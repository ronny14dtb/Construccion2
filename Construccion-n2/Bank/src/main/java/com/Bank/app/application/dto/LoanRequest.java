package com.Bank.app.application.dto;

import java.math.BigDecimal;

public record LoanRequest(
    String userId,
    BigDecimal requestedAmount,
    int termMonths
) {}