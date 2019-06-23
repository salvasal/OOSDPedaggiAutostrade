/**
 * 
 */
package model.implementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.components.Tariffa;
import model.database.Database;
import model.interfacesDAO.PedaggioDAO;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class MySQLPedaggioDAOImpl implements PedaggioDAO {

	private static final String UPDATE_QUERY_TARIFFA = "update Tariffa set Valore = ? where Categoria = ? and Tipo = ? ";
	
	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#setTariffa(model.components.Tariffa)
	 */
	@Override
	public void setTariffa(Tariffa t) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(UPDATE_QUERY_TARIFFA);
			preparedStatement.setString(1, t.getValore());
			preparedStatement.setString(2, t.getCategoria());
			preparedStatement.setString(3, t.getTipo());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
