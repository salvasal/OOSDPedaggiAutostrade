/**
 * 
 */
package model.implementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.components.Amministratore;
import model.components.Carta;
import model.components.Casello;
import model.components.Utente;
import model.database.Database;
import model.interfacesDAO.GestoreUtenzaDAO;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class MySQLGestoreUtenzaDAOImpl implements GestoreUtenzaDAO {

	private static final String READ_QUERY_AMMINISTRATORE = "select * from amministratore where Username = ? and Password = ? ";
	private static final String READ_QUERY_UTENTE = "select * from utente where Username = ? and Password = ? ";
	private static final String READ_QUERY_CARTA = "select IBAN, saldo from carta inner join utente on carta.IBAN = utente.carta where utente.username = ? ";
	private static final String CREATE_QUERY_CARTA = "insert into carta(IBAN, Saldo) values(?,?)";
	private static final String CREATE_QUERY_UTENTE = "insert into utente values(?,?,?,?,?,?,?,?,?)";
	private static final String CREATE_QUERY_AMMINISTRATORE = "insert into amministratore values(?,?,?,?,?,?,?,?)";
	private static final String READ_QUERY_AMMINISTRATORE_BYKEY = "select * from amministratore where ChiaveRecupero = ?";
	private static final String READ_QUERY_UTENTE_BYKEY = "select * from utente where ChiaveRecupero = ? ";
	private static final String READ_QUERY_UTENTE_BYUSERNAME = "select * from utente where Username = ? ";
	private static final String READ_ALLQUERY_UTENTI_USERNAME = "select username from utente";
	private static final String UPDATE_QUERY_CARTA = "update carta set saldo = ? where IBAN = ? "; 
	
	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#getAmministratore(java.lang.String, java.lang.String)
	 */
	@Override
	public Amministratore getAmministratore(String username, String password) {
		// TODO Auto-generated method stub
		Amministratore a = new Amministratore("","","","","","","","");
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_AMMINISTRATORE);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			if (rs.next()) {
				a = new Amministratore(rs.getString("username"), rs.getString("password"), rs.getString("chiaverecupero"), rs.getString("nome"), rs.getString("cognome"), rs.getString("luogon"), rs.getString("datan"), rs.getString("telefono"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#getUtente(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente getUtente(String username, String password) {
		// TODO Auto-generated method stub
		Utente u = new Utente("","","","","","","","","");
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_UTENTE);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			if (rs.next()) {
				u = new Utente(rs.getString("username"), rs.getString("password"), rs.getString("chiaverecupero"), rs.getString("nome"), rs.getString("cognome"), rs.getString("luogon"), rs.getString("datan"), rs.getString("telefono"), rs.getString("carta"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#setCarta(model.components.Utente, float)
	 */
	@Override
	public void setCarta(Utente u, float saldo) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(CREATE_QUERY_CARTA);
			preparedStatement.setString(1, u.getCarta());
			preparedStatement.setFloat(2, saldo);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#setUtente(model.components.Utente, java.lang.String)
	 */
	@Override
	public void setUtente(Utente u, String chiave) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(CREATE_QUERY_UTENTE);
			preparedStatement.setString(1, u.getUsername());
			preparedStatement.setString(2, u.getPassword());
			preparedStatement.setString(3, chiave);
			preparedStatement.setString(4, u.getNome());
			preparedStatement.setString(5, u.getCognome());
			preparedStatement.setString(6, u.getLuogon());
			preparedStatement.setString(7, u.getDatan());
			preparedStatement.setString(8, u.getTelefono());
			preparedStatement.setString(9, u.getCarta());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#getCredentialsbyKeyAmministratore(java.lang.String, java.lang.String)
	 */
	@Override
	public Amministratore getCredentialsbyKeyAmministratore(String chiave) {
		// TODO Auto-generated method stub
		Amministratore a = new Amministratore("","","","","","","","");
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_AMMINISTRATORE_BYKEY);
			preparedStatement.setString(1, chiave);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			if (rs.next()) {
				a = new Amministratore(rs.getString("username"), rs.getString("password"), rs.getString("chiaverecupero"), rs.getString("nome"), rs.getString("cognome"), rs.getString("luogon"), rs.getString("datan"), rs.getString("telefono"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#getCredentialsbyKeyUtente(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente getCredentialsbyKeyUtente(String chiave) {
		// TODO Auto-generated method stub
		Utente u = new Utente("","","","","","","","","");
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_UTENTE_BYKEY);
			preparedStatement.setString(1, chiave);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			if (rs.next()) {
				u = new Utente(rs.getString("username"), rs.getString("password"), rs.getString("chiaverecupero"), rs.getString("nome"), rs.getString("cognome"), rs.getString("luogon"), rs.getString("datan"), rs.getString("telefono"), rs.getString("carta"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#setAmministratore(model.components.Amministratore, java.lang.String)
	 */
	@Override
	public void setAmministratore(Amministratore a, String chiave) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(CREATE_QUERY_AMMINISTRATORE);
			preparedStatement.setString(1, a.getUsername());
			preparedStatement.setString(2, a.getPassword());
			preparedStatement.setString(3, chiave);
			preparedStatement.setString(4, a.getNome());
			preparedStatement.setString(5, a.getCognome());
			preparedStatement.setString(6, a.getLuogoN());
			preparedStatement.setString(7, a.getDataN());
			preparedStatement.setString(8, a.getTelefono());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#getUtente()
	 */
	@Override
	public ArrayList<String> getUtente() {
		// TODO Auto-generated method stub
		ArrayList<String> ulist = new ArrayList<String>();
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_ALLQUERY_UTENTI_USERNAME);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			while(rs.next()) {
				ulist.add(rs.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#getUtente(java.lang.String)
	 */
	@Override
	public Utente getUtente(String username) {
		// TODO Auto-generated method stub
		Utente u = new Utente("","","","","","","","","");
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_UTENTE_BYUSERNAME);
			preparedStatement.setString(1, username);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			if (rs.next()) {
				u = new Utente(rs.getString("username"), rs.getString("password"), rs.getString("chiaverecupero"), rs.getString("nome"), rs.getString("cognome"), rs.getString("luogon"), rs.getString("datan"), rs.getString("telefono"), rs.getString("carta"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#getCarta(model.components.Utente)
	 */
	@Override
	public Carta getCarta(Utente u) {
		// TODO Auto-generated method stub
		Carta c = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_CARTA);
			preparedStatement.setString(1, u.getUsername());
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			if (rs.next()) {
				c = new Carta(rs.getString("IBAN"), rs.getFloat("saldo"));
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#setCarta(float, model.components.Carta)
	 */
	@Override
	public void setCarta(float nuovosaldo, Carta c) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(UPDATE_QUERY_CARTA);
			preparedStatement.setFloat(1, nuovosaldo);
			preparedStatement.setString(2, c.getIban());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
