import type { User as FirebaseUser } from "firebase/auth";
import type { User }from '@models/User';
import type { Roles } from "@/models/Roles";


export const mapFirebaseUser = (firebaseUser: FirebaseUser, rolValidado: Roles): User => {
    return {
        id: firebaseUser.uid,
        fullName: firebaseUser.displayName || 'Usuario Nexa',
        email: firebaseUser.email || '',
        photoUrl: firebaseUser.photoURL || undefined,
        role: rolValidado,
        isActive: true
    }
}