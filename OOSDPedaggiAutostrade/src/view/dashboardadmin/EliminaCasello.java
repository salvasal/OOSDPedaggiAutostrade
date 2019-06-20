package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AutostradaController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class EliminaCasello extends JFrame {

	private JPanel contentPane;
	private String coordinateSelected;
	private ArrayList<String> coordinatevarlist;
	private String[] coordinatevar;
	private static String usernameAmministratore;
	private static String codiceAutostrada;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminaCasello frame = new EliminaCasello(usernameAmministratore, codiceAutostrada);
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
	public EliminaCasello(String usernameAmministratore, String codiceAutostrada) {
		setTitle("Elimina un Casello");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaCaselli = new JLabel("Lista Caselli");
		lblListaCaselli.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblListaCaselli.setBounds(28, 41, 89, 16);
		contentPane.add(lblListaCaselli);
		
		coordinatevarlist = new AutostradaController().getCoordinatecaselliBycodiceAutostrada(usernameAmministratore, codiceAutostrada); 
		coordinatevar = new String[coordinatevarlist.size()];
		JComboBox eliminaCaselloComboBox = new JComboBox(coordinatevarlist.toArray(coordinatevar));
		eliminaCaselloComboBox.setBounds(237, 37, 191, 27);
		contentPane.add(eliminaCaselloComboBox);
		
		JButton btnEliminaCasello = new JButton("Elimina Casello");
		btnEliminaCasello.setForeground(Color.RED);
		btnEliminaCasello.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnEliminaCasello.setBounds(237, 122, 162, 29);
		contentPane.add(btnEliminaCasello);
		btnEliminaCasello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coordinateSelected = eliminaCaselloComboBox.getSelectedItem().toString();
				if(!coordinateSelected.equals("")) {
					new AutostradaController().deletecasello(coordinateSelected);
					JOptionPane.showMessageDialog(null, "Il Casello e' stato eliminato! Chiudere e riaprire la finestra inerente all'elenco dei Caselli.");
				} else {
					JOptionPane.showMessageDialog(null, "Selezionare un Casello!");
				}
			}
		});
	}
	
}
