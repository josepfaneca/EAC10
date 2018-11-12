package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Desti;
import persistencia.GestorPersistencia;
import vista.MenuPrincipalVista;

/**
 *
 * @author FTA
 */
public class ControladorPrincipal implements ActionListener {
    
    static private MenuPrincipalVista menuPrincipalVista;
    static private final int MAXDESTINS = 10;
    static private Desti[] destins = new Desti[MAXDESTINS];
    static private int posicioDestins = 0;
    static private Desti destiActual = null;
    static private int tipusElement = 0;
    static private GestorPersistencia gp = new GestorPersistencia();
    //FUTUR static private final String[] METODESPERSISTENCIA = {"XML","Serial","JDBC","DB4O"}; 
    static private final String[] METODESPERSISTENCIA = {"XML", "Serial"};

    /**
     * TODO S'inicialitza la propietat menuPrincipalVista (això mostrarà el menú
     * principal) A cada botó del menú, s'afegeix aquest mateix objecte
     * (ControladorPrincipal) com a listener
     *
     */
    public ControladorPrincipal() {
        menuPrincipalVista = new MenuPrincipalVista();
        afegirListenersMenu();
    }
    /**
    A cada botó del menú, s'afegeix aquest mateix objecte
     * (ControladorPrincipal) com a listener
    */
    private void afegirListenersMenu() {
        int i = 0;
        for (JButton menuButton : menuPrincipalVista.getMenuButtons()) {
            menuPrincipalVista.getMenuButtons()[i].addActionListener(this);
            i++;
        }
    }
    /**
     * TODO S'ha de cridar a bifurcaOpcio segons l'opció premuda. Penseu que
     * l'opció es correspon amb la posició que el botó ocupa a l'array de botons
     * de menuPrincipalVista
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "0. Sortir":
                bifurcaOpcio(0);
                break;
            case "1. Menú Destins":
                bifurcaOpcio(1);
                break;
            case "2. Menú Guies":
                bifurcaOpcio(2);
                break;
            default:
                break;
        }
    }
    private void bifurcaOpcio(int opcio) {
        switch (opcio) {
            case 0:
                System.exit(0);
                break;
            case 1:
                menuPrincipalVista.getFrame().setVisible(false);
                ControladorDesti controladorDesti = new ControladorDesti();
                break;
            case 2:
                JOptionPane.showMessageDialog(menuPrincipalVista.getFrame(), "No heu d'implementar aquest menú");
                break;
        }
        
    }
    
    public static MenuPrincipalVista getMenuPrincipalVista() {
        return menuPrincipalVista;
    }
    
    public static void setMenuPrincipalVista(MenuPrincipalVista menuPrincipalVista) {
        ControladorPrincipal.menuPrincipalVista = menuPrincipalVista;
    }
    
    public static Desti[] getDestins() {
        return destins;
    }
    
    public static void setDestins(Desti[] destins) {
        ControladorPrincipal.destins = destins;
    }
    
    public static int getPosicioDestins() {
        return posicioDestins;
    }
    
    public static void setPosicioDestins() {
        posicioDestins++;
    }
    
    public static Desti getDestiActual() {
        return destiActual;
    }
    
    public static void setDestiActual(Desti destiActual) {
        ControladorPrincipal.destiActual = destiActual;
    }
    
    public static int getTipusElement() {
        return tipusElement;
    }
    
    public static void setTipusElement(int tipusElement) {
        ControladorPrincipal.tipusElement = tipusElement;
    }
    
    public static GestorPersistencia getGp() {
        return gp;
    }
    
    public static void setGp(GestorPersistencia gp) {
        ControladorPrincipal.gp = gp;
    }
    
    public static int getMAXDESTINS() {
        return MAXDESTINS;
    }
    
    public static String[] getMETODESPERSISTENCIA() {
        return METODESPERSISTENCIA;
    }

    
}