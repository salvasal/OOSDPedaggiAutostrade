/**
 * 
 */
package controller.gestori;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;

import model.components.Carta;
import model.components.Oneri;
import model.components.Pedaggio;
import model.components.Tariffa;
import model.components.Utente;
import model.implementsDAO.MySQLAutostradaDAOImpl;
import model.implementsDAO.MySQLGestoreUtenzaDAOImpl;
import model.implementsDAO.MySQLPedaggioDAOImpl;
import model.implementsDAO.MySQLVeicoloDAOImpl;
import controller.interfaces.PedaggioInterface;

/**
 * @author Salernitano Salvatore Matricola 242016
 *
 */
public class GestoreDatiPedaggio implements PedaggioInterface {

	
	/* (non-Javadoc)
	 * @see controller.interfaces.PedaggioInterface#setTariffa(model.components.Tariffa)
	 */
	@Override
	public void setTariffa(Tariffa t) {
		// TODO Auto-generated method stub
		new MySQLPedaggioDAOImpl().setTariffa(t);
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.PedaggioInterface#setOneri(model.components.Oneri)
	 */
	@Override
	public void setOneri(Oneri o) {
		// TODO Auto-generated method stub
		new MySQLPedaggioDAOImpl().setOneri(o);
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.PedaggioInterface#getPedagginonPagati(model.components.Utente)
	 */
	@Override
	public DefaultListModel getPedagginonPagati(Utente u) {
		// TODO Auto-generated method stub
		DefaultListModel  dfm = new DefaultListModel();
		ArrayList<Pedaggio> pedaggiNonPagati = new ArrayList<Pedaggio>();
		pedaggiNonPagati.addAll(new MySQLPedaggioDAOImpl().getPedagginonPagati(u));
		for (Pedaggio p : pedaggiNonPagati) {
			dfm.addElement("ID Pedaggio: "+ p.getId() + " Importo: " + p.getImporto() + " Euro Veicolo: " + p.getVeicolo());
		}
		return dfm;
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.PedaggioInterface#getPedaggi(model.components.Utente)
	 */
	@Override
	public DefaultListModel getPedaggi(Utente u) {
		// TODO Auto-generated method stub
		DefaultListModel  dfm = new DefaultListModel();
		ArrayList<Pedaggio> pedaggi = new ArrayList<Pedaggio>();
		pedaggi.addAll(new MySQLPedaggioDAOImpl().getPedaggi(u));
		for (Pedaggio p : pedaggi) {
			dfm.addElement("ID Pedaggio: "+ p.getId() + " Stato: "+p.getStato() +" Importo: " + p.getImporto() + " Euro Veicolo: " + p.getVeicolo());
		}
		return dfm;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.PedaggioInterface#pagamentoContante(java.lang.String)
	 */
	@Override
	public void pagamentoContante(String pedaggio) {
		// TODO Auto-generated method stub
		new MySQLPedaggioDAOImpl().setPedaggioPagato(pedaggio);
	}

	
	
	/* (non-Javadoc)
	 * @see controller.interfaces.PedaggioInterface#pagamentoCarta(java.lang.String, model.components.Utente)
	 */
	@Override
	public boolean pagamentoCarta(String pedaggio, Utente u) {
		// TODO Auto-generated method stub
		boolean check = false;
		float nuovosaldo;
		Pedaggio p = new MySQLPedaggioDAOImpl().getPedaggio(pedaggio);
		Carta c = new MySQLGestoreUtenzaDAOImpl().getCarta(u);
		if (p.getImporto() >= c.getSaldo()) {
			check = false;
		} else {
			nuovosaldo = c.getSaldo()-p.getImporto();
			new MySQLGestoreUtenzaDAOImpl().setCarta(nuovosaldo, c);
			new MySQLPedaggioDAOImpl().setPedaggioPagato(pedaggio);
			check = true;
		}
		return check;
	}

	
	
	/* (non-Javadoc)
	 * @see controller.interfaces.PedaggioInterface#ricarica(java.lang.Integer, java.lang.String, model.components.Utente)
	 */
	@Override
	public void ricarica(Integer importo, String pedaggio, Utente u) {
		// TODO Auto-generated method stub
		float nuovosaldo;
		Carta c = new MySQLGestoreUtenzaDAOImpl().getCarta(u);
		nuovosaldo = c.getSaldo()+importo;
		new MySQLGestoreUtenzaDAOImpl().setCarta(nuovosaldo, c);
		boolean check = new GestoreDatiPedaggio().pagamentoCarta(pedaggio, u);
	}


	/* (non-Javadoc)
	 * @see controller.interfaces.PedaggioInterface#setPedaggio(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setPedaggio(String targa, String caselloentrata, String casellouscita) {
		// TODO Auto-generated method stub
		Integer kmentrata = new MySQLAutostradaDAOImpl().getkmcasello(caselloentrata);
		Integer kmuscita = new MySQLAutostradaDAOImpl().getkmcasello(casellouscita);
		Integer km = Math.abs(kmentrata - kmuscita);
		String tipo = new MySQLAutostradaDAOImpl().getTipoAutostrada(caselloentrata);
		String categoria = new MySQLVeicoloDAOImpl().getCategoriaVeicolo(targa);
		float tariffa = new MySQLPedaggioDAOImpl().getvaloretariffa(categoria, tipo);
		double pedaggiosenzaimposta = km * tariffa;
		double imposta = pedaggiosenzaimposta * 0.22;
		double pedaggio = pedaggiosenzaimposta + imposta;
		System.out.println(pedaggio);
		Double importo = arrotonda(pedaggio, 1);
		System.out.println(importo);
		String ID = randomString(4);
		new MySQLPedaggioDAOImpl().setPedaggioNonPagato(ID, importo, targa);
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
	 * @see controller.interfaces.PedaggioInterface#setPedaggiowithOneri(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setPedaggiowithOneri(String targa, String caselloentrata, String casellouscita) {
		// TODO Auto-generated method stub
		Integer kmentrata = new MySQLAutostradaDAOImpl().getkmcasello(caselloentrata);
		Integer kmuscita = new MySQLAutostradaDAOImpl().getkmcasello(casellouscita);
		Integer km = Math.abs(kmentrata - kmuscita);
		String tipo = new MySQLAutostradaDAOImpl().getTipoAutostrada(caselloentrata);
		String categoria = new MySQLVeicoloDAOImpl().getCategoriaVeicolo(targa);
		Integer oneri = new MySQLVeicoloDAOImpl().getOneriVeicolo(targa);
		float tariffa = new MySQLPedaggioDAOImpl().getvaloretariffa(categoria, tipo);
		float importooneri = new MySQLPedaggioDAOImpl().getvaloreoneri(oneri);
		System.out.println(importooneri);
		double pedaggiosenzaimposta = km * tariffa;
		double pedaggiocononerisenzaimposta = pedaggiosenzaimposta + importooneri;
		double imposta = pedaggiocononerisenzaimposta * 0.22;
		double pedaggio = pedaggiocononerisenzaimposta + imposta;
		System.out.println(pedaggio);
		Double importo = arrotonda(pedaggio, 1);
		System.out.println(importo);
		String ID = randomString(4);
		new MySQLPedaggioDAOImpl().setPedaggioNonPagato(ID, importo, targa);
	}
	
}
