/**
 * 
 */
package controller;

import model.components.GestoreUtenza;
import model.components.Utente;

/**
 * @author Ludovico Di Federico Matricola 243542
 *
 */
public class LoginController {
	
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
