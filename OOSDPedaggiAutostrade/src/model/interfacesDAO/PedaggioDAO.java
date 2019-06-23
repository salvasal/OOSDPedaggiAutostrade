/**
 * 
 */
package model.interfacesDAO;

import model.components.Oneri;
import model.components.Tariffa;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public interface PedaggioDAO {
	public void setTariffa(Tariffa t);
	public void setOneri(Oneri o);
}
