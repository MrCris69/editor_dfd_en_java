package core.vista;

import javax.swing.SwingUtilities;
//Primera version funcional EJECUTRAR DESDE AQUI.
public class Principal {
    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo adecuado de Swing[cite: 1]
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}