package com.Bank.app.domain.model;

import com.Bank.app.domain.model.vo.Money; 
import com.Bank.app.domain.constant.RolSistem;
import java.time.LocalDate;
import com.Bank.app.domain.exceptions.DomainException;

public class Loans {
    private Long idPrestamo;
    private String idClienteSolicitante;
    private Money montoSolicitado;
    private Money montoAprobado; 
    private String estadoPrestamo;
    private String cuentaDestinoDesembolso;




    public String getEstadoPrestamo() {
        return this.estadoPrestamo;
    }

    public void setEstadoPrestamo(String estado) {
        this.estadoPrestamo = estado;
    }

    public Money getMontoAprobado() {
        return this.montoAprobado;
    }

    public void approve(RolSistem rol) {
        if (rol == RolSistem.ANALISTA_INTERNO) {
            this.estadoPrestamo = "APROBADO";
        }
    }
}