package core.vista;
import javax.swing.*;
import java.awt.*;

public class MenuHerramientas extends JFrame {
    JLabel lbl1;
    public MenuHerramientas () {
        setTitle ("EDITOR DE DIAGRAMAS DE FLUJO!");
        setSize (1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        
        lbl1 = new JLabel ("HOLA AMIKOS");
        add(lbl1);

    }
}
