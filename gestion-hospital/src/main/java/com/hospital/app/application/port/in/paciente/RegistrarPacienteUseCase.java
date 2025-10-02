package com.hospital.app.application.port.in.paciente;

import com.hospital.app.application.dto.DatosCreacionPaciente;
import com.hospital.app.domain.model.Paciente;


public interface RegistrarPacienteUseCase {

    /**
     *
     * @param datos 
     * @return 
     */
    Paciente registrarPaciente(DatosCreacionPaciente datos);
}