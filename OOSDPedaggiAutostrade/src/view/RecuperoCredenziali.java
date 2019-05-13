package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class RecuperoCredenziali {

	private JFrame frmRecuperoCredenziali;
	private JTextField usernameField;
	private JTextField recuperoCredenzialiField;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperoCredenziali window = new RecuperoCredenziali();
					window.frmRecuperoCredenziali.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecuperoCredenziali() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecuperoCredenziali = new JFrame();
		frmRecuperoCredenziali.setTitle("Recupero Credenziali");
		frmRecuperoCredenziali.setBounds(100, 100, 529, 338);
		frmRecuperoCredenziali.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecuperoCredenziali.getContentPane().setLayout(null);
		
		JLabel lblInserisciUsername = new JLabel("Inserisci la tua Username:");
		lblInserisciUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInserisciUsername.setBounds(170, 52, 175, 16);
		frmRecuperoCredenziali.getContentPane().add(lblInserisciUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(156, 80, 189, 36);
		frmRecuperoCredenziali.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblInserisciChiaveRecupero = new JLabel("Inserisci la tua Chiave di Recupero:");
		lblInserisciChiaveRecupero.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInserisciChiaveRecupero.setBounds(140, 139, 245, 16);
		frmRecuperoCredenziali.getContentPane().add(lblInserisciChiaveRecupero);
		
		recuperoCredenzialiField = new JTextField();
		recuperoCredenzialiField.setBounds(156, 167, 189, 36);
		frmRecuperoCredenziali.getContentPane().add(recuperoCredenzialiField);
		recuperoCredenzialiField.setColumns(10);
		
		JButton btnRecuperoCredenziali = new JButton("Recupero Credenziali");
		btnRecuperoCredenziali.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRecuperoCredenziali.setBounds(170, 245, 163, 36);
		frmRecuperoCredenziali.getContentPane().add(btnRecuperoCredenziali);
	}
}
