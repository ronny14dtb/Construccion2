package com.hospital.app.application.port.in.facturacion;

import com.hospital.app.application.dto.DatosGenerarFactura;
import com.hospital.app.domain.model.Factura;

/**
 * Define el contrato para el caso de uso de generar una nueva factura.
 */
public interface GenerarFacturaUseCase {

    /**
     * Crea y persiste una nueva factura asociada a un paciente.
     *
     * @param datos El DTO con la información para generar la factura.
     * @return El objeto Factura ya creado y con su ID asignado.
     */
    Factura generarFactura(DatosGenerarFactura datos);
}