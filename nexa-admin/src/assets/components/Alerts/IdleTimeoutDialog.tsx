"use client";

import { AlertDialog, Button } from "@heroui/react";


interface IdleTimeoutDialogProps {
    isOpen: boolean;
    onConfirm: () => void;
}

export function IdleTimeoutDialog({ isOpen, onConfirm }: IdleTimeoutDialogProps) {
    return (
        <AlertDialog 
            isOpen={isOpen} 
            onOpenChange={onConfirm}
        >
            <AlertDialog.Backdrop isDismissable={false} isKeyboardDismissDisabled={true}>
                <AlertDialog.Container>
                    <AlertDialog.Dialog className="sm:max-w-[400px]">
                        <AlertDialog.Header>
                            <AlertDialog.Icon status="danger" />
                            <AlertDialog.Heading style={{ fontFamily: '"Inter", sans-serif' }} className="font-bold">
                                Sesión expirada
                            </AlertDialog.Heading>
                        </AlertDialog.Header>
                        
                        <AlertDialog.Body style={{ fontFamily: '"Inter", sans-serif' }} className="text-zinc-600 text-sm">
                            <p>Tu sesión se ha cerrado automáticamente debido a <strong>5 minutos de inactividad</strong> para proteger tus datos de NEXA.</p>
                        </AlertDialog.Body>
                        
                        <AlertDialog.Footer>
                            <Button 
                                variant="danger"
                                onClick={onConfirm}
                                style={{ fontFamily: '"Inter", sans-serif' }}
                                className="w-full"
                            >
                               Entendido
                            </Button>
                        </AlertDialog.Footer>
                    </AlertDialog.Dialog>
                </AlertDialog.Container>
            </AlertDialog.Backdrop>
        </AlertDialog>
    );
}