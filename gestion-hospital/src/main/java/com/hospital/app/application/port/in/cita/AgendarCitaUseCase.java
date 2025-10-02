package com.hospital.app.application.port.in.cita;

import com.hospital.app.application.dto.DatosAgendamientoCita;
import com.hospital.app.domain.model.Cita;


public interface AgendarCitaUseCase {

    /**
     * @param datos 
     * @return 
     */
    Cita agendarCita(DatosAgendamientoCita datos);
}