package com.hospital.app.application.usecase.medico;

import com.hospital.app.application.port.in.medico.ConsultarMedicoUseCase;
import com.hospital.app.domain.model.Medico;
import com.hospital.app.domain.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultarMedicoService implements ConsultarMedicoUseCase {
    private final MedicoRepository medicoRepository;

    @Override
    public Optional<Medico> buscarPorId(Long id) {
        return medicoRepository.findById(id);
    }

    @Override
    public List<Medico> buscarPorEspecialidad(String especialidad) {
        return medicoRepository.findByEspecialidad(especialidad);
    }

    @Override
    public List<Medico> buscarTodos() {
        return medicoRepository.findAll();
    }
}