package modulos.ciclos;
import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;

public class BloqueMientras extends BloqueBase {
    private String condicion;

    public BloqueMientras(int x, int y, String condicion) {
        super(x, y, 150, 60, "Mientras " + condicion);
        this.condicion = condicion;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(new Color(135, 206, 250)); // Azul cielo (Sky Blue)
        g.fillOval(x, y, ancho, alto); // Óvalo para el ciclo Mientras
        
        g.setColor(Color.BLACK);
        g.drawOval(x, y, ancho, alto);
        
        g.drawString(texto, x + 25, y + 35);
    }

    @Override
    public String generarPseudocodigo() {
        return "Mientras " + condicion + " Hacer\n    // Tareas del bucle\nFin Mientras";
    }

    @Override
    public String guardarDatosFichero() {
        return "MIENTRAS|" + x + "|" + y + "|" + condicion;
    }
    
}
