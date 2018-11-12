package persistencia;

import excepcions.GestioExcursionsExcepcio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import model.Desti;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author FTA
 */
public class GestorSerial implements ProveedorPersistencia {

    private Desti desti;

    /**
     *
     *
     * Paràmetres: nom del fitxer i desti
     *
     * Acció: - Ha de desar l'objecte Desti serialitzat sobre un fitxer del
     * sistema operatiu amb nom nomFitxer i extensió ".ser". - Heu de controlar
     * excepcions d'entrada/sortida i en cas de produïrse alguna, llavors
     * llançar GestioExcursionsExcepcio amb codi GestorSerial.desar
     *
     * Nota: podeu comprovar que la classe Desti implementa Serializable
     *
     * Retorn: cap
     *
     * @param nomFitxer
     * @param desti
     * @throws excepcions.GestioExcursionsExcepcio
     */
    @Override
    public void desarDesti(String nomFitxer, Desti desti) throws GestioExcursionsExcepcio {

        try {
            File f = new File(nomFitxer);
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(f));
            ois.writeObject(desti);
            ois.close();
        } catch (Exception ex) {
            throw new GestioExcursionsExcepcio("GestorSerial.desar");
        }
    }

    /**
     *
     *
     * Paràmetres: nom del fitxer
     *
     * Acció: - Ha de carregar el fitxer del sistema operatiu amb nom nomFitxer
     * i extensió ".ser" sobre un nou objecte Desti que es retornarà com a
     * resultat. - Heu de controlar excepcions d'entrada/sortida i en cas de
     * produïrse alguna, llavors llançar GestioReservesExcepcio amb codi
     * GestorSerial.carrega
     *
     * retorn: cap
     *
     * @param nomFitxer
     * @throws excepcions.GestioExcursionsExcepcio
     */
    @Override
    public void carregarDesti(String nomFitxer) throws GestioExcursionsExcepcio {

        try {
            File f = new File(nomFitxer);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            this.desti = (Desti) ois.readObject();
            ois.close();
        } catch (Exception e) {
            throw new GestioExcursionsExcepcio("GestioSerial.carregar");
        }
    }
}
