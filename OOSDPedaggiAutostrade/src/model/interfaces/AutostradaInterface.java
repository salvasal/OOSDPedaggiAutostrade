/**
 * 
 */
package model.interfaces;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Amministratore;
import model.components.Casello;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public interface AutostradaInterface {
	public DefaultListModel getAutostradebyUsername(Amministratore a);
	public DefaultListModel getCasellibyIDautostrada(String ID);
	public void setAutostrada(String codice, String nome, String tipoSelected, Integer lunghezza, String username);
	public ArrayList<Integer> getkmbyID(String ID);
	public void setCasello(Casello c);
	public ArrayList<String> getIdautostradaByusername(Amministratore a);
	public void deleteautostrada(String codiceSelected);
	public ArrayList<String> getCoordinatecaselliBycodiceAutostrada(Amministratore a, String codiceAutostrada);
	public void deletecasello(String coordinateSelected);
}
