package core.modelo;

import java.awt.*;

public abstract class BloqueBase {
    protected int x, y;
    protected int ancho, alto;
    protected String texto;

    public BloqueBase(int x, int y, int ancho, int alto, String texto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.texto = texto;
    }

    // Métodos abstractos que obligan a cumplir con la rúbrica del proyecto
    public abstract void dibujar(Graphics g); // Para la interfaz gráfica
    public abstract String generarPseudocodigo(); // Para generar resultados
    public abstract String guardarDatosFichero(); // Para cargar/guardar
    
    // Getters y Setters básicos
    public int getX() { return x; }
    public int getY() { return y; }
}