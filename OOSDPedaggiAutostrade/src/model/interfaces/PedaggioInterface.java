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
}
