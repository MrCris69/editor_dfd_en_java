package core.vista;

import javax.swing.SwingUtilities;

public class Principal {
    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo adecuado de Swing[cite: 1]
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}