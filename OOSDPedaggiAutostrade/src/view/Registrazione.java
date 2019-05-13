package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrazione {

	private JFrame frmRegistrazioneUtente;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField luogonField;
	private JTextField datanField;
	private JTextField telefonoField;
	private JTextField cartaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione window = new Registrazione();
					window.frmRegistrazioneUtente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrazioneUtente = new JFrame();
		frmRegistrazioneUtente.setTitle("Registrazione Utente");
		frmRegistrazioneUtente.setBounds(100, 100, 450, 480);
		frmRegistrazioneUtente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrazioneUtente.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(12, 30, 92, 16);
		frmRegistrazioneUtente.getContentPane().add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(199, 27, 116, 22);
		frmRegistrazioneUtente.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(12, 75, 74, 16);
		frmRegistrazioneUtente.getContentPane().add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(199, 72, 116, 22);
		frmRegistrazioneUtente.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblCognome = new JLabel("Nome:");
		lblCognome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCognome.setBounds(12, 116, 74, 16);
		frmRegistrazioneUtente.getContentPane().add(lblCognome);
		
		nomeField = new JTextField();
		nomeField.setBounds(199, 113, 116, 22);
		frmRegistrazioneUtente.getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 160, 74, 16);
		frmRegistrazioneUtente.getContentPane().add(lblNewLabel_1);
		
		cognomeField = new JTextField();
		cognomeField.setBounds(199, 157, 116, 22);
		frmRegistrazioneUtente.getContentPane().add(cognomeField);
		cognomeField.setColumns(10);
		
		JLabel lblLuogon = new JLabel("Luogo di nascita:");
		lblLuogon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLuogon.setBounds(12, 208, 130, 16);
		frmRegistrazioneUtente.getContentPane().add(lblLuogon);
		
		luogonField = new JTextField();
		luogonField.setBounds(199, 205, 116, 22);
		frmRegistrazioneUtente.getContentPane().add(luogonField);
		luogonField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data di nascita:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 249, 110, 16);
		frmRegistrazioneUtente.getContentPane().add(lblNewLabel_2);
		
		datanField = new JTextField();
		datanField.setBounds(199, 246, 116, 22);
		frmRegistrazioneUtente.getContentPane().add(datanField);
		datanField.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTelefono.setBounds(12, 291, 56, 16);
		frmRegistrazioneUtente.getContentPane().add(lblTelefono);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(199, 288, 116, 22);
		frmRegistrazioneUtente.getContentPane().add(telefonoField);
		telefonoField.setColumns(10);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrati.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRegistrati.setBounds(155, 385, 130, 35);
		frmRegistrazioneUtente.getContentPane().add(btnRegistrati);
		
		JLabel lblCartaDiCredito = new JLabel("Carta di credito:");
		lblCartaDiCredito.setBounds(12, 335, 110, 16);
		frmRegistrazioneUtente.getContentPane().add(lblCartaDiCredito);
		
		cartaField = new JTextField();
		cartaField.setBounds(199, 336, 116, 22);
		frmRegistrazioneUtente.getContentPane().add(cartaField);
		cartaField.setColumns(10);
	}
}
