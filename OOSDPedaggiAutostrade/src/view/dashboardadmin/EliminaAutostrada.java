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

public class EliminaAutostrada extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminaAutostrada frame = new EliminaAutostrada();
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
	public EliminaAutostrada() {
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
		
		JComboBox codiceComboBox = new JComboBox();
		codiceComboBox.setBounds(209, 28, 115, 22);
		contentPane.add(codiceComboBox);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnElimina.setBounds(127, 111, 125, 25);
		contentPane.add(btnElimina);
	}

}
