package com.Bank.app.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transfer {
    private Long idTransferencia;
    private String cuentaOrigen;
    private String cuentaDestino;
    private BigDecimal monto;
    private LocalDateTime fechaCreacion;
    private String estadoTransferencia;

    public boolean debeVencer() {
        return this.fechaCreacion.plusMinutes(60).isBefore(LocalDateTime.now()) 
               && "En espera de aprobación".equals(this.estadoTransferencia);
    }
}