package com.Bank.app.application.dto;
import java.math.BigDecimal;

public record BankAccountRequest(
    String userId,
    String accountType, 
    BigDecimal initialDeposit
) {}