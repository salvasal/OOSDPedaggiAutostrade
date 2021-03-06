package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.components.Amministratore;
import view.Login;
import view.dashboardadmin.NewAdmin;
import view.dashboardadmin.RicercaUtente;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;

public class DashboardAdmin extends JFrame {

	private JPanel contentPane;
	private static Amministratore amministratore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardAdmin frame = new DashboardAdmin(amministratore);
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
	public DashboardAdmin(Amministratore amministratore) {
		setTitle("Dashboard Amministratore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAggiungiAmministratore = new JButton("Aggiungi un nuovo Amministratore");
		btnAggiungiAmministratore.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAggiungiAmministratore.setBounds(114, 67, 255, 39);
		contentPane.add(btnAggiungiAmministratore);
		btnAggiungiAmministratore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAdmin na = new NewAdmin();
				na.setVisible(true);
			}
		});
		
		JButton btnGestisciTariffeOneri = new JButton("Gestisci Tariffe e Oneri");
		btnGestisciTariffeOneri.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGestisciTariffeOneri.setBounds(114, 117, 255, 39);
		contentPane.add(btnGestisciTariffeOneri);
		btnGestisciTariffeOneri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyTariffe mt = new MyTariffe();
				mt.setVisible(true);
			}
		});
		
		JButton btnCercaUtente = new JButton("Cerca un Utente");
		btnCercaUtente.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCercaUtente.setBounds(114, 169, 255, 39);
		contentPane.add(btnCercaUtente);
		btnCercaUtente.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				RicercaUtente ru = new RicercaUtente();
				ru.setVisible(true);
			}
		});
		
		JButton btnCalcolaPedaggio = new JButton("Calcola un Pedaggio Autostradale");
		btnCalcolaPedaggio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCalcolaPedaggio.setBounds(114, 219, 255, 39);
		contentPane.add(btnCalcolaPedaggio);
		btnCalcolaPedaggio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RicercaUtenteAutostrada rua = new RicercaUtenteAutostrada(amministratore);
				rua.setVisible(true);
			}
		});
		
		JButton btnGestisciAutostrada = new JButton("Gestisci Autostrada");
		btnGestisciAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGestisciAutostrada.setBounds(114, 269, 255, 39);
		contentPane.add(btnGestisciAutostrada);
		btnGestisciAutostrada.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				GestoreAutostrada ga = new GestoreAutostrada(amministratore);
				ga.setVisible(true);	
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.RED);
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(114, 319, 255, 39);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Bentornato "+amministratore.getUsername());
		lblNewLabel.setBounds(10, 21, 147, 22);
		contentPane.add(lblNewLabel);
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e ) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
	}
}
