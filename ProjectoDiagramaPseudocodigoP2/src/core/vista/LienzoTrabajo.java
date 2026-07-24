package core.vista;

import core.modelo.BloqueBase;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class LienzoTrabajo extends JPanel {
    
    private core.modelo.BloqueBase bloqueSeleccionado = null;
    private int offsetX, offsetY;
    private List<BloqueBase> bloques;

    public LienzoTrabajo() {
        this.bloques = new ArrayList<>();
        this.setBackground(Color.WHITE); // Fondo blanco como una hoja de papel

        // Registramos el MouseAdapter dentro del constructor
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Revisar de atrás hacia adelante para seleccionar el bloque que esté más al frente
                for (int i = bloques.size() - 1; i >= 0; i--) {
                    core.modelo.BloqueBase b = bloques.get(i);
                    // Lógica de colisión: ¿El clic está dentro de los límites del bloque?
                    if (e.getX() >= b.getX() && e.getX() <= b.getX() + b.getAncho() &&
                        e.getY() >= b.getY() && e.getY() <= b.getY() + b.getAlto()) {

                        bloqueSeleccionado = b;
                        offsetX = e.getX() - b.getX(); // Guardar el punto exacto de agarre
                        offsetY = e.getY() - b.getY();
                        break; // Romper el ciclo al encontrar el primer bloque tocado
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                bloqueSeleccionado = null; // Soltar el bloque
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (bloqueSeleccionado != null) {
                    // Actualizar las coordenadas mientras se mueve el mouse
                    bloqueSeleccionado.setX(e.getX() - offsetX);
                    bloqueSeleccionado.setY(e.getY() - offsetY);
                    repaint(); // Redibujar el lienzo en tiempo real
                }
            }
        };

        // Activar los escuchadores dentro del constructor
        this.addMouseListener(ma);
        this.addMouseMotionListener(ma);
    }

    // Método para que los módulos agreguen sus bloques al lienzo
    public void agregarBloque(BloqueBase nuevoBloque) {
        if (nuevoBloque != null) {
            bloques.add(nuevoBloque);
            repaint(); // Obliga a Swing a actualizar la pantalla y dibujar de nuevo
        }
    }

    // El método que dibuja los elementos
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 1. Dibujar las líneas de conexión PRIMERO
        for (int i = 1; i < bloques.size(); i++) {
            core.modelo.Conexion flecha = new core.modelo.Conexion(bloques.get(i - 1), bloques.get(i), null);
            flecha.dibujar(g);
        }
        
        // 2. Dibujar los bloques de código encima
        for (core.modelo.BloqueBase bloque : bloques) {
            bloque.dibujar(g);
        }
    }

    public java.util.List<core.modelo.BloqueBase> getBloques() {
        return this.bloques;
    }

    public void setBloques(java.util.List<core.modelo.BloqueBase> nuevosBloques) {
        this.bloques = nuevosBloques;
        repaint();
    }
    
}