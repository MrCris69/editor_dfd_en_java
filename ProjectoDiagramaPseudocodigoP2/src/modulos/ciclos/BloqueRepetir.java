package modulos.ciclos;

import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;

public class BloqueRepetir extends BloqueBase {
     private String condicionFinal;

    public BloqueRepetir(int x, int y, String condicionFinal) {
        super(x, y, 160, 50, "Repetir hasta " + condicionFinal);
        this.condicionFinal = condicionFinal;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(new Color(216, 191, 216)); // Cardo (Thistle/Morado suave)
        g.fillRoundRect(x, y, ancho, alto, 30, 30); // Bordes muy redondeados
        
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, ancho, alto, 30, 30);
        
        g.drawString(texto, x + 15, y + 30);
    }

    @Override
    public String generarPseudocodigo() {
        return "Repetir\n    // Tareas\nHasta Que " + condicionFinal;
    }

    @Override
    public String guardarDatosFichero() {
        return "REPETIR|" + x + "|" + y + "|" + condicionFinal;
    }
}
