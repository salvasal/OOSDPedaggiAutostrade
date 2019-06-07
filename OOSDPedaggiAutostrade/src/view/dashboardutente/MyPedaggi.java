package view.dashboardutente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.GestoreUtenteController;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

public class MyPedaggi extends JFrame {

	private JPanel contentPane;
	private static String username;
	private DefaultListModel lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPedaggi frame = new MyPedaggi(username);
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
	public MyPedaggi(String username) {
		setTitle("Storico Pedaggi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblITuoiPedaggi = new JLabel("I tuoi pedaggi:");
		lblITuoiPedaggi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblITuoiPedaggi.setBounds(10, 11, 161, 24);
		contentPane.add(lblITuoiPedaggi);
		
		lista = new GestoreUtenteController().getPedaggi(username);
		JList list = new JList(lista);
		list.setBounds(12, 46, 462, 304);
		JScrollPane scrollablelist = new JScrollPane(list);
		contentPane.add(list);
	}

}
