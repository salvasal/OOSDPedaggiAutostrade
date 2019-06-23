/**
 * 
 */
package controller.gestori;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import model.components.Amministratore;
import model.components.Carta;
import model.components.Utente;
import model.database.Database;
import model.implementsDAO.MySQLGestoreUtenzaDAOImpl;
import controller.interfaces.GestoreUtenzaInterface;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */

public class GestoreUtenza implements GestoreUtenzaInterface {

	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#loginAmministratore(java.lang.String, java.lang.String)
	 */
	public Amministratore loginAmministratore(String username, String password) {
		// TODO Auto-generated method stub
		Amministratore a = new Amministratore("","","","","","","","");
		System.out.println(username);
		System.out.println(password);
		a = new MySQLGestoreUtenzaDAOImpl().getAmministratore(username, password);
		if(!(a.getUsername().equals(""))) {
			return a;
		}
		return a;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#loginUtente(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente loginUtente(String username, String password) {
		// TODO Auto-generated method stub
		Utente u = new Utente("","","","","","","","","");
		System.out.println(username);
		System.out.println(password);
		u = new MySQLGestoreUtenzaDAOImpl().getUtente(username, password);
		if(!(u.getUsername().equals(""))) {
			return u;
		}
		return u;
	}

	

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#setUtente(model.components.Utente)
	 */
	@Override
	public String setUtente(Utente u) {
		// TODO Auto-generated method stub
		String chiave = randomString(6);
		float saldo = 0;
		new MySQLGestoreUtenzaDAOImpl().setCarta(u, saldo);
		new MySQLGestoreUtenzaDAOImpl().setUtente(u, chiave);
		return chiave;
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getCredentialsbyKeyAmministratore(java.lang.String, java.lang.String)
	 */
	@Override
	public Amministratore getCredentialsbyKeyAmministratore(String username, String chiave) {
		// TODO Auto-generated method stub
		Amministratore a = new Amministratore("","","","","","","","");
		a = new MySQLGestoreUtenzaDAOImpl().getCredentialsbyKeyAmministratore(chiave);
		if(!(a.getUsername().equals(""))) {
			return a;
		}
		return a;
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getCredentialsbyKeyUtente(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente getCredentialsbyKeyUtente(String username, String chiave) {
		// TODO Auto-generated method stub
		Utente u = new Utente("","","","","","","","","");
		u = new MySQLGestoreUtenzaDAOImpl().getCredentialsbyKeyUtente(chiave);
		if(!(u.getUsername().equals(""))) {
			return u;
		}
		return u;
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#randomString(int)
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
		String chiave = randomString(6);
		new MySQLGestoreUtenzaDAOImpl().setAmministratore(a, chiave);
		return chiave;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getUtente()
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

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getUtentebyUsername(java.lang.String)
	 */
	@Override
	public String getUtentebyUsername(String username) {
		// TODO Auto-generated method stub
		Utente u = null;
		String s = null;
		Connection con = new Database().Connect();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select username, password, chiaverecupero, nome, cognome, luogon, datan, telefono, carta from Utente where username='"+username+"'");
			if(rs.next()) {
				u = new Utente(rs.getString("username"), rs.getString("password"), rs.getString("chiaverecupero"), rs.getString("nome"), rs.getString("cognome"), rs.getString("luogon"), rs.getString("datan"), rs.getString("telefono"), rs.getString("carta"));
			}
			s = "Nome: "+u.getNome()+"  Cognome: "+u.getCognome()+"  Carta di Credito: "+u.getCarta();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}

	
	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getCarta(model.components.Utente)
	 */
	@Override
	public Carta getCarta(Utente u) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		Carta c = new Carta();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select IBAN, saldo from carta inner join utente "
					+ "on carta.IBAN = utente.carta where utente.username='"+u.getUsername()+"'");
			if (rs.next()) {
				c.setIban(rs.getString("IBAN"));
				c.setSaldo(rs.getFloat("saldo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
