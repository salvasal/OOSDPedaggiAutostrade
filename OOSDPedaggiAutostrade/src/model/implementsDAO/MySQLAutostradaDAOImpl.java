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
import model.components.Casello;
import model.database.Database;
import model.interfacesDAO.AutostradaDAO;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class MySQLAutostradaDAOImpl implements AutostradaDAO {

	private static final String READ_QUERY = "select codice, nome, tipo, kminizio, kmfine, amministratore from autostrada where amministratore = ?";
	private static final String READ_QUERY_CASELLI = "select * from casello where autostrada = ?";
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
	/* (non-Javadoc)
	 * @see model.interfacesDAO.AutostradaDAO#getCasellibyIDautostrada(java.lang.String)
	 */
	@Override
	public ArrayList<Casello> getCasellibyIDautostrada(String ID) {
		// TODO Auto-generated method stub
		ArrayList<Casello> caselli = new ArrayList<Casello>();
		Casello c = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_CASELLI);
			preparedStatement.setString(1, ID);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			while (rs.next()) {
				c = new Casello(rs.getString("coordinate"), rs.getString("nome"), rs.getInt("km"), rs.getString("autostrada"));
				caselli.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caselli;
	}
	
	
	
}
