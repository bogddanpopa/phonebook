package phonebook.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ManageAbonatView extends JFrame {

	private static final long serialVersionUID = 1714796412529153718L;

	private JPanel contentPane;
	private JTextField txtNume;
	private JTextField txtPrenume;
	private JTextField txtdn;
	private JTextField txtTelefon;
	private JButton btnAdauga;
	private JButton btnRenunta;



	public ManageAbonatView() {
		setResizable(false);
		setTitle("Adaugare/Editare Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume:");
		lblNume.setBounds(10, 28, 46, 14);
		contentPane.add(lblNume);
		
		txtNume = new JTextField();
		txtNume.setBounds(80, 25, 279, 20);
		contentPane.add(txtNume);
		txtNume.setColumns(10);
		
		JLabel lblPrenume = new JLabel("Prenume:");
		lblPrenume.setBounds(10, 53, 46, 14);
		contentPane.add(lblPrenume);
		
		txtPrenume = new JTextField();
		txtPrenume.setBounds(80, 50, 279, 20);
		contentPane.add(txtPrenume);
		txtPrenume.setColumns(10);
		
		JLabel lbldn = new JLabel("Data nasterii:");
		lbldn.setBounds(10, 78, 80, 14);
		contentPane.add(lbldn);
		
		txtdn = new JTextField();
		txtdn.setBounds(80, 75, 279, 20);
		contentPane.add(txtdn);
		txtdn.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(10, 103, 46, 14);
		contentPane.add(lblTelefon);
		
		txtTelefon = new JTextField();
		txtTelefon.setBounds(80, 100, 279, 20);
		contentPane.add(txtTelefon);
		txtTelefon.setColumns(10);
		
		btnAdauga = new JButton("Salveaza");
		btnAdauga.setBounds(101, 131, 89, 23);
		contentPane.add(btnAdauga);
		
		btnRenunta = new JButton("Renunta");
		btnRenunta.setBounds(200, 131, 89, 23);
		contentPane.add(btnRenunta);
		
		setVisible(true);
	}



	public JTextField getTxtNume() {
		return txtNume;
	}



	public JTextField getTxtPrenume() {
		return txtPrenume;
	}



	public JTextField getTxtdn() {
		return txtdn;
	}



	public JTextField getTxtTelefon() {
		return txtTelefon;
	}



	public JButton getBtnAdauga() {
		return btnAdauga;
	}



	public JButton getBtnRenunta() {
		return btnRenunta;
	}

}
