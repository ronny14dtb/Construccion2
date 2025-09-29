package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.RegistrarPacienteUseCase;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class RegistrarPacienteUseCase implements RegistrarPacienteUseCase { 

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public RegistrarPacienteUseCase(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    @Override
    public Paciente registrar(Paciente paciente) {
        return pacienteRepositoryPort.guardar(paciente);
    }
}
