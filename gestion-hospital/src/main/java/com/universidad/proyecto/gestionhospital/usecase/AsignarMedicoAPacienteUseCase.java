package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.services.MedicoService;
import com.universidad.proyecto.gestionhospital.services.PacienteService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AsignarMedicoAPacienteUseCase {

    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public AsignarMedicoAPacienteUseCase(PacienteService pacienteService, MedicoService medicoService) {
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    public Optional<Paciente> ejecutar(Long idPaciente, Long idMedico) {
        Optional<Paciente> pacienteOpt = pacienteService.getById(idPaciente);
        Optional<Medico> medicoOpt = medicoService.getById(idMedico);

        if (pacienteOpt.isPresent() && medicoOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            paciente.setMedico(medicoOpt.get());
            return Optional.of(pacienteService.save(paciente));
        }
        return Optional.empty();
    }
}
