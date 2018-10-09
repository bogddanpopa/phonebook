package phonebook.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import phonebook.view.RegisterView;

public class RegisterController extends RegisterView implements ActionListener {
	

	private static final long serialVersionUID = 8156561424352100839L;
	
	public RegisterController() {
		
		getBtnCancel().addActionListener(this);
		getBtnRegister().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getBtnCancel())) {
			dispose();
		}else if (e.getSource().equals(getBtnRegister())) {
			if (getTxtRegCode().getText().equals(Application.regCode)) {
				Application.makeFull();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Codul introdus este invalid.\n " +
											"Va rugam sa introduceti un cod de deblocare corect.", "Invalid code", JOptionPane.ERROR_MESSAGE);
				getTxtRegCode().setText("");
			}
		}
	}

}
