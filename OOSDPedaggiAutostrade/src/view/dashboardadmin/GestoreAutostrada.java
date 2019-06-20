package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.AutostradaController;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class GestoreAutostrada extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Lista Autostrade d'appartenenza:");
	private JTextField autostradaField;
	private static String username;
	private DefaultListModel lista;
	private static String ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestoreAutostrada frame = new GestoreAutostrada(username);
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
	public GestoreAutostrada(String username) {
		setTitle("Gestione Autostrade");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1028, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAggiungiAutostrada = new JButton("Aggiungi Autostrada");
		btnAggiungiAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAggiungiAutostrada.setBounds(12, 26, 200, 49);
		contentPane.add(btnAggiungiAutostrada);
		btnAggiungiAutostrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiAutostrada aa = new AggiungiAutostrada(username);
				aa.setVisible(true);
			}
		});
		
		JButton btnEliminaAutostrada = new JButton("Elimina Autostrada");
		btnEliminaAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnEliminaAutostrada.setBounds(259, 26, 200, 49);
		contentPane.add(btnEliminaAutostrada);
		btnEliminaAutostrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminaAutostrada ea = new EliminaAutostrada(username);
				ea.setVisible(true);
			}
		});
		
		JButton btnAggiungiCasello = new JButton("Aggiungi Casello");
		btnAggiungiCasello.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAggiungiCasello.setBounds(508, 26, 200, 49);
		contentPane.add(btnAggiungiCasello);
		btnAggiungiCasello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = autostradaField.getText();
				if (!ID.equals("")) {
					AggiungiCasello ac = new AggiungiCasello(ID);
					ac.setVisible(true);
				} else { JOptionPane.showMessageDialog(null, "Inserire ID del autostrada"); }
			}
		});
		
		JButton btnEliminaCasello = new JButton("Elimina Casello");
		btnEliminaCasello.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnEliminaCasello.setBounds(752, 26, 200, 49);
		contentPane.add(btnEliminaCasello);
		btnEliminaCasello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = autostradaField.getText();
				if (!ID.equals("")) {
					EliminaCasello ec = new EliminaCasello(username ,ID);
					ec.setVisible(true);
				} else { JOptionPane.showMessageDialog(null, "Inserire ID del autostrada"); }
			}
		});
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(22, 88, 252, 36);
		contentPane.add(lblNewLabel);
		
		lista = new AutostradaController().getAutostradebyUsername(username);
		JList list = new JList(lista);
		list.setBounds(12, 129, 756, 284);
		JScrollPane scrollablelist = new JScrollPane(list);
		contentPane.add(list);
		
		
		autostradaField = new JTextField();
		autostradaField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		autostradaField.setBounds(883, 131, 69, 49);
		contentPane.add(autostradaField);
		autostradaField.setColumns(10);
		
		JButton btnVisualizzaCaselli = new JButton("Visualizza Caselli");
		btnVisualizzaCaselli.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisualizzaCaselli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = autostradaField.getText();
				if (!ID.equals("")) {
					GestoreCaselli gc = new GestoreCaselli(ID);
					gc.setVisible(true);
				} else { JOptionPane.showMessageDialog(null, "Inserire ID del autostrada"); }
			}
		});
		btnVisualizzaCaselli.setBounds(780, 193, 172, 59);
		contentPane.add(btnVisualizzaCaselli);
		
		JLabel lblNewLabel_1 = new JLabel("ID Autostrada:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(780, 132, 114, 47);
		contentPane.add(lblNewLabel_1);
	}
}
