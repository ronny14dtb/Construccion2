package com.hospital.app.application.port.in.facturacion;

import com.hospital.app.application.dto.DatosGenerarFactura;
import com.hospital.app.domain.model.Factura;


public interface GenerarFacturaUseCase {

    /**
     * @param datos 
     * @return 
     */
    Factura generarFactura(DatosGenerarFactura datos);
}