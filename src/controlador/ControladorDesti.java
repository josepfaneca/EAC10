package controlador;

import excepcions.GestioExcursionsExcepcio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Desti;
import persistencia.GestorPersistencia;
import persistencia.GestorSerial;
import persistencia.GestorXML;
import vista.DestiForm;
import vista.DestiLlista;
import vista.MenuDestiVista;

/**
 * MVC
 *
 * @author FTA
 */
public class ControladorDesti implements ActionListener {

    private MenuDestiVista menuDestiVista;
    private DestiForm destiForm = null;
    private DestiLlista destiLlista = null;
    private int opcioSelec = 0;

    /**
     * TODO S'inicialitza l'atribut menuDestiVista (això mostrarà el menú
     * destins) Es crida a afegirListenersMenu
     */
    public ControladorDesti() {
        menuDestiVista = new MenuDestiVista();
        afegirListenersMenu();
    }
    //El controlador com a listener dels controls de les finestres que gestionen els destins
    //S'AFEGEIX EL CONTROLADOR COM A LISTENER DELS BOTONS DEL MENU

    /**
     * TODO A cada botó del menú destins, s'afegeix aquest mateix objecte
     * (ControladorDesti) com a listener
     */
    private void afegirListenersMenu() {
        int i = 0;
        for (JButton menuButton : menuDestiVista.getMenuButtons()) {
            menuDestiVista.getMenuButtons()[i].addActionListener(this);
            i++;
        }
    }
    //S'AFEGEIX EL CONTROLADOR COM A LISTENER DELS BOTONS DEL FORMULARI

    /**
     * TODO A cada botó del formulari del destí, s'afegeix aquest mateix objecte
     * (ControladorDesti) com a listener
     */
    private void afegirListenersForm() {
        destiForm.getbDesar().addActionListener(this);
        destiForm.getbSortir().addActionListener(this);
    }

    //S'AFEGEIX EL CONTROLADOR COM A LISTENER DEL BOTO DE LA LLISTA
    /**
     * TODO Al botó de sortir de la llista de destins, s'afegeix aquest mateix
     * objecte (ControladorDesti) com a listener
     */
    private void afegirListenersLlista() {
        destiLlista.getbSortir().addActionListener(this);
    }

