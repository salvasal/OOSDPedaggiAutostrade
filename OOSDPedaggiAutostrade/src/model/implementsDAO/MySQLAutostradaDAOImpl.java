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
	private static final String READ_QUERY_KMFINE = "select kmfine from autostrada order by kmfine DESC";
	private static final String CREATE_QUERY_AUTOSTRADA = "insert into autostrada values(?,?,?,?,?,?)";
	private static final String READ_QUERY_KM = "select kminizio, kmfine from autostrada where codice = ?";
	private static final String CREATE_QUERY_CASELLO = "insert into casello values (?,?,?,?)";
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
	/* (non-Javadoc)
	 * @see model.interfacesDAO.AutostradaDAO#getkmfine()
	 */
	@Override
	public Integer getkmfine() {
		// TODO Auto-generated method stub
		Integer km = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement prepareStatement = cn.prepareStatement(READ_QUERY_KMFINE);
			prepareStatement.execute();
			rs = prepareStatement.getResultSet();
			if(rs.next()) {
				km = rs.getInt("kmfine");
				return km;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return km;
	}
	/* (non-Javadoc)
	 * @see model.interfacesDAO.AutostradaDAO#setautostrada(model.components.Autostrada)
	 */
	@Override
	public void setautostrada(Autostrada a) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement prepareStatement = cn.prepareStatement(CREATE_QUERY_AUTOSTRADA);
			prepareStatement.setString(1, a.getCodice());
			prepareStatement.setString(2, a.getNome());
			prepareStatement.setString(3, a.getTipo());
			prepareStatement.setInt(4, a.getKminizio());
			prepareStatement.setInt(5, a.getKmfine());
			prepareStatement.setString(6, a.getAmministratore());
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see model.interfacesDAO.AutostradaDAO#getkm(java.lang.String)
	 */
	@Override
	public Integer[] getkm(String ID) {
		// TODO Auto-generated method stub
		Integer[] km = new Integer[2];
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_KM);
			preparedStatement.setString(1, ID);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			if (rs.next()) {
				km[0] = rs.getInt("kminizio");
				km[1] = rs.getInt("kmfine");
				return km;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return km;
	}
	/* (non-Javadoc)
	 * @see model.interfacesDAO.AutostradaDAO#setCasello(model.components.Casello)
	 */
	@Override
	public void setCasello(Casello c) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(CREATE_QUERY_CASELLO);
			preparedStatement.setString(1, c.getCoordinate());
			preparedStatement.setString(2, c.getNome());
			preparedStatement.setInt(3, c.getKm());
			preparedStatement.setString(4, c.getAutostrada());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see model.interfacesDAO.AutostradaDAO#getIdautostradaByusername(model.components.Amministratore)
	 */
	@Override
	public ArrayList<String> getIdautostradaByUsername(Amministratore a) {
		// TODO Auto-generated method stub
		ArrayList<String> idautostradalist = new ArrayList<String>();
		String s = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY);
			preparedStatement.setString(1, a.getUsername());
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			while (rs.next()) {
				s = rs.getString("codice");
				idautostradalist.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idautostradalist;
	}
	
	
	
}
