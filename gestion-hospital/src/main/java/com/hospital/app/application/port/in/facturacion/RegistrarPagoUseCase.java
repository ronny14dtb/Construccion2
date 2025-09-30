package com.hospital.app.application.port.in.facturacion;

import com.hospital.app.application.dto.DatosRegistrarPago;
import com.hospital.app.domain.model.Factura;

/**
 * Define el contrato para el caso de uso de registrar un pago a una factura.
 */
public interface RegistrarPagoUseCase {

    /**
     * Registra un pago y actualiza el estado de una factura.
     *
     * @param datos El DTO con el ID de la factura y el monto del pago.
     * @return La factura actualizada.
     */
    Factura registrarPago(DatosRegistrarPago datos);
}