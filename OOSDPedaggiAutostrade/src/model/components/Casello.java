/**
 * 
 */
package model.components;

/**
 * @author Ludovico Di Federico Matricola 243542
 *
 */
public class Casello {
	public String coordinate;
	public String nome;
	public Integer km;
	public String autostrada;
	
	/**
	 * @param coordinate
	 * @param nome
	 * @param km
	 * @param autostrada
	 */
	public Casello(String coordinate, String nome, Integer km, String autostrada) {
		this.coordinate = coordinate;
		this.nome = nome;
		this.km = km;
		this.autostrada = autostrada;
	}
	/**
	 * @return the coordinate
	 */
	public String getCoordinate() {
		return coordinate;
	}
	/**
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the km
	 */
	public Integer getKm() {
		return km;
	}
	/**
	 * @param km the km to set
	 */
	public void setKm(Integer km) {
		this.km = km;
	}
	/**
	 * @return the autostrada
	 */
	public String getAutostrada() {
		return autostrada;
	}
	/**
	 * @param autostrada the autostrada to set
	 */
	public void setAutostrada(String autostrada) {
		this.autostrada = autostrada;
	}

	
}
