/**
 * 
 */
package model.implementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.components.Amministratore;
import model.components.Autostrada;
import model.database.Database;
import model.interfacesDAO.AutostradaDAO;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class MySQLAutostradaDAOImpl implements AutostradaDAO {

	private static final String READ_QUERY = "select codice, nome, tipo, kminizio, kmfine, amministratore from autostrada where amministratore = ?";
	/* (non-Javadoc)
	 * @see model.interfacesDAO.AutostradaDAO#getAutostradabyUsername(model.components.Amministratore)
	 */
	@Override
	public ArrayList<Autostrada> getAutostradabyUsername(Amministratore a) {
		// TODO Auto-generated method stub
		ArrayList<Autostrada> autostrade = new ArrayList<Autostrada>();
		Autostrada ad = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY);
			preparedStatement.setString(1, a.getUsername());
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			while (rs.next()) {
				ad = new Autostrada(rs.getString("codice"), rs.getString("nome"), rs.getString("tipo"), rs.getInt("kminizio"), rs.getInt("kmfine"), rs.getString("amministratore"));
				autostrade.add(ad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autostrade;
	}
	
}
