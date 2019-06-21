/**
 * 
 */
package controller;

import javax.swing.DefaultListModel;

import model.components.GestoreDatiPedaggio;
import model.components.Oneri;
import model.components.Tariffa;
import model.components.Utente;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class PedaggioController {
	
	public void setTariffa(Tariffa t) {
		new GestoreDatiPedaggio().setTariffa(t);
	}
	
	public void setOneri(Oneri o) {
		new GestoreDatiPedaggio().setOneri(o);
	}
	
	public void setPedaggio (String targa, String caselloentrata, String casellouscita) {
		new GestoreDatiPedaggio().setPedaggio(targa, caselloentrata, casellouscita);
	}
	
	public void setPedaggiowithOneri (String targa, String caselloentrata, String casellouscita) {
		new GestoreDatiPedaggio().setPedaggiowithOneri(targa, caselloentrata, casellouscita);
	}
	
	public DefaultListModel getPedagginonPagati (Utente u) {
		return new GestoreDatiPedaggio().getPedagginonPagati(u);
	}

	public DefaultListModel getPedaggi (Utente u) {
		return new GestoreDatiPedaggio().getPedaggi(u);
	}
	
	public void pagamentoContante(String pedaggio) {
		new GestoreDatiPedaggio().pagamentoContante(pedaggio);
	}
	
	public boolean pagamentoCarta(String pedaggio, Utente u) {
		return new GestoreDatiPedaggio().pagamentoCarta(pedaggio, u);
	}
	
	public void ricarica(Integer importo, String pedaggio, Utente u) {
		new GestoreDatiPedaggio().ricarica(importo, pedaggio, u);
	}
}
