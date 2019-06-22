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
import model.database.Database;
import model.interfacesDAO.GestoreUtenzaDAO;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class MySQLGestoreUtenzaDAOImpl implements GestoreUtenzaDAO {

	private static final String READ_QUERY_AMMINISTRATORE = "select * from amministratore where Username = ? and Password = ? ";
	/* (non-Javadoc)
	 * @see model.interfacesDAO.GestoreUtenzaDAO#getAmministratore(java.lang.String, java.lang.String)
	 */
	@Override
	public Amministratore getAmministratore(String username, String password) {
		// TODO Auto-generated method stub
		Amministratore a = new Amministratore("","","","","","","","");;
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
	
}
