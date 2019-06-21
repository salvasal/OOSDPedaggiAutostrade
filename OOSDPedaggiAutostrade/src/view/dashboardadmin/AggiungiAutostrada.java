package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AutostradaController;
import model.components.Amministratore;
import model.components.Autostrada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AggiungiAutostrada extends JFrame {

	private JPanel contentPane;
	private JTextField codiceField;
	private JTextField nomeField;
	private JTextField lunghezzaField;
	private String[] tipoList = {"Collina", "Montagna"};
	private static Amministratore amministratore;
	private Integer lunghezza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggiungiAutostrada frame = new AggiungiAutostrada(amministratore);
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
	public AggiungiAutostrada(Amministratore amministratore) {
		setTitle("Aggiungi Autostrada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codice:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 36, 116, 16);
		contentPane.add(lblNewLabel);
		
		codiceField = new JTextField();
		codiceField.setBounds(209, 33, 116, 22);
		contentPane.add(codiceField);
		codiceField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNome.setBounds(12, 79, 81, 16);
		contentPane.add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBounds(209, 76, 116, 22);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 121, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JComboBox tipoComboBox = new JComboBox(tipoList);
		tipoComboBox.setBounds(209, 118, 116, 22);
		contentPane.add(tipoComboBox);
		
		JLabel lblLunghezza = new JLabel("Lunghezza:");
		lblLunghezza.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLunghezza.setBounds(12, 160, 137, 16);
		contentPane.add(lblLunghezza);
		
		lunghezzaField = new JTextField();
		lunghezzaField.setBounds(209, 153, 116, 22);
		contentPane.add(lunghezzaField);
		lunghezzaField.setColumns(10);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAggiungi.setBounds(153, 224, 97, 25);
		contentPane.add(btnAggiungi);
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				lunghezza = Integer.parseInt(lunghezzaField.getText());
				Autostrada a = new Autostrada(codiceField.getText(), nomeField.getText(), tipoComboBox.getSelectedItem().toString(), null, null, amministratore.getUsername());
				new AutostradaController().setAutostrada(a, lunghezza);
				JOptionPane.showMessageDialog(null, "Autostrada inserita. Chiudere e riaprire la finestra inerente alla lista autostrade");
			}
		});
	}
}
