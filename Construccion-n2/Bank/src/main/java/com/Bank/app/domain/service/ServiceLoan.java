package com.Bank.app.domain.service;

import com.Bank.app.domain.model.Loans;
import com.Bank.app.domain.model.Bankaccount;
import com.Bank.app.domain.model.User;
import com.Bank.app.domain.constant.RolSistem;
import com.Bank.app.domain.constant.StateAccount;

public class ServiceLoan {

    public void approveLoan(Loans loan, User evaluator) {
    
        if (evaluator.getRol() != RolSistem.ANALISTA_INTERNO) {
            throw new RuntimeException("Permiso denegado: El usuario no tiene rol de Analista Interno");
        }
        
        loan.approve(evaluator.getRol());
    }

    public void disburseLoan(Loans loan, Bankaccount destinationAccount) {
        if (!"APROBADO".equals(loan.getEstadoPrestamo())) {
            throw new RuntimeException("No se puede desembolsar un préstamo que no esté aprobado");
        }

        if (destinationAccount.getEstado() != StateAccount.ACTIVA) {
            throw new RuntimeException("La cuenta de destino debe estar ACTIVA para el desembolso");
        }

        destinationAccount.deposit(loan.getMontoAprobado());
        
        loan.setEstadoPrestamo("DESEMBOLSADO");

    }
}