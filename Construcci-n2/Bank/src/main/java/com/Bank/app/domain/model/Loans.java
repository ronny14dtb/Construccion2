package com.Bank.app.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Loans {
    private Long idPrestamo;
    private String idClienteSolicitante;
    private BigDecimal montoSolicitado;
    private BigDecimal montoAprobado;
    private String estadoPrestamo; // En estudio, Aprobado, Rechazado, Desembolsado
    private String cuentaDestinoDesembolso;

    // Getters y Setters
}