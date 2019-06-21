/**
 * 
 */
package model.interfaces;

import javax.swing.DefaultListModel;

import model.components.Oneri;
import model.components.Tariffa;
import model.components.Utente;

/**
 * @author Salvi Lorenzo Matricola 242387
 *
 */
public interface PedaggioInterface {
	public void setTariffa(Tariffa t);
	public void setOneri(Oneri o);
	public DefaultListModel getPedagginonPagati(Utente u);
	public DefaultListModel getPedaggi(Utente u);
	public void pagamentoContante(String pedaggio);
	public boolean pagamentoCarta(String pedaggio, Utente u);
	public void ricarica(Integer importo, String pedaggio, Utente u);
	public void setPedaggio(String targa, String caselloentrata, String casellouscita);
	public void setPedaggiowithOneri(String targa, String caselloentrata, String casellouscita);
}
