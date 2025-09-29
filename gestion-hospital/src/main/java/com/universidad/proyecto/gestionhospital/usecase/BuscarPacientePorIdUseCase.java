package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.BuscarPacientePorIdUseCase;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarPacientePorIdService implements BuscarPacientePorIdUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public BuscarPacientePorIdService(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepositoryPort.buscarPorId(id);
    }
}
