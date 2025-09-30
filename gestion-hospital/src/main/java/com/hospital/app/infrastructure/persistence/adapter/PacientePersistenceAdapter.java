package com.hospital.app.infrastructure.persistence.adapter;

import com.hospital.app.domain.model.Paciente;
import com.hospital.app.domain.repository.PacienteRepository;
import com.hospital.app.infrastructure.persistence.jpa.PacienteSpringDataRepository;
import com.hospital.app.infrastructure.persistence.mapper.PacienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PacientePersistenceAdapter implements PacienteRepository {

    private final PacienteSpringDataRepository springDataRepository;
    private final PacienteMapper mapper;

    @Override
    public Paciente save(Paciente paciente) {
        var jpaEntity = mapper.toJpaEntity(paciente);
        var savedEntity = springDataRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return springDataRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Paciente> findAll() {
        return springDataRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Paciente> findByDocumentoIdentidad(String documento) {
        return springDataRepository.findByDocumentoIdentidad(documento).map(mapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        springDataRepository.deleteById(id);
    }
}