/**
 * 
 */
package model.interfacesDAO;

import java.util.ArrayList;
import java.util.List;

import model.components.Amministratore;
import model.components.Autostrada;
import model.components.Casello;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public interface AutostradaDAO {
	public ArrayList<Autostrada> getAutostradabyUsername(Amministratore a);
	public ArrayList<Casello> getCasellibyIDautostrada(String ID);
	public Integer getkmfine();
	public void setautostrada(Autostrada a);
}
