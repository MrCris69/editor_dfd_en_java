package modulos.control;

import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class BloqueCondicional extends BloqueBase {
    private String condicion;

    public BloqueCondicional(int x, int y, String condicion) {
        super(x, y, 160, 80, condicion + " ?"); // Un poco más alto para que parezca rombo
        this.condicion = condicion;
    }

    @Override
    public void dibujar(Graphics g) {
        // Calcular los 4 puntos del rombo geométrico
        int[] puntosX = {x + ancho / 2, x + ancho, x + ancho / 2, x};
        int[] puntosY = {y, y + alto / 2, y + alto, y + alto / 2};
        Polygon rombo = new Polygon(puntosX, puntosY, 4);

        g.setColor(new Color(255, 255, 153)); // Amarillo claro
        g.fillPolygon(rombo);
        
        g.setColor(Color.BLACK);
        g.drawPolygon(rombo);
        
        // Texto centrado en el rombo
        g.drawString(texto, x + 40, y + 45);
        
        // Dibujar pequeñas etiquetas para los caminos de la bifurcación
        g.drawString("Sí", x + ancho + 5, y + alto / 2 + 5);
        g.drawString("No", x - 20, y + alto / 2 + 5);
    }

    @Override
    public String generarPseudocodigo() {
        return "Si " + condicion + " Entonces\n    // Tareas\nSino\n    // Tareas\nFin Si";
    }

    @Override
    public String guardarDatosFichero() {
        return "CONDICIONAL|" + x + "|" + y + "|" + condicion;
    }
}