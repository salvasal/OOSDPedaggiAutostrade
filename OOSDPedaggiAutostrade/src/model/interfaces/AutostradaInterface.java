/**
 * 
 */
package model.interfaces;

import javax.swing.DefaultListModel;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public interface AutostradaInterface {
	public DefaultListModel getAutostradebyUsername(String username);
	public DefaultListModel getCasellibyIDautostrada(String ID);
}
