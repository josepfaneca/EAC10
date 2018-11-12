package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author FTA
 */
public class MenuDestiVista {

    private JFrame frame;

    private JButton[] menuButtons = new JButton[7];

    private final int AMPLADA = 800;
    private final int ALCADA = 600;
    
    /**
        TODO
        Amb els atributs d'aquesta classe, heu de fer el següent (no afegiu cap 
        * listener a cap control)
            
            Heu de crear l'objecte JFrame amb títol "Menú Destí" i layout Grid
            * d'una columna
            Heu de crear els botons del formulari. Cada botó serà un element de
            * l'array de botons amb les següents etiquetes:
                        "0. Sortir"
                        "1. Alta Destí"
                        "2. Seleccionar Destí"
                        "3. Modificar Destíi"
                        "4. LListar Destins"
                        "5. Carregar Destí"
                        "6. Desar Destí"
            Heu d'afegir-ho tot al frame
            Heu de fer visible el frame amb l'amplada i alçada que proposen les
            * propietats d'aquest nom
            Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el 
            * control "X" de la finestra
         */

    public MenuDestiVista() {
        
        frame = new JFrame("Menú Destí");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        menuButtons[0] = new JButton("0. Sortir");
        menuButtons[1] = new JButton("1. Alta Destí");
        menuButtons[2] = new JButton("2. Seleccionar Destí");
        menuButtons[3] = new JButton("3. Modificar Destíi");
        menuButtons[4] = new JButton("4. LListar Destins");
        menuButtons[5] = new JButton("5. Carregar Destí");
        menuButtons[6] = new JButton("6. Desar Destí");
        frame.add(menuButtons[0]);
        frame.add(menuButtons[1]);
        frame.add(menuButtons[2]);
        frame.add(menuButtons[3]);
        frame.add(menuButtons[4]);
        frame.add(menuButtons[5]);
        frame.add(menuButtons[6]);
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
