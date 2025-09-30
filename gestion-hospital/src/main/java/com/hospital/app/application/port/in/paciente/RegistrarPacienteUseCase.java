package com.hospital.app.application.port.in.paciente;

import com.hospital.app.application.dto.DatosCreacionPaciente;
import com.hospital.app.domain.model.Paciente;

/**
 * Define el contrato para el caso de uso de registrar un nuevo paciente.
 */
public interface RegistrarPacienteUseCase {

    /**
     * Crea y persiste un nuevo paciente en el sistema.
     *
     * @param datos El DTO con la información necesaria para el registro.
     * @return El objeto Paciente ya creado y con su ID asignado.
     */
    Paciente registrarPaciente(DatosCreacionPaciente datos);
}