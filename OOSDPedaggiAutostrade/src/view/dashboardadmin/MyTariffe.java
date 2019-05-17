package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MyTariffe extends JFrame {

	private JPanel contentPane;
	private JTextField importoField;

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
		
		JComboBox categoriaComboBox = new JComboBox();
		categoriaComboBox.setBounds(285, 15, 155, 27);
		panelTariffe.add(categoriaComboBox);
		
		JLabel lblSelezionaTipoAutostrada = new JLabel("Seleziona la Tipologia di Autostrada");
		lblSelezionaTipoAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSelezionaTipoAutostrada.setBounds(23, 99, 230, 16);
		panelTariffe.add(lblSelezionaTipoAutostrada);
		
		JComboBox autostradaComboBox = new JComboBox();
		autostradaComboBox.setBounds(285, 95, 155, 27);
		panelTariffe.add(autostradaComboBox);
		
		JLabel lblInserisciImporto = new JLabel("Inserisci l'importo della tariffa");
		lblInserisciImporto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInserisciImporto.setBounds(23, 181, 230, 16);
		panelTariffe.add(lblInserisciImporto);
		
		importoField = new JTextField();
		importoField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		importoField.setBounds(290, 176, 150, 26);
		panelTariffe.add(importoField);
		importoField.setColumns(10);
		
		JButton btnApplica = new JButton("Applica ");
		btnApplica.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnApplica.setBounds(177, 264, 117, 35);
		panelTariffe.add(btnApplica);
		
		// componenti del pannello oneri
		
	}
}
