package com.hospital.app.application.usecase.paciente;

import com.hospital.app.application.dto.DatosCreacionPaciente;
import com.hospital.app.application.port.in.paciente.RegistrarPacienteUseCase;
import com.hospital.app.domain.model.Paciente;
import com.hospital.app.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPacienteService implements RegistrarPacienteUseCase {

    private final PacienteRepository pacienteRepository;

    @Override
    public Paciente registrarPaciente(DatosCreacionPaciente datos) {
        Paciente nuevoPaciente = Paciente.builder()
                .nombre(datos.nombre())
                .apellido(datos.apellido())
                .documentoIdentidad(datos.documentoIdentidad())
                .fechaNacimiento(datos.fechaNacimiento())
                .build();
        return pacienteRepository.save(nuevoPaciente);
    }
}