/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.components.Amministratore;
import model.components.Carta;
import model.components.GestoreUtenza;
import model.components.Utente;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class GestoreUtenzaController {
	
	public String setAmministratore(Amministratore a) {
		return new GestoreUtenza().setAmministratore(a);
	}
	
	public ArrayList<String> getUtente() {
		return new GestoreUtenza().getUtente();
	}
	
	public String getUtentebyUsername(String usernameSelected) {
		return new GestoreUtenza().getUtentebyUsername(usernameSelected);
	}
	
	public Carta getCarta (String username) {
		return new GestoreUtenza().getCarta(username);
	}
	
	public String login(String username,String password) {
		return new GestoreUtenza().login(username, password);
	}
	
	public String setUtente(Utente u) {
		return new GestoreUtenza().setUtente(u);
	}

	public String[] getCredentialsbyKey(String username, String chiave) {
		return new GestoreUtenza().getCredentialsbyKey(username, chiave);
	}
}
