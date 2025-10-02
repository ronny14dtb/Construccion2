package com.hospital.app.application.port.in.medico;

import com.hospital.app.application.dto.DatosCreacionMedico;
import com.hospital.app.domain.model.Medico;

public interface RegistrarMedicoUseCase {

    /**
     * @param datos 
     * @return 
     */
    Medico registrarMedico(DatosCreacionMedico datos);
}