/**
 * 
 */
package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Salvatore Salernitano Matricola 242016
 *
 */
public class Database {
	/*In questa classe avverrà il collegamento al database*/
	private static String LOCATION="jdbc:mysql://localhost:3306/pedaggiautostrade?serverTimezone=UTC";
	private static String NAME="root";
	private static String PSW="root";
	
	//Effettua connessione DB
		public static Connection Connect() {
			
			Connection myConn;
			
			try {
				myConn=DriverManager.getConnection(LOCATION,NAME,PSW);
				//System.out.println("\n----Connessione Effettuata Corretamente al Database---- ");
				return myConn;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
}
