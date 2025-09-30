package com.hospital.app.infrastructure.persistence.adapter;

import com.hospital.app.domain.model.Medico;
import com.hospital.app.domain.repository.MedicoRepository;
import com.hospital.app.infrastructure.persistence.jpa.MedicoSpringDataRepository;
import com.hospital.app.infrastructure.persistence.mapper.MedicoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component // <-- Esta anotación es la que permite que Spring lo encuentre
@RequiredArgsConstructor
public class MedicoPersistenceAdapter implements MedicoRepository {

    private final MedicoSpringDataRepository springDataRepository;
    private final MedicoMapper mapper;

    @Override
    public Medico save(Medico medico) {
        var jpaEntity = mapper.toJpaEntity(medico);
        var savedEntity = springDataRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Medico> findById(Long id) {
        return springDataRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Medico> findByEspecialidad(String especialidad) {
        return springDataRepository.findByEspecialidad(especialidad)
                .stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Medico> findAll() {
        return springDataRepository.findAll()
                .stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}