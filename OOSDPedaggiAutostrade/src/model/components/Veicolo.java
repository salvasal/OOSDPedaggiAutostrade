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
import model.interfaces.VeicoloInterface;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public class Veicolo implements VeicoloInterface {
	public String targa;
	public String marca;
	public String modello;
	public Integer peso;
	public Integer assi;
	public Integer altezza;
	public Integer anno;
	public String categoria;
	public Integer qtaco2;
	public Integer oneri;
	public String utente;
	
	
	
	/**
	 * 
	 */
	public Veicolo() {
		super();
	}
	/**
	 * @param targa
	 * @param marca
	 * @param modello
	 * @param peso
	 * @param assi
	 * @param altezza
	 * @param anno
	 * @param categoria
	 * @param qtaco2
	 * @param oneri
	 * @param utente
	 */
	public Veicolo(String targa, String marca, String modello, Integer peso, Integer assi, Integer altezza,
			Integer anno, String categoria, Integer qtaco2, Integer oneri, String utente) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.peso = peso;
		this.assi = assi;
		this.altezza = altezza;
		this.anno = anno;
		this.categoria = categoria;
		this.qtaco2 = qtaco2;
		this.oneri = oneri;
		this.utente = utente;
	}
	/**
	 * @return the targa
	 */
	public String getTarga() {
		return targa;
	}
	/**
	 * @param targa the targa to set
	 */
	public void setTarga(String targa) {
		this.targa = targa;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the modello
	 */
	public String getModello() {
		return modello;
	}
	/**
	 * @param modello the modello to set
	 */
	public void setModello(String modello) {
		this.modello = modello;
	}
	/**
	 * @return the peso
	 */
	public Integer getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	/**
	 * @return the assi
	 */
	public Integer getAssi() {
		return assi;
	}
	/**
	 * @param assi the assi to set
	 */
	public void setAssi(Integer assi) {
		this.assi = assi;
	}
	/**
	 * @return the altezza
	 */
	public Integer getAltezza() {
		return altezza;
	}
	/**
	 * @param altezza the altezza to set
	 */
	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}
	/**
	 * @return the anno
	 */
	public Integer getAnno() {
		return anno;
	}
	/**
	 * @param anno the anno to set
	 */
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the qtaco2
	 */
	public Integer getQtaco2() {
		return qtaco2;
	}
	/**
	 * @param qtaco2 the qtaco2 to set
	 */
	public void setQtaco2(Integer qtaco2) {
		this.qtaco2 = qtaco2;
	}
	/**
	 * @return the oneri
	 */
	public Integer getOneri() {
		return oneri;
	}
	/**
	 * @param oneri the oneri to set
	 */
	public void setOneri(Integer oneri) {
		this.oneri = oneri;
	}
	/**
	 * @return the utente
	 */
	public String getUtente() {
		return utente;
	}
	/**
	 * @param utente the utente to set
	 */
	public void setUtente(String utente) {
		this.utente = utente;
	}
	/* (non-Javadoc)
	 * @see model.interfaces.VeicoloInterface#getVeicoli(java.lang.String)
	 */
	@Override
	public DefaultListModel getVeicoli(String usernameSelected) {
		// TODO Auto-generated method stub
		DefaultListModel dfm = new DefaultListModel();
		ResultSet result;
		Connection con = Database.Connect();
		Statement st;
		try {
			st = con.createStatement();
			result = st.executeQuery("select targa, marca, modello, peso, assi, altezza, anno, categoria, qtaco2, oneri from veicolo where utente='"+usernameSelected+"'");
			while (result.next()) {
				dfm.addElement("Targa: "+result.getString("targa")+" Marca: "+result.getString("marca")+" Modello: "+result.getString("modello")+" Assi: "+result.getInt("assi")+" Categoria: "+result.getString("categoria")+" Quantita di co2 emessa: "+result.getFloat("qtaco2")+" Oneri: "+result.getInt("oneri"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dfm;
	}
	/* (non-Javadoc)
	 * @see model.interfaces.VeicoloInterface#getVeicolibyUsername(java.lang.String)
	 */
	@Override
	public ArrayList<String> getVeicolibyUsername(String usernameutente) {
		// TODO Auto-generated method stub
		ArrayList<String> targalist = new ArrayList<String>();
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select targa from veicolo where utente ='"+usernameutente+"'");
			while(rs.next()) {
				targalist.add(rs.getString("targa"));
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targalist;
	}
	/* (non-Javadoc)
	 * @see model.interfaces.VeicoloInterface#deleteVeicolo(java.lang.String)
	 */
	@Override
	public void deleteVeicolo(String targa) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from veicolo where targa = '"+targa+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see model.interfaces.VeicoloInterface#setVeicolo(model.components.Veicolo)
	 */
	@Override
	public void setVeicolo(Veicolo v) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		
		
		switch(v.getAssi()) {
			
		case 2: 
			
			if (v.getAltezza() <= 130) {
				v.setCategoria("A");
			} else {v.setCategoria("B");}
			break;
			
		case 3:
			
			v.setCategoria("3");
			break;
			
		case 4:
			
			v.setCategoria("4");
			break;
			
		case 5:
			
			v.setCategoria("5");
			break;
			
		default: v.setCategoria("5");
		}
		
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select euro, importo, valoreMin, valoreMax from oneri");
			
			while(rs.next()) {
				Oneri o = new Oneri(rs.getInt("Euro"), rs.getFloat("Importo"), rs.getFloat("ValoreMin"), rs.getFloat("ValoreMax"));
				if(o.getValoreMin() <= v.getQtaco2() && v.getQtaco2() <= o.getValoreMax()) {
					v.setOneri(o.getEuro());
					Statement st2 = con.createStatement();
					st2.executeUpdate("insert into veicolo values ('"+v.getTarga()+"','"+v.getMarca()+"','"+v.getModello()+"','"+v.getPeso()+"','"+v.getAssi()+"','"+v.getAltezza()+"','"+v.getAnno()+"','"+v.getCategoria()+"','"+v.getQtaco2()+"','"+v.getOneri()+"','"+v.getUtente()+"')");
			
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
}
