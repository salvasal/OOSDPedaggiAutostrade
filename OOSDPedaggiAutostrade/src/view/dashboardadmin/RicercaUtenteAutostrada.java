package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class RicercaUtenteAutostrada extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RicercaUtenteAutostrada frame = new RicercaUtenteAutostrada();
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
	public RicercaUtenteAutostrada() {
		setTitle("Filtra per Utente ed Autostrada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserisciAutostrada = new JLabel("Inserisci Autostrada");
		lblInserisciAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInserisciAutostrada.setBounds(37, 35, 145, 16);
		contentPane.add(lblInserisciAutostrada);
		
		JComboBox autostradaComboBox = new JComboBox();
		autostradaComboBox.setBounds(236, 31, 177, 27);
		contentPane.add(autostradaComboBox);
		
		JLabel lblInserisciUtente = new JLabel("Inserisci un Utente");
		lblInserisciUtente.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInserisciUtente.setBounds(37, 108, 145, 16);
		contentPane.add(lblInserisciUtente);
		
		JComboBox usernameComboBox = new JComboBox();
		usernameComboBox.setBounds(236, 104, 177, 27);
		contentPane.add(usernameComboBox);
		
		JButton btnProcedi = new JButton("Procedi");
		btnProcedi.setForeground(Color.RED);
		btnProcedi.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnProcedi.setBounds(236, 175, 177, 29);
		contentPane.add(btnProcedi);
	}
}
