/**
 * 
 */
package controller;

import javax.swing.DefaultListModel;

import model.components.GestoreUtenza;
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
	
	public float getSaldo (String username) {
		return new GestoreUtenza().getSaldo(username);
	}
	
	public String getIBAN (String username) {
		return new GestoreUtenza().getIBAN(username);
	}
	
	public void pagamentoContante(String pedaggio) {
		new Pedaggio().pagamentoContante(pedaggio);
	}
	
	public boolean pagamentoCarta(String pedaggio, String username) {
		return new Pedaggio().pagamentoCarta(pedaggio, username);
	}
}
