/**
 * 
 */
package model.components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.DefaultListModel;

import model.database.Database;
import model.interfaces.PedaggioInterface;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class GestoreDatiPedaggio implements PedaggioInterface {

	
	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#setTariffa(model.components.Tariffa)
	 */
	@Override
	public void setTariffa(Tariffa t) {
		// TODO Auto-generated method stub
		Connection con = new Database().Connect();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update Tariffa set Valore = '"+t.getValore()+"' where Categoria = '"+t.getCategoria()+"' and Tipo = '"+t.getTipo()+"' ");
			
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
				dfm.addElement("ID Pedaggio: "+ result.getString("ID") + " Importo: " + result.getFloat("Importo") + " � Veicolo: " + result.getString("Veicolo"));
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
				dfm.addElement("ID Pedaggio: "+ result.getString("ID") + "Stato: "+ result.getString("stato") + " Importo: " + result.getFloat("Importo") + " � Veicolo: " + result.getString("Veicolo"));
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

	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#pagamentoCarta(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean pagamentoCarta(String pedaggio, String username) {
		// TODO Auto-generated method stub
		boolean check = false;
		float nuovosaldo;
		String stato = "Pagato";
		Connection con = new Database().Connect();
		Statement st, st2, st3, st4;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select ID, Stato, Importo, Veicolo from Pedaggio where ID = '"+pedaggio+"'");
			if(rs.next()) {
				Pedaggio p = new Pedaggio(rs.getString("ID"), rs.getString("Stato"), rs.getFloat("Importo"), rs.getString("Veicolo"));
				st2 = con.createStatement();
				ResultSet rs2 = st2.executeQuery("select IBAN, saldo from carta inner join utente "
						+ "on carta.IBAN = utente.carta where utente.username ='"+username+"'");
				if(rs2.next()) {
					Carta c = new Carta (rs2.getString("IBAN"), rs2.getFloat("saldo"));
					if (p.getImporto() >= c.getSaldo()) {
						check = false;
					} else  {
						nuovosaldo = c.getSaldo()-p.getImporto();
						st3 = con.createStatement();
						st3.executeUpdate("update carta set saldo ='"+nuovosaldo+"' where IBAN ='"+c.getIban()+"'");
						st4 = con.createStatement();
						st4.executeUpdate("update Pedaggio set Stato ='"+stato+"' where ID = '"+pedaggio+"'");
						check = true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#ricarica(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public void ricarica(Integer importo, String pedaggio, String username) {
		// TODO Auto-generated method stub
		float nuovosaldo;
		Connection con = new Database().Connect();
		Statement st, st2;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select IBAN, saldo from carta inner join utente "
					+ "on carta.IBAN = utente.carta where utente.username ='"+username+"'");
			if(rs.next()) {
				Carta c = new Carta (rs.getString("IBAN"), rs.getFloat("saldo"));
				nuovosaldo = c.getSaldo()+importo;
				st2 = con.createStatement();
				st2.executeUpdate("update carta set saldo = '"+nuovosaldo+"' where IBAN = '"+c.getIban()+"'");
				boolean check = new GestoreDatiPedaggio().pagamentoCarta(pedaggio, username);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#setPedaggio(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setPedaggio(String targa, String caselloentrata, String casellouscita) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select km from casello where coordinate = '"+caselloentrata+"'");
			if(rs.next()) {
				Integer kmentrata = rs.getInt("km");
				Statement st2 = cn.createStatement();
				ResultSet rs2 = st2.executeQuery("select km from casello where coordinate = '"+casellouscita+"'");
				if(rs2.next()) {
					Integer kmuscita = rs2.getInt("km");
					Integer km = Math.abs(kmentrata - kmuscita);
					Statement st3 = cn.createStatement();
					ResultSet rs3 = st3.executeQuery("select tipo from autostrada inner join casello "
							+ "on autostrada.codice = casello.autostrada where casello.coordinate = '"+caselloentrata+"'");
					if(rs3.next()) {
						String tipo = rs3.getString("tipo");
						Statement st4 = cn.createStatement();
						ResultSet rs4 = st4.executeQuery("select categoria from veicolo where targa = '"+targa+"'");
						if(rs4.next()) {
							String categoria = rs4.getString("categoria");
							Statement st5 = cn.createStatement();
							ResultSet rs5 = st5.executeQuery("select valore from tariffa where categoria = '"+categoria+"' and tipo = '"+tipo+"'");
							if(rs5.next()) {
								float tariffa = rs5.getFloat("valore");
								double pedaggiosenzaimposta = km * tariffa;
								double imposta = pedaggiosenzaimposta * 0.22;
								double pedaggio = pedaggiosenzaimposta + imposta;
								System.out.println(pedaggio);
								Double importo = arrotonda(pedaggio, 1);
								System.out.println(importo);
								String ID = randomString(4);
								String stato ="NonPagato";
								Statement st6 = cn.createStatement();
								st6.executeUpdate("insert into pedaggio values('"+ID+"','"+stato+"','"+importo+"','"+targa+"')");
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static double arrotonda(double value, int numCifreDecimali) {
	      double temp = Math.pow(10, numCifreDecimali);
	      return Math.round(value * temp) / temp; 
	}
	
	public String randomString(int length) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		StringBuffer tempStr = new StringBuffer();
		tempStr.append("");
		for (int i = 0; i < length; i++) {
		int c = rand.nextInt(122 - 48) + 48;
		if((c >= 58 && c <= 64) || (c >= 91 && c <= 96)){
		i--;
		continue;
		}
		tempStr.append((char)c);

		}
		return tempStr.toString();
	}
	/* (non-Javadoc)
	 * @see model.interfaces.PedaggioInterface#setPedaggiowithOneri(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setPedaggiowithOneri(String targa, String caselloentrata, String casellouscita) {
		// TODO Auto-generated method stub
		Connection cn = new Database().Connect();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select km from casello where coordinate = '"+caselloentrata+"'");
			if(rs.next()) {
				Integer kmentrata = rs.getInt("km");
				Statement st2 = cn.createStatement();
				ResultSet rs2 = st2.executeQuery("select km from casello where coordinate = '"+casellouscita+"'");
				if(rs2.next()) {
					Integer kmuscita = rs2.getInt("km");
					Integer km = Math.abs(kmentrata - kmuscita);
					Statement st3 = cn.createStatement();
					ResultSet rs3 = st3.executeQuery("select tipo from autostrada inner join casello "
							+ "on autostrada.codice = casello.autostrada where casello.coordinate = '"+caselloentrata+"'");
					if(rs3.next()) {
						String tipo = rs3.getString("tipo");
						Statement st4 = cn.createStatement();
						ResultSet rs4 = st4.executeQuery("select categoria, oneri from veicolo where targa = '"+targa+"'");
						if(rs4.next()) {
							String categoria = rs4.getString("categoria");
							Integer oneri = rs4.getInt("oneri");
							Statement st5 = cn.createStatement();
							ResultSet rs5 = st5.executeQuery("select valore from tariffa where categoria = '"+categoria+"' and tipo = '"+tipo+"'");
							if(rs5.next()) {
								float tariffa = rs5.getFloat("valore");
								Statement st6 = cn.createStatement();
								ResultSet rs6 = st6.executeQuery("select importo from oneri where euro = '"+oneri+"'");
								if(rs6.next()) {
									float importooneri = rs6.getFloat("importo");
									System.out.println(importooneri);
									double pedaggiosenzaimposta = km * tariffa;
									double pedaggiocononerisenzaimposta = pedaggiosenzaimposta + importooneri;
									double imposta = pedaggiocononerisenzaimposta * 0.22;
									double pedaggio = pedaggiocononerisenzaimposta + imposta;
									System.out.println(pedaggio);
									Double importo = arrotonda(pedaggio, 1);
									System.out.println(importo);
									String ID = randomString(4);
									String stato ="NonPagato";
									Statement st7 = cn.createStatement();
									st7.executeUpdate("insert into pedaggio values('"+ID+"','"+stato+"','"+importo+"','"+targa+"')");
								}
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
