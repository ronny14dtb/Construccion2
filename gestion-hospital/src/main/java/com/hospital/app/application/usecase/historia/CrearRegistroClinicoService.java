package com.hospital.app.application.usecase.historia;

import com.hospital.app.application.dto.DatosNuevoRegistro;
import com.hospital.app.application.port.in.historia.CrearRegistroClinicoUseCase;
import com.hospital.app.domain.model.*;
import com.hospital.app.domain.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrearRegistroClinicoService implements CrearRegistroClinicoUseCase {
    private final HistoriaClinicaRepository historiaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    @Override
    public RegistroClinico crearRegistro(Long pacienteId, DatosNuevoRegistro datos) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new RuntimeException("Paciente no existe"));
        Medico medico = medicoRepository.findById(datos.medicoId()).orElseThrow(() -> new RuntimeException("Medico no existe"));

        HistoriaClinica historia = historiaRepository.findByPacienteId(pacienteId)
                .orElse(HistoriaClinica.builder().paciente(paciente).build());

        RegistroClinico nuevoRegistro = RegistroClinico.builder()
                .diagnostico(datos.diagnostico())
                .tratamiento(datos.tratamiento())
                .notas(datos.notas())
                .medico(medico)
                .build();
        historia.getRegistros().add(nuevoRegistro);
        historiaRepository.save(historia);

        return nuevoRegistro;
    }
}