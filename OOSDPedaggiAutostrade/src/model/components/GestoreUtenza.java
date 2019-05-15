/**
 * 
 */
package model.components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.database.Database;
import model.interfaces.GestoreUtenzaInterface;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public class GestoreUtenza implements GestoreUtenzaInterface {

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#login(java.lang.String, java.lang.String)
	 */
	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		
		/*Connessione al database per prendere i dati*/
		Connection con=new Database().Connect();
		
		try {
			Statement st = con.createStatement();
			/*controlla se l'username e la password appartengono ad un amministratore*/
			System.out.println(username);
			System.out.println(password);
			ResultSet result=st.executeQuery("select * from amministratore where Username='"+username+"'and Password='"+password+"'");
			/*Se è un amministratore*/
			if(result.next()) {
				return "amministratore";
			}
			/*controlla se l'username e la password appartengono ad un utente*/
			result=st.executeQuery("select * from utente where Username='"+username+"'and Password='"+password+"'");
			if(result.next()) {
				return "utente";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*se l'utente non è un amministratore e neanche un utente*/
		return "";
		
	}

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#setUtente(model.components.Utente)
	 */
	@Override
	public void setUtente(Utente u) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#getCredentialsbyKey(java.lang.String)
	 */
	@Override
	public String[] getCredentialsbyKey(String username, String chiave) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
