package com.hospital.app.infrastructure.persistence.jpa;

import com.hospital.app.infrastructure.persistence.entity.PacienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PacienteSpringDataRepository extends JpaRepository<PacienteJpaEntity, Long> {
    Optional<PacienteJpaEntity> findByDocumentoIdentidad(String documento);
}