package core.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class BloqueFin extends BloqueBase {
    public BloqueFin(int x, int y) {
        super(x, y, 100, 40,"Fin");
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(new Color(255, 182, 193)); // Rojo pastel
        g.fillRoundRect(getX(), getY(), ancho, alto, 40, 40);
        g.setColor(Color.BLACK);
        g.drawRoundRect(getX(), getY(), ancho, alto, 40, 40);
        g.drawString("Fin", getX() + 42, getY() + 25);
    }

    @Override
    public String guardarDatosFichero() {
        return "TERMINAL|FIN|" + getX() + "|" + getY();
    }

    @Override
    public String generarPseudocodigo() {
        return "// Fin del algoritmo";
    }
}