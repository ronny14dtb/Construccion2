package com.Bank.app.domain.model.vo;
import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    
    public BigDecimal getAmount() {
        return this.amount;
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.getAmount()));
    }

    public Money subtract(Money other) {
        return new Money(this.amount.subtract(other.getAmount()));
    }
}