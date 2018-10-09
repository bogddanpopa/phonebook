package phonebook.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class AboutView extends JFrame {


	private static final long serialVersionUID = -5310991507448513276L;
	private JPanel contentPane;


	public AboutView() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("About Phonebook v1.2");
		setBounds(100, 100, 452, 137);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JEditorPane dtrpnAplicatiaPhonebookPermine = new JEditorPane();
		dtrpnAplicatiaPhonebookPermine.setDisabledTextColor(Color.BLACK);
		dtrpnAplicatiaPhonebookPermine.setText("Aplicatia Phonebook v1.1 permite organizarea numerelor de telefoane pentru diferite \r\npersoane. Aplicatia faciliteaza organizarea acestor persoane(abonati) intr-un mod \r\norganizat si ofera un modalitati de sortare si cautare a acestora.");
		dtrpnAplicatiaPhonebookPermine.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dtrpnAplicatiaPhonebookPermine.setEnabled(false);
		contentPane.add(dtrpnAplicatiaPhonebookPermine, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		panel.setPreferredSize(new Dimension(10, 30));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblAutor = new JLabel("Autor: ");
		panel.add(lblAutor);
		
		JLabel lblNumeAutor = new JLabel("Bogdan Popa");
		panel.add(lblNumeAutor);
		
		setVisible(true);
		
	}

}
