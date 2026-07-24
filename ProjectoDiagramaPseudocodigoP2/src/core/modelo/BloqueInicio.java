package core.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class BloqueInicio extends BloqueBase {
    public BloqueInicio(int x, int y) {
        super(x, y, 100, 40, "Inicio");
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(new Color(144, 238, 144)); // Verde claro
        g.fillRoundRect(getX(), getY(), ancho, alto, 40, 40);
        g.setColor(Color.BLACK);
        g.drawRoundRect(getX(), getY(), ancho, alto, 40, 40);
        g.drawString("Inicio", getX() + 32, getY() + 25);
    }

    @Override
    public String guardarDatosFichero() {
        return "TERMINAL|INICIO|" + getX() + "|" + getY();
    }

    @Override
    public String generarPseudocodigo() {
        return "// Inicio del algoritmo";
    }
}