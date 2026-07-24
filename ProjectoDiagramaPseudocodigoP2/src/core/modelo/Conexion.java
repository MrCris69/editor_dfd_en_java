package core.modelo;

import java.awt.Color;
import java.awt.Graphics;

public class Conexion {
    private BloqueBase origen;
    private BloqueBase destino;
    private String tipoCamino; // Ej: "Si", "No", o vacío para flujo normal

    public Conexion(BloqueBase origen, BloqueBase destino, String tipoCamino) {
        this.origen = origen;
        this.destino = destino;
        this.tipoCamino = tipoCamino;
    }

    public void dibujar(Graphics g) {
        g.setColor(java.awt.Color.BLACK);

        // Coordenadas del bloque de ORIGEN (Punto central inferior)
        int x1 = origen.getX() + (origen.getAncho() / 2);
        int y1 = origen.getY() + origen.getAlto(); 

        // Coordenadas del bloque de DESTINO (Punto central superior)
        int x2 = destino.getX() + (destino.getAncho() / 2);
        int y2 = destino.getY(); 

        // Dibuja la línea centrada
        g.drawLine(x1, y1, x2, y2);

        // Dibuja la punta de la flecha (opcional)
        g.fillPolygon(new int[]{x2, x2 - 5, x2 + 5}, new int[]{y2, y2 - 5, y2 - 5}, 3);
    }
    
    public BloqueBase getOrigen() { return origen; }
    public BloqueBase getDestino() { return destino; }
    public String getTipoCamino() { return tipoCamino; }
}