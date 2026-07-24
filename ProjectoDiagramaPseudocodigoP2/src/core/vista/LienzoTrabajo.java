package core.vista;

import core.modelo.BloqueBase;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class LienzoTrabajo extends JPanel {
    
    // Lista donde se guardarán todos los bloques creados por el usuario
    private List<BloqueBase> bloques;

    public LienzoTrabajo() {
        this.bloques = new ArrayList<>();
        this.setBackground(Color.WHITE); // Fondo blanco como una hoja de papel
    }

    // Método para que los módulos agreguen sus bloques al lienzo
    public void agregarBloque(BloqueBase nuevoBloque) {
        if (nuevoBloque != null) {
            bloques.add(nuevoBloque);
            repaint(); // Obliga a Swing a actualizar la pantalla y dibujar de nuevo
        }
    }

    // El método mágico de Java Swing que dibuja los elementos[cite: 1]
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el panel antes de redibujar

        // Recorre todos los bloques (sean Secuenciales, Condicionales, etc.) y los dibuja
        for (BloqueBase bloque : bloques) {
            bloque.dibujar(g);
        }
    }
    // Añade este método dentro de la clase LienzoTrabajo
    public java.util.List<core.modelo.BloqueBase> getBloques() {
        return this.bloques;
    }
    public void setBloques(java.util.List<core.modelo.BloqueBase> nuevosBloques) {
        this.bloques = nuevosBloques;
        repaint();
    }
    
}