package com.hospital.app.domain.repository;

import com.hospital.app.domain.model.HistoriaClinica;
import java.util.Optional;

public interface HistoriaClinicaRepository {
    HistoriaClinica save(HistoriaClinica historiaClinica);
    Optional<HistoriaClinica> findByPacienteId(Long pacienteId);
}