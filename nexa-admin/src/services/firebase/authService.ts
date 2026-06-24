import { auth, microsoftProvider } from "./firebase";
import {
    signInWithPopup,
    getRedirectResult,
    signOut,
    type User as FirebaseUser,
    type UserCredential
} from 'firebase/auth';

import { mapFirebaseRol } from "@/mappers/RolesMapper";
import { mapFirebaseUser } from "@/mappers/UserMapper";
import type { User as AppUser } from "@/models/User";
import { getUserById, createUser, getRoleByName } from "@dataconnect-generated/";


microsoftProvider.setCustomParameters({
    tenant: '6d77cef0-e8f4-4ed0-b160-3b15a8315327',
    prompt: 'select_account'
});

microsoftProvider.addScope('openid');
microsoftProvider.addScope('profile');
microsoftProvider.addScope('email');


const getUserPostgres = async (id: string, name: string, email: string, photoUrl: string) => {
    try {
        console.log("NEXA_DEBUG: Buscando usuario en PostgreSQL...");
        const userQuery = await getUserById({ id: id });

        if (userQuery.data && userQuery.data.users.length > 0) {
            const userFound = userQuery.data.users[0];
            console.log("NEXA_DEBUG: Usuario existente encontrado", userFound.fullName);
            return userFound;
        }

        console.log("NEXA_DEBUG: El usuario no existe. Iniciando logica de creación");
        console.log("NEXA_DEBUG: Obteniendo el ID del rol del supervisor");
        const roleQuery = await getRoleByName({ name: 'Supervisor' });

        if (!roleQuery.data || roleQuery.data.roles.length === 0) {
            throw new Error("El rol administrativo 'Supervisor' no está sembrado en la base de datos");
        }

        const supervisorRoleId = roleQuery.data.roles[0].id;

        console.log(`NEXA_DEBUG: Insertando usuario con roleId: ${supervisorRoleId}`);

        await createUser({
            id,
            email,
            fullName: name,
            photoUrl,
            roleId: supervisorRoleId
        });
        console.log("NEXA_DEBUG: Inserción completada con éxito");

        const newUserQuery = await getUserById({ id: id });
        if (newUserQuery.data && newUserQuery.data.users.length > 0) {
            return newUserQuery.data.users[0];
        }

        throw new Error("Error al verificar el usuario reción creado");
    } catch (error) {
        console.error("NEXA_DEBUG: Error en getUserPostgres (GET/CREATE)", error);
        throw new Error("Error_Registro: No se pudo gestionar tu perfil de supervisor en la base de datos")
    }
}


let authenticatePostresUser: any = null;



export const authService = {

    loginWithMicrosoft: async (): Promise<AppUser> => {
        try {

            let firebaseUser: FirebaseUser | null = await authService.getPendingMicrosoftUser();

            if (!firebaseUser) {
                const result: UserCredential = await signInWithPopup(auth, microsoftProvider);
                firebaseUser = result.user;
            }

            console.log("NEXA_DEBUG: LOGIN MICROSOFT OK");
            console.log(`NEXA_DEBUG: uid=${firebaseUser.uid}`);
            console.log(`NEXA_DEBUG: email=${firebaseUser.email}`);

            try {


                const displayName = firebaseUser.displayName || 'Usuario Nexa';
                const email = firebaseUser.email || '';
                const photo = firebaseUser.photoURL || '';

                const postgresUser = await getUserPostgres(firebaseUser.uid, displayName, email, photo);

                authenticatePostresUser = postgresUser;

                const rawRole = postgresUser.role.name



                const checkedRole = mapFirebaseRol(rawRole as any);
                const appUser = mapFirebaseUser(firebaseUser, checkedRole)
                return appUser
            } catch (roleError: any) {
                await signOut(auth);
                throw roleError;

            }
        } catch (error: any) {
            console.error("NEXA_DEBUG: Error al autenticar con Microsoft", error);

            if (error.message?.includes('ACCESO_DENEGADO')) {
                throw error;
            }
            throw new Error('No se puede obtener el usuario autenticado');
        }
    },


    getCurrentPostgressUser : async () => {

        if(authenticatePostresUser) return authenticatePostresUser;

        const firebaseUser = auth.currentUser;
        if(!firebaseUser) return null;

        try {
            const userQuery = await getUserById({id: firebaseUser.uid});
            if(userQuery.data && userQuery.data.users.length > 0) {
                authenticatePostresUser = userQuery.data.users[0];
                return authenticatePostresUser;
            }
        }catch(error) {
            console.error("Error recuperando rol en recarga", error);
        }
    },

    getPendingMicrosoftUser: async (): Promise<FirebaseUser | null> => {
        try {
            const result = await getRedirectResult(auth);
            if (result && result.user) {
                console.log("NEXA_DEBUG: Recuperado usuario de redirección pendiente", result.user.email);
                return result.user;
            }
            return null;
        } catch (error) {
            console.error("NEXA_DEBUG: Erro al obtener resultado pendiente", error);
            return null;
        }
    },

    currentUser: (): FirebaseUser | null => {
        return auth.currentUser;
    },

    logout: async (): Promise<void> => {
        authenticatePostresUser = null;
        await signOut(auth)
    }
}