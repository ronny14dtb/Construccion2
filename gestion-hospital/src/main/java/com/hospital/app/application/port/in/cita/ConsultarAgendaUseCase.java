package com.hospital.app.application.port.in.cita;

import com.hospital.app.domain.model.Cita;
import java.time.LocalDate;
import java.util.List;


public interface ConsultarAgendaUseCase {

    /**
     * @param medicoId 
     * @param fecha 
     * @return 
     */
    List<Cita> consultarAgendaPorMedicoYFecha(Long medicoId, LocalDate fecha);
}