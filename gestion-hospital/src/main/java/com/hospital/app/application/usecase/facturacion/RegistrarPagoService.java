package com.hospital.app.application.usecase.facturacion;

import com.hospital.app.application.dto.DatosRegistrarPago;
import com.hospital.app.application.port.in.facturacion.RegistrarPagoUseCase;
import com.hospital.app.domain.model.EstadoFactura;
import com.hospital.app.domain.model.Factura;
import com.hospital.app.domain.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPagoService implements RegistrarPagoUseCase {
    
    private final FacturaRepository facturaRepository;

    @Override
    public Factura registrarPago(DatosRegistrarPago datos) {
        Factura factura = facturaRepository.findById(datos.facturaId())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        factura.setEstado(EstadoFactura.PAGADA);
        
        return facturaRepository.save(factura);
    }
}