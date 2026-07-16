package modulos.datos;

import core.modelo.BloqueBase;
import java.awt.Color;
import java.awt.Graphics;

public class BloqueFuncion extends BloqueBase {
    private String nombreFuncion;
    private String parametros;

    public BloqueFuncion(int x, int y, String nombreFuncion, String parametros) {
        super(x, y, 150, 50, nombreFuncion + "(" + parametros + ")");
        this.nombreFuncion = nombreFuncion;
        this.parametros = parametros;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(new Color(255, 200, 150)); // Naranja claro
        g.fillRect(x, y, ancho, alto);
        
        g.setColor(Color.BLACK);
        g.drawRect(x, y, ancho, alto);
        
        // Líneas laterales típicas del bloque de función
        g.drawLine(x + 15, y, x + 15, y + alto);
        g.drawLine(x + ancho - 15, y, x + ancho - 15, y + alto);
        
        g.drawString(texto, x + 25, y + 30);
    }

    @Override
    public String generarPseudocodigo() {
        return "Llamar " + texto; 
    }

    @Override
    public String guardarDatosFichero() {
        return "FUNCION|" + x + "|" + y + "|" + nombreFuncion + "|" + parametros;
    }
}