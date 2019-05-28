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
import java.awt.Color;

public class EliminaCasello extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminaCasello frame = new EliminaCasello();
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
	public EliminaCasello() {
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
		
		JComboBox eliminaCaselloComboBox = new JComboBox();
		eliminaCaselloComboBox.setBounds(237, 37, 162, 27);
		contentPane.add(eliminaCaselloComboBox);
		
		JButton btnEliminaCasello = new JButton("Elimina Casello");
		btnEliminaCasello.setForeground(Color.RED);
		btnEliminaCasello.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnEliminaCasello.setBounds(237, 122, 162, 29);
		contentPane.add(btnEliminaCasello);
	}
	

}
