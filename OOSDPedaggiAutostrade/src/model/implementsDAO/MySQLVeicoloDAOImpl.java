/**
 * 
 */
package model.implementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.Database;
import model.interfacesDAO.VeicoloDAO;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class MySQLVeicoloDAOImpl implements VeicoloDAO {

	private static final String READ_QUERY_CATEGORIAVEICOLO = "select categoria from veicolo where targa = ? ";
	/* (non-Javadoc)
	 * @see model.interfacesDAO.VeicoloDAO#getCategoriaVeicolo(java.lang.String)
	 */
	@Override
	public String getCategoriaVeicolo(String targa) {
		// TODO Auto-generated method stub
		String categoria = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement prepareStatement = cn.prepareStatement(READ_QUERY_CATEGORIAVEICOLO);
			prepareStatement.setString(1, targa);
			prepareStatement.execute();
			rs = prepareStatement.getResultSet();
			if(rs.next()) {
				categoria = rs.getString("categoria");
				return categoria;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoria;
	}
	
}
