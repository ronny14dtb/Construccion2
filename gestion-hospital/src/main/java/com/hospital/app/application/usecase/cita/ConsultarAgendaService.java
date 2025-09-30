package com.hospital.app.application.usecase.cita;

import com.hospital.app.application.port.in.cita.ConsultarAgendaUseCase;
import com.hospital.app.domain.model.Cita;
import com.hospital.app.domain.repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultarAgendaService implements ConsultarAgendaUseCase {
    
    private final CitaRepository citaRepository;

    @Override
    public List<Cita> consultarAgendaPorMedicoYFecha(Long medicoId, LocalDate fecha) {
        LocalDateTime inicioDelDia = fecha.atStartOfDay();
        LocalDateTime finDelDia = fecha.plusDays(1).atStartOfDay();
        return citaRepository.findByMedicoIdAndFechaHoraBetween(medicoId, inicioDelDia, finDelDia);
    }
}