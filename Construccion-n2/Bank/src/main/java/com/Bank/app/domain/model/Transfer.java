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
    private LocalDateTime fechaAprobacion;
    private TransferStatus estado; 
    private Integer idUsuarioCreador;     
    private Integer idUsuarioAprobador;   


    public Transfer() {}


    public Transfer(Long idTransferencia, String cuentaOrigen, String cuentaDestino, Money monto, 
                    LocalDateTime fechaCreacion, LocalDateTime fechaAprobacion, TransferStatus estado, 
                    Integer idUsuarioCreador, Integer idUsuarioAprobador) {
        this.idTransferencia = idTransferencia;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.fechaCreacion = fechaCreacion;
        this.fechaAprobacion = fechaAprobacion;
        this.estado = estado;
        this.idUsuarioCreador = idUsuarioCreador;
        this.idUsuarioAprobador = idUsuarioAprobador;
    }


    public Long getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(Long idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Money getMonto() {
        return this.monto;
    }

    public void setMonto(Money monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDateTime fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public TransferStatus getEstado() {
        return estado;
    }

    public void setEstado(TransferStatus estado) {
        this.estado = estado;
    }

    public Integer getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public void setIdUsuarioCreador(Integer idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    public Integer getIdUsuarioAprobador() {
        return idUsuarioAprobador;
    }

    public void setIdUsuarioAprobador(Integer idUsuarioAprobador) {
        this.idUsuarioAprobador = idUsuarioAprobador;
    }


 
    public String getEstadoTransferencia() {
        return this.estado != null ? this.estado.name() : null;
    }

    public void setEstadoTransferencia(String estadoTransferencia) {
        if (estadoTransferencia != null) {
            this.estado = TransferStatus.valueOf(estadoTransferencia.toUpperCase());
        }
    }


    public boolean isExpired() {
        if (this.fechaCreacion == null) return false;
        return Duration.between(this.fechaCreacion, LocalDateTime.now()).toMinutes() > 60;
    }

    public boolean debeVencer() {
        return isExpired() && this.estado == TransferStatus.PENDIENTE;
    }
}