/**
 * 
 */
package model.components;

import java.util.Date;

/**
 * @author Lorenzo Salvi Matricola 242387
 *
 */
public class Amministratore {
	
	public String username;
	public String password;
	public String chiaveRecupero;
	public String nome;
	public String cognome;
	public String luogoN;
	public String dataN;
	public String telefono;
	
	
	/**
	 * 
	 */
	public Amministratore() {
		super();
	}
	/**
	 * @param username
	 * @param password
	 * @param chiaveRecupero
	 * @param nome
	 * @param cognome
	 * @param luogoN
	 * @param dataN
	 * @param telefono
	 */
	public Amministratore(String username, String password, String chiaveRecupero, String nome, String cognome,
			String luogoN, String dataN, String telefono) {
		
		this.username = username;
		this.password = password;
		this.chiaveRecupero = chiaveRecupero;
		this.nome = nome;
		this.cognome = cognome;
		this.luogoN = luogoN;
		this.dataN = dataN;
		this.telefono = telefono;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the chiaveRecupero
	 */
	public String getChiaveRecupero() {
		return chiaveRecupero;
	}
	/**
	 * @param chiaveRecupero the chiaveRecupero to set
	 */
	public void setChiaveRecupero(String chiaveRecupero) {
		this.chiaveRecupero = chiaveRecupero;
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
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return the luogoN
	 */
	public String getLuogoN() {
		return luogoN;
	}
	/**
	 * @param luogoN the luogoN to set
	 */
	public void setLuogoN(String luogoN) {
		this.luogoN = luogoN;
	}
	/**
	 * @return the dataN
	 */
	public String getDataN() {
		return dataN;
	}
	/**
	 * @param dataN the dataN to set
	 */
	public void setDataN(String dataN) {
		this.dataN = dataN;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	

}
