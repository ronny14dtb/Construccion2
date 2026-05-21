package com.Bank.app.application.dto;

import java.math.BigDecimal;

public record TransferRequest(
    String sourceAccountNumber,
    String destinationAccountNumber,
    BigDecimal amount
) {}