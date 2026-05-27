package main.java.com.Bank.app.infrastructure.adapter.gui;

import main.java.com.Bank.app.application.dto.LoanRequest;
import main.java.com.Bank.app.application.ports.in.RequestLoanUseCase;
import main.java.com.Bank.app.application.ports.in.ApproveLoanUseCase;
import main.java.com.Bank.app.application.ports.in.RejectLoanUseCase;
import main.java.com.Bank.app.application.ports.in.DisburseLoanUseCase;
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
    public ResponseEntity<?> approveLoan(@PathVariable Integer id, @RequestParam String analystId) {
        try {
            approveLoanUseCase.execute(id, analystId);
            return ResponseEntity.ok("Préstamo aprobado de forma exitosa.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<?> rejectLoan(@PathVariable Integer id, @RequestParam String analystId) {
        try {
            rejectLoanUseCase.execute(id, analystId);
            return ResponseEntity.ok("Préstamo rechazado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/disburse")
    public ResponseEntity<?> disburseLoan(@PathVariable Integer id) {
        try {
            disburseLoanUseCase.execute(id);
            return ResponseEntity.ok("Monto del préstamo desembolsado en la cuenta destino.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}