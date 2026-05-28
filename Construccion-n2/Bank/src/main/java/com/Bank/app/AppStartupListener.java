package com.Bank.app;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupListener {

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        System.out.println("==========================================");
        System.out.println("¡EL SISTEMA BANCARIO ESTÁ LISTO PARA OPERAR!");
        System.out.println("Escuchando en el puerto definido.");
        System.out.println("==========================================");
    }
}