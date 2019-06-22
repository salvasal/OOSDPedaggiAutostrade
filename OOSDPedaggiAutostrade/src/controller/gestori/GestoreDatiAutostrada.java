/**
 * 
 */
package controller.gestori;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import model.components.Amministratore;
import model.components.Autostrada;
import model.components.Casello;
import model.database.Database;
import model.implementsDAO.MySQLAutostradaDAOImpl;
import model.interfacesDAO.AutostradaDAO;
import controller.interfaces.AutostradaInterface;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class GestoreDatiAutostrada implements AutostradaInterface {

	
	/* (non-Javadoc)
	 * @see controller.interfaces.AutostradaInterface#getAutostradebyUsername(model.components.Amministratore)
	 */
	@Override
	public DefaultListModel getAutostradebyUsername(Amministratore a) {
		// TODO Auto-generated method stub
		DefaultListModel dfm = new DefaultListModel();
		ArrayList<Autostrada> autostrade = new ArrayList<Autostrada>();
		autostrade.addAll(new MySQLAutostradaDAOImpl().getAutostradabyUsername(a));
		for (Autostrada ad : autostrade) {
			dfm.addElement("Codice: "+ad.getCodice()+" Nome: "+ad.getNome()+" Tipologia: "+ad.getTipo()+" KmInzio: "+ad.getKminizio()+" KmFine: "+ad.getKmfine());
		}
		return dfm;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.AutostradaInterface#getCasellibyIDautostrada(java.lang.String)
	 */
	@Override
	public DefaultListModel getCasellibyIDautostrada(String ID) {
		// TODO Auto-generated method stub
		DefaultListModel dfm = new DefaultListModel();
		ArrayList<Casello> caselli = new ArrayList<Casello>();
		caselli.addAll(new MySQLAutostradaDAOImpl().getCasellibyIDautostrada(ID));
		for (Casello c : caselli) {
			dfm.addElement(" Nome: "+c.getNome()+" Km: "+c.getKm());
		}
		return dfm;
	}

	
	

	/* (non-Javadoc)
	 * @see controller.interfaces.AutostradaInterface#setAutostrada(model.components.Autostrada, java.lang.Integer)
	 */
	@Override
	public void setAutostrada(Autostrada a, Integer lunghezza) {
		// TODO Auto-generated method stub
		Integer kmInizio, KmFine, km;
		km = new MySQLAutostradaDAOImpl().getkmfine();
		kmInizio = km + 1;
		KmFine = km + lunghezza;
		a.setKminizio(kmInizio);
		a.setKmfine(KmFine);
		new MySQLAutostradaDAOImpl().setautostrada(a);
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.AutostradaInterface#getkmbyID(java.lang.String)
	 */
	@Override
	public ArrayList<Integer> getkmbyID(String ID) {
		// TODO Auto-generated method stub
		//Connection con = new Database().Connect();
		ArrayList<Integer> kmlist = new ArrayList<Integer>();
		Integer kmInizio, kmFine;
		Integer[] km = new Integer[2];
		km = new MySQLAutostradaDAOImpl().getkm(ID);
		kmInizio = km[0];
		kmFine = km[1];
		for(int i=kmInizio; i<=kmFine; i++) {
			kmlist.add(i);
		}
		return kmlist;
	}
	
	/* (non-Javadoc)
	 * @see controller.interfaces.AutostradaInterface#setCasello(model.components.Casello)
	 */
	@Override
	public void setCasello(Casello c) {
		// TODO Auto-generated method stub
		new MySQLAutostradaDAOImpl().setCasello(c);
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.AutostradaInterface#getIdautostradaByusername(model.components.Amministratore)
	 */
	@Override
	public ArrayList<String> getIdautostradaByusername(Amministratore a) {
		// TODO Auto-generated method stub
		ArrayList<String> idautostradalist = new ArrayList<String>();
		idautostradalist.addAll(new MySQLAutostradaDAOImpl().getIdautostradaByUsername(a));
		return idautostradalist;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.AutostradaInterface#deleteautostrada(java.lang.String)
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
	 * @see controller.interfaces.AutostradaInterface#getCoordinatecaselliBycodiceAutostrada(model.components.Amministratore, java.lang.String)
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
	 * @see controller.interfaces.AutostradaInterface#deletecasello(java.lang.String)
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
