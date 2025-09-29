package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import java.util.List;

public interface ListarMedicosPorEspecialidadUseCase {
    List<Medico> listarPorEspecialidad(String especialidad);
}
