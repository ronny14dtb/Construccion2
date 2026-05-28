package com.Bank.app.domain.model;

import com.Bank.app.domain.model.vo.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loans {
    private Long id;
    private String estadoPrestamo;
    

    private Money montoSolicitado;
    private Money montoAprobado;
    

    private String tipoPrestamo; 
    private String idClienteSolicitante;
    private Double tasaInteres;
    private int plazoMeses;
    
    private LocalDateTime fechaAprobacion;
    private LocalDateTime fechaDesembolso;
    private String cuentaDestinoDesembolso;


    public void approve(String rol) {

        this.estadoPrestamo = "APROBADO";
        this.fechaAprobacion = LocalDateTime.now();
    }
}