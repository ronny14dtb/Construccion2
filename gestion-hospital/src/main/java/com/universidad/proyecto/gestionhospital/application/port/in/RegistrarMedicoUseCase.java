package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Medico;

public interface RegistrarMedicoUseCase {
    Medico registrar(Medico medico);
}
