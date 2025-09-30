package com.hospital.app.application.usecase.cita;

import com.hospital.app.application.dto.DatosAgendamientoCita;
import com.hospital.app.application.port.in.cita.AgendarCitaUseCase;
import com.hospital.app.domain.model.Cita;
import com.hospital.app.domain.model.EstadoCita;
import com.hospital.app.domain.model.Medico;
import com.hospital.app.domain.model.Paciente;
import com.hospital.app.domain.repository.CitaRepository;
import com.hospital.app.domain.repository.MedicoRepository;
import com.hospital.app.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendarCitaService implements AgendarCitaUseCase {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    @Override
    public Cita agendarCita(DatosAgendamientoCita datos) {
        Paciente paciente = pacienteRepository.findById(datos.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        Medico medico = medicoRepository.findById(datos.medicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        Cita nuevaCita = Cita.builder()
                .paciente(paciente)
                .medico(medico)
                .fechaHora(datos.fechaHora())
                .motivoConsulta(datos.motivo())
                .estado(EstadoCita.AGENDADA)
                .build();

        return citaRepository.save(nuevaCita);
    }
}