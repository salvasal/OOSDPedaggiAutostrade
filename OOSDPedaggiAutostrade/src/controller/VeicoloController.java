/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Veicolo;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class VeicoloController {
	
	public DefaultListModel getVeicoli(String usernameSelected) {
		return new Veicolo().getVeicoli(usernameSelected);
	}
	
	public ArrayList<String> getVeicolibyUsername(String usernameutente) {
		return new Veicolo().getVeicolibyUsername(usernameutente);
	}
	
	public void deleteVeicolo(String targa) {
		new Veicolo().deleteVeicolo(targa);
	}
	
	public void setVeicolo(Veicolo v) {
		new Veicolo().setVeicolo(v);
	}
	
}
