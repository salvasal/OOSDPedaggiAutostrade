/**
 * 
 */
package controller;

import model.components.GestoreUtenza;

/**
 * @author Ludovico Di Federico Matricola 243542
 *
 */
public class LoginController {
	
		public String login(String username,String password) {
			return new GestoreUtenza().login(username, password);
		}

}
