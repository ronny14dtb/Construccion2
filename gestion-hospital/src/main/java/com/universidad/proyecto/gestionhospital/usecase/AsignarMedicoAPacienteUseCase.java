package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.ActualizarMedicoPacienteUseCase;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import org.springframework.stereotype.Service;

@Service
public class ActualizarMedicoPacienteService implements ActualizarMedicoPacienteUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public ActualizarMedicoPacienteService(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    @Override
    public Paciente actualizarMedico(Paciente paciente, Medico medico) {
        paciente.setMedico(medico);
        return pacienteRepositoryPort.guardar(paciente);
    }
}
