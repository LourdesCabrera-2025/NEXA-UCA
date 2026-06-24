import { useEffect, useRef } from "react";

interface UseIdleTimeoutProps {
    onTimeout: () => void;
    timeoutInMinutes: number;
}


export const useIdleTimeout = ({onTimeout , timeoutInMinutes}: UseIdleTimeoutProps) => {

    const timerRef = useRef<ReturnType<typeof setTimeout> | null>(null);
    const timeoutMs = timeoutInMinutes * 60 * 1000;

    const resetTimer = () => {

        if(timerRef.current) {
            clearTimeout(timerRef.current);
        }

        timerRef.current = setTimeout(() => {
            console.log("NEXA_DEBUG: Inactivdad detectada. Cerrando sesión...");
            onTimeout();
        }, timeoutMs);
    };

    useEffect(() => {
        const events = [
            'mousedown',
            'mousemove',
            'keypress',
            'scroll',
            'touchstart',
            'click'
        ];

        resetTimer();

        events.forEach(event => {
            window.addEventListener(event, resetTimer);
        });

        return () => {
            if(timerRef.current) {
                clearTimeout(timerRef.current);
            }
            events.forEach(event => {
                window.removeEventListener(event, resetTimer);
            });
        };
    }, [timeoutMs])
};