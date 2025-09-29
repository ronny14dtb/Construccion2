package com.universidad.proyecto.gestionhospital.infrastructure.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import com.universidad.proyecto.gestionhospital.application.port.in.ListarMedicosPorEspecialidadUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class MedicoFrame {

    @Autowired
    private ListarMedicosPorEspecialidadUseCase listarMedicosUseCase;

    public static void main(String[] args) {
        var context = new SpringApplication(MedicoFrame.class);
        context.setWebApplicationType(WebApplicationType.NONE);
        var appContext = context.run(args);

        MedicoFrame app = appContext.getBean(MedicoFrame.class);
        app.mostrarVentana();
    }

    public void mostrarVentana() {
        JFrame frame = new JFrame("Médicos del Hospital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new BorderLayout());

        List<Medico> medicos = listarMedicosUseCase.listarTodos(); // suponiendo que el usecase tiene listarTodos()

        StringBuilder sb = new StringBuilder();
        for (Medico m : medicos) {
            sb.append("ID: ").append(m.getId())
              .append(" | Nombre: ").append(m.getNombre())
              .append(" | Especialidad: ").append(m.getEspecialidad())
              .append("\n");
        }

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);

        panel.add(scroll, BorderLayout.CENTER);
        frame.add(panel);

        frame.setVisible(true);
    }
}
