/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Amministratore;
import model.components.Autostrada;
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
	
	public DefaultListModel getAutostradebyUsername (String username) {
		return new Autostrada().getAutostradebyUsername(username);
	}
	
	public DefaultListModel getCasellibyIDautostrada (String ID) {
		return new Autostrada().getCasellibyIDautostrada(ID);
	}
	
	public void setAutostrada(String codice, String nome, String tipoSelected, Integer lunghezza, String username) {
		new Autostrada().setAutostrada(codice, nome, tipoSelected, lunghezza, username);
	}
	
	public ArrayList<Integer> getkmbyID(String ID) {
		return new Autostrada().getkmbyID(ID);
	}
	
	public void setCasello(String coordinate, String nome, Integer km, String autostrada) {
		new Autostrada().setCasello(coordinate, nome, km, autostrada);
	}
	
	public ArrayList<String> getIdautostradaByusername(String username) {
		return new Autostrada().getIdautostradaByusername(username);
	}
	
	public void deleteautostrada(String codiceSelected) {
		new Autostrada().deleteautostrada(codiceSelected);
	}
	
	public ArrayList<String> getCoordinatecaselliBycodiceAutostrada(String usernameAmministratore, String codiceAutostrada) {
		return new Autostrada().getCoordinatecaselliBycodiceAutostrada(usernameAmministratore, codiceAutostrada);
	}
	public void deletecasello(String coordinateSelected) {
		new Autostrada().deletecasello(coordinateSelected);
	}
	
	public ArrayList<String> getVeicolibyUsername(String usernameutente) {
		return new Veicolo().getVeicolibyUsername(usernameutente);
	}
}

