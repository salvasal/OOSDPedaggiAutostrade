package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class GestoreAutostrada extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Lista Autostrade d'appartenenza:");
	private JTextField autostradField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestoreAutostrada frame = new GestoreAutostrada();
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
	public GestoreAutostrada() {
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
		
		JButton btnEliminaAutostrada = new JButton("Elimina Autostrada");
		btnEliminaAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnEliminaAutostrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminaAutostrada.setBounds(259, 26, 200, 49);
		contentPane.add(btnEliminaAutostrada);
		
		JButton btnAggiungiCasello = new JButton("Aggiungi Casello");
		btnAggiungiCasello.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAggiungiCasello.setBounds(508, 26, 200, 49);
		contentPane.add(btnAggiungiCasello);
		
		JButton btnEliminaCasello = new JButton("Elimina Casello");
		btnEliminaCasello.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnEliminaCasello.setBounds(752, 26, 200, 49);
		contentPane.add(btnEliminaCasello);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(22, 88, 252, 36);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(12, 129, 756, 284);
		contentPane.add(list);
		
		autostradField = new JTextField();
		autostradField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		autostradField.setBounds(883, 131, 69, 49);
		contentPane.add(autostradField);
		autostradField.setColumns(10);
		
		JButton btnVisualizzaCaselli = new JButton("Visualizza Caselli");
		btnVisualizzaCaselli.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisualizzaCaselli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
