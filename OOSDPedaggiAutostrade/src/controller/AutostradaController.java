/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.GestoreDatiAutostrada;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class AutostradaController {
	
	public DefaultListModel getAutostradebyUsername (String username) {
		return new GestoreDatiAutostrada().getAutostradebyUsername(username);
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
	
	public void setCasello(String coordinate, String nome, Integer km, String autostrada) {
		new GestoreDatiAutostrada().setCasello(coordinate, nome, km, autostrada);
	}
	
	public ArrayList<String> getIdautostradaByusername(String username) {
		return new GestoreDatiAutostrada().getIdautostradaByusername(username);
	}
	
	public void deleteautostrada(String codiceSelected) {
		new GestoreDatiAutostrada().deleteautostrada(codiceSelected);
	}
	
	public ArrayList<String> getCoordinatecaselliBycodiceAutostrada(String usernameAmministratore, String codiceAutostrada) {
		return new GestoreDatiAutostrada().getCoordinatecaselliBycodiceAutostrada(usernameAmministratore, codiceAutostrada);
	}
	
	public void deletecasello(String coordinateSelected) {
		new GestoreDatiAutostrada().deletecasello(coordinateSelected);
	}
}
