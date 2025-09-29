package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;

public interface RegistrarPacienteUseCase {
    Paciente registrar(Paciente paciente);
}
