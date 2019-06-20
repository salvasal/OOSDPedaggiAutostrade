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

public class EliminaAutostrada extends JFrame {

	private JPanel contentPane;
	private String codiceSelected;
	private ArrayList<String> codicevarlist;
	private String[] codicevar;
	private static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminaAutostrada frame = new EliminaAutostrada(username);
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
	public EliminaAutostrada(String username) {
		setTitle("Elimina Autostrada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodiceAutostrada = new JLabel("Codice Autostrada:");
		lblCodiceAutostrada.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCodiceAutostrada.setBounds(24, 31, 143, 16);
		contentPane.add(lblCodiceAutostrada);
		
		codicevarlist = new AutostradaController().getIdautostradaByusername(username);
		codicevar = new String[codicevarlist.size()];
		JComboBox codiceComboBox = new JComboBox(codicevarlist.toArray(codicevar));
		codiceComboBox.setMaximumRowCount(30);
		codiceComboBox.setBounds(209, 28, 115, 22);
		contentPane.add(codiceComboBox);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnElimina.setBounds(127, 111, 125, 25);
		contentPane.add(btnElimina);
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				codiceSelected = codiceComboBox.getSelectedItem().toString();
				if(!codiceSelected.equals("")) {
					new AutostradaController().deleteautostrada(codiceSelected);
					JOptionPane.showMessageDialog(null,"Autostrada eliminata! Chiudere e riaprire la finestra inerente all'elenco delle autostrade");
				} else {
					JOptionPane.showMessageDialog(null,"Selezionare un'autostrada!");
				}
			}
		});
	}

}
