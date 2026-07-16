package core.vista;

import javax.swing.*;
import java.awt.*;
import modulos.datos.PanelesDatosUI;
import modulos.datos.BloqueAsignar;
import modulos.datos.BloqueLeer;
import modulos.datos.BloqueFuncion;

public class VentanaPrincipal extends JFrame {
    
    private LienzoTrabajo lienzo;
    // Variables para que los bloques no se dibujen uno encima del otro al crearlos
    private int posicionX = 50; 
    private int posicionY = 50;

    public VentanaPrincipal() {
        // Configuración básica de la ventana requerida para aplicaciones visuales
        setTitle("Editor de Diagramas de Flujo - Programación 2");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout());

        // 1. Instanciar y agregar el lienzo al centro
        lienzo = new LienzoTrabajo();
        add(lienzo, BorderLayout.CENTER);

        // 2. Crear y agregar el panel lateral de herramientas a la izquierda
        JPanel panelHerramientas = crearPanelHerramientas();
        add(panelHerramientas, BorderLayout.WEST);
    }

    private JPanel crearPanelHerramientas() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 240, 240)); // Gris claro
        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        JLabel titulo = new JLabel("Módulo Datos");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio en blanco

        // Instanciar los botones interactivos[cite: 1]
        JButton btnAsignar = new JButton("Asignar / Proceso");
        JButton btnLeer = new JButton("Leer Dato");
        JButton btnFuncion = new JButton("Llamar Función");

        // Aplicar diseño a los botones
        estilizarBoton(btnAsignar);
        estilizarBoton(btnLeer);
        estilizarBoton(btnFuncion);

        // --- EVENTOS DE LOS BOTONES ---
        // Aquí conectamos la interfaz con tu código del Módulo de Datos
        btnAsignar.addActionListener(e -> {
            BloqueAsignar b = PanelesDatosUI.crearBloqueAsignar(posicionX, posicionY);
            if (b != null) {
                lienzo.agregarBloque(b);
                actualizarCoordenadas();
            }
        });

        btnLeer.addActionListener(e -> {
            BloqueLeer b = PanelesDatosUI.crearBloqueLeer(posicionX, posicionY);
            if (b != null) {
                lienzo.agregarBloque(b);
                actualizarCoordenadas();
            }
        });

        btnFuncion.addActionListener(e -> {
            BloqueFuncion b = PanelesDatosUI.crearBloqueFuncion(posicionX, posicionY);
            if (b != null) {
                lienzo.agregarBloque(b);
                actualizarCoordenadas();
            }
        });

        // Agregar los botones al panel lateral
        panel.add(btnAsignar);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(btnLeer);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(btnFuncion);

        return panel;
    }

    // Método para darle un look moderno a los botones de Swing
    private void estilizarBoton(JButton boton) {
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(160, 40));
        boton.setFocusPainted(false);
        boton.setBackground(new Color(70, 130, 180)); // Azul acero
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
    }

    // Método para evitar que el siguiente bloque caiga en la misma posición
    private void actualizarCoordenadas() {
        posicionY += 70; 
        // Si se sale de la pantalla hacia abajo, reinicia arriba más a la derecha
        if (posicionY > 600) {
            posicionY = 50;
            posicionX += 180;
        }
    }
}
