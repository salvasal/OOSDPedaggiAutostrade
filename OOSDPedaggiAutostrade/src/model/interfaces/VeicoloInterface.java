/**
 * 
 */
package model.interfaces;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Veicolo;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public interface VeicoloInterface {
	public DefaultListModel getVeicoli(String usernameSelected);
	public ArrayList<String> getVeicolibyUsername(String usernameutente);
	public void deleteVeicolo(String targa);
	public void setVeicolo(Veicolo v);
}
