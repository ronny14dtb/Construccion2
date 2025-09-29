package com.universidad.proyecto.gestionhospital.infrastructure.persistence.jpa;

import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoJpaRepository extends JpaRepository<MedicoEntity, Long> {
}
