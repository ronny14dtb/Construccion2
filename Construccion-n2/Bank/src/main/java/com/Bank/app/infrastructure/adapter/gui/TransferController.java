package com.Bank.app.infrastructure.adapter.gui;

import com.Bank.app.application.dto.TransferRequest;
import com.Bank.app.application.ports.in.CreateTransferUseCase;
import com.Bank.app.application.ports.in.ApproveTransferUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final CreateTransferUseCase createTransferUseCase;
    private final ApproveTransferUseCase approveTransferUseCase;

    public TransferController(CreateTransferUseCase createTransferUseCase,
                              ApproveTransferUseCase approveTransferUseCase) {
        this.createTransferUseCase = createTransferUseCase;
        this.approveTransferUseCase = approveTransferUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTransfer(@RequestBody TransferRequest request) {
        try {
            var transfer = createTransferUseCase.execute(request);
            return new ResponseEntity<>(transfer, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<?> approveTransfer(@PathVariable Long id, @RequestParam Integer approverId, @RequestParam(defaultValue = "false") boolean autoApprove) {
        try {
            approveTransferUseCase.execute(id, approverId, autoApprove);
            return ResponseEntity.ok("Transferencia aprobada y saldos actualizados con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}