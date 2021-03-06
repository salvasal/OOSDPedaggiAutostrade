/**
 * 
 */
package model.implementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Oneri;
import model.components.Pedaggio;
import model.components.Tariffa;
import model.components.Utente;
import model.database.Database;
import model.interfacesDAO.PedaggioDAO;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class MySQLPedaggioDAOImpl implements PedaggioDAO {

	private static final String UPDATE_QUERY_TARIFFA = "update Tariffa set Valore = ? where Categoria = ? and Tipo = ? ";
	private static final String UPDATE_QUERY_ONERI = "update Oneri set Importo = ? where Euro = ? ";
	private static final String READ_QUERY_PEDAGGINONPAGATI = "select * from pedaggio inner join veicolo on pedaggio.veicolo = veicolo.targa inner join utente on veicolo.utente = utente.username where pedaggio.stato = ? and utente.username = ? ";
	private static final String READ_QUERY_PEDAGGI = "select * from pedaggio inner join veicolo on pedaggio.veicolo = veicolo.targa inner join utente on veicolo.utente = utente.username where utente.username = ? ";
	private static final String READ_QUERY_PEDAGGIO = "select * from Pedaggio where ID = ? ";
	private static final String UPDATE_QUERY_PEDAGGIO = "update Pedaggio set Stato = ? where ID = ? ";
	private static final String READ_QUERY_TARIFFA = "select valore from tariffa where categoria = ? and tipo = ? ";
	private static final String READ_QUERY_ONERI = "select importo from oneri where euro = ? ";
	private static final String CREATE_QUERY_PEDAGGIO = "insert into pedaggio values(?,?,?,?)";
	private static final String READ_ALL_QUERY_ONERI = "select * from oneri";
	
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

	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#setOneri(model.components.Oneri)
	 */
	@Override
	public void setOneri(Oneri o) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(UPDATE_QUERY_ONERI);
			preparedStatement.setString(1, o.getImporto());
			preparedStatement.setInt(2, o.getEuro());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#getPedagginonPagati(model.components.Utente)
	 */
	@Override
	public ArrayList<Pedaggio> getPedagginonPagati(Utente u) {
		// TODO Auto-generated method stub
		ArrayList<Pedaggio> pedaggiNonPagati = new ArrayList<Pedaggio>();
		Pedaggio p = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_PEDAGGINONPAGATI);
			preparedStatement.setString(1, "NonPagato");
			preparedStatement.setString(2, u.getUsername());
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			while (rs.next()) {
				p = new Pedaggio(rs.getString("ID"), rs.getString("Stato"), rs.getFloat("Importo"), rs.getString("Veicolo"));
				pedaggiNonPagati.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pedaggiNonPagati;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#getPedaggi(model.components.Utente)
	 */
	@Override
	public ArrayList<Pedaggio> getPedaggi(Utente u) {
		// TODO Auto-generated method stub
		ArrayList<Pedaggio> pedaggi = new ArrayList<Pedaggio>();
		Pedaggio p = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_PEDAGGI);
			preparedStatement.setString(1, u.getUsername());
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			while (rs.next()) {
				p = new Pedaggio(rs.getString("ID"), rs.getString("Stato"), rs.getFloat("Importo"), rs.getString("Veicolo"));
				pedaggi.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pedaggi;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#setPedaggioPagato(java.lang.String)
	 */
	@Override
	public void setPedaggioPagato(String pedaggio) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(UPDATE_QUERY_PEDAGGIO);
			preparedStatement.setString(1, "Pagato");
			preparedStatement.setString(2, pedaggio);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#getPedaggio(java.lang.String)
	 */
	@Override
	public Pedaggio getPedaggio(String pedaggio) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		Pedaggio p = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_QUERY_PEDAGGIO);
			preparedStatement.setString(1, pedaggio);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			if(rs.next()) {
				p = new Pedaggio(rs.getString("ID"), rs.getString("Stato"), rs.getFloat("Importo"), rs.getString("Veicolo"));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#getvaloretariffa(java.lang.String, java.lang.String)
	 */
	@Override
	public float getvaloretariffa(String categoria, String tipo) {
		// TODO Auto-generated method stub
		float tariffa = 0;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement prepareStatement = cn.prepareStatement(READ_QUERY_TARIFFA);
			prepareStatement.setString(1, categoria);
			prepareStatement.setString(2, tipo);
			prepareStatement.execute();
			rs = prepareStatement.getResultSet();
			if(rs.next()) {
				tariffa = rs.getFloat("valore");
				return tariffa;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tariffa;
	}

	
	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#getvaloreoneri(java.lang.String)
	 */
	@Override
	public float getvaloreoneri(Integer oneri) {
		// TODO Auto-generated method stub
		float importo = 0;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement prepareStatement = cn.prepareStatement(READ_QUERY_ONERI);
			prepareStatement.setInt(1, oneri);
			prepareStatement.execute();
			rs = prepareStatement.getResultSet();
			if(rs.next()) {
				importo = rs.getFloat("importo");
				return importo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return importo;
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#setPedaggioNonPagato(java.lang.String, java.lang.Double, java.lang.String)
	 */
	@Override
	public void setPedaggioNonPagato(String ID, Double importo, String targa) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(CREATE_QUERY_PEDAGGIO);
			preparedStatement.setString(1, ID);
			preparedStatement.setString(2, "NonPagato");
			preparedStatement.setDouble(3, importo);
			preparedStatement.setString(4, targa);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.interfacesDAO.PedaggioDAO#getOneri()
	 */
	@Override
	public ArrayList<Oneri> getOneri() {
		// TODO Auto-generated method stub
		ArrayList<Oneri> list = new ArrayList<Oneri>();
		Oneri o = null;
		Connection cn = new Database().Connect();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = cn.prepareStatement(READ_ALL_QUERY_ONERI);
			preparedStatement.execute();
			rs = preparedStatement.getResultSet();
			while (rs.next()) {
				o = new Oneri(rs.getInt("euro"), rs.getString("importo"), rs.getFloat("valoremin"), rs.getFloat("valoremax"));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
