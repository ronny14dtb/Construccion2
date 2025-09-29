package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;

public interface ActualizarPacienteUseCase {
    Paciente actualizar(Paciente paciente);
}
