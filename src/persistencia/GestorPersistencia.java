package persistencia;

import excepcions.GestioExcursionsExcepcio;
import model.Desti;


/**
 *
 * @author FTA
 */
public class GestorPersistencia {
    
    private ProveedorPersistencia gestor;

    public ProveedorPersistencia getGestor() {
        return gestor;
    }

    public void setGestor(ProveedorPersistencia pGestor) {
        gestor = pGestor;
    }

    public void desarDesti(String tipusPersistencia, String nomFitxer, Desti desti) throws GestioExcursionsExcepcio{
        
        switch(tipusPersistencia){
            
            case "XML":
                gestor = new GestorXML();
                break;                
            default:
                gestor = new GestorSerial();
                break;
            
        }

        gestor.desarDesti(nomFitxer, desti);
    }

    public void carregarDesti(String tipusPersistencia, String nomFitxer) throws GestioExcursionsExcepcio{
       
        switch(tipusPersistencia){
            
            case "XML":
                gestor = new GestorXML();
                break;                
            default:
                gestor = new GestorSerial();
                break;
            
        }

        gestor.carregarDesti(nomFitxer);
    }
 
}