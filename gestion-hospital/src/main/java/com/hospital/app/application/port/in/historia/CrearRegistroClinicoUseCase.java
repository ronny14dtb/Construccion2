package com.hospital.app.application.port.in.historia;

import com.hospital.app.application.dto.DatosNuevoRegistro;
import com.hospital.app.domain.model.RegistroClinico;


public interface CrearRegistroClinicoUseCase {

    /**
 
     * @param pacienteId
     * @param datos 
     * @return 
     */
    RegistroClinico crearRegistro(Long pacienteId, DatosNuevoRegistro datos);
}