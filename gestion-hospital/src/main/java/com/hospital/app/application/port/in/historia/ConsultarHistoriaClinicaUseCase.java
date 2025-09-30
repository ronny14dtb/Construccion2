package com.hospital.app.application.port.in.historia;

import com.hospital.app.domain.model.HistoriaClinica;
import java.util.Optional;

/**
 * Define el contrato para el caso de uso de consultar la historia clínica de un paciente.
 */
public interface ConsultarHistoriaClinicaUseCase {

    /**
     * Busca la historia clínica completa asociada a un paciente.
     *
     * @param pacienteId El ID del paciente cuya historia se quiere consultar.
     * @return Un Optional que contiene la HistoriaClinica si se encuentra, o vacío si no.
     */
    Optional<HistoriaClinica> consultarPorPacienteId(Long pacienteId);
}