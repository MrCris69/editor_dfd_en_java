package core.controlador;

import core.modelo.BloqueBase;
import java.util.List;
import modulos.datos.TraductorDatos;
import modulos.control.TraductorControl;
import modulos.ciclos.TraductorCiclos;

public class GestorProyecto {
    
    public static String generarCodigoFinal(List<BloqueBase> bloques) {
        StringBuilder codigo = new StringBuilder();
        codigo.append("Algoritmo ProyectoFinal_Cris\n\n");
        
        for (BloqueBase bloque : bloques) {
            String linea = TraductorDatos.obtenerPseudocodigo(bloque);
            if (linea.isEmpty()) linea = TraductorControl.obtenerPseudocodigo(bloque);
            if (linea.isEmpty()) linea = TraductorCiclos.obtenerPseudocodigo(bloque);
            
            codigo.append("    ").append(linea).append("\n");
        }
        
        codigo.append("\nFinAlgoritmo");
        return codigo.toString();
    }
}
