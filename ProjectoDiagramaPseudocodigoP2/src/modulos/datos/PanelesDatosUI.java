package modulos.datos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class PanelesDatosUI {

    // 1. Interfaz para el Bloque Asignar
    public static BloqueAsignar crearBloqueAsignar(int x, int y) {
        JTextField campoVariable = new JTextField();
        JTextField campoValor = new JTextField();
        
        // Usamos JPanel y GridLayout de Swing
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Variable:"));
        panel.add(campoVariable);
        panel.add(new JLabel("Valor / Operación:"));
        panel.add(campoValor);

        int resultado = JOptionPane.showConfirmDialog(null, panel, 
                 "Configurar Bloque Asignar", JOptionPane.OK_CANCEL_OPTION);
                 
        if (resultado == JOptionPane.OK_OPTION) {
            String var = campoVariable.getText().trim();
            String val = campoValor.getText().trim();
            
            // Validación básica requerida
            if (!var.isEmpty() && !val.isEmpty()) {
                return new BloqueAsignar(x, y, var, val);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Los campos no pueden estar vacíos.", 
                                              "Validación", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null; // Retorna nulo si el usuario cancela o deja vacío
    }

    // 2. Interfaz para el Bloque Leer
    public static BloqueLeer crearBloqueLeer(int x, int y) {
        String variable = JOptionPane.showInputDialog(null, 
                "Ingrese el nombre de la variable a leer:", 
                "Configurar Bloque Leer", JOptionPane.QUESTION_MESSAGE);
        
        if (variable != null && !variable.trim().isEmpty()) {
            return new BloqueLeer(x, y, variable.trim());
        } else if (variable != null) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar una variable.", 
                                          "Validación", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // 3. Interfaz para el Bloque Función
    public static BloqueFuncion crearBloqueFuncion(int x, int y) {
        JTextField campoNombre = new JTextField();
        JTextField campoParametros = new JTextField();
        
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Nombre de la Función:"));
        panel.add(campoNombre);
        panel.add(new JLabel("Parámetros (opcional):"));
        panel.add(campoParametros);

        int resultado = JOptionPane.showConfirmDialog(null, panel, 
                 "Configurar Llamada a Función", JOptionPane.OK_CANCEL_OPTION);
                 
        if (resultado == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText().trim();
            String param = campoParametros.getText().trim();
            
            if (!nombre.isEmpty()) {
                return new BloqueFuncion(x, y, nombre, param);
            } else {
                JOptionPane.showMessageDialog(null, "Error: El nombre de la función es obligatorio.", 
                                              "Validación", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
}