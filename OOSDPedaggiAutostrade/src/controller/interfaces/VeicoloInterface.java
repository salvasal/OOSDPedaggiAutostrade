/**
 * 
 */
package controller.interfaces;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Utente;
import model.components.Veicolo;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public interface VeicoloInterface {
	public DefaultListModel getVeicoli(Utente u);
	public ArrayList<String> getVeicolibyUsername(String usernameutente);
	public void deleteVeicolo(String targa);
	public void setVeicolo(Veicolo v);
}
