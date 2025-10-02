package com.hospital.app.application.port.in.historia;

import com.hospital.app.domain.model.HistoriaClinica;
import java.util.Optional;


public interface ConsultarHistoriaClinicaUseCase {

    /**
     * @param pacienteId 
     * @return 
     */
    Optional<HistoriaClinica> consultarPorPacienteId(Long pacienteId);
}