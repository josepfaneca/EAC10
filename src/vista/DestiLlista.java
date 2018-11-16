package vista;

import com.sun.javafx.scene.control.skin.TableColumnHeader;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author FTA
 */
public class DestiLlista {

    private JFrame frame;

    private final int AMPLADA = 600;
    private final int ALCADA = 200;

    private JTable tDesti;

    private JButton bSortir;

    /**
     * TODO
     *
     * Amb els atributs d'aquesta classe, heu de fer el següent (no afegiu cap
     * listener a cap control) * Heu de crear l'objecte JFrame amb títol "Llista
     * de destins" i layout Grid d'una columna Heu de crear la taula amb un nou
     * objecte DestiTableModel com a model Heu de crear el botó del formulari
     * Heu d'afegir-ho tot al frame Heu de fer visible el frame amb l'amplada i
     * alçada que proposen les propietats d'aquest nom Heu de fer que la
     * finestra es tanqui quan l'usuari ho fa amb el control "X" de la finestra
     *
     * http://camposha.info/source/java-jtable-button-column
     */
    public DestiLlista() {
        DestiTableModel modelTaula = new DestiTableModel();
        modelTaula.getValueAt(0, 0);
        modelTaula.getColumnName(1);
        frame = new JFrame("Llista de destins");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        tDesti = new JTable(modelTaula);
        frame.add(tDesti);
        frame.add(new JScrollPane(tDesti));
        bSortir = new JButton("Sortir");
        frame.add(bSortir);
        frame.setSize(AMPLADA, ALCADA);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTable getDesti() {
        return tDesti;
    }

    public void settDesti(JTable tDesti) {
        this.tDesti = tDesti;
    }

    public JButton getbSortir() {
        return bSortir;
    }

    public void setbSortir(JButton bSortir) {
        this.bSortir = bSortir;
    }

    private void add(JScrollPane scrollPane) {
    }
}
