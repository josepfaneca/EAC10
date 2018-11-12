package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author FTA
 */
public class DestiForm {

    private JFrame frame;

    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lCodi;
    private JTextField tCodi;
    private JLabel lNom;
    private JTextField tNom;
    private JLabel lContinent;
    private JTextField tContinent;

    private JButton bDesar;
    private JButton bSortir;

    /**
        TODO
        Amb els atributs d'aquesta classe, heu de fer el següent (no afegiu cap 
        * listener a cap control)
            Heu de crear l'objecte JFrame amb títol "Formulari Desti" i 
            * layout Grid d'una columna
            Heu de crear els controls del formulari (labels i textFields).
            Heu de crear els botons del formulari
            Heu d'afegir-ho tot al frame
            Heu de fer visible el frame amb l'amplada i alçada que proposen les 
            * propietats d'aquest nom
            Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el 
            * control "X" de la finestra
     */
    public DestiForm() {
        
        frame = new JFrame("Formulari Desti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        lCodi = new JLabel("Codi");
        tCodi = new JTextField();
        frame.add(lCodi);
        frame.add(tCodi);
        lNom = new JLabel("Nom");
        tNom = new JTextField();
        frame.add(lNom);
        frame.add(tNom);
        lContinent = new JLabel("Continent");
        tContinent = new JTextField();
        frame.add(lContinent);
        frame.add(tContinent);
        bDesar = new JButton("Desar");
        frame.add(bDesar);
        bSortir = new JButton("Sortir");
        frame.add(bSortir);
        frame.setSize(AMPLADA, ALCADA);
        frame.setVisible(true);
    }

    public DestiForm(int codi, String nom, String continent) {
        this();
        tCodi.setText(String.valueOf(codi));
        tNom.setText(nom);
        tContinent.setText(continent);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField gettCodi() {
        return tCodi;
    }

    public void settCodi(JTextField tCodi) {
        this.tCodi = tCodi;
    }

    public JTextField gettNom() {
        return tNom;
    }

    public void settNom(JTextField tNom) {
        this.tNom = tNom;
    }

    public JTextField gettContinent() {
        return tContinent;
    }

    public void settContinent(JTextField tContinent) {
        this.tContinent = tContinent;
    }

    public JButton getbDesar() {
        return bDesar;
    }

    public void setbDesar(JButton bDesar) {
        this.bDesar = bDesar;
    }

    public JButton getbSortir() {
        return bSortir;
    }

    public void setbSortir(JButton bSortir) {
        this.bSortir = bSortir;
    }

}
