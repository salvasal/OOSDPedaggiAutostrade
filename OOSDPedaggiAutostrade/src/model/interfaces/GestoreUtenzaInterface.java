/**
 * 
 */
package model.interfaces;

import java.util.ArrayList;

import model.components.Amministratore;
import model.components.Carta;
import model.components.Utente;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public interface GestoreUtenzaInterface {
	public Amministratore loginAmministratore(String username, String password);
	public Utente loginUtente(String username, String password);
	public String setUtente(Utente u);
	public Amministratore getCredentialsbyKeyAmministratore(String username, String chiave);
	public Utente getCredentialsbyKeyUtente(String username, String chiave);
	public String randomString(int length);
	public String setAmministratore(Amministratore a);
	public ArrayList<String> getUtente();
	public String getUtentebyUsername(String username);
	public Carta getCarta(String username);
}
