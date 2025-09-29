package com.universidad.proyecto.gestionhospital.infrastructure.persistence.jpa;

import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.EnfermeraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermeraJpaRepository extends JpaRepository<EnfermeraEntity, Long> {
}
