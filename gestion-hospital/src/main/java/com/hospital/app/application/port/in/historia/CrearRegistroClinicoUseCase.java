package com.hospital.app.application.port.in.historia;

import com.hospital.app.application.dto.DatosNuevoRegistro;
import com.hospital.app.domain.model.RegistroClinico;

/**
 * Define el contrato para el caso de uso de crear un nuevo registro
 * en la historia clínica de un paciente.
 */
public interface CrearRegistroClinicoUseCase {

    /**
     * Añade una nueva entrada a la historia clínica de un paciente específico.
     *
     * @param pacienteId El ID del paciente al que pertenece la historia.
     * @param datos El DTO con la información del nuevo registro (diagnóstico, etc.).
     * @return El objeto RegistroClinico ya creado y con su ID asignado.
     */
    RegistroClinico crearRegistro(Long pacienteId, DatosNuevoRegistro datos);
}