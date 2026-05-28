package com.Bank.app.application.ports.in;


import com.Bank.app.application.dto.TransferRequest;
import com.Bank.app.domain.model.Transfer;

public interface CreateTransferUseCase {
    Transfer execute(TransferRequest request);
}