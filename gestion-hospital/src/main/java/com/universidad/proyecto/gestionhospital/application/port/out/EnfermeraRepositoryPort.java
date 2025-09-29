package com.universidad.proyecto.gestionhospital.application.port.out;

import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;
import java.util.List;
import java.util.Optional;

public interface EnfermeraRepositoryPort {

    Enfermera guardar(Enfermera enfermera); 
    Optional<Enfermera> buscarPorId(Long id);    
    List<Enfermera> listarTodas();                 
    void eliminar(Long id);                       
}
