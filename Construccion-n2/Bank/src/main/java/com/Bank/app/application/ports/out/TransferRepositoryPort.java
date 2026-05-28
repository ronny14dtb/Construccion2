package com.Bank.app.application.ports.out;

import com.Bank.app.domain.model.Transfer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransferRepositoryPort {
    Transfer save(Transfer transfer);
    Optional<Transfer> findById(Long id);
    
    List<Transfer> findPendingTransfersOlderThan(LocalDateTime thresholdTime);
}