package com.Bank.app.infrastructure.persistence;

import com.Bank.app.application.ports.out.TransferRepositoryPort;
import com.Bank.app.domain.model.Transfer;
import com.Bank.app.infrastructure.adapter.sql.entity.TransferEntity;
import com.Bank.app.infrastructure.adapter.sql.repository.RepositoryTransfer;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class DatabaseTransferAdapter implements TransferRepositoryPort {

    private final RepositoryTransfer repositoryTransfer;

    public DatabaseTransferAdapter(RepositoryTransfer repositoryTransfer) {
        this.repositoryTransfer = repositoryTransfer;
    }

    @Override
    public Optional<Transfer> findById(Long id) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    @Override
    public List<Transfer> findPendingTransfersOlderThan(LocalDateTime thresholdTime) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    @Override
    public Transfer save(Transfer transfer) {
        TransferEntity entity = new TransferEntity();

        entity.setCuentaOrigen(transfer.getCuentaOrigen());
        entity.setCuentaDestino(transfer.getCuentaDestino());
        entity.setMonto(transfer.getMonto().getAmount());
        entity.setEstado(transfer.getEstado().name());
        entity.setFechaTransferencia(transfer.getFechaCreacion());
        TransferEntity savedEntity = repositoryTransfer.save(entity);
        transfer.setIdTransferencia(savedEntity.getId());

        return transfer;
    }
}