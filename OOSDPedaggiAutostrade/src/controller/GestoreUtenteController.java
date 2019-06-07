/**
 * 
 */
package controller;

import javax.swing.DefaultListModel;

import model.components.Pedaggio;
import model.components.Veicolo;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public class GestoreUtenteController {
	
	public DefaultListModel getPedagginonPagati (String username) {
		return new Pedaggio().getPedagginonPagati(username);
	}

	public DefaultListModel getPedaggi (String username) {
		return new Pedaggio().getPedaggi(username);
	}
	
	public DefaultListModel getVeicoli(String usernameSelected) {
		return new Veicolo().getVeicoli(usernameSelected);
	}
}
