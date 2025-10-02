package com.hospital.app.application.port.in.paciente;

import com.hospital.app.domain.model.Paciente;
import java.util.List;
import java.util.Optional;


public interface BuscarPacienteUseCase {

    /**
     * @param id 
     * @return 
     */
    Optional<Paciente> buscarPorId(Long id);

    /**
     * @param nombre 
     * @param apellido 
     * @return 
     */
    List<Paciente> buscarPorNombreYApellido(String nombre, String apellido);

    /**
     * @param documento
     * @return 
     */
    Optional<Paciente> buscarPorDocumento(String documento);
}