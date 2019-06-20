package view.dashboardadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.AutostradaController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class GestoreCaselli extends JFrame {

	private JPanel contentPane;
	private static String ID;
	private DefaultListModel lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestoreCaselli frame = new GestoreCaselli(ID);
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
	public GestoreCaselli(String ID) {
		setTitle("Visualizza Caselli");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Caselli dell'autostrada "+ID+":");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(12, 0, 367, 34);
		contentPane.add(lblNewLabel);
		
		lista = new AutostradaController().getCasellibyIDautostrada(ID);
		JList list = new JList(lista);
		list.setBounds(12, 31, 609, 395);
		JScrollPane scrollablelist = new JScrollPane(list);
		contentPane.add(list);
	}

}
