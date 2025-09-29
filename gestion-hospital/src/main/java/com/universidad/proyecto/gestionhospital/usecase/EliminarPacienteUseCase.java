package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.EliminarPacienteUseCase;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarPacienteService implements EliminarPacienteUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public EliminarPacienteService(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepositoryPort.eliminar(id);
    }
}
