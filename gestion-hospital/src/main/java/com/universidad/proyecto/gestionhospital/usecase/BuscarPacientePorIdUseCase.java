package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class BuscarPacientePorIdUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public BuscarPacientePorIdUseCase(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepositoryPort.buscarPorId(id);
    }
}
