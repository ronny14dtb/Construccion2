package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.ListarPacientesUseCase;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListarPacientesService implements ListarPacientesUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public ListarPacientesService(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    @Override
    public List<Paciente> listarTodos() {
        return pacienteRepositoryPort.listarTodos();
    }
}
