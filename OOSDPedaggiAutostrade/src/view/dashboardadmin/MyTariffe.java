package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PedaggioController;
import model.components.Oneri;
import model.components.Tariffa;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MyTariffe extends JFrame {

	private JPanel contentPane;
	private JTextField importoTariffeField;
	private JTextField importoOneriField;
	private String[] categoriaList = {"A", "B", "3", "4", "5"}; 
	private String[] autostradaList = {"Collina", "Montagna"};
	private String[] veicoloClasseList = {"1", "2", "3", "4", "5", "6"};
	private String importoOneri;
	private String veicoloClasseSelected;
	private Tariffa t;
	private Oneri o;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTariffe frame = new MyTariffe();
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
	public MyTariffe() {
		setTitle("Gestione Tariffe e Oneri");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTariffe = new JPanel();
		panelTariffe.setBounds(100, 100, 514, 419);
		contentPane.add(panelTariffe);
		panelTariffe.setLayout(null);
		panelTariffe.setVisible(false);
		
		JPanel panelOneri = new JPanel();
		panelOneri.setBounds(100, 100, 514, 419);
		contentPane.add(panelOneri);
		panelOneri.setLayout(null);
		panelOneri.setVisible(false);
		
		JButton btnGestisciTariffe = new JButton("Gestisci le Tariffe");
		btnGestisciTariffe.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnGestisciTariffe.setBounds(19, 16, 216, 35);
		contentPane.add(btnGestisciTariffe);
		btnGestisciTariffe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTariffe.setBounds(6, 63, 514, 419);
				panelTariffe.setVisible(true);
				panelOneri.setVisible(false);
				}
		});
		
		
		JButton btnGestisciOneri = new JButton("Gestisci gli Oneri Esterni");
		btnGestisciOneri.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnGestisciOneri.setBounds(247, 16, 216, 35);
		contentPane.add(btnGestisciOneri);
		btnGestisciOneri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOneri.setBounds(6, 63, 514, 419);
				panelTariffe.setVisible(false);
				panelOneri.setVisible(true);
			}	
		});
		
		
		// componenti del pannello tariffe
		
		
		JLabel lblSelezionaCategoria = new JLabel("Seleziona la Categoria del Veicolo");
		lblSelezionaCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSelezionaCategoria.setBounds(23, 19, 230, 16);
		panelTariffe.add(lblSelezionaCategoria);
		
		JComboBox categoriaComboBox = new JComboBox(categoriaList);
		categoriaComboBox.setBounds(285, 15, 155, 27);
		panelTariffe.add(categoriaComboBox);
		
		JLabel lblSelezionaTipoAutostrada = new JLabel("Seleziona la Tipologia di Autostrada");
		lblSelezionaTipoAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSelezionaTipoAutostrada.setBounds(23, 99, 230, 16);
		panelTariffe.add(lblSelezionaTipoAutostrada);
		
		JComboBox autostradaComboBox = new JComboBox(autostradaList);
		autostradaComboBox.setBounds(285, 95, 155, 27);
		panelTariffe.add(autostradaComboBox);
		
		JLabel lblInserisciImporto = new JLabel("Inserisci l'importo della tariffa");
		lblInserisciImporto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInserisciImporto.setBounds(23, 181, 230, 16);
		panelTariffe.add(lblInserisciImporto);
		
		importoTariffeField = new JTextField();
		importoTariffeField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		importoTariffeField.setBounds(290, 176, 150, 26);
		panelTariffe.add(importoTariffeField);
		importoTariffeField.setColumns(10);
		
		JButton btnApplicaTariffe = new JButton("Applica ");
		btnApplicaTariffe.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnApplicaTariffe.setBounds(177, 264, 117, 35);
		panelTariffe.add(btnApplicaTariffe);
		btnApplicaTariffe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = new Tariffa(categoriaComboBox.getSelectedItem().toString(), autostradaComboBox.getSelectedItem().toString(), importoTariffeField.getText());
				new PedaggioController().setTariffa(t);
				JOptionPane.showMessageDialog(null, "La Tariffa e' stata impostata");
			}
		});
		
		// componenti del pannello oneri
		
		JLabel lblSelezionaOneri = new JLabel("Seleziona la Classe Ambientale del Veicolo");
		lblSelezionaOneri.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSelezionaOneri.setBounds(23, 19, 230, 16);
		panelOneri.add(lblSelezionaOneri);
		
		JComboBox oneriComboBox = new JComboBox(veicoloClasseList);
		oneriComboBox.setBounds(285, 15, 155, 27);
		panelOneri.add(oneriComboBox);
		
		JLabel lblImporto = new JLabel("Inserisci l'importo degli Oneri");
		lblImporto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblImporto.setBounds(23, 99, 230, 16);
		panelOneri.add(lblImporto);
		
		importoOneriField = new JTextField();
		importoOneriField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		importoOneriField.setBounds(285, 95, 155, 27);
		panelOneri.add(importoOneriField);
		importoOneriField.setColumns(10);
		
		JButton btnApplicaOneri = new JButton("Applica ");
		btnApplicaOneri.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnApplicaOneri.setBounds(177, 264, 117, 35);
		panelOneri.add(btnApplicaOneri);
		btnApplicaOneri.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o = new Oneri(Integer.parseInt(oneriComboBox.getSelectedItem().toString()), importoOneriField.getText(), 0, 0);
				//importoOneri = importoOneriField.getText();
				//veicoloClasseSelected = oneriComboBox.getSelectedItem().toString();
				//if (!importoOneri.equals("") && !veicoloClasseSelected.equals("")) {
				new PedaggioController().setOneri(o);
				JOptionPane.showMessageDialog(null, "Gli Oneri sono stati impostati");
				//} else JOptionPane.showMessageDialog(null, "Uno dei campi non e' stato riempito oppure non e' stato selezionato");
				
				
			}
		});
		
	}
}
