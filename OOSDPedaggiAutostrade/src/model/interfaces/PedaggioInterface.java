/**
 * 
 */
package model.interfaces;

import javax.swing.DefaultListModel;

/**
 * @author Salvi Lorenzo Matricola 242387
 *
 */
public interface PedaggioInterface {
	public void setTariffa(String importoTariffa, String categoriaSelected, String autostradaSelected);
	public void setOneri(String importoOneri, String veicoloClasseSelected);
	public DefaultListModel getPedagginonPagati(String username);
	public DefaultListModel getPedaggi(String username);
	public void pagamentoContante(String pedaggio);
	public boolean pagamentoCarta(String pedaggio, String username);
}
