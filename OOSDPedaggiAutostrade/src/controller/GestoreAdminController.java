/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.components.Amministratore;
import model.components.GestoreUtenza;

/**
 * @author Ludovico Di Federico Matricola 243542
 *
 */
public class GestoreAdminController {
	public String setAmministratore(Amministratore a) {
		return new GestoreUtenza().setAmministratore(a);
	}
	public ArrayList<String> getUtente() {
		return new GestoreUtenza().getUtente();
	}
}

