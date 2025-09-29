package com.universidad.proyecto.gestionhospital.application.port.in;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.domain.model.Medico;

public interface ActualizarMedicoPacienteUseCase {
    Paciente actualizarMedico(Paciente paciente, Medico medico);
}
