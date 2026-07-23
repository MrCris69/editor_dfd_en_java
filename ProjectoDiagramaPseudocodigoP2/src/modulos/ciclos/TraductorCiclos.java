package modulos.ciclos;
import core.modelo.BloqueBase;

public class TraductorCiclos {
    public static String obtenerPseudocodigo(BloqueBase bloque) {
        if (bloque instanceof BloqueMientras || 
            bloque instanceof BloquePara || 
            bloque instanceof BloqueRepetir) {
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
                case "MIENTRAS":
                    return new BloqueMientras(x, y, partes[3]);
                case "PARA":
                    // El Para tiene 6 partes en el array (tipo, x, y, variable, inicio, fin, paso)
                    return new BloquePara(x, y, partes[3], partes[4], partes[5], partes[6]);
                case "REPETIR":
                    return new BloqueRepetir(x, y, partes[3]);
            }
        } catch (Exception e) {
            System.out.println("Error al reconstruir bloque de ciclos: " + e.getMessage());
        }
       return null;
    }
}
