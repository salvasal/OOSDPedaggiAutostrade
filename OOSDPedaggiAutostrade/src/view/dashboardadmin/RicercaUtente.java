package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestoreAdminController;
import model.components.Utente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

public class RicercaUtente extends JFrame {

	private JPanel contentPane;
	private String usernameSelected;
	private ArrayList<String> usernamevarlist;
	private String[] usernamevar;
	private String u;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RicercaUtente frame = new RicercaUtente();
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
	public RicercaUtente() {
		setTitle("Ricerca un utente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelezionaUnUtente = new JLabel("Seleziona un utente:");
		lblSelezionaUnUtente.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSelezionaUnUtente.setBounds(12, 26, 119, 16);
		contentPane.add(lblSelezionaUnUtente);
		
		usernamevarlist = new GestoreAdminController().getUtente();
		usernamevar = new String[usernamevarlist.size()];
		JComboBox<String> usernameComboBox = new JComboBox(usernamevarlist.toArray(usernamevar));
		usernameComboBox.setMaximumRowCount(50);
		usernameComboBox.setBounds(167, 23, 130, 22);
		contentPane.add(usernameComboBox);
		
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCerca.setBounds(12, 55, 97, 25);
		contentPane.add(btnCerca);
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//generazione della label al onClick
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setBounds(12, 93, 500, 20);
				contentPane.add(lblNewLabel_1);
				
				//restituisce la stringa da mostrare tramite la label sopra dichiarata
				usernameSelected = usernameComboBox.getSelectedItem().toString();
				u = new GestoreAdminController().getUtentebyUsername(usernameSelected);
				lblNewLabel_1.setText(u);
				
				
				
				
				
			} 
		});
		
		JList list = new JList();
		list.setBounds(12, 168, 678, 272);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Veicoli di sua propriet\u00E0:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 139, 157, 16);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	}
}
