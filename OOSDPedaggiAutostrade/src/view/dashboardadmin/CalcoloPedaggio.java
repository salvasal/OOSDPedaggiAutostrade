package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AutostradaController;
import controller.PedaggioController;
import controller.VeicoloController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class CalcoloPedaggio extends JFrame {

	private JPanel contentPane;
	private String coordinateSelectedentrata;
	private String coordinateSelecteduscita;
	private String targaSelected;
	private ArrayList<String> coordinateEntratavarlist;
	private ArrayList<String> coordinateUscitavarlist;
	private ArrayList<String> targavarlist;
	private String[] coordinateEntratavar;
	private String[] coordinateUscitavar;
	private String[] targavar;
	private static String username;
	private static String codice;
	private static String usernameutente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcoloPedaggio frame = new CalcoloPedaggio(codice, usernameutente);
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
	public CalcoloPedaggio(String codice, String usernameutente) {
		setTitle("Calcolo Pedaggio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCaselloEntrata = new JLabel("Coordinate Casello Entrata:");
		lblCaselloEntrata.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCaselloEntrata.setBounds(46, 55, 180, 16);
		contentPane.add(lblCaselloEntrata);
		
		coordinateEntratavarlist = new AutostradaController().getCoordinatecaselliBycodiceAutostrada(username, codice);
		coordinateEntratavar = new String[coordinateEntratavarlist.size()];
		JComboBox caselloEntrataComboBox = new JComboBox(coordinateEntratavarlist.toArray(coordinateEntratavar));
		caselloEntrataComboBox.setBounds(254, 52, 245, 22);
		contentPane.add(caselloEntrataComboBox);
		
		JLabel lblCoordinateCaselloUscita = new JLabel("Coordinate Casello Uscita:");
		lblCoordinateCaselloUscita.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCoordinateCaselloUscita.setBounds(46, 134, 180, 16);
		contentPane.add(lblCoordinateCaselloUscita);
		
		coordinateUscitavarlist = new AutostradaController().getCoordinatecaselliBycodiceAutostrada(username, codice);
		coordinateUscitavar = new String[coordinateUscitavarlist.size()];
		JComboBox caselloUscitaComboBox = new JComboBox(coordinateUscitavarlist.toArray(coordinateUscitavar));
		caselloUscitaComboBox.setBounds(254, 131, 245, 22);
		contentPane.add(caselloUscitaComboBox);
		
		JLabel lblNewLabel = new JLabel("Inserisci targa del veicolo dell'utente:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 200, 222, 16);
		contentPane.add(lblNewLabel);
		
		targavarlist = new VeicoloController().getVeicolibyUsername(usernameutente);
		targavar = new String[targavarlist.size()];
		JComboBox targaUtenteComboBox = new JComboBox(targavarlist.toArray(targavar));
		targaUtenteComboBox.setBounds(254, 197, 245, 22);
		contentPane.add(targaUtenteComboBox);
		
		JButton btnCalcolaPedaggio = new JButton("Calcola Pedaggio");
		btnCalcolaPedaggio.setBounds(218, 312, 169, 25);
		contentPane.add(btnCalcolaPedaggio);
		btnCalcolaPedaggio.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				targaSelected = targaUtenteComboBox.getSelectedItem().toString();
				coordinateSelectedentrata = caselloEntrataComboBox.getSelectedItem().toString();
				coordinateSelecteduscita = caselloUscitaComboBox.getSelectedItem().toString();
				if(!targaSelected.equals("") && !coordinateSelectedentrata.equals("") && !coordinateSelecteduscita.equals("")) {
					//Per l'anno 2021, basta richiamare il metodo setPedaggiowithOneri presente nella classe GestoreAdminController al posto di setPedaggio
					new PedaggioController().setPedaggio(targaSelected, coordinateSelectedentrata, coordinateSelecteduscita);
					JOptionPane.showMessageDialog(null, "Pedaggio inserito ed inviato alla dashboard dell'utente!");
				} else JOptionPane.showMessageDialog(null, "Selezionare gli elementi!");
			}
		});
	}
}
