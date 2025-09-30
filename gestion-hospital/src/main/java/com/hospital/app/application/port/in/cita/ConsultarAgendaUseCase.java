package com.hospital.app.application.port.in.cita;

import com.hospital.app.domain.model.Cita;
import java.time.LocalDate;
import java.util.List;

/**
 * Define el contrato para el caso de uso de consultar la agenda de un médico.
 */
public interface ConsultarAgendaUseCase {

    /**
     * Devuelve todas las citas de un médico para una fecha específica.
     *
     * @param medicoId El ID del médico cuya agenda se quiere consultar.
     * @param fecha La fecha para la cual se consultará la agenda.
     * @return Una lista de citas para ese día (puede estar vacía).
     */
    List<Cita> consultarAgendaPorMedicoYFecha(Long medicoId, LocalDate fecha);
}