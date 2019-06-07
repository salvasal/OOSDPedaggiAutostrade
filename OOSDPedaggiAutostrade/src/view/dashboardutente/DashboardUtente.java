package view.dashboardutente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.GestoreUtenteController;
import view.Login;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.List;

public class DashboardUtente extends JFrame {

	private JPanel contentPane;
	private static String username;
	private JTextField IDField;
	private DefaultListModel lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardUtente frame = new DashboardUtente(username);
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
	public DashboardUtente(String username) {
		setTitle("Dashboard Utente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.RED);
		btnLogout.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnLogout.setBounds(532, 11, 161, 39);
		contentPane.add(btnLogout);
		
		JLabel lblBentornato = new JLabel("Bentornato "+username);
		lblBentornato.setBounds(10, 11, 132, 22);
		contentPane.add(lblBentornato);
		
		JButton btnGestisciVeicoli = new JButton("Gestisci i tuoi Veicoli");
		btnGestisciVeicoli.setBounds(340, 11, 182, 41);
		contentPane.add(btnGestisciVeicoli);
		
		JLabel lblPedaggiDaPagare = new JLabel("Pedaggi da pagare:");
		lblPedaggiDaPagare.setBounds(10, 44, 151, 22);
		contentPane.add(lblPedaggiDaPagare);
		
		JButton btnStoricoPedaggi = new JButton("Storico Pedaggi");
		btnStoricoPedaggi.setBounds(532, 72, 161, 39);
		contentPane.add(btnStoricoPedaggi);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(557, 131, 46, 29);
		contentPane.add(lblId);
		
		IDField = new JTextField();
		IDField.setBounds(616, 127, 77, 39);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		JButton btnEffettuaPagamento = new JButton("Effettua Pagamento");
		btnEffettuaPagamento.setBounds(532, 177, 161, 39);
		contentPane.add(btnEffettuaPagamento);
		
		lista = new GestoreUtenteController().getPedagginonPagati(username);
		JList list = new JList(lista);
		list.setBounds(12, 72, 510, 278);
		JScrollPane scrollablelist = new JScrollPane(list);
		contentPane.add(list);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.setBounds(198, 11, 132, 39);
		contentPane.add(btnSaldo);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
	}
}
