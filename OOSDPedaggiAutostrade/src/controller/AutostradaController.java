/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Amministratore;
import model.components.Casello;
import model.components.GestoreDatiAutostrada;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class AutostradaController {
	
	public DefaultListModel getAutostradebyUsername (Amministratore a) {
		return new GestoreDatiAutostrada().getAutostradebyUsername(a);
	}
	
	public DefaultListModel getCasellibyIDautostrada (String ID) {
		return new GestoreDatiAutostrada().getCasellibyIDautostrada(ID);
	}
	
	public void setAutostrada(String codice, String nome, String tipoSelected, Integer lunghezza, String username) {
		new GestoreDatiAutostrada().setAutostrada(codice, nome, tipoSelected, lunghezza, username);
	}
	
	public ArrayList<Integer> getkmbyID(String ID) {
		return new GestoreDatiAutostrada().getkmbyID(ID);
	}
	
	public void setCasello(Casello c) {
		new GestoreDatiAutostrada().setCasello(c);
	}
	
	public ArrayList<String> getIdautostradaByusername(Amministratore a) {
		return new GestoreDatiAutostrada().getIdautostradaByusername(a);
	}
	
	public void deleteautostrada(String codiceSelected) {
		new GestoreDatiAutostrada().deleteautostrada(codiceSelected);
	}
	
	public ArrayList<String> getCoordinatecaselliBycodiceAutostrada(Amministratore a, String codiceAutostrada) {
		return new GestoreDatiAutostrada().getCoordinatecaselliBycodiceAutostrada(a, codiceAutostrada);
	}
	
	public void deletecasello(String coordinateSelected) {
		new GestoreDatiAutostrada().deletecasello(coordinateSelected);
	}
}
