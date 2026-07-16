package modulos.datos;

import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class BloqueLeer extends BloqueBase {
    private String variable;

    public BloqueLeer(int x, int y, String variable) {
        super(x, y, 140, 50, "Leer " + variable);
        this.variable = variable;
    }

    @Override
    public void dibujar(Graphics g) {
        // 1. Crear el paralelogramo (inclinado)
        int[] puntosX = {x + 15, x + ancho, x + ancho - 15, x};
        int[] puntosY = {y, y, y + alto, y + alto};
        Polygon paralelogramo = new Polygon(puntosX, puntosY, 4);

        g.setColor(new Color(144, 238, 144)); // Verde claro
        g.fillPolygon(paralelogramo);
        
        g.setColor(Color.BLACK); // Borde
        g.drawPolygon(paralelogramo);
        
        // Texto centrado
        g.drawString(texto, x + 30, y + 30);
    }

    @Override
    public String generarPseudocodigo() {
        return "Leer " + variable;
    }

    @Override
    public String guardarDatosFichero() {
        
        return "LEER|" + x + "|" + y + "|" + variable;
    }
}
