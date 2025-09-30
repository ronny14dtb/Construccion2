package com.hospital.app.application.port.in.cita;

import com.hospital.app.application.dto.DatosAgendamientoCita;
import com.hospital.app.domain.model.Cita;

/**
 * Define el contrato para el caso de uso de agendar una nueva cita.
 */
public interface AgendarCitaUseCase {

    /**
     * Crea y persiste una nueva cita en el sistema.
     *
     * @param datos El DTO con la información necesaria para agendar la cita.
     * @return El objeto Cita ya creado y con su ID asignado.
     */
    Cita agendarCita(DatosAgendamientoCita datos);
}