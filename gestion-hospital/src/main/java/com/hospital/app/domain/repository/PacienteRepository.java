package com.hospital.app.domain.repository;

import com.hospital.app.domain.model.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteRepository {
    Paciente save(Paciente paciente);
    Optional<Paciente> findById(Long id);
    List<Paciente> findAll();
    Optional<Paciente> findByDocumentoIdentidad(String documento);
    void deleteById(Long id);
}