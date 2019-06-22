/**
 * 
 */
package model.interfacesDAO;

import model.components.Amministratore;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public interface GestoreUtenzaDAO {
	public Amministratore getAmministratore(String username, String password);
}
