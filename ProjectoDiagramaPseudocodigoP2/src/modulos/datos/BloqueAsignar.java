package modulos.datos;

import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;

public class BloqueAsignar extends BloqueBase {
    private String variable;
    private String valor;

    public BloqueAsignar(int x, int y, String variable, String valor) {
        // Los bloques de asignación suelen ser rectángulos
        super(x, y, 140, 50, variable + " = " + valor);
        this.variable = variable;
        this.valor = valor;
    }

    @Override
    public void dibujar(Graphics g) {
        
        g.setColor(new Color(173, 216, 230)); // Fondo color azul claro
        g.fillRect(x, y, ancho, alto);
        
        g.setColor(Color.BLACK); // Borde color negro
        g.drawRect(x, y, ancho, alto);
        
        // Dibuja el texto asignado centrado
        g.drawString(texto, x + 15, y + 30);
    }

    @Override
    public String generarPseudocodigo() {
        
        return "Asignar " + variable + " <- " + valor;
    }

    @Override
    public String guardarDatosFichero() {
        
        return "ASIGNAR|" + x + "|" + y + "|" + variable + "|" + valor;
    }
}