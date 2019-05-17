package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Login;
import view.NewAdmin;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class DashboardAdmin extends JFrame {

	private JPanel contentPane;
	private static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardAdmin frame = new DashboardAdmin(username);
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
	public DashboardAdmin(String username) {
		setTitle("Dashboard Amministratore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAggiungiAmministratore = new JButton("Aggiungi un nuovo Amministratore");
		btnAggiungiAmministratore.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAggiungiAmministratore.setBounds(114, 16, 255, 39);
		contentPane.add(btnAggiungiAmministratore);
		btnAggiungiAmministratore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAdmin na = new NewAdmin();
				na.setVisible(true);
			}
		});
		
		JButton btnGestisciTariffeOneri = new JButton("Gestisci Tariffe e Oneri");
		btnGestisciTariffeOneri.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGestisciTariffeOneri.setBounds(114, 67, 255, 39);
		contentPane.add(btnGestisciTariffeOneri);
		
		JButton btnCercaUtente = new JButton("Cerca un Utente");
		btnCercaUtente.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCercaUtente.setBounds(114, 125, 255, 39);
		contentPane.add(btnCercaUtente);
		
		JButton btnCalcolaPedaggio = new JButton("Calcola un Pedaggio Autostradale");
		btnCalcolaPedaggio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCalcolaPedaggio.setBounds(114, 176, 255, 39);
		contentPane.add(btnCalcolaPedaggio);
		
		JButton btnGestisciAutostrada = new JButton("Gestisci Autostrada");
		btnGestisciAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGestisciAutostrada.setBounds(114, 227, 255, 39);
		contentPane.add(btnGestisciAutostrada);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.RED);
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(114, 319, 255, 39);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e ) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
	}
}
