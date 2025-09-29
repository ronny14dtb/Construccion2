package com.universidad.proyecto.gestionhospital.infrastructure.persistence.adapter;

import com.universidad.proyecto.gestionhospital.application.port.out.PacienteRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.jpa.PacienteJpaRepository;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper.PacienteMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PacienteRepositoryAdapter implements PacienteRepositoryPort {

    private final PacienteJpaRepository pacienteJpaRepository;

    public PacienteRepositoryAdapter(PacienteJpaRepository pacienteJpaRepository) {
        this.pacienteJpaRepository = pacienteJpaRepository;
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteJpaRepository.findAll()
                .stream()
                .map(PacienteMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return PacienteMapper.toDomain(
                pacienteJpaRepository.save(PacienteMapper.toEntity(paciente))
        );
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteJpaRepository.deleteById(id);
    }

    @Override
    public Paciente buscarPorId(Long id) {
        return pacienteJpaRepository.findById(id)
                .map(PacienteMapper::toDomain)
                .orElse(null);
    }
}
