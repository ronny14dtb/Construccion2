package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.ActualizarPacienteUseCase;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class ActualizarPacienteService implements ActualizarPacienteUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public ActualizarPacienteService(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return pacienteRepositoryPort.guardar(paciente);
    }
}
