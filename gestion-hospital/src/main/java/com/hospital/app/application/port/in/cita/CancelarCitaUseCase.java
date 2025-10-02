package com.hospital.app.application.port.in.cita;


public interface CancelarCitaUseCase {

    /**
     * @param citaId 
     */
    void cancelarCita(Long citaId);
}