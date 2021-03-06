/**
 * 
 */
package model.components;

/**
 * @author Ludovico Di Federico Matricola 243542 
 *
 */
public class Carta {	
	public String iban;
	public float saldo;
	
	
	/**
	 * @param iban
	 * @param saldo
	 */
	public Carta(String iban, float saldo) {
		this.iban = iban;
		this.saldo = saldo;
	}
	public Carta() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}
	/**
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}
	/**
	 * @return the saldo
	 */
	public float getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	
}
