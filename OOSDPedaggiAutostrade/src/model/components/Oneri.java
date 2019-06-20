/**
 * 
 */
package model.components;

/**
 * @author Lorenzo Salvi Matricola 242387
 *
 */
public class Oneri {
	
	public int euro;
	public String importo;
	public float valoreMin;
	public float valoreMax;
	/**
	 * @param euro
	 * @param importo
	 * @param valoreMin
	 * @param valoreMax
	 */
	public Oneri(int euro, String importo, float valoreMin, float valoreMax) {
		
		this.euro = euro;
		this.importo = importo;
		this.valoreMin = valoreMin;
		this.valoreMax = valoreMax;
	}
	/**
	 * @return the euro
	 */
	public int getEuro() {
		return euro;
	}
	/**
	 * @param euro the euro to set
	 */
	public void setEuro(int euro) {
		this.euro = euro;
	}
	/**
	 * @return the importo
	 */
	public String getImporto() {
		return importo;
	}
	/**
	 * @param importo the importo to set
	 */
	public void setImporto(String importo) {
		this.importo = importo;
	}
	/**
	 * @return the valoreMin
	 */
	public float getValoreMin() {
		return valoreMin;
	}
	/**
	 * @param valoreMin the valoreMin to set
	 */
	public void setValoreMin(float valoreMin) {
		this.valoreMin = valoreMin;
	}
	/**
	 * @return the valoreMax
	 */
	public float getValoreMax() {
		return valoreMax;
	}
	/**
	 * @param valoreMax the valoreMax to set
	 */
	public void setValoreMax(float valoreMax) {
		this.valoreMax = valoreMax;
	}
	
	
	
}
