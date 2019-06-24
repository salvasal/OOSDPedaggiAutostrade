/**
 * 
 */
package model.interfacesDAO;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Oneri;
import model.components.Pedaggio;
import model.components.Tariffa;
import model.components.Utente;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public interface PedaggioDAO {
	public void setTariffa(Tariffa t);
	public void setOneri(Oneri o);
	public ArrayList<Pedaggio> getPedagginonPagati(Utente u);
	public ArrayList<Pedaggio> getPedaggi(Utente u);
	public void setPedaggioPagato(String pedaggio);
}
