/**
 * 
 */
package model.components;

import java.util.Date;

/**
 * @author Ludovico Di Federico Matricola 243542
 *
 */
public class Utente {
	public String username;
	public String password;
	public String chiaverecupero;
	public String nome;
	public String cognome;
	public String luogon;
	public String datan;
	public String telefono;
	public String carta;
	
	
	
	/**
	 * 
	 */
	public Utente() {
		super();
	}
	/**
	 * @param username
	 * @param password
	 * @param chiaverecupero
	 * @param nome
	 * @param cognome
	 * @param luogon
	 * @param datan
	 * @param telefono
	 * @param carta
	 */
	public Utente(String username, String password, String chiaverecupero, String nome, String cognome, String luogon,
			String datan, String telefono, String carta) {
		this.username = username;
		this.password = password;
		this.chiaverecupero = chiaverecupero;
		this.nome = nome;
		this.cognome = cognome;
		this.luogon = luogon;
		this.datan = datan;
		this.telefono = telefono;
		this.carta = carta;
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
	 * @return the chiaverecupero
	 */
	public String getChiaverecupero() {
		return chiaverecupero;
	}
	/**
	 * @param chiaverecupero the chiaverecupero to set
	 */
	public void setChiaverecupero(String chiaverecupero) {
		this.chiaverecupero = chiaverecupero;
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
	 * @return the luogon
	 */
	public String getLuogon() {
		return luogon;
	}
	/**
	 * @param luogon the luogon to set
	 */
	public void setLuogon(String luogon) {
		this.luogon = luogon;
	}
	/**
	 * @return the datan
	 */
	public String getDatan() {
		return datan;
	}
	/**
	 * @param datan the datan to set
	 */
	public void setDatan(String datan) {
		this.datan = datan;
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
	/**
	 * @return the carta
	 */
	public String getCarta() {
		return carta;
	}
	/**
	 * @param carta the carta to set
	 */
	public void setCarta(String carta) {
		this.carta = carta;
	}
	
	

}
