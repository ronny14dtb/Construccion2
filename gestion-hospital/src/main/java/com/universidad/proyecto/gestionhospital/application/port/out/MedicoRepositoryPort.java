package com.universidad.proyecto.gestionhospital.application.port.out;

import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoRepositoryPort {

    Medico guardar(Medico medico);    
    Optional<Medico> buscarPorId(Long id);       
    List<Medico> listarTodos();               
    List<Medico> listarPorEspecialidad(String especialidad); 
    void eliminar(Long id);                             
}