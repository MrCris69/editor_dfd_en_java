package core.vista;

import javax.swing.*;
import java.awt.*;
import modulos.datos.PanelesDatosUI;
import modulos.datos.BloqueAsignar;
import modulos.datos.BloqueLeer;
import modulos.datos.BloqueFuncion;
import modulos.ciclos.PanelesCiclosUI;
import modulos.ciclos.BloqueMientras;
import modulos.ciclos.BloquePara;
import modulos.ciclos.BloqueRepetir;
import core.controlador.GestorFicheros;
import core.controlador.GestorProyecto;
import java.io.File;

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
        
        
        
        JLabel tituloCiclos = new JLabel("Módulo Ciclos");
        tituloCiclos.setFont(new Font("Arial", Font.BOLD, 14));
        tituloCiclos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloCiclos);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton btnMientras = new JButton("Mientras (While)");
        JButton btnPara = new JButton("Para (For)");
        JButton btnRepetir = new JButton("Repetir (Do-While)");

        estilizarBoton(btnMientras, new Color(46, 139, 87)); 
        estilizarBoton(btnPara, new Color(46, 139, 87));
        estilizarBoton(btnRepetir, new Color(46, 139, 87));

        btnMientras.addActionListener(e -> {
            BloqueMientras b = PanelesCiclosUI.crearBloqueMientras(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });
        btnPara.addActionListener(e -> {
            BloquePara b = PanelesCiclosUI.crearBloquePara(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });
        btnRepetir.addActionListener(e -> {
            BloqueRepetir b = PanelesCiclosUI.crearBloqueRepetir(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });

        panel.add(btnMientras); panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnPara);     panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnRepetir);  panel.add(Box.createRigidArea(new Dimension(0, 30)));

        //BOTONES (Guardar / Generar)
        JButton btnGuardar = new JButton("Guardar Proyecto");
        JButton btnCargar = new JButton("Cargar Proyecto");
        JButton btnGenerar = new JButton("Generar Código");
        
        estilizarBoton(btnGuardar, Color.DARK_GRAY);
        estilizarBoton(btnCargar, Color.DARK_GRAY);
        estilizarBoton(btnGenerar, Color.BLACK);

        btnGuardar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                GestorFicheros.guardar(fc.getSelectedFile(), lienzo.getBloques());
                JOptionPane.showMessageDialog(this, "Guardado con éxito");
            }
        });

        btnCargar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                lienzo.setBloques(GestorFicheros.cargar(fc.getSelectedFile()));
            }
        });

        btnGenerar.addActionListener(e -> {
            String codigo = GestorProyecto.generarCodigoFinal(lienzo.getBloques());
            JOptionPane.showMessageDialog(this, new JTextArea(codigo), "Pseudocódigo Generado", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(btnGuardar); panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnCargar);  panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnGenerar);
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
