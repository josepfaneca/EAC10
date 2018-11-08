package persistencia;

import excepcions.GestioExcursionsExcepcio;
import model.Desti;

/**
 *
 * @author FTA
 */
public class GestorSerial implements ProveedorPersistencia{
    
    private Desti desti;

    @Override
    public void desarDesti(String nomFitxer, Desti desti) throws GestioExcursionsExcepcio {
        /*
         *TODO
         *
         *Paràmetres: nom del fitxer i desti
         *
         *Acció:
         * - Ha de desar l'objecte Desti serialitzat sobre un fitxer del sistema 
         *   operatiu amb nom nomFitxer i extensió ".ser".
         * - Heu de controlar excepcions d'entrada/sortida i en cas de produïrse alguna, 
         *   llavors llançar GestioExcursionsExcepcio amb codi GestorSerial.desar 
         *
         *Nota: podeu comprovar que la classe Desti implementa Serializable  
         *
         *Retorn: cap
         */

    }

    @Override
    public void carregarDesti(String nomFitxer) throws GestioExcursionsExcepcio {
        /*
         *TODO
         *
         *Paràmetres: nom del fitxer
         *
         *Acció:
         * - Ha de carregar el fitxer del sistema operatiu amb nom nomFitxer i extensió 
         *   ".ser" sobre un nou objecte Desti que es retornarà com a resultat.               
         * - Heu de controlar excepcions d'entrada/sortida i en cas de produïrse alguna, 
         *   llavors llançar GestioReservesExcepcio amb codi GestorSerial.carrega 
         *
         *Retorn: cap
         */

    }
}