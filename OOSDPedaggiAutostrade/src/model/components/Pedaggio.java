/**
 * 
 */
package model.components;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public class Pedaggio {
	public String id;
	public String stato;
	public float importo;
	public String veicolo;
	
	
	
	/**
	 * 
	 */
	public Pedaggio() {
		super();
	}
	
	

	/**
	 * @param id
	 * @param stato
	 * @param importo
	 * @param veicolo
	 */
	public Pedaggio(String id, String stato, float importo, String veicolo) {
		this.id = id;
		this.stato = stato;
		this.importo = importo;
		this.veicolo = veicolo;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}
	/**
	 * @param stato the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}
	/**
	 * @return the importo
	 */
	public float getImporto() {
		return importo;
	}
	/**
	 * @param importo the importo to set
	 */
	public void setImporto(float importo) {
		this.importo = importo;
	}
	/**
	 * @return the veicolo
	 */
	public String getVeicolo() {
		return veicolo;
	}
	/**
	 * @param veicolo the veicolo to set
	 */
	public void setVeicolo(String veicolo) {
		veicolo = veicolo;
	}
	
}
