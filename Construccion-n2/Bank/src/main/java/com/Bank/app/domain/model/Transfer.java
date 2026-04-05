package com.Bank.app.domain.model;

import com.Bank.app.domain.model.vo.Money; 
import com.Bank.app.domain.constant.TransferStatus;
import java.time.LocalDateTime;
import java.time.Duration;

public class Transfer {
    private Long idTransferencia;
    private String cuentaOrigen;
    private String cuentaDestino;
    private Money monto; 
    private LocalDateTime fechaCreacion;
    private TransferStatus estado; 

 
    public boolean isExpired() {
        return Duration.between(this.fechaCreacion, LocalDateTime.now()).toMinutes() > 60;
    }

    public Money getMonto() {
        return this.monto;
    }

    public void setEstado(TransferStatus estado) {
        this.estado = estado;
    }


    public boolean debeVencer() {
        return isExpired() && this.estado == TransferStatus.PENDIENTE;
    }
}