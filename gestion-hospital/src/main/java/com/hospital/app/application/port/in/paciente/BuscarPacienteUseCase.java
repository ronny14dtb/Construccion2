package com.hospital.app.application.port.in.paciente;

import com.hospital.app.domain.model.Paciente;
import java.util.List;
import java.util.Optional;


public interface BuscarPacienteUseCase {

    /**
     * Busca un paciente por su ID único.
     *
     * @param id El ID del paciente.
     * @return Un Optional que contiene al paciente si se encuentra, o vacío si no.
     */
    Optional<Paciente> buscarPorId(Long id);

    /**
     * Busca pacientes que coincidan con un nombre y apellido.
     *
     * @param nombre El nombre a buscar.
     * @param apellido El apellido a buscar.
     * @return Una lista de pacientes que coinciden (puede estar vacía).
     */
    List<Paciente> buscarPorNombreYApellido(String nombre, String apellido);

    /**
     * Busca un paciente por su número de documento, que debería ser único.
     *
     * @param documento El número de documento a buscar.
     * @return Un Optional que contiene al paciente si se encuentra.
     */
    Optional<Paciente> buscarPorDocumento(String documento);
}