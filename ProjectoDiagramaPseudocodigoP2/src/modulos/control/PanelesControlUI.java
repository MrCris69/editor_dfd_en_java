package modulos.control;

import javax.swing.JOptionPane;

public class PanelesControlUI {

    // 1. Interfaz para el Bloque Escribir (Salida de texto)
    public static BloqueEscribir crearBloqueEscribir(int x, int y) {
        String mensaje = JOptionPane.showInputDialog(null, 
                "Ingrese el mensaje o variable a imprimir:", 
                "Configurar Bloque Escribir", JOptionPane.QUESTION_MESSAGE);
        
        // Validación básica exigida por la rúbrica
        if (mensaje != null && !mensaje.trim().isEmpty()) {
            return new BloqueEscribir(x, y, mensaje.trim());
        } else if (mensaje != null) {
            JOptionPane.showMessageDialog(null, "Error: El mensaje no puede estar vacío.", 
                                          "Validación", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // 2. Interfaz para el Bloque Condicional (Rombo de Decisión)
    public static BloqueCondicional crearBloqueCondicional(int x, int y) {
        String condicion = JOptionPane.showInputDialog(null, 
                "Ingrese la condición lógica (ej. x > 10):", 
                "Configurar Rombo de Decisión", JOptionPane.WARNING_MESSAGE);
        
        if (condicion != null && !condicion.trim().isEmpty()) {
            return new BloqueCondicional(x, y, condicion.trim());
        } else if (condicion != null) {
            JOptionPane.showMessageDialog(null, "Error: La condición es obligatoria para bifurcar.", 
                                          "Validación", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // 3. Interfaz para el Bloque Según (Casos Múltiples)
    public static BloqueSegun crearBloqueSegun(int x, int y) {
        String variable = JOptionPane.showInputDialog(null, 
                "Ingrese la variable a evaluar en los múltiples casos:", 
                "Configurar Bloque Según", JOptionPane.INFORMATION_MESSAGE);
        
        if (variable != null && !variable.trim().isEmpty()) {
            return new BloqueSegun(x, y, variable.trim());
        } else if (variable != null) {
            JOptionPane.showMessageDialog(null, "Error: Debe especificar una variable objetivo.", 
                                          "Validación", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
