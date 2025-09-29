package com.universidad.proyecto.gestionhospital.services;


import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> getById(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }
}
