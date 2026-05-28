package com.Bank.app.domain.service;

import com.Bank.app.domain.model.Loans;
import com.Bank.app.domain.model.Bankaccount;
import com.Bank.app.domain.model.User;
import com.Bank.app.domain.constant.RolSistem;
import com.Bank.app.domain.constant.StateAccount;
import com.Bank.app.domain.exceptions.DomainException;

public class ServiceLoan {

    public void approveLoan(Loans loan, User evaluator) {
        if (!RolSistem.ANALISTA_INTERNO.name().equals(evaluator.getRolSistema())) {
            throw new DomainException("Permiso denegado: El usuario no tiene rol de Analista Interno");
        }
        

        loan.approve(evaluator.getRolSistema());
    }

    public void disburseLoan(Loans loan, Bankaccount destinationAccount) {

        if (!"APROBADO".equals(loan.getEstadoPrestamo())) {
            throw new DomainException("No se puede desembolsar un préstamo que no esté aprobado");
        }

        if (destinationAccount.getEstado() != StateAccount.ACTIVA) {
            throw new DomainException("La cuenta de destino debe estar ACTIVA para el desembolso");
        }


        destinationAccount.deposit(loan.getMontoAprobado());
        
        loan.setEstadoPrestamo("DESEMBOLSADO");
    }
}