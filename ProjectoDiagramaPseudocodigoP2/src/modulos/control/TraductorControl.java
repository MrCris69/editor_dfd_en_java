package modulos.control;

import core.modelo.BloqueBase;

public class TraductorControl {

    public static String obtenerPseudocodigo(BloqueBase bloque) {
        if (bloque instanceof BloqueEscribir || 
            bloque instanceof BloqueCondicional || 
            bloque instanceof BloqueSegun) {
            return bloque.generarPseudocodigo();
        }
        return "";
    }

    public static BloqueBase reconstruirDesdeFichero(String lineaFichero) {
        String[] partes = lineaFichero.split("\\|");
        String tipoBloque = partes[0];
        
        try {
            int x = Integer.parseInt(partes[1]);
            int y = Integer.parseInt(partes[2]);
            
            switch (tipoBloque) {
                case "ESCRIBIR":
                    return new BloqueEscribir(x, y, partes[3]);
                case "CONDICIONAL":
                    return new BloqueCondicional(x, y, partes[3]);
                case "SEGUN":
                    return new BloqueSegun(x, y, partes[3]);
            }
        } catch (Exception e) {
            System.out.println("Error al reconstruir bloque de control: " + e.getMessage());
        }
        
        return null;
    }
}