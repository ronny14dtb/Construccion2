package com.hospital.app.application.port.in.medico;

import com.hospital.app.domain.model.Medico;
import java.util.List;
import java.util.Optional;

/**
 * Define el contrato para las diferentes formas de consultar médicos.
 */
public interface ConsultarMedicoUseCase {

    /**
     * Busca un médico por su ID único.
     *
     * @param id El ID del médico.
     * @return Un Optional que contiene al médico si se encuentra, o vacío si no.
     */
    Optional<Medico> buscarPorId(Long id);

    /**
     * Busca todos los médicos de una especialidad específica.
     *
     * @param especialidad La especialidad a buscar (ej. "Cardiología").
     * @return Una lista de médicos que coinciden (puede estar vacía).
     */
    List<Medico> buscarPorEspecialidad(String especialidad);

    /**
     * Devuelve una lista de todos los médicos registrados en el sistema.
     *
     * @return Una lista con todos los médicos.
     */
    List<Medico> buscarTodos();
}