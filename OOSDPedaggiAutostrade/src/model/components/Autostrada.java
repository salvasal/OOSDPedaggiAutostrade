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
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public class Autostrada implements AutostradaInterface {
	public String codice;
	public String nome;
	public String tipo;
	public Integer kminizio;
	public Integer kmfine;
	public String amministratore;
	
	
	
	/**
	 * 
	 */
	public Autostrada() {
		super();
	}
	/**
	 * @param codice
	 * @param nome
	 * @param tipo
	 * @param kminizio
	 * @param kmfine
	 * @param amministratore
	 */
	public Autostrada(String codice, String nome, String tipo, Integer kminizio, Integer kmfine,
			String amministratore) {
		this.codice = codice;
		this.nome = nome;
		this.tipo = tipo;
		this.kminizio = kminizio;
		this.kmfine = kmfine;
		this.amministratore = amministratore;
	}
	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}
	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the kminizio
	 */
	public Integer getKminizio() {
		return kminizio;
	}
	/**
	 * @param kminizio the kminizio to set
	 */
	public void setKminizio(Integer kminizio) {
		this.kminizio = kminizio;
	}
	/**
	 * @return the kmfine
	 */
	public Integer getKmfine() {
		return kmfine;
	}
	/**
	 * @param kmfine the kmfine to set
	 */
	public void setKmfine(Integer kmfine) {
		this.kmfine = kmfine;
	}
	/**
	 * @return the amministratore
	 */
	public String getAmministratore() {
		return amministratore;
	}
	/**
	 * @param amministratore the amministratore to set
	 */
	public void setAmministratore(String amministratore) {
		this.amministratore = amministratore;
	}
	/* (non-Javadoc)
	 * @see model.interfaces.AutostradaInterface#getAutostradebyUsername(java.lang.String)
	 */
	@Override
	public DefaultListModel getAutostradebyUsername(String username) {
		// TODO Auto-generated method stub
		DefaultListModel dfm = new DefaultListModel();
		ResultSet rs;
		Connection cn = new Database().Connect();
		try {
			Statement st = cn.createStatement();
			rs = st.executeQuery("select codice, nome, tipo, kminizio, kmfine from autostrada where amministratore='"+username+"' ");
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
	 * @see model.interfaces.AutostradaInterface#setCasello(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String)
	 */
	@Override
	public void setCasello(String coordinate, String nome, Integer km, String autostrada) {
		// TODO Auto-generated method stub
		Casello c = new Casello(coordinate, nome, km, autostrada);
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
	 * @see model.interfaces.AutostradaInterface#getIdautostradaByusername(java.lang.String)
	 */
	@Override
	public ArrayList<String> getIdautostradaByusername(String username) {
		// TODO Auto-generated method stub
		ArrayList<String> idautostradalist = new ArrayList<String>();
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select codice from autostrada where Amministratore='"+username+"'");
			while(rs.next()) {
				idautostradalist.add(rs.getString("codice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idautostradalist;
	}
	
	
	
	
	
}
