package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarPacienteUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public ActualizarPacienteUseCase(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    public Paciente actualizar(Paciente paciente) {
        return pacienteRepositoryPort.actualizar(paciente); // o guardar según tu repo
    }
}
