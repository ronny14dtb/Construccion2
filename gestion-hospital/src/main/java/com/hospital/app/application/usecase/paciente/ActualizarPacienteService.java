package com.hospital.app.application.usecase.paciente;

import com.hospital.app.application.dto.DatosActualizacionPaciente;
import com.hospital.app.application.port.in.paciente.ActualizarPacienteUseCase;
import com.hospital.app.domain.model.Paciente;
import com.hospital.app.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarPacienteService implements ActualizarPacienteUseCase {

    private final PacienteRepository pacienteRepository;

    @Override
    public Paciente actualizarPaciente(Long pacienteId, DatosActualizacionPaciente datos) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + pacienteId));

        paciente.setNombre(datos.nombre());
        paciente.setApellido(datos.apellido());

        return pacienteRepository.save(paciente);
    }
}