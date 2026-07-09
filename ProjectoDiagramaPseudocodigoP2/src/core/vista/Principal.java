package core.vista;
import javax.swing.*;
public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            MenuHerramientas ventGest = new MenuHerramientas ();
            ventGest.setVisible(true);
        });
        
    }
}