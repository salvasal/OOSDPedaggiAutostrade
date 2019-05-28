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
public interface AutostradaInterface {
	public DefaultListModel getAutostradebyUsername(String username);
	public DefaultListModel getCasellibyIDautostrada(String ID);
	public void setAutostrada(String codice, String nome, String tipoSelected, Integer lunghezza, String username);
	public ArrayList<Integer> getkmbyID(String ID);
	public void setCasello(String coordinate, String nome, Integer km, String autostrada);
	public ArrayList<String> getIdautostradaByusername(String username);
}
