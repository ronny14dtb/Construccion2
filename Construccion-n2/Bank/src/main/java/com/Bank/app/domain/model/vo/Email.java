package com.Bank.app.domain.model.vo;

import com.Bank.app.domain.constant.Currency;
import java.math.BigDecimal;

public record Email(String value) {
    public Email {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Formato de correo electrónico inválido");
        }
    }
}