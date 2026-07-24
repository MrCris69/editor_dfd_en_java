package core.vista;
//PRIMERA VERSION
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
import modulos.control.BloqueCondicional;
import modulos.control.BloqueEscribir;
import modulos.control.BloqueSegun;
import modulos.control.PanelesControlUI;

public class VentanaPrincipal extends JFrame {

    private LienzoTrabajo lienzo;
    // Variables para que los bloques no se dibujen uno encima del otro al crearlos
    private int posicionX = 50;
    private int posicionY = 50;

    public VentanaPrincipal() {
        // Configuración básica de la ventana requerida para aplicaciones visuales
        setTitle("Editor de Diagramas de Flujo - Programación 2 - MOISES SAAVEDRA");
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
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        // --- MÓDULO DATOS (Integrante 1) ---
        JLabel tituloDatos = new JLabel("Módulo Datos");
        tituloDatos.setFont(new Font("Arial", Font.BOLD, 14));
        tituloDatos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloDatos);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton btnAsignar = new JButton("Asignar / Proceso");
        JButton btnLeer = new JButton("Leer Dato");
        JButton btnFuncion = new JButton("Llamar Función");

        estilizarBoton(btnAsignar, new Color(70, 130, 180));
        estilizarBoton(btnLeer, new Color(70, 130, 180));
        estilizarBoton(btnFuncion, new Color(70, 130, 180));

        btnAsignar.addActionListener(e -> {
            BloqueAsignar b = PanelesDatosUI.crearBloqueAsignar(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });
        btnLeer.addActionListener(e -> {
            BloqueLeer b = PanelesDatosUI.crearBloqueLeer(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });
        btnFuncion.addActionListener(e -> {
            BloqueFuncion b = PanelesDatosUI.crearBloqueFuncion(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });

        panel.add(btnAsignar); panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnLeer);    panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnFuncion); panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // --- MÓDULO CONTROL (Integrante 2) ---
        JLabel tituloControl = new JLabel("Módulo Control");
        tituloControl.setFont(new Font("Arial", Font.BOLD, 14));
        tituloControl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloControl);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton btnEscribir = new JButton("Escribir / Salida");
        JButton btnCondicional = new JButton("Condicional (Si)");
        JButton btnSegun = new JButton("Según (Switch)");

        estilizarBoton(btnEscribir, new Color(139, 0, 139)); // Botones morados
        estilizarBoton(btnCondicional, new Color(139, 0, 139));
        estilizarBoton(btnSegun, new Color(139, 0, 139));

        btnEscribir.addActionListener(e -> {
            BloqueEscribir b = PanelesControlUI.crearBloqueEscribir(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });
        btnCondicional.addActionListener(e -> {
            BloqueCondicional b = PanelesControlUI.crearBloqueCondicional(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });
        btnSegun.addActionListener(e -> {
            BloqueSegun b = PanelesControlUI.crearBloqueSegun(posicionX, posicionY);
            if (b != null) { lienzo.agregarBloque(b); actualizarCoordenadas(); }
        });

        panel.add(btnEscribir);    panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnCondicional); panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnSegun);       panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // --- MÓDULO CICLOS (Integrante 3) ---
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

        // --- BOTONES GLOBALES (Guardar / Generar) ---
        JButton btnGuardar = new JButton("Guardar Proyecto");
        JButton btnCargar = new JButton("Cargar Proyecto");
        JButton btnGenerar = new JButton("Generar Código");

        estilizarBoton(btnGuardar, Color.DARK_GRAY);
        estilizarBoton(btnCargar, Color.DARK_GRAY);
        estilizarBoton(btnGenerar, Color.BLACK);

        btnGuardar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                GestorFicheros.guardar(fc.getSelectedFile(), lienzo.getBloques());
                JOptionPane.showMessageDialog(null, "Guardado con éxito");
            }
        });

        btnCargar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                lienzo.setBloques(GestorFicheros.cargar(fc.getSelectedFile()));
            }
        });

        btnGenerar.addActionListener(e -> {
            String codigo = GestorProyecto.generarCodigoFinal(lienzo.getBloques());
            JOptionPane.showMessageDialog(null, new JTextArea(codigo), "Pseudocódigo Generado", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(btnGuardar); panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnCargar);  panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnGenerar);

        return panel;
    }

    // Método para darle un look moderno a los botones de Swing
    private void estilizarBoton(JButton boton, Color colorFondo) {
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(160, 35));
        boton.setFocusPainted(false);
        boton.setBackground(colorFondo); 
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
