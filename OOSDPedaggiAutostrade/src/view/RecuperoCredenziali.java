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

public class RecuperoCredenziali extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField ChiaveField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperoCredenziali frame = new RecuperoCredenziali();
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
	public RecuperoCredenziali() {
		setTitle("Recupero Credenziali");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserisciUsername = new JLabel("Inserisci il tuo Username:");
		lblInserisciUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInserisciUsername.setBounds(143, 22, 159, 16);
		contentPane.add(lblInserisciUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(131, 50, 182, 38);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblInserisciChiaveRecupero = new JLabel("Inserisci la tua Chiave di Recupero:");
		lblInserisciChiaveRecupero.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInserisciChiaveRecupero.setBounds(115, 100, 229, 16);
		contentPane.add(lblInserisciChiaveRecupero);
		
		ChiaveField = new JTextField();
		ChiaveField.setBounds(131, 129, 182, 38);
		contentPane.add(ChiaveField);
		ChiaveField.setColumns(10);
		
		JButton btnRecuperaCredenziali = new JButton("Recupera Credenziali");
		btnRecuperaCredenziali.setBounds(131, 213, 182, 29);
		contentPane.add(btnRecuperaCredenziali);
	}

}
