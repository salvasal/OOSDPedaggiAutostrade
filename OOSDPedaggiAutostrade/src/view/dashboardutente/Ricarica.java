package view.dashboardutente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PedaggioController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class Ricarica extends JFrame {

	private JPanel contentPane;
	private static String pedaggio;
	private static String username;
	private Integer[] importo = {20, 50, 100};
	private Integer importoSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ricarica frame = new Ricarica(pedaggio, username);
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
	public Ricarica(String pedaggio, String username) {
		setTitle("Ricarica Carta di Credito");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImpossibileEffettuareIl = new JLabel("Impossibile effettuare il pagamento del Pedaggio! ");
		lblImpossibileEffettuareIl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImpossibileEffettuareIl.setBounds(10, 21, 414, 32);
		contentPane.add(lblImpossibileEffettuareIl);
		
		JLabel lblCreditoResiduoInsufficiente = new JLabel("Credito residuo insufficiente effettuare una ricarica!");
		lblCreditoResiduoInsufficiente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCreditoResiduoInsufficiente.setBounds(10, 46, 324, 32);
		contentPane.add(lblCreditoResiduoInsufficiente);
		
		JLabel lblImportoDaCaricare = new JLabel("Importo da caricare:");
		lblImportoDaCaricare.setBounds(10, 90, 179, 14);
		contentPane.add(lblImportoDaCaricare);
		
		JComboBox importoComboBox = new JComboBox(importo);
		importoComboBox.setBounds(137, 87, 116, 20);
		contentPane.add(importoComboBox);
		
		JButton btnRicaricaEProcedi = new JButton("Ricarica e procedi al Pagamento");
		btnRicaricaEProcedi.setForeground(Color.RED);
		btnRicaricaEProcedi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRicaricaEProcedi.setBounds(86, 132, 235, 32);
		contentPane.add(btnRicaricaEProcedi);
		btnRicaricaEProcedi.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e ) {
				importoSelected = Integer.parseInt(importoComboBox.getSelectedItem().toString());
				new PedaggioController().ricarica(importoSelected, pedaggio, username);
				JOptionPane.showMessageDialog(null, "Ricarica e Pagamento del pedaggio effettuati con successo! Chiudere e riaprire la Dashboard per verificare l'avvenuto pagamento del pedaggio");
				dispose();
			}
		});
	}
}
