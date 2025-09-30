package com.hospital.app.application.usecase.cita;

import com.hospital.app.application.port.in.cita.CancelarCitaUseCase;
import com.hospital.app.domain.model.Cita;
import com.hospital.app.domain.model.EstadoCita;
import com.hospital.app.domain.repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelarCitaService implements CancelarCitaUseCase {

    private final CitaRepository citaRepository;

    @Override
    public void cancelarCita(Long citaId) {
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        
        cita.setEstado(EstadoCita.CANCELADA);
        
        citaRepository.save(cita);
    }
}