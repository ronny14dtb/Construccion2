package com.hospital.app.application.port.in.medico;

import com.hospital.app.domain.model.Medico;
import java.util.List;
import java.util.Optional;


public interface ConsultarMedicoUseCase {

    /**
     * @param id 
     * @return 
     */
    Optional<Medico> buscarPorId(Long id);

    /**
     * @param especialidad 
     * @return 
     */
    List<Medico> buscarPorEspecialidad(String especialidad);

    /**
     * @return 
     */
    List<Medico> buscarTodos();
}