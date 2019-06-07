/**
 * 
 */
package model.interfaces;

import java.util.ArrayList;

import model.components.Amministratore;
import model.components.Utente;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public interface GestoreUtenzaInterface {
	public String login(String username, String password);
	public String setUtente(Utente u);
	public String[] getCredentialsbyKey(String username, String chiave);
	public String randomString(int length);
	public String setAmministratore(Amministratore a);
	public ArrayList<String> getUtente();
	public String getUtentebyUsername(String username);
	public float getSaldo(String username);
	public String getIBAN(String username);
	
}
