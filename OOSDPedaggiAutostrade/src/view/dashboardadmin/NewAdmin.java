package view.dashboardadmin;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestoreAdminController;
import model.components.Amministratore;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField luogonField;
	private JTextField datanField;
	private JTextField telefonoField;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String luogon;
	private String datan;
	private String telefono;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAdmin frame = new NewAdmin();
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
	public NewAdmin() {
		setTitle("Nuovo Amministratore");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(167, 28, 116, 22);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(12, 31, 75, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(12, 60, 75, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(167, 57, 116, 22);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 89, 111, 16);
		contentPane.add(lblNewLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(167, 86, 116, 22);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(12, 118, 75, 16);
		contentPane.add(lblCognome);
		
		cognomeField = new JTextField();
		cognomeField.setBounds(167, 115, 116, 22);
		contentPane.add(cognomeField);
		cognomeField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Luogo di nascita:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 147, 111, 16);
		contentPane.add(lblNewLabel_1);
		
		luogonField = new JTextField();
		luogonField.setBounds(167, 144, 116, 22);
		contentPane.add(luogonField);
		luogonField.setColumns(10);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita:");
		lblDataDiNascita.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDataDiNascita.setBounds(12, 175, 99, 26);
		contentPane.add(lblDataDiNascita);
		
		datanField = new JTextField();
		datanField.setBounds(167, 179, 116, 22);
		contentPane.add(datanField);
		datanField.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTelefono.setBounds(12, 214, 75, 16);
		contentPane.add(lblTelefono);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(167, 211, 116, 22);
		contentPane.add(telefonoField);
		telefonoField.setColumns(10);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username=usernameField.getText();
				password=passwordField.getText();
				nome=nomeField.getText();
				cognome=cognomeField.getText();
				luogon=luogonField.getText();
				datan=datanField.getText();
				telefono=telefonoField.getText();
				if(!username.equals("") && !password.equals("") && !nome.equals("") && !cognome.equals("") && !luogon.equals("") && !datan.equals("") && !telefono.equals("")) {
					Amministratore a = new Amministratore (username, password, null, nome, cognome, luogon, datan, telefono);
					String chiave = new GestoreAdminController().setAmministratore(a);
					JOptionPane.showMessageDialog(null,"Amministratore aggiunto con successo! Chiave di recupero:" +chiave);
				} else JOptionPane.showMessageDialog(null,"Uno dei campi non è stato riempito");
			}
		});
		btnAggiungi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAggiungi.setBounds(153, 262, 130, 25);
		contentPane.add(btnAggiungi);
	}
}
