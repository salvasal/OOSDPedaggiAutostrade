/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Autostrada;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class AutostradaController {
	
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
}