    /**
     * TODO Nota: Com ControladorDesti és listener del menú de destins, del
     * formulari i de la llista, llavors en aquest mètode actionPerformed heu de
     * controlar si l'usuari ha premut cap botó de qualsevol dels esmentats
     * frames. Ull! En el cas del formulari i de la llista, com provenen del
     * menú (els llança el menú de destins), heu de verificar primer que els
     * objectes destiForm o destiLlista no són nulls, per tal de saber si podeu
     * comparar amb cap botó d'aquests frames
     *
     * Accions per al menú: S'ha de cridar a bifurcaOpcio segons l'opció
     * premuda. Penseu que l'opció es correspon amb la posició que el botó ocupa
     * a l'array de botons de menuDestiVista També, heu d'actualitzar la
     * propietat opcioSelec (amb l'opció que ha premut l'usuari)
     *
     * Accions per al formulari de destí:
     *
     * ---- DESAR ---- Si el botó premut per l'usuari és el botó de desar del
     * formulari de destí, llavors Si l'opció seleccionada (al menú de destins)
     * és 1 (alta), llavors Es crea un nou objecte Desti amb les dades del
     * formulari S'afegeix el destí creat a la llista de ControladorPrincipal Es
     * posa aquest destí com destiActual (de ControladorPrincipal) i es canvia
     * l'atribut opcioSelec a 2 Si l'opció seleccionada (al menú de destins) és
     * 3 (modificació), llavors Nota: no es validen dades amb aquesta opció (per
     * simplificar) Es modifica l'objecte destí amb les dades del formulari
     * (penseu que és el destiActual de ControladorPrincipal) ---- SORTIR ----
     * Si el botó premut per l'usuari és el botó de sortir del formulari de
     * destins, llavors Heu de tornar al menú de destí (i amagar el formulari)
     * Accions per a la llista de destins: ---- SORTIR ---- Si el botó premut
     * per l'usuari és el botó de sortir de la llista de destins, llavors Heu de
     * tornar al menú de destins (i amagar la llista)
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * TODO Accions per al menú: S'ha de cridar a bifurcaOpcio segons
         * l'opció premuda. Penseu que l'opció es correspon amb la posició que
         * el botó ocupa a l'array de botons de menuDestiVista També, heu
         * d'actualitzar la propietat opcioSelec (amb l'opció que ha premut
         * l'usuari)
         *
         */
        if (e.getSource() == menuDestiVista.getMenuButtons()[0]) {
            try {
                bifurcaOpcio(0);
            } catch (GestioExcursionsExcepcio ex) {
                Logger.getLogger(ControladorDesti.class.getName()).log(Level.SEVERE, null, ex);
            }
            opcioSelec = 0;
        } else if (e.getSource() == menuDestiVista.getMenuButtons()[1]) {
            try {
                bifurcaOpcio(1);
            } catch (GestioExcursionsExcepcio ex) {
                Logger.getLogger(ControladorDesti.class.getName()).log(Level.SEVERE, null, ex);
            }
            opcioSelec = 1;
        } else if (e.getSource() == menuDestiVista.getMenuButtons()[2]) {
            try {
                bifurcaOpcio(2);
            } catch (GestioExcursionsExcepcio ex) {
                Logger.getLogger(ControladorDesti.class.getName()).log(Level.SEVERE, null, ex);
            }
            opcioSelec = 2;
        } else if (e.getSource() == menuDestiVista.getMenuButtons()[3]) {
            try {
                bifurcaOpcio(3);
            } catch (GestioExcursionsExcepcio ex) {
                Logger.getLogger(ControladorDesti.class.getName()).log(Level.SEVERE, null, ex);
            }
            opcioSelec = 3;
        } else if (e.getSource() == menuDestiVista.getMenuButtons()[4]) {
            try {
                bifurcaOpcio(4);
            } catch (GestioExcursionsExcepcio ex) {
                Logger.getLogger(ControladorDesti.class.getName()).log(Level.SEVERE, null, ex);
            }
            opcioSelec = 4;
        } else if (e.getSource() == menuDestiVista.getMenuButtons()[5]) {
            try {
                bifurcaOpcio(5);
            } catch (GestioExcursionsExcepcio ex) {
                Logger.getLogger(ControladorDesti.class.getName()).log(Level.SEVERE, null, ex);
            }
            opcioSelec = 5;
        } else if (e.getSource() == menuDestiVista.getMenuButtons()[6]) {
            try {
                bifurcaOpcio(6);
            } catch (GestioExcursionsExcepcio ex) {
                Logger.getLogger(ControladorDesti.class.getName()).log(Level.SEVERE, null, ex);
            }
            opcioSelec = 6;
        }
        /**
         *
         * Ull! En el cas del formulari i de la llista, com provenen del menú
         * (els llança el menú de destins), heu de verificar primer que els
         * objectes destiForm o destiLlista no són nulls, per tal de saber si
         * podeu comparar amb cap botó d'aquests frames
         *
         * Accions per al formulari de destí: ---- DESAR ---- Si el botó premut
         * per l'usuari és el botó de desar del formulari de destí, llavors Si
         * l'opció seleccionada (al menú de destins) és 1 (alta), llavors Es
         * crea un nou objecte Desti amb les dades del formulari S'afegeix el
         * destí creat a la llista de ControladorPrincipal Es posa aquest destí
         * com destiActual (de ControladorPrincipal) i es canvia l'atribut
         * opcioSelec a 2 Si l'opció seleccionada (al menú de destins) és 3
         * (modificació), llavors Nota: no es validen dades amb aquesta opció
         * (per simplificar) Es modifica l'objecte destí amb les dades del
         * formulari (penseu que és el destiActual de ControladorPrincipal)
         *
         */
        if (destiForm != null) {
            if (e.getSource() == destiForm.getbDesar()) {
                if (opcioSelec == 1) {
                    //Es crea un nou objecte Desti amb les dades del formulari
                    Desti nouDesti = new Desti(destiForm.gettNom().getText(),
                            destiForm.gettContinent().getText());
                    //S'afegeix el destí creat a la llista de ControladorPrincipal
                    ControladorPrincipal.getDestins()[ControladorPrincipal.getPosicioDestins()] = nouDesti;
                    //Es posa aquest destí com destiActual
                    ControladorPrincipal.setDestiActual(ControladorPrincipal.getDestins()[ControladorPrincipal.getPosicioDestins()]);
                    //avanço a la següent posició de l'array destins de ControladorPrincipal
                    ControladorPrincipal.setPosicioDestins();
                    //es canvia l'atribut a opcioSelect a 2
                    opcioSelec = 2;
                    //mostrar un missatge SEGONS ELS REQUERIMENTS NO S'HA D'IMPLEMENTAR CAP MISSATGE
                    destiForm.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(destiForm.getFrame(), "S'ha creat un nou desti amb nom: " + destiForm.gettNom().getText());
                    destiForm.getFrame().setVisible(false);
                } else if (opcioSelec == 3) {
                    //Es crea un nou objecte Desti amb les dades del formulari
                    Desti nouDesti = new Desti(destiForm.gettNom().getText(),
                            destiForm.gettContinent().getText());
                    //Es modifica l'objecte destí amb les dades del formulari
                    //és el destiActual de ControladorPrincipal
                    nouDesti.setCodi(ControladorPrincipal.getDestiActual().getCodi());//no vull modificar el codi
                    Desti.setProperCodiRestar();//setter per no córrer posició quan modifico
                    int posiDestiMod = 0;
                    //cercar la posició del Destí a modificar en l'array de ControladorPrincipal
                    for (int i = 0; i < ControladorPrincipal.getDestins().length; i++) {
                        if (ControladorPrincipal.getDestiActual().equals(ControladorPrincipal.getDestins()[i])) {
                            posiDestiMod = i;
                            i = ControladorPrincipal.getDestins().length;//sortir del bucle
                        }
                    }
                    //modificar el Destí de l'array de ControladorPrincipal seleccionat
                    ControladorPrincipal.getDestins()[posiDestiMod] = nouDesti;
                    ControladorPrincipal.setDestiActual(ControladorPrincipal.getDestins()[posiDestiMod]);
                }
            }
            /*
            ---- SORTIR ----
            Si el botó premut per l'usuari és el botó de sortir del formulari 
            de destins, llavors
            Heu de tornar al menú de destí (i amagar el formulari)
             */
            if (e.getSource() == destiForm.getbSortir()) {
                destiForm.getFrame().dispose();
                menuDestiVista.getFrame().setVisible(true);
            }
        }
        /*
        Accions per a la llista de destins:
        ---- SORTIR ----
        Si el botó premut per l'usuari és el botó de sortir de la llista 
        de destins, llavors
        Heu de tornar al menú de destins (i amagar la llista)
         */
        if (destiLlista != null) {
            if (e.getSource() == destiLlista.getbSortir()) {
                destiLlista.getFrame().dispose();
                menuDestiVista.getFrame().setVisible(true);
            }
        }
    }

    private void bifurcaOpcio(Integer opcio) throws GestioExcursionsExcepcio {

        switch (opcio) {
            case 0: //sortir
                ControladorPrincipal.getMenuPrincipalVista().getFrame().setVisible(true);
                this.menuDestiVista.getFrame().dispose();//extret del fòrum
                break;
            case 1: // alta
                if (ControladorPrincipal.getPosicioDestins() < ControladorPrincipal.getMAXDESTINS()) {
                    destiForm = new DestiForm();
                    destiForm.gettCodi().setEnabled(false);
                    afegirListenersForm();
                } else {
                    menuDestiVista.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "Màxim nombre de destins assolits.");
                }
                break;

            case 2: //seleccionar
                menuDestiVista.getFrame().setVisible(true);
                if (ControladorPrincipal.getDestins()[0] != null) {
                    seleccionarDesti();
                } else {
                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "Abans s'ha de crear al menys un destí");
                }
                break;

            case 3: //modificar
                if (ControladorPrincipal.getDestins()[0] != null) {
                    seleccionarDesti();
                    destiForm = new DestiForm(ControladorPrincipal.getDestiActual().getCodi(), ControladorPrincipal.getDestiActual().getNom(), ControladorPrincipal.getDestiActual().getContinent());
                    destiForm.gettCodi().setEnabled(false);
                    afegirListenersForm();
                } else {
                    menuDestiVista.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "Abans s'ha de crear al menys un destí");
                }
                break;

            case 4: // llistar
                if (ControladorPrincipal.getDestins()[0] != null) {
                    destiLlista = new DestiLlista();
                    afegirListenersLlista();
                } else {
                    menuDestiVista.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "Abans s'ha de crear al menys un destí");
                }
                break;

            case 5: //carregar
            /**
             * 
            TODO
            Es mostra un dialog (JOptionPane.showOptionDialog) amb botons, on cadascun d'ells és un mètode de càrrega 
            (propietat a Controlador Principal: ara XML i Serial)
            Un cop seleccionat el mètode, amb un altre dialog, es demana el codi del destí a carregar 
            (recordeu que el nom del fitxer és el codi del destí i l'extensió)
            Un cop l'usuari ha entrat el codi i ha premut OK,
                Es crea un objecte destí (nouDesti) com retorn de cridar a carregarDesti del gestor de persistència. 
                Penseu que la
                carrega pots ser d'un fitxer XML o bé d'un fitxer serial.
                Es comprova si el codi del nouDesti ja existeix al vector de destins 
                (això donarà la posició on s'ha trobat a la llista). Penseu
                que en aquesta classe teniu un mètode per fer la comprovació.
                Si existeix,
                    es mostra un dialog notificant a l'usuari si vol substituir 
                el destí del vector pel que es carregarà des de el fitxer (JOptionPane.showOptionDialog)
                    Si l'usuari cancela, no es fa res
                    Si l'usuari accepta, llavors es posa el nouDesti al vector a la mateixa posició on s'havia trobat aquest codi
                Si no existeix,
                    S'afegeix el nouDesti al vector de destins a la darrera posició
                    Es mostra un missatge confirmant l'addició (JOptionPane.showMessageDialog)
                 */
                int sel = JOptionPane.showOptionDialog(menuDestiVista.getFrame(),
                        "Selecciona un mètode", "Carregar destí",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new Object[]{"XML", "Serial"}, "XML");//opció 0 o 1
                //Un cop seleccionat el mètode, amb un altre dialog, es demana el codi del destí a carregar
                String codiFitxer = (JOptionPane.showInputDialog("Codi del destí"));
                switch (sel) {
                    case 0://xml
                        //Es crea un objecte destí (nouDesti) com retorn de cridar a carregarDesti del gestor de persistència
                        //extret de fòrum
                        try {
                            GestorXML gxml = new GestorXML();
                            gxml.carregarDesti(codiFitxer);
                            Desti nouDesti = gxml.getDesti();
                            //Es comprova si el codi del nouDesti ja existeix al vector de destins
                            if (comprovarDesti(nouDesti.getCodi()) != -1) {//si troba el codi
                                //es mostra un dialog notificant a l'usuari si vol substituir
                                int select = JOptionPane.showOptionDialog(menuDestiVista.getFrame(),
                                        "Vol subtituir el destí?", "Carregar destí",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                        null, new Object[]{"Desar", "Cancelar"}, "Desar");//opció 0 o 1

                                switch (select) {
                                    case 0://Si l'usuari accepta, llavors es posa el nouDesti 
                                        //al vector a la mateixa posició on s'havia trobat aquest codi
                                        ControladorPrincipal.getDestins()[comprovarDesti(nouDesti.getCodi())] = nouDesti;
                                        break;
                                    case 1:
                                        //s'ha triat cancelar
                                        JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "Ha triat cancel-lar");
                                        break;
                                }
                            } else {
                                //podria trobar l'array ple ?????
                                if (ControladorPrincipal.getPosicioDestins() < ControladorPrincipal.getMAXDESTINS()) {
                                    //es suposa que hi ha un fitxer xml creat
                                    //S'afegeix el nouDesti al vector de destins a la darrera posició
                                    ControladorPrincipal.getDestins()[ControladorPrincipal.getPosicioDestins()] = nouDesti;
                                    Desti.setProperCodi();//córrer un codi, així evitar duplicitat
                                    ControladorPrincipal.setPosicioDestins();
                                    //Es mostra un missatge confirmant l'addició (JOptionPane.showMessageDialog)
                                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "S'ha addicionat el destí "
                                            + "amb codi: " + nouDesti.getCodi());
                                } else {
                                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "No es poden afegir més destins "
                                    );
                                }
                            }
                        } catch (GestioExcursionsExcepcio e) {//mostrar missatge en cas d'excepció
                            JOptionPane.showMessageDialog(menuDestiVista.getFrame(), e);
                        }
                        break;
                    case 1://serial
                        //revisar bé si funciona
                        try {
                            GestorSerial gs = new GestorSerial();
                            gs.carregarDesti(codiFitxer + ".ser");
                            Desti nouDestiSerial = gs.getDesti();//he insertat el getter i el setter

                            //Es comprova si el codi del nouDesti ja existeix al vector de destins
                            if (comprovarDesti(nouDestiSerial.getCodi()) != -1) {
                                //es mostra un dialog notificant a l'usuari si vol substituir
                                int select = JOptionPane.showOptionDialog(menuDestiVista.getFrame(),
                                        "Vol subtituir el destí?", "Carregar destí",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                        null, new Object[]{"Desar", "Cancelar"}, "Desar");//opció 0 o 1
                                switch (select) {
                                    case 0://Si l'usuari accepta, llavors es posa el nouDesti 
                                        //al vector a la mateixa posició on s'havia trobat aquest codi
                                        ControladorPrincipal.getDestins()[comprovarDesti(nouDestiSerial.getCodi())] = nouDestiSerial;
                                        break;
                                    case 1:
                                        //s'ha triat cancelar
                                        JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "Ha triat cancel-lar");
                                        break;
                                }
                            } else {
                                //podria trobar l'array ple ?????
                                if (ControladorPrincipal.getPosicioDestins() < ControladorPrincipal.getMAXDESTINS()) {
                                    //es suposa que hi ha un fitxer xml creat
                                    //S'afegeix el nouDesti al vector de destins a la darrera posició
                                    ControladorPrincipal.getDestins()[ControladorPrincipal.getPosicioDestins()] = nouDestiSerial;
                                    Desti.setProperCodi();
                                    ControladorPrincipal.setPosicioDestins();
                                    //Es mostra un missatge confirmant l'addició (JOptionPane.showMessageDialog)
                                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "S'ha addicionat el destí "
                                            + "amb codi: " + nouDestiSerial.getCodi());
                                } else {
                                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "No es poden afegir més destins "
                                    );
                                }
                            }
                        } catch (GestioExcursionsExcepcio e) {
                            JOptionPane.showMessageDialog(menuDestiVista.getFrame(), e);
                        }
                        break;
                    default:
                        break;
                }
                break;
            case 6: //desar
                /*
                TODO
                Es comprova si s'ha seleccionat el destí, mostrant, si correspon, missatges d'error (JOptionPane.showMessageDialog)
                Si s'ha sseleccionat el destí, 
                    Es mostra un dialog (JOptionPane.showOptionDialog) amb botons, on cadascun d'ells és un mètode de càrrega
                    (propietat a Controlador Principal: ara XML i Serial)
                    Un cop escollit el mètode, es desa el destí cridant a desarDesti del gestor de persistència
                 */
                //http://chuwiki.chuidiang.org/index.php?title=JOptionPane_y_di%C3%A1logos_modales#JOptionPane.showOptionDialog.28.29
                if (ControladorPrincipal.getDestiActual() != null) {
                    int seleccio = JOptionPane.showOptionDialog(menuDestiVista.getFrame(), "Selecciona un mètode", "Desar destí",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, new Object[]{"XML", "Serial"}, "XML");//opció 0 o 1
                    //crear objecte gestorPersistencia per guardar fitxer.
                    GestorPersistencia gestorPersistencia = new GestorPersistencia();
                    switch (seleccio) {
                        case 0://xml
                            try {
                                String nomFitxer = String.valueOf((ControladorPrincipal.getDestiActual().getCodi()));
                                gestorPersistencia.desarDesti(ControladorPrincipal.getMETODESPERSISTENCIA()[0],
                                        nomFitxer,
                                        ControladorPrincipal.getDestiActual());
                            } catch (GestioExcursionsExcepcio e) {
                                JOptionPane.showMessageDialog(menuDestiVista.getFrame(), e);
                            }
                            break;
                        case 1://serial
                            try {
                                gestorPersistencia.desarDesti(ControladorPrincipal.getMETODESPERSISTENCIA()[1],
                                        ControladorPrincipal.getDestiActual().getCodi() + ".ser",
                                        ControladorPrincipal.getDestiActual());
                            } catch (GestioExcursionsExcepcio e) {
                                JOptionPane.showMessageDialog(menuDestiVista.getFrame(), e);
                            }
                            break;
                        default:
                            menuDestiVista.getFrame().setVisible(true);
                            JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "Error desconegut");
                            break;
                    }
                } else {
                    menuDestiVista.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuDestiVista.getFrame(), "Abans s'ha de seleccionar un destí");
                }
                break;
        }
    }

    private void seleccionarDesti() {

        String[] nomDesti = new String[ControladorPrincipal.getPosicioDestins()];

        int i = 0;

        for (Desti desti : ControladorPrincipal.getDestins()) {

            if (desti != null) {
                nomDesti[i] = desti.getNom();
            }

            i++;
        }

        int messageType = JOptionPane.QUESTION_MESSAGE;
        int code = JOptionPane.showOptionDialog(null, "Selecciona un desti", "Selecció de destí", 0, messageType, null, nomDesti, "A");

        if (code != JOptionPane.CLOSED_OPTION) {
            ControladorPrincipal.setDestiActual(ControladorPrincipal.getDestins()[code]);
        }

    }

    private Integer comprovarDesti(int codi) {

        boolean trobat = false;

        int pos = -1;

        for (int i = 0; i < ControladorPrincipal.getDestins().length && !trobat; i++) {

            if (ControladorPrincipal.getDestins()[i] != null) {
                if (ControladorPrincipal.getDestins()[i].getCodi() == codi) {
                    pos = i;
                    trobat = true;
                }
            }
        }

        return pos;
    }

}
