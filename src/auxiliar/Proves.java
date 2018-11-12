/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

import controlador.ControladorPrincipal;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import vista.DestiForm;
import vista.DestiLlista;
import vista.MenuPrincipalVista;

/**
 *
 * @author jfanecat
 */
public class Proves {

    public static JButton[] menuButtons = new JButton[7];
    private static final int AMPLADA = 800;
    private static final int ALCADA = 600;
    private static final JFrame FRAME = new JFrame("");
    
    static JFrame MenuPrincipalVista1(JFrame frame) {

        frame = new JFrame("Menú Destí");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
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

        return frame;

    }
    
    static JFrame MenuDestiVista1 (JFrame frame){
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
        return frame;
    }

    public static void main(String[] args) {
//        JFrame miFrame = MenuPrincipalVista1(FRAME);
//        JFrame miFrame2 = MenuDestiVista1(FRAME);
//        MenuPrincipalVista MenuPrincipalVista = new MenuPrincipalVista(); 
//        DestiLlista destiLlista = new DestiLlista();
//        DestiForm destiform = new DestiForm();
//        ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
        
        
    }

}
