package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.RegistrarPacienteUseCase;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class RegistrarPacienteService implements RegistrarPacienteUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public RegistrarPacienteService(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    @Override
    public Paciente registrar(Paciente paciente) {
        // Validaciones opcionales antes de guardar
        return pacienteRepositoryPort.guardar(paciente);
    }
}
