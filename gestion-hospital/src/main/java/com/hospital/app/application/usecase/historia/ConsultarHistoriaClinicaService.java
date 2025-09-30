package com.hospital.app.application.usecase.historia;

import com.hospital.app.application.port.in.historia.ConsultarHistoriaClinicaUseCase;
import com.hospital.app.domain.model.HistoriaClinica;
import com.hospital.app.domain.repository.HistoriaClinicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultarHistoriaClinicaService implements ConsultarHistoriaClinicaUseCase {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public Optional<HistoriaClinica> consultarPorPacienteId(Long pacienteId) {
        return historiaClinicaRepository.findByPacienteId(pacienteId);
    }
}