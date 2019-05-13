package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Registrazione extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField chiaverecuperoField;
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
					Registrazione frame = new Registrazione();
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
	public Registrazione() {
		setTitle("Registrazione Utente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(12, 35, 82, 16);
		contentPane.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(184, 32, 116, 22);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(12, 68, 82, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(184, 67, 116, 22);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Chiave Recupero:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 106, 135, 16);
		contentPane.add(lblNewLabel);
		
		chiaverecuperoField = new JTextField();
		chiaverecuperoField.setBounds(184, 103, 116, 22);
		contentPane.add(chiaverecuperoField);
		chiaverecuperoField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 144, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		nomeField = new JTextField();
		nomeField.setBounds(184, 141, 116, 22);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCogome = new JLabel("Cognome:");
		lblCogome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCogome.setBounds(12, 180, 82, 16);
		contentPane.add(lblCogome);
		
		cognomeField = new JTextField();
		cognomeField.setBounds(184, 177, 116, 22);
		contentPane.add(cognomeField);
		cognomeField.setColumns(10);
		
		JLabel lblLuogoDiNascita = new JLabel("Luogo di nascita:");
		lblLuogoDiNascita.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLuogoDiNascita.setBounds(12, 219, 154, 16);
		contentPane.add(lblLuogoDiNascita);
		
		luogonField = new JTextField();
		luogonField.setBounds(184, 216, 116, 22);
		contentPane.add(luogonField);
		luogonField.setColumns(10);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita:");
		lblDataDiNascita.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDataDiNascita.setBounds(12, 260, 135, 16);
		contentPane.add(lblDataDiNascita);
		
		datanField = new JTextField();
		datanField.setBounds(184, 257, 116, 22);
		contentPane.add(datanField);
		datanField.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTelefono.setBounds(12, 295, 56, 16);
		contentPane.add(lblTelefono);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(184, 292, 116, 22);
		contentPane.add(telefonoField);
		telefonoField.setColumns(10);
		
		JLabel lblCartaDiCredito = new JLabel("Carta di credito:");
		lblCartaDiCredito.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCartaDiCredito.setBounds(12, 334, 135, 16);
		contentPane.add(lblCartaDiCredito);
		
		cartaField = new JTextField();
		cartaField.setBounds(184, 331, 116, 22);
		contentPane.add(cartaField);
		cartaField.setColumns(10);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRegistrati.setBounds(154, 395, 97, 25);
		contentPane.add(btnRegistrati);
	}

}
