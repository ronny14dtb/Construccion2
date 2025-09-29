package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;
import java.util.List;

public interface ListarEnfermerasUseCase {
    List<Enfermera> listar();
}
