/**
 * 
 */
package model.implementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.components.Utente;
import model.components.Veicolo;
import model.database.Database;
import model.interfacesDAO.VeicoloDAO;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class MySQLVeicoloDAOImpl implements VeicoloDAO {

	private static final String READ_QUERY_VEICOLO = "select categoria, oneri from veicolo where targa = ? ";
	private static final String READ_QUERY_VEICOLI = "select * from veicolo where utente = ? ";
	
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
			PreparedStatement prepareStatement = cn.prepareStatement(READ_QUERY_VEICOLO);
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
	/* (non-Javadoc)
	 * @see model.interfacesDAO.VeicoloDAO#getOneriVeicolo(java.lang.String)
	 */
	@Override
	public Integer getOneriVeicolo(String targa) {
		// TODO Auto-generated method stub
		Integer oneri = 0;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement prepareStatement = cn.prepareStatement(READ_QUERY_VEICOLO);
			prepareStatement.setString(1, targa);
			prepareStatement.execute();
			rs = prepareStatement.getResultSet();
			if(rs.next()) {
				oneri = rs.getInt("oneri");
				return oneri;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneri;
	}
	/* (non-Javadoc)
	 * @see model.interfacesDAO.VeicoloDAO#getVeicoli(model.components.Utente)
	 */
	@Override
	public ArrayList<Veicolo> getVeicoli(Utente u) {
		// TODO Auto-generated method stub
		ArrayList<Veicolo> list = new ArrayList<Veicolo>();
		Veicolo v = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_VEICOLI);
			preparedStatement.setString(1, u.getUsername());
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			while (rs.next()) {
				v = new Veicolo(rs.getString("targa"), rs.getString("marca"), rs.getString("modello"), rs.getInt("peso"), rs.getInt("assi"), rs.getInt("altezza"), rs.getInt("anno"), rs.getString("categoria"), rs.getInt("qtaco2"), rs.getInt("oneri"), rs.getString("utente"));
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
