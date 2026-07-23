package modulos.ciclos;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class PanelesCiclosUI {
    public static BloqueMientras crearBloqueMientras(int x, int y) {
        String condicion = JOptionPane.showInputDialog(null, 
                "Ingrese la condición para el bucle Mientras:", 
                "Bucle Mientras", JOptionPane.QUESTION_MESSAGE);
        
        if (condicion != null && !condicion.trim().isEmpty()) {
            return new BloqueMientras(x, y, condicion.trim());
        }
        return null;
    }
    
    public static BloquePara crearBloquePara(int x, int y) {
        JTextField campoVariable = new JTextField("i");
        JTextField campoInicio = new JTextField("1");
        JTextField campoFin = new JTextField("10");
        JTextField campoPaso = new JTextField("1");
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("Variable iteradora:")); panel.add(campoVariable);
        panel.add(new JLabel("Valor inicial:"));      panel.add(campoInicio);
        panel.add(new JLabel("Valor final:"));        panel.add(campoFin);
        panel.add(new JLabel("Incremento (Paso):"));  panel.add(campoPaso);

        int resultado = JOptionPane.showConfirmDialog(null, panel, "Configurar Bucle Para", JOptionPane.OK_CANCEL_OPTION);
                 
        if (resultado == JOptionPane.OK_OPTION) {
            String var = campoVariable.getText().trim();
            String ini = campoInicio.getText().trim();
            String fin = campoFin.getText().trim();
            String paso = campoPaso.getText().trim();
            
            if (!var.isEmpty() && !ini.isEmpty() && !fin.isEmpty()) {
                return new BloquePara(x, y, var, ini, fin, paso);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Faltan datos obligatorios.", "Validación", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public static BloqueRepetir crearBloqueRepetir(int x, int y) {
        String condicion = JOptionPane.showInputDialog(null, 
                "Ingrese la condición de salida (Hasta Que...):", 
                "Bucle Repetir", JOptionPane.QUESTION_MESSAGE);
        
        if (condicion != null && !condicion.trim().isEmpty()) {
            return new BloqueRepetir(x, y, condicion.trim());
        }
        return null;
    }
}
