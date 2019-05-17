/**
 * 
 */
package model.components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

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
			/*Se � un amministratore*/
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
		/*se l'utente non � un amministratore e neanche un utente*/
		return "";
		
	}

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#setUtente(model.components.Utente)
	 */
	@Override
	public String setUtente(Utente u) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		String chiave = randomString(6);
		float saldo = 0;
		Statement st;
		try {
			st = con.createStatement();
			Statement st2 = con.createStatement();
			String tot="insert into carta(IBAN, Saldo) values('"+u.getCarta()+"','"+saldo+"')";
			st.executeUpdate(tot);
			String tot2="insert into utente values('"+u.getUsername()+"','"+u.getPassword()+"','"+chiave+"','"+u.getNome()+"','"+u.getCognome()+"','"+u.getLuogon()+"','"+u.getDatan()+"','"+u.getTelefono()+"','"+u.getCarta()+"')";
			st2.executeUpdate(tot2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return chiave;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#getCredentialsbyKey(java.lang.String)
	 */
	@Override
	public String[] getCredentialsbyKey(String username, String chiave) {
		// TODO Auto-generated method stub
		
		// connessione al database
		Connection con=new Database().Connect();
		String a[] = new String[2];
		
		try {
			Statement st = con.createStatement();
			// controllo credenziali amministratore
			System.out.println(username);
			System.out.println(chiave);
			ResultSet result=st.executeQuery("select Username, Password from amministratore where ChiaveRecupero='"+chiave+"' ");
			while(result.next()) {
				a[0]=result.getString("Username");
				a[1]=result.getString("Password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st2;
		try {
			st2 = con.createStatement();
			//controllo credenziali utente
			ResultSet result=st2.executeQuery("select Username, Password from utente where ChiaveRecupero='"+chiave+"'");
			while(result.next()) {
				a[0]=result.getString("Username");
				a[1]=result.getString("Password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// se l'utente non e' ne' ammimistratore ne' utente
		return a;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#randomString(int)
	 */
	@Override
	public String randomString(int length) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		StringBuffer tempStr = new StringBuffer();
		tempStr.append("");
		for (int i = 0; i < length; i++) {
		int c = rand.nextInt(122 - 48) + 48;
		if((c >= 58 && c <= 64) || (c >= 91 && c <= 96)){
		i--;
		continue;
		}
		tempStr.append((char)c);

		}
		return tempStr.toString();
		}

	@Override
	public String setAmministratore(Amministratore a) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		String chiave = randomString(6);
		Statement st;
		try {
			st = con.createStatement();
			String tot= "insert into amministratore values('"+a.getUsername()+"','"+a.getPassword()+"','"+chiave+"','"+a.getNome()+"','"+a.getCognome()+"','"+a.getLuogoN()+"','"+a.getDataN()+"','"+a.getTelefono()+"')";
			st.executeUpdate(tot);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chiave;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#getUtente()
	 */
	@Override
	public ArrayList<String> getUtente() {
		// TODO Auto-generated method stub
		ArrayList<String> ulist = new ArrayList<String>();
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select username from utente");
			while (rs.next()) {
				ulist.add(rs.getNString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ulist;
		
	}
		
	
}
