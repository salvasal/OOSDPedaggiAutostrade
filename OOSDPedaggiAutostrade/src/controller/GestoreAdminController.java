/**
 * 
 */
package controller;

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
}
