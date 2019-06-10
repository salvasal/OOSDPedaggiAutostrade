/**
 * 
 */
package model.components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;

import model.database.Database;
import model.interfaces.PedaggioInterface;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public class Pedaggio implements PedaggioInterface {
	public String id;
	public String stato;
	public float importo;
	public String veicolo;
	
	
	
	/**
	 * 
	 */
	public Pedaggio() {
		super();
	}
	
	

	/**
	 * @param id
	 * @param stato
	 * @param importo
	 * @param veicolo
	 */
	public Pedaggio(String id, String stato, float importo, String veicolo) {
		this.id = id;
		this.stato = stato;
		this.importo = importo;
		this.veicolo = veicolo;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}
	/**
	 * @param stato the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}
	/**
	 * @return the importo
	 */
	public float getImporto() {
		return importo;
	}
	/**
	 * @param importo the importo to set
	 */
	public void setImporto(float importo) {
		this.importo = importo;
	}
	/**
	 * @return the veicolo
	 */
	public String getVeicolo() {
		return veicolo;
	}
	/**
	 * @param veicolo the veicolo to set
	 */
	public void setVeicolo(String veicolo) {
		veicolo = veicolo;
	}
	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#setTariffa(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setTariffa(String importoTariffa, String categoriaSelected, String autostradaSelected) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update Tariffa set Valore = '"+importoTariffa+"' where Categoria = '"+categoriaSelected+"' and Tipo = '"+autostradaSelected+"' ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#setOneri(java.lang.String, java.lang.String)
	 */
	@Override
	public void setOneri(String importoOneri, String veicoloClasseSelected) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		
		try {
			Statement so = con.createStatement();
			so.executeUpdate("update Oneri set Importo = '"+importoOneri+"' where Euro = '"+veicoloClasseSelected+"' ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#getPedagginonPagati(java.lang.String)
	 */
	@Override
	public DefaultListModel getPedagginonPagati(String username) {
		// TODO Auto-generated method stub
		DefaultListModel  dfm = new DefaultListModel();
		Connection cn = new Database().Connect();
		String statopedaggio = "NonPagato";
		try {
			Statement st = cn.createStatement();
			ResultSet result = st.executeQuery("select ID, stato, Importo, Veicolo from pedaggio inner join veicolo "
					+ "on pedaggio.veicolo = veicolo.targa inner join utente "
					+ "on veicolo.utente = utente.username where pedaggio.stato ='"+statopedaggio+"' and utente.username ='"+username+"'");
			while (result.next()) {
				dfm.addElement("ID Pedaggio: "+ result.getString("ID") + " Importo: " + result.getFloat("Importo") + " € Veicolo: " + result.getString("Veicolo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dfm;
	}



	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#getPedaggi(java.lang.String)
	 */
	@Override
	public DefaultListModel getPedaggi(String username) {
		// TODO Auto-generated method stub
		DefaultListModel  dfm = new DefaultListModel();
		Connection cn = new Database().Connect();
		try {
			Statement st = cn.createStatement();
			ResultSet result = st.executeQuery("select ID, stato, Importo, Veicolo from pedaggio inner join veicolo "
					+ "on pedaggio.veicolo = veicolo.targa inner join utente "
					+ "on veicolo.utente = utente.username where utente.username ='"+username+"'");
			while (result.next()) {
				dfm.addElement("ID Pedaggio: "+ result.getString("ID") + "Stato: "+ result.getString("stato") + " Importo: " + result.getFloat("Importo") + " € Veicolo: " + result.getString("Veicolo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dfm;
	}



	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#pagamentoContante(java.lang.String)
	 */
	@Override
	public void pagamentoContante(String pedaggio) {
		// TODO Auto-generated method stub
		String stato="Pagato";
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update Pedaggio set Stato ='"+stato+"' where ID = '"+pedaggio+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
