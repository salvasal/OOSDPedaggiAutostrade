package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.components.Utente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;

public class Registrazione extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField luogonField;
	private JTextField datanField;
	private JTextField telefonoField;
	private JTextField cartaField;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String luogon;
	private String datan;
	private String telefono;
	private String carta;
	

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(12, 41, 82, 16);
		contentPane.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(135, 39, 116, 22);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(12, 68, 82, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(135, 66, 116, 22);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 95, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		nomeField = new JTextField();
		nomeField.setBounds(135, 93, 116, 22);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCogome = new JLabel("Cognome:");
		lblCogome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCogome.setBounds(12, 122, 82, 16);
		contentPane.add(lblCogome);
		
		cognomeField = new JTextField();
		cognomeField.setBounds(135, 120, 116, 22);
		contentPane.add(cognomeField);
		cognomeField.setColumns(10);
		
		JLabel lblLuogoDiNascita = new JLabel("Luogo di nascita:");
		lblLuogoDiNascita.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLuogoDiNascita.setBounds(12, 149, 154, 16);
		contentPane.add(lblLuogoDiNascita);
		
		luogonField = new JTextField();
		luogonField.setBounds(135, 147, 116, 22);
		contentPane.add(luogonField);
		luogonField.setColumns(10);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita:");
		lblDataDiNascita.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDataDiNascita.setBounds(12, 176, 135, 16);
		contentPane.add(lblDataDiNascita);
		
		datanField = new JTextField();
		datanField.setBounds(135, 174, 116, 22);
		contentPane.add(datanField);
		datanField.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTelefono.setBounds(12, 203, 56, 16);
		contentPane.add(lblTelefono);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(135, 201, 116, 22);
		contentPane.add(telefonoField);
		telefonoField.setColumns(10);
		
		JLabel lblCartaDiCredito = new JLabel("Carta di credito:");
		lblCartaDiCredito.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCartaDiCredito.setBounds(12, 227, 135, 16);
		contentPane.add(lblCartaDiCredito);
		
		cartaField = new JTextField();
		cartaField.setBounds(135, 225, 116, 22);
		contentPane.add(cartaField);
		cartaField.setColumns(10);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRegistrati.setBounds(145, 268, 97, 25);
		contentPane.add(btnRegistrati);
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				username=usernameField.getText();
				password=passwordField.getText();
				nome=nomeField.getText();
				cognome=cognomeField.getText();
				luogon=luogonField.getText();
				datan=datanField.getText();
				telefono=telefonoField.getText();
				carta=cartaField.getText();
				if(!username.equals("") && !password.equals("") && !nome.equals("") && !cognome.equals("") && !luogon.equals("") && !datan.equals("") && !telefono.equals("") && !carta.equals("")) {
					Utente u = new Utente (username, password, null, nome, cognome, luogon, datan, telefono, carta);
					String chiave = new LoginController().setUtente(u);
					JOptionPane.showMessageDialog(null,"Utente aggiunto con successo! Chiave di recupero:" +chiave);
				} else JOptionPane.showMessageDialog(null, "Uno dei campi non e stato riempito");
			}
		});
	}

}
