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
        if (origen != null && destino != null) {
            // Calcular el centro inferior del bloque de origen
            int x1 = origen.getX() + origen.ancho / 2;
            int y1 = origen.getY() + origen.alto;
            
            // Calcular el centro superior del bloque de destino
            int x2 = destino.getX() + destino.ancho / 2;
            int y2 = destino.getY();

            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x2, y2); // Dibuja la línea principal
            
            // Dibuja la punta de la flecha
            int tamañoFlecha = 7;
            g.drawLine(x2, y2, x2 - tamañoFlecha, y2 - tamañoFlecha);
            g.drawLine(x2, y2, x2 + tamañoFlecha, y2 - tamañoFlecha);

            // Si la conexión sale de un rombo, escribe "Sí" o "No" en la flecha
            if (tipoCamino != null && !tipoCamino.isEmpty()) {
                g.setColor(Color.RED);
                g.drawString(tipoCamino, (x1 + x2) / 2 + 10, (y1 + y2) / 2);
            }
        }
    }
    
    public BloqueBase getOrigen() { return origen; }
    public BloqueBase getDestino() { return destino; }
    public String getTipoCamino() { return tipoCamino; }
}