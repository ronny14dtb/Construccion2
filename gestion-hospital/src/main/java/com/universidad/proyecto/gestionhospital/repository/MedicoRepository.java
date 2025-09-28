package com.universidad.proyecto.gestionhospital.repository;

import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByEspecialidad(String especialidad);
}
