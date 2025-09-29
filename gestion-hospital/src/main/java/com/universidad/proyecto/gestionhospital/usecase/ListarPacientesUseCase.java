package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPacientesUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public ListarPacientesUseCase(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    public List<Paciente> listar() {
        return pacienteRepositoryPort.listarTodos();
    }
}
