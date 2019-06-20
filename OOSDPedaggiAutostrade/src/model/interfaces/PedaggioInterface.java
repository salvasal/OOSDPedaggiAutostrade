/**
 * 
 */
package model.interfaces;

import javax.swing.DefaultListModel;

import model.components.Tariffa;

/**
 * @author Salvi Lorenzo Matricola 242387
 *
 */
public interface PedaggioInterface {
	public void setTariffa(Tariffa t);
	public void setOneri(String importoOneri, String veicoloClasseSelected);
	public DefaultListModel getPedagginonPagati(String username);
	public DefaultListModel getPedaggi(String username);
	public void pagamentoContante(String pedaggio);
	public boolean pagamentoCarta(String pedaggio, String username);
	public void ricarica(Integer importo, String pedaggio, String username);
	public void setPedaggio(String targa, String caselloentrata, String casellouscita);
	public void setPedaggiowithOneri(String targa, String caselloentrata, String casellouscita);
}
