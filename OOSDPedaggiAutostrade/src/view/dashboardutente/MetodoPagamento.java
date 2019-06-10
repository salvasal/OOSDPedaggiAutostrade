package view.dashboardutente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestoreUtenteController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public class MetodoPagamento extends JFrame {

	private JPanel contentPane;
	private static String pedaggio;
	private static String username;
	private boolean check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetodoPagamento frame = new MetodoPagamento(pedaggio, username);
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
	public MetodoPagamento(String pedaggio, String username) {
		setTitle("Pagamento Pedaggio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 124);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInQualeModallit = new JLabel("In quale modallit\u00E0 desideri pagare il pedaggio autostradale?");
		lblInQualeModallit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInQualeModallit.setBounds(40, 11, 363, 25);
		contentPane.add(lblInQualeModallit);
		
		JButton btnContante = new JButton("Contante");
		btnContante.setForeground(Color.RED);
		btnContante.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnContante.setBounds(40, 47, 147, 25);
		contentPane.add(btnContante);
		btnContante.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e ) {
				new GestoreUtenteController().pagamentoContante(pedaggio);
				JOptionPane.showMessageDialog(null, "Pagamento avvenuto con successo! Chiudere la dashboard utente per visualizzare l'avvenuto pagamento!");
			}
		});
		
		JButton btnCartaDiCredito = new JButton("Carta di Credito");
		btnCartaDiCredito.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCartaDiCredito.setForeground(Color.RED);
		btnCartaDiCredito.setBounds(233, 47, 147, 25);
		contentPane.add(btnCartaDiCredito);
		btnCartaDiCredito.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				check = new GestoreUtenteController().pagamentoCarta(pedaggio, username);
				if (check) {
					JOptionPane.showMessageDialog(null, "Pagamento avvenuto con successo! Chiudere la dashboard utente per visualizzare l'avvenuto pagamento!");
				} else {
					dispose();
					Ricarica r = new Ricarica(pedaggio, username);
					r.setVisible(true);
				}
			}
		});
	}
}
