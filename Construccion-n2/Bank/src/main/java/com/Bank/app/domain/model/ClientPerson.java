package com.Bank.app.domain.model;

import java.time.LocalDate;
import java.time.Period;

public class ClientPerson extends User {
    private LocalDate fechaNacimiento;

    public boolean esMayorDeEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

}