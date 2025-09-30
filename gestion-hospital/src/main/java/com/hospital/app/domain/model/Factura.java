package com.hospital.app.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class Factura {
    private Long id;
    private LocalDate fechaEmision;
    private Double montoTotal;
    private EstadoFactura estado;
    private Paciente paciente;
}