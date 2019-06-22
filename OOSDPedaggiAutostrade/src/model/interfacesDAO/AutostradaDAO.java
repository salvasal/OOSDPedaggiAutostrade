/**
 * 
 */
package model.interfacesDAO;

import java.util.List;

import model.components.Amministratore;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public interface AutostradaDAO {
	public List getAutostradabyUsername(Amministratore a);
}
