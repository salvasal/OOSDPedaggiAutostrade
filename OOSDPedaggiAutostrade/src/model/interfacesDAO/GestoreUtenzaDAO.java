/**
 * 
 */
package model.interfacesDAO;

import model.components.Amministratore;
import model.components.Utente;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public interface GestoreUtenzaDAO {
	public Amministratore getAmministratore(String username, String password);
	public Utente getUtente(String username, String password);
	public void setCarta(Utente u, float saldo);
	public void setUtente(Utente u, String chiave);
	public Amministratore getCredentialsbyKeyAmministratore(String chiave);
	public Utente getCredentialsbyKeyUtente(String chiave);
	public void setAmministratore(Amministratore a, String chiave);
}
