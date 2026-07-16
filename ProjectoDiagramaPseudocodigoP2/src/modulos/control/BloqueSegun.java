package modulos.control;

import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class BloqueSegun extends BloqueBase {
    private String variableObjetivo;

    public BloqueSegun(int x, int y, String variableObjetivo) {
        super(x, y, 160, 60, "Según " + variableObjetivo);
        this.variableObjetivo = variableObjetivo;
    }

    @Override
    public void dibujar(Graphics g) {
        // Puntos para crear un hexágono alargado
        int[] puntosX = {x + 20, x + ancho - 20, x + ancho, x + ancho - 20, x + 20, x};
        int[] puntosY = {y, y, y + alto / 2, y + alto, y + alto, y + alto / 2};
        Polygon hexagono = new Polygon(puntosX, puntosY, 6);

        g.setColor(new Color(221, 160, 221)); // Morado (Plum)
        g.fillPolygon(hexagono);
        
        g.setColor(Color.BLACK);
        g.drawPolygon(hexagono);
        
        g.drawString(texto, x + 30, y + 35);
    }

    @Override
    public String generarPseudocodigo() {
        return "Segun " + variableObjetivo + " Hacer\n    // Casos\nFin Segun";
    }

    @Override
    public String guardarDatosFichero() {
        return "SEGUN|" + x + "|" + y + "|" + variableObjetivo;
    }
}