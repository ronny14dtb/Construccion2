package com.universidad.proyecto.gestionhospital.infrastructure.persistence.jpa;

import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteJpaRepository extends JpaRepository<PacienteEntity, Long> {

}
