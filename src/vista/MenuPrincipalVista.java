package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author FTA
 */
public class MenuPrincipalVista {
    
    private JFrame frame;

    private JButton[] menuButtons = new JButton[3];
    
    

    private final int AMPLADA = 800;
    private final int ALCADA = 600;
    
    /**
        TODO
        
        Amb els atributs d'aquesta classe, heu de fer el següent (no afegiu cap 
      * listener a cap control):
            Heu de crear l'objecte JFrame amb títol "Menú Principal" 
           * i layout Grid d'una columna
            Heu de crear els botons del formulari. Cada botó serà un element de 
          * l'array de botons amb les següents etiquetes:
                        "0. Sortir"
                        "1. Menú Destins"
                        "2. Menú Guies"
            Heu d'afegir-ho tot al frame
            Heu de fer visible el frame amb l'amplada i alçada que proposen les 
          * propietats d'aquest nom
            Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el 
          * control "X" de la finestra
        */ 

    public MenuPrincipalVista() {
        
        frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        menuButtons[0] = new JButton("0. Sortir");
        menuButtons[1] = new JButton("1. Menú Destins");
        menuButtons[2] = new JButton("2. Menú Guies");
        frame.add(menuButtons[0]);
        frame.add(menuButtons[1]);
        frame.add(menuButtons[2]);
        frame.setSize(AMPLADA, ALCADA);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton[] getMenuButtons() {
        return menuButtons;
    }

    public void setMenuButtons(JButton[] menuButtons) {
        this.menuButtons = menuButtons;
    }
    
}
