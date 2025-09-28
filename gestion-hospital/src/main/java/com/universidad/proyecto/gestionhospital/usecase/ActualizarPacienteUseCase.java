package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.services.PacienteService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ActualizarPacienteUseCase {

    private final PacienteService pacienteService;

    public ActualizarPacienteUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public Optional<Paciente> ejecutar(Long id, Paciente datosActualizados) {
        return pacienteService.getById(id).map(paciente -> {
            paciente.setNombre(datosActualizados.getNombre());
            paciente.setEdad(datosActualizados.getEdad());
            paciente.setEnfermedad(datosActualizados.getEnfermedad());

            return pacienteService.save(paciente);
        });
    }
}
