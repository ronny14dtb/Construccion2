package com.hospital.app.application.port.in.facturacion;

import com.hospital.app.application.dto.DatosRegistrarPago;
import com.hospital.app.domain.model.Factura;


public interface RegistrarPagoUseCase {

    /**

     * @param datos 
     * @return 
     */
    Factura registrarPago(DatosRegistrarPago datos);
}