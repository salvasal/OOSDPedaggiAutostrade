/**
 * 
 */
package model.components;

/**
 * @author Lorenzo Salvi Matricola 242387
 *
 */
public class Tariffa {
	
	public String categoria;
	public String tipo;
	public String valore;
	/**
	 * @param categoria
	 * @param tipo
	 * @param valore
	 */
	public Tariffa(String categoria, String tipo, String valore) {
		
		this.categoria = categoria;
		this.tipo = tipo;
		this.valore = valore;
	}
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the valore
	 */
	public String getValore() {
		return valore;
	}
	/**
	 * @param valore the valore to set
	 */
	public void setValore(String valore) {
		this.valore = valore;
	}
	
	

}
