package modulos.datos;

import core.modelo.BloqueBase;

public class TraductorDatos {

    /**
     * Requisito: Generación de resultados (Pseudocódigo)
     * Extrae el pseudocódigo de los bloques de este módulo.
     */
    public static String obtenerPseudocodigo(BloqueBase bloque) {
        if (bloque instanceof BloqueAsignar || 
            bloque instanceof BloqueLeer || 
            bloque instanceof BloqueFuncion) {
            return bloque.generarPseudocodigo();
        }
        return "";
    }

    /**
     * Requisito: Carga mediante ficheros
     * Reconstruye los objetos visuales a partir de una línea de texto leída del archivo .txt
     */
    public static BloqueBase reconstruirDesdeFichero(String lineaFichero) {
        // Separamos los datos usando la barra "|" que definimos antes
        String[] partes = lineaFichero.split("\\|");
        String tipoBloque = partes[0];
        
        try {
            int x = Integer.parseInt(partes[1]);
            int y = Integer.parseInt(partes[2]);
            
            // Reconstruimos el bloque exacto según el tipo guardado
            switch (tipoBloque) {
                case "ASIGNAR":
                    return new BloqueAsignar(x, y, partes[3], partes[4]);
                case "LEER":
                    return new BloqueLeer(x, y, partes[3]);
                case "FUNCION":
                    return new BloqueFuncion(x, y, partes[3], partes[4]);
            }
        } catch (Exception e) {
            System.out.println("Error al reconstruir bloque de datos: " + e.getMessage());
        }
        
        return null; // Retorna null si la línea pertenece a otro módulo (ej. Condicional)
    }
}