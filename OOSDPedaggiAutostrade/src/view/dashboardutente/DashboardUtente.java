package view.dashboardutente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.GestoreUtenzaController;
import controller.PedaggioController;
import model.components.Carta;
import model.components.Utente;
import view.Login;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.List;

public class DashboardUtente extends JFrame {

	private JPanel contentPane;
	private static Utente utente;
	private JTextField IDField;
	private DefaultListModel lista;
	private Carta c;
	private String ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardUtente frame = new DashboardUtente(utente);
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
	public DashboardUtente(Utente utente) {
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
		
		JLabel lblBentornato = new JLabel("Bentornato "+utente.getUsername());
		lblBentornato.setBounds(10, 11, 132, 22);
		contentPane.add(lblBentornato);
		
		JButton btnGestisciVeicoli = new JButton("Gestisci i tuoi Veicoli");
		btnGestisciVeicoli.setBounds(340, 11, 182, 41);
		contentPane.add(btnGestisciVeicoli);
		btnGestisciVeicoli.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e ) {
				MyVeicoli mv = new MyVeicoli(utente);
				mv.setVisible(true);
			}
		});
		
		JLabel lblPedaggiDaPagare = new JLabel("Pedaggi da pagare:");
		lblPedaggiDaPagare.setBounds(10, 44, 151, 22);
		contentPane.add(lblPedaggiDaPagare);
		
		JButton btnStoricoPedaggi = new JButton("Storico Pedaggi");
		btnStoricoPedaggi.setBounds(532, 72, 161, 39);
		contentPane.add(btnStoricoPedaggi);
		btnStoricoPedaggi.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e ) {
				MyPedaggi mp = new MyPedaggi(utente);
				mp.setVisible(true);
			}
		});
		
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
		btnEffettuaPagamento.addActionListener(new ActionListener() {
			public void actionPerformed ( ActionEvent e ) {
				ID = IDField.getText();
				if(!ID.equals("")) {
					MetodoPagamento mp = new MetodoPagamento(ID, utente);
					mp.setVisible(true);
				} else JOptionPane.showMessageDialog(null, "Inserire ID del Pedaggio che si desidera pagare");
			}
		});
		
		lista = new PedaggioController().getPedagginonPagati(utente);
		JList list = new JList(lista);
		list.setBounds(12, 72, 510, 278);
		JScrollPane scrollablelist = new JScrollPane(list);
		contentPane.add(list);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.setBounds(198, 11, 132, 39);
		contentPane.add(btnSaldo);
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e ) {
				c = new GestoreUtenzaController().getCarta(utente);
				JOptionPane.showMessageDialog(null, "IBAN: "+ c.getIban() +" Saldo: "+ c.getSaldo());
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
	}
}
