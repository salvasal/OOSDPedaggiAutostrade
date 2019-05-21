/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Amministratore;
import model.components.GestoreUtenza;
import model.components.Pedaggio;
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
	
	public void setTariffa(String importoTariffe, String categoriaSelected, String autostradaSelected) {
		new Pedaggio().setTariffa(importoTariffe, categoriaSelected, autostradaSelected);
	}
	
	public void setOneri(String importoOneri, String veicoloClasseSelected) {
		new Pedaggio().setOneri(importoOneri, veicoloClasseSelected);
	}
}

