package vista;
import javax.swing.*;
public class PrincipalGestor {

    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(()-> {
            VentanasAplicacion ventGest = new VentanasAplicacion ();
            ventGest.setVisible(true);
        });
        
    }
    
}
