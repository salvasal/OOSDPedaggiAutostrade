/**
 * 
 */
package controller;

import javax.swing.DefaultListModel;

import model.components.Pedaggio;

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
}
