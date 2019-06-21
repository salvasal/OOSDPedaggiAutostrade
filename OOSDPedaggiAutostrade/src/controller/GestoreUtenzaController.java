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
	
	public Carta getCarta (Utente u) {
		return new GestoreUtenza().getCarta(u);
	}
	
	public Amministratore loginAmministratore(String username, String password) {
		return new GestoreUtenza().loginAmministratore(username, password);
	}
	
	public Utente loginUtente(String username, String password) {
		return new GestoreUtenza().loginUtente(username, password);
	}
	
	public String setUtente(Utente u) {
		return new GestoreUtenza().setUtente(u);
	}

	public Amministratore getCredentialsbyKeyAmministratore(String username, String chiave) {
		return new GestoreUtenza().getCredentialsbyKeyAmministratore(username, chiave);
	}
	
	public Utente getCredentialsbyKeyUtente(String username, String chiave) {
		return new GestoreUtenza().getCredentialsbyKeyUtente(username, chiave);
	}
}
