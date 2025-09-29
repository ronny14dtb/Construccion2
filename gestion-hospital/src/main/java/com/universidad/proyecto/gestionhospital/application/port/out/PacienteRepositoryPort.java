package com.universidad.proyecto.gestionhospital.application.port.out;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteRepositoryPort {

    Paciente guardar(Paciente paciente);    
    Optional<Paciente> buscarPorId(Long id);     
    List<Paciente> listarTodos();                 
    void eliminar(Long id);                      
}
