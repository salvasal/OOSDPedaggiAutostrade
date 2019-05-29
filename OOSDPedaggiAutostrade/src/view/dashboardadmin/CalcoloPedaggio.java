package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CalcoloPedaggio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcoloPedaggio frame = new CalcoloPedaggio();
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
	public CalcoloPedaggio() {
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
		
		JComboBox caselloEntrataComboBox = new JComboBox();
		caselloEntrataComboBox.setBounds(254, 52, 245, 22);
		contentPane.add(caselloEntrataComboBox);
		
		JLabel lblCoordinateCaselloUscita = new JLabel("Coordinate Casello Uscita:");
		lblCoordinateCaselloUscita.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCoordinateCaselloUscita.setBounds(46, 134, 180, 16);
		contentPane.add(lblCoordinateCaselloUscita);
		
		JComboBox caselloUscitaComboBox = new JComboBox();
		caselloUscitaComboBox.setBounds(254, 131, 245, 22);
		contentPane.add(caselloUscitaComboBox);
		
		JLabel lblNewLabel = new JLabel("Inserisci targa del veicolo dell'utente:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 200, 222, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox targaUtenteComboBox = new JComboBox();
		targaUtenteComboBox.setBounds(254, 197, 245, 22);
		contentPane.add(targaUtenteComboBox);
		
		JButton btnCalcolaPedaggio = new JButton("Calcola Pedaggio");
		btnCalcolaPedaggio.setBounds(218, 312, 169, 25);
		contentPane.add(btnCalcolaPedaggio);
	}
}
