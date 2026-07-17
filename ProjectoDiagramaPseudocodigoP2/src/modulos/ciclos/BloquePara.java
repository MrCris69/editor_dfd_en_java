package modulos.ciclos;

import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class BloquePara extends BloqueBase {
     private String variable, inicio, fin, paso;

    public BloquePara(int x, int y, String variable, String inicio, String fin, String paso) {
        super(x, y, 180, 60, "Para " + variable + "=" + inicio + " hasta " + fin);
        this.variable = variable;
        this.inicio = inicio;
        this.fin = fin;
        this.paso = paso;
    }

    @Override
    public void dibujar(Graphics g) {
        int[] puntosX = {x + 15, x + ancho - 15, x + ancho, x + ancho - 15, x + 15, x};
        int[] puntosY = {y, y, y + alto / 2, y + alto, y + alto, y + alto / 2};
        Polygon hex = new Polygon(puntosX, puntosY, 6);

        g.setColor(new Color(255, 160, 122)); // Salmón claro
        g.fillPolygon(hex);
        
        g.setColor(Color.BLACK);
        g.drawPolygon(hex);
        
        g.drawString(texto, x + 20, y + 35);
    }

    @Override
    public String generarPseudocodigo() {
        return "Para " + variable + " <- " + inicio + " Hasta " + fin + " Con Paso " + paso + " Hacer\n    // Tareas\nFin Para";
    }

    @Override
    public String guardarDatosFichero() {
        return "PARA|" + x + "|" + y + "|" + variable + "|" + inicio + "|" + fin + "|" + paso;
    }
}
