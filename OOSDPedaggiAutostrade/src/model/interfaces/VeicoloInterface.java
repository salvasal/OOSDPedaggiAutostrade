/**
 * 
 */
package model.interfaces;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public interface VeicoloInterface {
	public DefaultListModel getVeicoli(String usernameSelected);
	public ArrayList<String> getVeicolibyUsername(String usernameutente);
}
