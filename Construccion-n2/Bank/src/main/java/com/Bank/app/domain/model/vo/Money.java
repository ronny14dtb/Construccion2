package com.Bank.app.domain.model.vo;
import java.math.BigDecimal;
public class Money implements Comparable<Money> {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount != null ? amount : BigDecimal.ZERO;
    }

    public Money(Double amount) {
        this.amount = BigDecimal.valueOf(amount != null ? amount : 0.0);
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

    @Override
    public int compareTo(Money other) {
        return this.amount.compareTo(other.getAmount());
    }
}