package com.universidad.proyecto.gestionhospital.infrastructure.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;
import com.universidad.proyecto.gestionhospital.application.port.in.ListarEnfermerasUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class EnfermeraFrame {

    @Autowired
    private ListarEnfermerasUseCase listarEnfermerasUseCase;

    public static void main(String[] args) {
        var context = new SpringApplication(EnfermeraFrame.class);
        context.setWebApplicationType(WebApplicationType.NONE);
        var appContext = context.run(args);

        EnfermeraFrame app = appContext.getBean(EnfermeraFrame.class);
        app.mostrarVentana();
    }

    public void mostrarVentana() {
        JFrame frame = new JFrame("Enfermeras del Hospital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new BorderLayout());

        List<Enfermera> enfermeras = listarEnfermerasUseCase.listarTodas();

        StringBuilder sb = new StringBuilder();
        for (Enfermera e : enfermeras) {
            sb.append("ID: ").append(e.getId())
              .append(" | Nombre: ").append(e.getNombre())
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
