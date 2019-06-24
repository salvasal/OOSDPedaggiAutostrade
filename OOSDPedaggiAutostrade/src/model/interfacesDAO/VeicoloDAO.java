/**
 * 
 */
package model.interfacesDAO;

import java.util.ArrayList;

import model.components.Utente;
import model.components.Veicolo;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public interface VeicoloDAO {
	public String getCategoriaVeicolo(String targa);
	public Integer getOneriVeicolo(String targa);
	public ArrayList<Veicolo> getVeicoli(Utente u);
	public ArrayList<String> getVeicolibyUsername(String usernameutente);
}
