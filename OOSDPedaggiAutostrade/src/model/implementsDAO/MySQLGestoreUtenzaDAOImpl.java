/**
 * 
 */
package model.implementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.components.Amministratore;
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
	private static final String CREATE_QUERY_CARTA = "insert into carta(IBAN, Saldo) values(?,?)";
	private static final String CREATE_QUERY_UTENTE = "insert into utente values(?,?,?,?,?,?,?,?,?)";
	private static final String READ_QUERY_AMMINISTRATORE_BYKEY = "select * from amministratore where ChiaveRecupero = ?";
	private static final String READ_QUERY_UTENTE_BYKEY = "select * from utente where ChiaveRecupero = ? ";
	
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
	
}
