package com.hospital.app.domain.repository;

import com.hospital.app.domain.model.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoRepository {
    Medico save(Medico medico);
    Optional<Medico> findById(Long id);
    List<Medico> findByEspecialidad(String especialidad);
    List<Medico> findAll();
}