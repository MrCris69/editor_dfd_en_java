package modulos.control;

import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;

public class BloqueEscribir extends BloqueBase {
    private String mensaje;

    public BloqueEscribir(int x, int y, String mensaje) {
        super(x, y, 160, 50, "Escribir: " + mensaje);
        this.mensaje = mensaje;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(new Color(255, 182, 193)); // Rosa claro
        // Usamos un rectángulo redondeado para diferenciarlo visualmente
        g.fillRoundRect(x, y, ancho, alto, 20, 20);
        
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, ancho, alto, 20, 20);
        
        g.drawString(texto, x + 20, y + 30);
    }

    @Override
    public String generarPseudocodigo() {
        return "Escribir " + mensaje;
    }

    @Override
    public String guardarDatosFichero() {
        return "ESCRIBIR|" + x + "|" + y + "|" + mensaje;
    }
}