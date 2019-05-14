/**
 * 
 */
package model.interfaces;

import model.components.Utente;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public interface GestoreUtenzaInterface {
	public String login(String username, String password);
	public void setUtente(Utente u);
	public String[] getCredentialsbyKey(String chiave);
}
