package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;

public interface RegistrarEnfermeraUseCase {
    Enfermera registrar(Enfermera enfermera);
}
