package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import java.util.Optional;

public interface BuscarPacientePorIdUseCase {
    Optional<Paciente> buscarPorId(Long id);
}
