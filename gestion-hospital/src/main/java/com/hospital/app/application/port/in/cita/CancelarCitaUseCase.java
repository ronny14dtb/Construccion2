package com.hospital.app.application.port.in.cita;

/**
 * Define el contrato para el caso de uso de cancelar una cita existente.
 */
public interface CancelarCitaUseCase {

    /**
     * Cambia el estado de una cita a CANCELADA.
     *
     * @param citaId El ID de la cita a cancelar.
     */
    void cancelarCita(Long citaId);
}