package com.hospital.app.domain.repository;

import com.hospital.app.domain.model.Factura;
import com.hospital.app.domain.model.EstadoFactura;
import java.util.List;
import java.util.Optional;

public interface FacturaRepository {
    Factura save(Factura factura);
    Optional<Factura> findById(Long id);
    List<Factura> findByPacienteId(Long pacienteId);
    List<Factura> findByEstado(EstadoFactura estado);
}