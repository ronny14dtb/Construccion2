package main.java.com.Bank.app.application.ports.in;

import com.Bank.app.domain.model.Transfer;

public interface ApproveTransferUseCase {

    Transfer execute(Long transferId, Integer supervisorId, boolean approve);
}