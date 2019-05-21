/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Amministratore;
import model.components.GestoreUtenza;
import model.components.Utente;
import model.components.Veicolo;

/**
 * @author Ludovico Di Federico Matricola 243542
 *
 */
public class GestoreAdminController {
	public String setAmministratore(Amministratore a) {
		return new GestoreUtenza().setAmministratore(a);
	}
	public ArrayList<String> getUtente() {
		return new GestoreUtenza().getUtente();
	}
	public String getUtentebyUsername(String usernameSelected) {
		return new GestoreUtenza().getUtentebyUsername(usernameSelected);
	}
	public DefaultListModel getVeicoli(String usernameSelected) {
		return new Veicolo().getVeicoli(usernameSelected);
	}
}

