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
	 * @see model.interfaces.GestoreUtenzaInterface#loginAmministratore(java.lang.String, java.lang.String)
	 */
	@Override
	public Amministratore loginAmministratore(String username, String password) {
		// TODO Auto-generated method stub
		Connection con=new Database().Connect();
		Amministratore a = new Amministratore("","","","","","","","");
		
		try {
			Statement st = con.createStatement();
			/*controlla se l'username e la password appartengono ad un amministratore*/
			System.out.println(username);
			System.out.println(password);
			ResultSet result=st.executeQuery("select * from amministratore where Username='"+username+"'and Password='"+password+"'");
			if(result.next()) {
				a = new Amministratore(result.getString("username"),result.getString("password"),result.getString("chiaveRecupero"),result.getString("nome"),result.getString("cognome"),result.getString("luogoN"),result.getString("dataN"),result.getString("telefono"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#loginUtente(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente loginUtente(String username, String password) {
		// TODO Auto-generated method stub
		Connection con=new Database().Connect();
		Utente u = new Utente("","","","","","","","","");
		
		try {
			Statement st = con.createStatement();
			/*controlla se l'username e la password appartengono ad un utente*/
			System.out.println(username);
			System.out.println(password);
			ResultSet result=st.executeQuery("select * from utente where Username='"+username+"'and Password='"+password+"'");
			if(result.next()) {
				u = new Utente(result.getString("username"),result.getString("password"),result.getString("chiaveRecupero"),result.getString("nome"),result.getString("cognome"),result.getString("luogoN"),result.getString("dataN"),result.getString("telefono"),result.getString("carta"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
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
	 * @see model.interfaces.GestoreUtenzaInterface#getCredentialsbyKeyAmministratore(java.lang.String, java.lang.String)
	 */
	@Override
	public Amministratore getCredentialsbyKeyAmministratore(String username, String chiave) {
		// TODO Auto-generated method stub
		Connection con=new Database().Connect();
		Amministratore a = new Amministratore("","","","","","","","");
		
		try {
			Statement st = con.createStatement();
			// controllo credenziali amministratore
			ResultSet result=st.executeQuery("select * from amministratore where ChiaveRecupero='"+chiave+"' ");
			if(result.next()) {
				a = new Amministratore(result.getString("username"),result.getString("password"),result.getString("chiaveRecupero"),result.getString("nome"),result.getString("cognome"),result.getString("luogoN"),result.getString("dataN"),result.getString("telefono"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	
	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#getCredentialsbyKeyUtente(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente getCredentialsbyKeyUtente(String username, String chiave) {
		// TODO Auto-generated method stub
		Connection con=new Database().Connect();
		Utente u = new Utente("","","","","","","","","");
		
		try {
			Statement st = con.createStatement();
			// controllo credenziali utente
			ResultSet result=st.executeQuery("select * from utente where ChiaveRecupero='"+chiave+"' ");
			if(result.next()) {
				u = new Utente(result.getString("username"),result.getString("password"),result.getString("chiaveRecupero"),result.getString("nome"),result.getString("cognome"),result.getString("luogoN"),result.getString("dataN"),result.getString("telefono"),result.getString("carta"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
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

	/* (non-Javadoc)
	 * @see model.interfaces.GestoreUtenzaInterface#getUtentebyUsername(java.lang.String)
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
	 * @see model.interfaces.GestoreUtenzaInterface#getCarta(model.components.Utente)
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
