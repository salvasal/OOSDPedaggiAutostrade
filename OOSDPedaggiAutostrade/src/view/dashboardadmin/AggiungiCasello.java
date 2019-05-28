package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class AggiungiCasello extends JFrame {

	private JPanel contentPane;
	private JTextField coordinateField;
	private JTextField nomeCaselloField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggiungiCasello frame = new AggiungiCasello();
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
	public AggiungiCasello() {
		setTitle("Aggiungi un Casello");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 380);
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
		
		JLabel lblCodiceAutostrada = new JLabel("Codice Autostrada");
		lblCodiceAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCodiceAutostrada.setBounds(35, 163, 121, 16);
		contentPane.add(lblCodiceAutostrada);
		
		JComboBox codiceAutostradaComboBox = new JComboBox();
		codiceAutostradaComboBox.setBounds(189, 159, 189, 27);
		contentPane.add(codiceAutostradaComboBox);
		
		JLabel lblKm = new JLabel("Km");
		lblKm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKm.setBounds(35, 239, 61, 16);
		contentPane.add(lblKm);
		
		JComboBox kmComboBox = new JComboBox();
		kmComboBox.setBounds(189, 235, 189, 27);
		contentPane.add(kmComboBox);
		
		JButton btnAggiungiCasello = new JButton("Aggiungi Casello");
		btnAggiungiCasello.setForeground(Color.RED);
		btnAggiungiCasello.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAggiungiCasello.setBounds(189, 304, 189, 35);
		contentPane.add(btnAggiungiCasello);
		
	}
}
