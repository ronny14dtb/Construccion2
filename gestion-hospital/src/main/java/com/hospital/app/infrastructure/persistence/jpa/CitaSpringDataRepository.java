package com.hospital.app.infrastructure.persistence.jpa;

import com.hospital.app.infrastructure.persistence.entity.CitaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaSpringDataRepository extends JpaRepository<CitaJpaEntity, Long> {
    List<CitaJpaEntity> findByMedicoIdAndFechaHoraBetween(Long medicoId, LocalDateTime start, LocalDateTime end);
    List<CitaJpaEntity> findByPacienteId(Long pacienteId);
}