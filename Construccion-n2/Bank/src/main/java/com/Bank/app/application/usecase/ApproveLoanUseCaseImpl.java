package main.java.com.Bank.app.application.usecase;

import com.Bank.app.application.ports.in.ApproveLoanUseCase;
import com.Bank.app.application.ports.out.AuditLogPort;
import com.Bank.app.application.ports.out.LoanRepositoryPort;
import com.Bank.app.application.ports.out.UserRepositoryPort;
import com.Bank.app.domain.exceptions.DomainException;
import com.Bank.app.domain.model.Loans;
import com.Bank.app.domain.model.OperationLog;
import com.Bank.app.domain.model.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ApproveLoanUseCaseImpl implements ApproveLoanUseCase {

    private final LoanRepositoryPort loanRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final AuditLogPort auditLogPort;

    public ApproveLoanUseCaseImpl(LoanRepositoryPort loanRepositoryPort, UserRepositoryPort userRepositoryPort, AuditLogPort auditLogPort) {
        this.loanRepositoryPort = loanRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.auditLogPort = auditLogPort;
    }

    @Override
    public Loans execute(Long loanId, Integer analystId) {
        User user = userRepositoryPort.findById(analystId)
                .orElseThrow(() -> new DomainException("Usuario no encontrado."));
        
        if (!"Analista Interno".equals(user.getRolSistema())) {
            throw new DomainException("Acceso denegado: Solo el Analista Interno puede aprobar préstamos.");
        }

        Loans loan = loanRepositoryPort.findById(loanId)
                .orElseThrow(() -> new DomainException("Préstamo no encontrado."));

        if (!"En estudio".equals(loan.getEstadoPrestamo())) {
            throw new DomainException("Un préstamo solo puede pasar a Aprobado si está 'En estudio'.");
        }

        loan.setEstadoPrestamo("Aprobado");
        loan.setMontoAprobado(loan.getMontoSolicitado());
        loan.setFechaAprobacion(LocalDateTime.now());

        Loans savedLoan = loanRepositoryPort.save(loan);


        OperationLog log = new OperationLog();
        log.setTipoOperacion("APROBACION_PRESTAMO");
        log.setFechaHoraOperacion(LocalDateTime.now());
        log.setIdUsuario(analystId);
        log.setRolUsuario(user.getRolSistema());
        log.setIdProductoAfectado(loanId.toString());

        Map<String, Object> detalle = new HashMap<>();
        detalle.put("montoAprobado", loan.getMontoAprobado());
        detalle.put("estadoAnterior", "En estudio");
        detalle.put("nuevoEstado", "Aprobado");
        log.setDatosDetalle(detalle);

        auditLogPort.save(log);

        return savedLoan;
    }
}