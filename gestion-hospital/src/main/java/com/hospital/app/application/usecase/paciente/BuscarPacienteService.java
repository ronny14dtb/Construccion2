package com.hospital.app.application.usecase.paciente;

import com.hospital.app.application.port.in.paciente.BuscarPacienteUseCase;
import com.hospital.app.domain.model.Paciente;
import com.hospital.app.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarPacienteService implements BuscarPacienteUseCase {

    private final PacienteRepository pacienteRepository;

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> buscarPorNombreYApellido(String nombre, String apellido) {
        return pacienteRepository.findAll().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre) && p.getApellido().equalsIgnoreCase(apellido))
                .toList();
    }

    @Override
    public Optional<Paciente> buscarPorDocumento(String documento) {
        return pacienteRepository.findByDocumentoIdentidad(documento);
    }
}