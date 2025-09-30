package com.hospital.app.domain.repository;

import com.hospital.app.domain.model.Cita;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CitaRepository {
    Cita save(Cita cita);
    Optional<Cita> findById(Long id);
    List<Cita> findByMedicoIdAndFechaHoraBetween(Long medicoId, LocalDateTime start, LocalDateTime end);
    List<Cita> findByPacienteId(Long pacienteId);
}