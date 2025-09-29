package com.universidad.proyecto.gestionhospital.infrastructure.persistence.adapter;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.application.port.out.PacienteRepositoryPort;
import com.universidad.proyecto.gestionhospital.repository.PacienteRepository;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper.PacienteMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PacienteRepositoryAdapter implements PacienteRepositoryPort {

    private final PacienteRepository pacienteRepository;

    public PacienteRepositoryAdapter(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return PacienteMapper.toDomain(
                pacienteRepository.save(PacienteMapper.toEntity(paciente))
        );
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .map(PacienteMapper::toDomain);
    }
}
