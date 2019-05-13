package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDiPedaggi = new JLabel("Sistema di Pedaggi Autostradali");
		lblSistemaDiPedaggi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblSistemaDiPedaggi.setBounds(102, 28, 287, 28);
		contentPane.add(lblSistemaDiPedaggi);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(52, 83, 92, 14);
		contentPane.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(139, 77, 188, 28);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(52, 131, 78, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(139, 125, 188, 28);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLogin.setBounds(176, 164, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNonTiSei = new JLabel("Non ti sei ancora registrato?");
		lblNonTiSei.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNonTiSei.setBounds(52, 210, 190, 14);
		contentPane.add(lblNonTiSei);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRegistrati.setBounds(268, 206, 89, 23);
		contentPane.add(btnRegistrati);
		
		JLabel lblHaiDimenticatoLa = new JLabel("Hai dimenticato la credenziali?");
		lblHaiDimenticatoLa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblHaiDimenticatoLa.setBounds(52, 250, 190, 14);
		contentPane.add(lblHaiDimenticatoLa);
		
		JButton btnRecupera = new JButton("Recupera");
		btnRecupera.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRecupera.setBounds(268, 247, 89, 23);
		contentPane.add(btnRecupera);
	}

}
