package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	private JFrame frmLogin;
	private JTextField usernamefield;
	private JTextField passwordfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 348);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblSistemaDiPedaggi = new JLabel("Sistema di Pedaggi Autostradali");
		lblSistemaDiPedaggi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblSistemaDiPedaggi.setBounds(96, 36, 282, 26);
		frmLogin.getContentPane().add(lblSistemaDiPedaggi);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(72, 82, 77, 14);
		frmLogin.getContentPane().add(lblUsername);
		
		usernamefield = new JTextField();
		usernamefield.setBounds(170, 77, 142, 26);
		frmLogin.getContentPane().add(usernamefield);
		usernamefield.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(72, 125, 77, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		passwordfield = new JTextField();
		passwordfield.setBounds(170, 120, 142, 26);
		frmLogin.getContentPane().add(passwordfield);
		passwordfield.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Non ti sei ancora registrato?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(72, 191, 190, 26);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLogin.setBounds(180, 157, 103, 26);
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnRegistrati.setBounds(266, 194, 103, 23);
		frmLogin.getContentPane().add(btnRegistrati);
		
		JLabel lblHaiDimenticatoLe = new JLabel("Hai dimenticato le credenziali?");
		lblHaiDimenticatoLe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblHaiDimenticatoLe.setBounds(72, 242, 190, 14);
		frmLogin.getContentPane().add(lblHaiDimenticatoLe);
		
		JButton btnRecupera = new JButton("Recupera");
		btnRecupera.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnRecupera.setBounds(266, 239, 103, 23);
		frmLogin.getContentPane().add(btnRecupera);
	}
}
