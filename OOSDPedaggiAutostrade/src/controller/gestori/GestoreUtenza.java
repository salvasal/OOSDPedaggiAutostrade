/**
 * 
 */
package controller.gestori;

import java.util.ArrayList;
import java.util.Random;

import model.components.Amministratore;
import model.components.Carta;
import model.components.Utente;
import model.implementsDAO.MySQLGestoreUtenzaDAOImpl;
import controller.interfaces.GestoreUtenzaInterface;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */

public class GestoreUtenza implements GestoreUtenzaInterface {

	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#loginAmministratore(java.lang.String, java.lang.String)
	 */
	public Amministratore loginAmministratore(String username, String password) {
		// TODO Auto-generated method stub
		Amministratore a = new Amministratore("","","","","","","","");
		System.out.println(username);
		System.out.println(password);
		a = new MySQLGestoreUtenzaDAOImpl().getAmministratore(username, password);
		if(!(a.getUsername().equals(""))) {
			return a;
		}
		return a;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#loginUtente(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente loginUtente(String username, String password) {
		// TODO Auto-generated method stub
		Utente u = new Utente("","","","","","","","","");
		System.out.println(username);
		System.out.println(password);
		u = new MySQLGestoreUtenzaDAOImpl().getUtente(username, password);
		if(!(u.getUsername().equals(""))) {
			return u;
		}
		return u;
	}

	

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#setUtente(model.components.Utente)
	 */
	@Override
	public String setUtente(Utente u) {
		// TODO Auto-generated method stub
		String chiave = randomString(6);
		float saldo = 0;
		new MySQLGestoreUtenzaDAOImpl().setCarta(u, saldo);
		new MySQLGestoreUtenzaDAOImpl().setUtente(u, chiave);
		return chiave;
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getCredentialsbyKeyAmministratore(java.lang.String, java.lang.String)
	 */
	@Override
	public Amministratore getCredentialsbyKeyAmministratore(String username, String chiave) {
		// TODO Auto-generated method stub
		Amministratore a = new Amministratore("","","","","","","","");
		a = new MySQLGestoreUtenzaDAOImpl().getCredentialsbyKeyAmministratore(chiave);
		if(!(a.getUsername().equals(""))) {
			return a;
		}
		return a;
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getCredentialsbyKeyUtente(java.lang.String, java.lang.String)
	 */
	@Override
	public Utente getCredentialsbyKeyUtente(String username, String chiave) {
		// TODO Auto-generated method stub
		Utente u = new Utente("","","","","","","","","");
		u = new MySQLGestoreUtenzaDAOImpl().getCredentialsbyKeyUtente(chiave);
		if(!(u.getUsername().equals(""))) {
			return u;
		}
		return u;
	}

	
	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#randomString(int)
	 */
	@Override
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

	@Override
	public String setAmministratore(Amministratore a) {
		// TODO Auto-generated method stub
		String chiave = randomString(6);
		new MySQLGestoreUtenzaDAOImpl().setAmministratore(a, chiave);
		return chiave;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getUtente()
	 */
	@Override
	public ArrayList<String> getUtente() {
		// TODO Auto-generated method stub
		ArrayList<String> ulist = new ArrayList<String>();
		ulist.addAll(new MySQLGestoreUtenzaDAOImpl().getUtente());
		return ulist;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getUtentebyUsername(java.lang.String)
	 */
	@Override
	public String getUtentebyUsername(String username) {
		// TODO Auto-generated method stub
		Utente u = new MySQLGestoreUtenzaDAOImpl().getUtente(username);
		String s = "Nome: "+u.getNome()+"  Cognome: "+u.getCognome()+"  Carta di Credito: "+u.getCarta();
		return s;
	}

	/* (non-Javadoc)
	 * @see controller.interfaces.GestoreUtenzaInterface#getCarta(model.components.Utente)
	 */
	@Override
	public Carta getCarta(Utente u) {
		// TODO Auto-generated method stub
		Carta c = new MySQLGestoreUtenzaDAOImpl().getCarta(u);
		return c;
	}

}
