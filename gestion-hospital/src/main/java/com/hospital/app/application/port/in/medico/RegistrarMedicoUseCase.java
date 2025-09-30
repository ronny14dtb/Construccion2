package com.hospital.app.application.port.in.medico;

import com.hospital.app.application.dto.DatosCreacionMedico;
import com.hospital.app.domain.model.Medico;

/**
 * Define el contrato para el caso de uso de registrar un nuevo médico.
 */
public interface RegistrarMedicoUseCase {

    /**
     * Crea y persiste un nuevo médico en el sistema.
     *
     * @param datos El DTO con la información necesaria para el registro.
     * @return El objeto Medico ya creado y con su ID asignado.
     */
    Medico registrarMedico(DatosCreacionMedico datos);
}