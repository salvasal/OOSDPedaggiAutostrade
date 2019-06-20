/**
 * 
 */
package controller;

import javax.swing.DefaultListModel;

import model.components.GestoreDatiPedaggio;
import model.components.Tariffa;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class PedaggioController {
	
	public void setTariffa(Tariffa t) {
		new GestoreDatiPedaggio().setTariffa(t);
	}
	
	public void setOneri(String importoOneri, String veicoloClasseSelected) {
		new GestoreDatiPedaggio().setOneri(importoOneri, veicoloClasseSelected);
	}
	
	public void setPedaggio (String targa, String caselloentrata, String casellouscita) {
		new GestoreDatiPedaggio().setPedaggio(targa, caselloentrata, casellouscita);
	}
	
	public void setPedaggiowithOneri (String targa, String caselloentrata, String casellouscita) {
		new GestoreDatiPedaggio().setPedaggiowithOneri(targa, caselloentrata, casellouscita);
	}
	
	public DefaultListModel getPedagginonPagati (String username) {
		return new GestoreDatiPedaggio().getPedagginonPagati(username);
	}

	public DefaultListModel getPedaggi (String username) {
		return new GestoreDatiPedaggio().getPedaggi(username);
	}
	
	public void pagamentoContante(String pedaggio) {
		new GestoreDatiPedaggio().pagamentoContante(pedaggio);
	}
	
	public boolean pagamentoCarta(String pedaggio, String username) {
		return new GestoreDatiPedaggio().pagamentoCarta(pedaggio, username);
	}
	
	public void ricarica(Integer importo, String pedaggio, String username) {
		new GestoreDatiPedaggio().ricarica(importo, pedaggio, username);
	}
}
