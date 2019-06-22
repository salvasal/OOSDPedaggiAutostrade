/**
 * 
 */
package controller.gestori;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.components.Oneri;
import model.components.Utente;
import model.components.Veicolo;
import model.database.Database;
import controller.interfaces.VeicoloInterface;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class GestoreDatiVeicolo implements VeicoloInterface {

	
	
	/* (non-Javadoc)
	 * @see controller.interfaces.VeicoloInterface#getVeicoli(model.components.Utente)
	 */
	@Override
	public DefaultListModel getVeicoli(Utente u) {
		// TODO Auto-generated method stub
		DefaultListModel dfm = new DefaultListModel();
		ResultSet result;
		Connection con = Database.Connect();
		Statement st;
		try {
			st = con.createStatement();
			result = st.executeQuery("select targa, marca, modello, peso, assi, altezza, anno, categoria, qtaco2, oneri from veicolo where utente='"+u.getUsername()+"'");
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
	 * @see controller.interfaces.VeicoloInterface#getVeicolibyUsername(java.lang.String)
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
	 * @see controller.interfaces.VeicoloInterface#deleteVeicolo(java.lang.String)
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
	 * @see controller.interfaces.VeicoloInterface#setVeicolo(model.components.Veicolo)
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
				Oneri o = new Oneri(rs.getInt("Euro"), rs.getString("Importo"), rs.getFloat("ValoreMin"), rs.getFloat("ValoreMax"));
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
