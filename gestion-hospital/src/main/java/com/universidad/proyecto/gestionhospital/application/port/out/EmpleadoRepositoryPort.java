package com.universidad.proyecto.gestionhospital.application.port.out;

import com.universidad.proyecto.gestionhospital.domain.model.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoRepositoryPort {

    Empleado guardar(Empleado empleado);              
    Optional<Empleado> buscarPorId(Long id);     
    List<Empleado> listarTodos();                   
    void eliminar(Long id);                           
}