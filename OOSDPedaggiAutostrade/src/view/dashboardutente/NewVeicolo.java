package view.dashboardutente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestoreUtenteController;
import model.components.Veicolo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class NewVeicolo extends JFrame {

	private JPanel contentPane;
	private JTextField targaField;
	private JTextField marcaField;
	private JTextField modelloField;
	private JTextField pesoField;
	private JTextField altezzaField;
	private JTextField immatricolazioneField;
	private JTextField co2Field;
	private static String username;
	private Integer[] assi = {2,3,4,5};
	private String targa;
	private String marca;
	private String modello;
	private Integer peso;
	private Integer assiSelected;
	private Integer altezza;
	private Integer anno;
	private Integer qtaco2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewVeicolo frame = new NewVeicolo(username);
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
	public NewVeicolo(String username) {
		setTitle("Aggiungi un Veicolo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTarga = new JLabel("Targa");
		lblTarga.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTarga.setBounds(35, 44, 61, 16);
		contentPane.add(lblTarga);
		
		targaField = new JTextField();
		targaField.setBounds(198, 39, 207, 26);
		contentPane.add(targaField);
		targaField.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMarca.setBounds(35, 94, 61, 16);
		contentPane.add(lblMarca);
		
		marcaField = new JTextField();
		marcaField.setBounds(198, 89, 207, 26);
		contentPane.add(marcaField);
		marcaField.setColumns(10);
		
		JLabel lblModello = new JLabel("Modello");
		lblModello.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblModello.setBounds(35, 147, 61, 16);
		contentPane.add(lblModello);
		
		modelloField = new JTextField();
		modelloField.setBounds(198, 142, 207, 26);
		contentPane.add(modelloField);
		modelloField.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso (Kg)");
		lblPeso.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPeso.setBounds(35, 200, 74, 16);
		contentPane.add(lblPeso);
		
		pesoField = new JTextField();
		pesoField.setBounds(198, 195, 207, 26);
		contentPane.add(pesoField);
		pesoField.setColumns(10);
		
		JLabel lblAltezza = new JLabel("Altezza (Cm)");
		lblAltezza.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAltezza.setBounds(35, 316, 83, 16);
		contentPane.add(lblAltezza);
		
		altezzaField = new JTextField();
		altezzaField.setBounds(198, 311, 207, 26);
		contentPane.add(altezzaField);
		altezzaField.setColumns(10);
		
		JLabel lblAnnoImmatricolazione = new JLabel("Anno Immatricolazione");
		lblAnnoImmatricolazione.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAnnoImmatricolazione.setBounds(35, 373, 155, 16);
		contentPane.add(lblAnnoImmatricolazione);
		
		immatricolazioneField = new JTextField();
		immatricolazioneField.setBounds(198, 368, 207, 26);
		contentPane.add(immatricolazioneField);
		immatricolazioneField.setColumns(10);
		
		JLabel lblQuantitaCo2 = new JLabel("Quantita' CO2 (g/Km)");
		lblQuantitaCo2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblQuantitaCo2.setBounds(35, 418, 155, 16);
		contentPane.add(lblQuantitaCo2);
		
		co2Field = new JTextField();
		co2Field.setBounds(198, 413, 207, 26);
		contentPane.add(co2Field);
		co2Field.setColumns(10);
		
		JLabel lblNumeroAssi = new JLabel("Numero di Assi");
		lblNumeroAssi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNumeroAssi.setBounds(35, 260, 107, 16);
		contentPane.add(lblNumeroAssi);
		
		JComboBox assiComboBox = new JComboBox(assi);
		assiComboBox.setBounds(198, 256, 207, 27);
		contentPane.add(assiComboBox);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAggiungi.setBounds(112, 463, 196, 42);
		contentPane.add(btnAggiungi);
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				targa = targaField.getText();
				marca = marcaField.getText();
				modello = modelloField.getText();
				peso = Integer.parseInt(pesoField.getText());
				assiSelected = Integer.parseInt(assiComboBox.getSelectedItem().toString());
				altezza = Integer.parseInt(altezzaField.getText());
				anno = Integer.parseInt(immatricolazioneField.getText());
				qtaco2 = Integer.parseInt(co2Field.getText());
				
				if(!targa.equals("") && !marca.equals("") && !modello.equals("") && (peso != 0 || peso != null) && 
					(assiSelected != 0 || assiSelected != null) && (altezza != 0 || altezza != null) && (anno != 0 || anno != null) && 
					!qtaco2.equals("")) {
						Veicolo v = new Veicolo(targa,marca,modello,peso,assiSelected,altezza,anno,null,qtaco2,null,username);
						new GestoreUtenteController().setVeicolo(v);
						JOptionPane.showMessageDialog(null, "Il veicolo e' stato aggiunto correttamente. Chiudi e riapri ;a finestra inerente ai veicoli.");
				} else { 
					JOptionPane.showMessageDialog(null,"Uno dei campi non risulta compilato. Riempire tutti i campi.");
				}
			}
		});
	}
}
