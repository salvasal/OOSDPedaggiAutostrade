/**
 * 
 */
package controller;

import javax.swing.DefaultListModel;

import model.components.Pedaggio;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class PedaggioController {
	
	public void setTariffa(String importoTariffe, String categoriaSelected, String autostradaSelected) {
		new Pedaggio().setTariffa(importoTariffe, categoriaSelected, autostradaSelected);
	}
	
	public void setOneri(String importoOneri, String veicoloClasseSelected) {
		new Pedaggio().setOneri(importoOneri, veicoloClasseSelected);
	}
	
	public void setPedaggio (String targa, String caselloentrata, String casellouscita) {
		new Pedaggio().setPedaggio(targa, caselloentrata, casellouscita);
	}
	
	public void setPedaggiowithOneri (String targa, String caselloentrata, String casellouscita) {
		new Pedaggio().setPedaggiowithOneri(targa, caselloentrata, casellouscita);
	}
	
	public DefaultListModel getPedagginonPagati (String username) {
		return new Pedaggio().getPedagginonPagati(username);
	}

	public DefaultListModel getPedaggi (String username) {
		return new Pedaggio().getPedaggi(username);
	}
	
	public void pagamentoContante(String pedaggio) {
		new Pedaggio().pagamentoContante(pedaggio);
	}
	
	public boolean pagamentoCarta(String pedaggio, String username) {
		return new Pedaggio().pagamentoCarta(pedaggio, username);
	}
	
	public void ricarica(Integer importo, String pedaggio, String username) {
		new Pedaggio().ricarica(importo, pedaggio, username);
	}
}
