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
	
	
	
}
