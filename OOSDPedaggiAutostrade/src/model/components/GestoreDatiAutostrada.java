/**
 * 
 */
package model.components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.database.Database;
import model.interfaces.AutostradaInterface;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class GestoreDatiAutostrada implements AutostradaInterface {

	
	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#getAutostradebyUsername(model.components.Amministratore)
	 */
	@Override
	public DefaultListModel getAutostradebyUsername(Amministratore a) {
		// TODO Auto-generated method stub
		DefaultListModel dfm = new DefaultListModel();
		ResultSet rs;
		Connection cn = new Database().Connect();
		try {
			Statement st = cn.createStatement();
			rs = st.executeQuery("select codice, nome, tipo, kminizio, kmfine from autostrada where amministratore='"+a.getUsername()+"' ");
			while (rs.next()) {
				dfm.addElement("Codice: "+rs.getString("codice")+" Nome: "+rs.getString("nome")+" Tipologia: "+rs.getString("tipo")+" KmInzio: "+rs.getInt("kminizio")+" KmFine: "+rs.getInt("kmfine"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dfm;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#getCasellibyIDautostrada(java.lang.String)
	 */
	@Override
	public DefaultListModel getCasellibyIDautostrada(String ID) {
		// TODO Auto-generated method stub
		DefaultListModel dfm = new DefaultListModel();
		ResultSet rs;
		Connection cn = new Database().Connect();
		try {
			Statement st = cn.createStatement();
			rs = st.executeQuery("select nome, km from casello where autostrada = '"+ID+"'");
			while(rs.next()) {
				dfm.addElement("Casello: "+rs.getString("nome")+" "+rs.getInt("km"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dfm;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#setAutostrada(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String)
	 */
	@Override
	public void setAutostrada(String codice, String nome, String tipoSelected, Integer lunghezza, String username) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		Integer kmInizio;
		Integer kmFine;
		Statement st;
		Statement st2;
		Autostrada a;
		
		try {
			st = cn.createStatement();
			ResultSet rs = st.executeQuery("select kmfine from autostrada order by kmfine DESC");
			if(rs.next()) {
				kmInizio = (rs.getInt("kmfine"))+1;
				kmFine = (rs.getInt("kmfine"))+lunghezza;
				a = new Autostrada(codice, nome, tipoSelected, kmInizio, kmFine, username);
				st2 = cn.createStatement();
				String tot = "insert into autostrada values('"+a.getCodice()+"','"+a.getNome()+"','"+a.getTipo()+"','"+a.getKminizio()+"','"+a.getKmfine()+"','"+a.getAmministratore()+"')";
				st2.executeUpdate(tot);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#getkmbyID(java.lang.String)
	 */
	@Override
	public ArrayList<Integer> getkmbyID(String ID) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		ArrayList<Integer> kmlist = new ArrayList<Integer>();
		Integer kmInizio;
		Integer kmFine;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select kminizio, kmfine from autostrada where codice='"+ID+"'");
			if(rs.next()) {
				kmInizio = (rs.getInt("kminizio"));
				kmFine = (rs.getInt("kmfine"));
				for(int i=kmInizio; i<=kmFine; i++) {
					kmlist.add(i);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kmlist;
	}
	
	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#setCasello(model.components.Casello)
	 */
	@Override
	public void setCasello(Casello c) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into casello values ('"+c.getCoordinate()+"','"+c.getNome()+"','"+c.getKm()+"','"+c.getAutostrada()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#getIdautostradaByusername(model.components.Amministratore)
	 */
	@Override
	public ArrayList<String> getIdautostradaByusername(Amministratore a) {
		// TODO Auto-generated method stub
		ArrayList<String> idautostradalist = new ArrayList<String>();
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select codice from autostrada where Amministratore='"+a.getUsername()+"'");
			while(rs.next()) {
				idautostradalist.add(rs.getString("codice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idautostradalist;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#deleteautostrada(java.lang.String)
	 */
	@Override
	public void deleteautostrada(String codiceSelected) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from casello where Autostrada = '"+codiceSelected+"'");
			Statement st2 = con.createStatement();
			st.executeUpdate("delete from autostrada where codice ='"+codiceSelected+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#getCoordinatecaselliBycodiceAutostrada(model.components.Amministratore, java.lang.String)
	 */
	@Override
	public ArrayList<String> getCoordinatecaselliBycodiceAutostrada(Amministratore a, String codiceAutostrada) {
		// TODO Auto-generated method stub
		ArrayList<String> coordinateCaselli = new ArrayList<String>();
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select coordinate from casello inner join autostrada "
					+ "on casello.autostrada = autostrada.codice inner join amministratore on "
					+ "autostrada.amministratore = amministratore.username where casello.autostrada = '"+codiceAutostrada+"' ");
			while (rs.next()) {
				coordinateCaselli.add(rs.getString("coordinate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coordinateCaselli;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#deletecasello(java.lang.String)
	 */
	@Override
	public void deletecasello(String coordinateSelected) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from casello where coordinate = '"+coordinateSelected+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
