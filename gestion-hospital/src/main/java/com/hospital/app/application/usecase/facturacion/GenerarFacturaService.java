package com.hospital.app.application.usecase.facturacion;

import com.hospital.app.application.dto.DatosGenerarFactura;
import com.hospital.app.application.port.in.facturacion.GenerarFacturaUseCase;
import com.hospital.app.domain.model.EstadoFactura;
import com.hospital.app.domain.model.Factura;
import com.hospital.app.domain.model.Paciente;
import com.hospital.app.domain.repository.FacturaRepository;
import com.hospital.app.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class GenerarFacturaService implements GenerarFacturaUseCase {

    private final FacturaRepository facturaRepository;
    private final PacienteRepository pacienteRepository;

    @Override
    public Factura generarFactura(DatosGenerarFactura datos) {
        Paciente paciente = pacienteRepository.findById(datos.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Factura nuevaFactura = Factura.builder()
                .paciente(paciente)
                .montoTotal(datos.montoTotal())
                .fechaEmision(LocalDate.now())
                .estado(EstadoFactura.PENDIENTE)
                .build();
        
        return facturaRepository.save(nuevaFactura);
    }
}