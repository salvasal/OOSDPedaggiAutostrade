package view.dashboardutente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.VeicoloController;
import model.components.Utente;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MyVeicoli extends JFrame {

	private JPanel contentPane;
	private static Utente utente;
	private JTextField targaField;
	private DefaultListModel lista;
	private String targa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyVeicoli frame = new MyVeicoli(utente);
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
	public MyVeicoli(Utente utente) {
		setTitle("I miei veicoli");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIMieiVeicoli = new JLabel("I miei veicoli:");
		lblIMieiVeicoli.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIMieiVeicoli.setBounds(10, 11, 94, 24);
		contentPane.add(lblIMieiVeicoli);
		
		JButton btnAggiungiVeicolo = new JButton("Aggiungi Veicolo");
		btnAggiungiVeicolo.setBounds(122, 13, 131, 23);
		contentPane.add(btnAggiungiVeicolo);
		btnAggiungiVeicolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewVeicolo nv = new NewVeicolo(utente);
				nv.setVisible(true);
			}
		});
		
		JLabel lblTarga = new JLabel("Targa: ");
		lblTarga.setBounds(268, 17, 46, 14);
		contentPane.add(lblTarga);
		
		targaField = new JTextField();
		targaField.setBounds(310, 14, 86, 20);
		contentPane.add(targaField);
		targaField.setColumns(10);
		
		JButton btnEliminaVeicolo = new JButton("Elimina Veicolo");
		btnEliminaVeicolo.setBounds(411, 13, 133, 23);
		contentPane.add(btnEliminaVeicolo);
		btnEliminaVeicolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				targa = targaField.getText();
				if(!targa.equals("")) {
					new VeicoloController().deleteVeicolo(targa);
					JOptionPane.showMessageDialog(null, "Veicolo eliminato! Chiudere e riaprire la finestra inerente alla gestione dei veicoli");
				} else JOptionPane.showMessageDialog(null, "Inserire la targa del Veicolo da eliminare");
			}
		});
		
		lista = new VeicoloController().getVeicoli(utente);
		JList list = new JList(lista);
		list.setBounds(12, 54, 737, 196);
		JScrollPane scrollablelist = new JScrollPane(list);
		contentPane.add(list);
	}

}
