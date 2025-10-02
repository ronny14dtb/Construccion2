package com.hospital.app.application.port.in.paciente;

import com.hospital.app.application.dto.DatosActualizacionPaciente;
import com.hospital.app.domain.model.Paciente;

public interface ActualizarPacienteUseCase {

    /**
     * @param pacienteId 
     * @param datos 
     * @return 
     */
    Paciente actualizarPaciente(Long pacienteId, DatosActualizacionPaciente datos);

}