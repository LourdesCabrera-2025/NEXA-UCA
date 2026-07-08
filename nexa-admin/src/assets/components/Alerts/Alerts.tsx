import { AlertDialog, Button } from "@heroui/react";
import { CheckCircleIcon, ExclamationTriangleIcon } from "@heroicons/react/24/outline";


interface GeneralAlertProps {
    isOpenAlert: boolean;
    onClose: () => void;
    type: 'success' | 'error';
    title: string;
    message: string;
    portalContainer?: HTMLElement | null;
}


export const GeneralAlert = ({ isOpenAlert, onClose, type, title, message, portalContainer }: GeneralAlertProps) => {
    const isError = type === 'error';

    return (
        <AlertDialog  isOpen={isOpenAlert} onOpenChange={onClose} >
            <AlertDialog.Backdrop isDismissable={false} isKeyboardDismissDisabled={true} UNSTABLE_portalContainer={portalContainer ?? undefined} className={"z-[2000]"}>
                <AlertDialog.Container>
                    <AlertDialog.Dialog className="sm:max-w-[400px]">
                        <AlertDialog.Header>
                            <AlertDialog.Icon>
                                {isError ? (
                                    <ExclamationTriangleIcon className="text-red-500 w-6 h-6" />
                                ) : (
                                    <CheckCircleIcon className="text-green-500 w-6 h-6" />
                                )}
                            </AlertDialog.Icon>
                            <AlertDialog.Heading style={{fontFamily: '"Inter", sans-serif'}} className="font-bold">
                                {title}
                            </AlertDialog.Heading>
                        </AlertDialog.Header>
                        <AlertDialog.Body style={{fontFamily: '"Inter", sans-serif'}} className="text-zinc-600 text-sm">
                            <p>{message}</p>
                        </AlertDialog.Body>
                        <AlertDialog.Footer>
                            <Button onClick={onClose}>Cerrar</Button>
                        </AlertDialog.Footer>
                    </AlertDialog.Dialog>
                </AlertDialog.Container>
            </AlertDialog.Backdrop>
        </AlertDialog>
    )
}