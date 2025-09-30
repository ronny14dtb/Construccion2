package com.hospital.app.infrastructure.persistence.adapter;

import com.hospital.app.domain.model.EstadoFactura;
import com.hospital.app.domain.model.Factura;
import com.hospital.app.domain.repository.FacturaRepository;
import com.hospital.app.infrastructure.persistence.jpa.FacturaSpringDataRepository;
import com.hospital.app.infrastructure.persistence.mapper.FacturaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FacturaPersistenceAdapter implements FacturaRepository {

    private final FacturaSpringDataRepository springDataRepository;
    private final FacturaMapper mapper;

    @Override
    public Factura save(Factura factura) {
        var jpaEntity = mapper.toJpaEntity(factura);
        var savedEntity = springDataRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Factura> findById(Long id) {
        return springDataRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Factura> findByPacienteId(Long pacienteId) {
        return springDataRepository.findByPacienteId(pacienteId).stream()
                .map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Factura> findByEstado(EstadoFactura estado) {
        return springDataRepository.findByEstado(estado).stream()
                .map(mapper::toDomain).collect(Collectors.toList());
    }
}