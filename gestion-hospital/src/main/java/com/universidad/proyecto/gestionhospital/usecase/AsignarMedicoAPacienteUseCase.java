package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import com.universidad.proyecto.gestionhospital.port.out.PacienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class AsignarMedicoAPacienteUseCase {

    private final PacienteRepositoryPort pacienteRepositoryPort;

    public AsignarMedicoAPacienteUseCase(PacienteRepositoryPort pacienteRepositoryPort) {
        this.pacienteRepositoryPort = pacienteRepositoryPort;
    }

    public Paciente asignarMedico(Paciente paciente, Medico medico) {
        paciente.setMedico(medico);
        return pacienteRepositoryPort.actualizar(paciente);
    }
}
