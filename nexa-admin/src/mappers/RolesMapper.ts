import type {Role_Key as FirebaseRole} from '@dataconnect-generated/'
import type {Roles} from '@models/Roles';


export const mapFirebaseRol = (firebaseRole : FirebaseRole) : Roles => {
    const rolString = firebaseRole as unknown as string;

    if(rolString === 'Supervisor') {
        return 'Supervisor' as unknown as Roles;
    }

    throw new Error('ACCESO_DENEGADO: NO Tienes permisos de supervisor para ingresar')
}