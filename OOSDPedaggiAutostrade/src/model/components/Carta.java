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
	public Float saldo;
	
	
	/**
	 * @param iban
	 * @param saldo
	 */
	public Carta(String iban, Float saldo) {
		super();
		this.iban = iban;
		this.saldo = saldo;
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
	public Float getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	
}
