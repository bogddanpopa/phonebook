package phonebook.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterView extends JFrame {

	
	private static final long serialVersionUID = -129647296202581907L;
	private JPanel contentPane;
	private JTextField txtRegCode;
	private JButton btnRegister;
	private JButton btnCancel;


	public RegisterView() {
		setResizable(false);
		setTitle("Phonebook registration");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 101);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrationCode = new JLabel("Registration code:");
		lblRegistrationCode.setBounds(10, 11, 88, 14);
		contentPane.add(lblRegistrationCode);
		
		txtRegCode = new JTextField();
		txtRegCode.setBounds(108, 8, 326, 20);
		contentPane.add(txtRegCode);
		txtRegCode.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(225, 39, 89, 25);
		contentPane.add(btnRegister);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(324, 39, 89, 25);
		contentPane.add(btnCancel);
		
		setVisible(true);
	}


	public JTextField getTxtRegCode() {
		return txtRegCode;
	}


	public void setTxtRegCode(JTextField txtRegCode) {
		this.txtRegCode = txtRegCode;
	}


	public JButton getBtnRegister() {
		return btnRegister;
	}


	public JButton getBtnCancel() {
		return btnCancel;
	}
}
