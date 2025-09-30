package com.hospital.app.infrastructure.persistence.jpa;

import com.hospital.app.infrastructure.persistence.entity.HistoriaClinicaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HistoriaClinicaSpringDataRepository extends JpaRepository<HistoriaClinicaJpaEntity, Long> {
    Optional<HistoriaClinicaJpaEntity> findByPacienteId(Long pacienteId);
}