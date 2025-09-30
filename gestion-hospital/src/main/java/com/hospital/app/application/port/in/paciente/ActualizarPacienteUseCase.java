package com.hospital.app.application.port.in.paciente;

import com.hospital.app.application.dto.DatosActualizacionPaciente;
import com.hospital.app.domain.model.Paciente;

// Esta es la definición del contrato (el "qué"), no la implementación (el "cómo").
public interface ActualizarPacienteUseCase {

    /**
     * Actualiza la información de un paciente existente.
     * @param pacienteId El ID del paciente a modificar.
     * @param datos Un objeto DTO que contiene la nueva información.
     * @return El objeto Paciente con los datos ya actualizados.
     */
    Paciente actualizarPaciente(Long pacienteId, DatosActualizacionPaciente datos);

}