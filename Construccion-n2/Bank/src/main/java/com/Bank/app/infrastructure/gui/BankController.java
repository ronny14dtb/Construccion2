package com.Bank.app.infrastructure.gui;

import com.Bank.app.domain.service.ServiceTransfer;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private final ServiceTransfer serviceTransfer;

    public BankController(ServiceTransfer serviceTransfer) {
        this.serviceTransfer = serviceTransfer;
    }

    @PostMapping("/transfer")
    public String transferir(@RequestParam String desde, @RequestParam String hacia, @RequestParam BigDecimal monto) {
        return "Transferencia en proceso...";
    }
}