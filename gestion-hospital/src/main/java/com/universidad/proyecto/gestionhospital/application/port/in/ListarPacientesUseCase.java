package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import java.util.List;

public interface ListarPacientesUseCase {
    List<Paciente> listarTodos();
}
