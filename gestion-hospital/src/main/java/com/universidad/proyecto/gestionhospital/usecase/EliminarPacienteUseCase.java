package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarPacienteUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public EliminarPacienteUseCase(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    public void eliminar(Long id) {
        pacienteRepositoryPort.eliminar(id);
    }
}
