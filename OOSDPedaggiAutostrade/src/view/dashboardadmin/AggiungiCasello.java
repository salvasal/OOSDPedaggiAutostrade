package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AutostradaController;
import model.components.Casello;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class AggiungiCasello extends JFrame {

	private JPanel contentPane;
	private JTextField coordinateField;
	private JTextField nomeCaselloField;
	private static String ID;
	private ArrayList<Integer> kmvarlist;
	private Integer[] kmvar;
	private Casello c;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggiungiCasello frame = new AggiungiCasello(ID);
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
	public AggiungiCasello(String ID) {
		setTitle("Aggiungi un Casello");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoordinate = new JLabel("Coordinate");
		lblCoordinate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCoordinate.setBounds(35, 30, 81, 16);
		contentPane.add(lblCoordinate);
		
		coordinateField = new JTextField();
		coordinateField.setBounds(189, 16, 189, 35);
		contentPane.add(coordinateField);
		coordinateField.setColumns(10);
		
		JLabel lblNomeCasello = new JLabel("Nome del Casello");
		lblNomeCasello.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNomeCasello.setBounds(35, 92, 121, 16);
		contentPane.add(lblNomeCasello);
		
		nomeCaselloField = new JTextField();
		nomeCaselloField.setBounds(189, 78, 189, 35);
		contentPane.add(nomeCaselloField);
		nomeCaselloField.setColumns(10);
		
		JLabel lblKm = new JLabel("Km");
		lblKm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKm.setBounds(35, 152, 61, 16);
		contentPane.add(lblKm);
		
		kmvarlist = new AutostradaController().getkmbyID(ID);
		kmvar = new Integer[kmvarlist.size()];
		JComboBox kmComboBox = new JComboBox(kmvarlist.toArray(kmvar));
		kmComboBox.setMaximumRowCount(20);
		kmComboBox.setBounds(189, 148, 189, 27);
		contentPane.add(kmComboBox);
		
		JButton btnAggiungiCasello = new JButton("Aggiungi Casello");
		btnAggiungiCasello.setForeground(Color.RED);
		btnAggiungiCasello.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAggiungiCasello.setBounds(189, 208, 189, 35);
		contentPane.add(btnAggiungiCasello);
		btnAggiungiCasello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = new Casello(coordinateField.getText(), nomeCaselloField.getText(), Integer.parseInt(kmComboBox.getSelectedItem().toString()), ID);
				new AutostradaController().setCasello(c);
				JOptionPane.showMessageDialog(null,"Casello inserito con successo!");
			}
		});
		
	}
}
