package com.Bank.app.infrastructure.adapter.gui;

import com.Bank.app.application.dto.LoanRequest;
import com.Bank.app.application.ports.in.RequestLoanUseCase;
import com.Bank.app.application.ports.in.ApproveLoanUseCase;
import com.Bank.app.application.ports.in.RejectLoanUseCase;
import com.Bank.app.application.ports.in.DisburseLoanUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final RequestLoanUseCase requestLoanUseCase;
    private final ApproveLoanUseCase approveLoanUseCase;
    private final RejectLoanUseCase rejectLoanUseCase;
    private final DisburseLoanUseCase disburseLoanUseCase;

    public LoanController(RequestLoanUseCase requestLoanUseCase,
                          ApproveLoanUseCase approveLoanUseCase,
                          RejectLoanUseCase rejectLoanUseCase,
                          DisburseLoanUseCase disburseLoanUseCase) {
        this.requestLoanUseCase = requestLoanUseCase;
        this.approveLoanUseCase = approveLoanUseCase;
        this.rejectLoanUseCase = rejectLoanUseCase;
        this.disburseLoanUseCase = disburseLoanUseCase;
    }

    @PostMapping("/request")
    public ResponseEntity<?> requestLoan(@RequestBody LoanRequest request) {
        try {
            var loan = requestLoanUseCase.execute(request);
            return new ResponseEntity<>(loan, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<?> approveLoan(@PathVariable Long id, @RequestParam Integer analystId) {
        try {
            approveLoanUseCase.execute(id, analystId);
            return ResponseEntity.ok("Préstamo aprobado de forma exitosa.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<?> rejectLoan(@PathVariable Long id, @RequestParam Integer analystId) {
        try {
            rejectLoanUseCase.execute(id, analystId);
            return ResponseEntity.ok("Préstamo rechazado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/disburse")
    public ResponseEntity<?> disburseLoan(@PathVariable Long id, @RequestParam Integer analystId) {
        try {
            disburseLoanUseCase.execute(id, analystId);
            return ResponseEntity.ok("Monto del préstamo desembolsado en la cuenta destino.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}