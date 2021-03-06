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
	public Integer[] getkm(String ID);
	public void setCasello(Casello c);
	public ArrayList<String> getIdautostradaByUsername(Amministratore a);
	public void deletecaselli(String codiceSelected);
	public void deleteautostrada(String codiceSelected);
	public ArrayList<String> getCoordinatecaselliBycodiceAutostrada(String codiceAutostrada);
	public void deletecasello(String coordinateSelected);
	public Integer getkmcasello(String casellocoordinate);
	public String getTipoAutostrada(String casellocoordinate);
}
