/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.GestoreDatiVeicolo;
import model.components.Utente;
import model.components.Veicolo;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class VeicoloController {
	
	public DefaultListModel getVeicoli(Utente u) {
		return new GestoreDatiVeicolo().getVeicoli(u);
	}
	
	public ArrayList<String> getVeicolibyUsername(String usernameutente) {
		return new GestoreDatiVeicolo().getVeicolibyUsername(usernameutente);
	}
	
	public void deleteVeicolo(String targa) {
		new GestoreDatiVeicolo().deleteVeicolo(targa);
	}
	
	public void setVeicolo(Veicolo v) {
		new GestoreDatiVeicolo().setVeicolo(v);
	}
	
}
