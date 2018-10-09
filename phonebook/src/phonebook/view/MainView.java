package phonebook.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;     
import javax.swing.JScrollPane;
import javax.swing.JTable; 
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

import javax.swing.ListSelectionModel;


public class MainView extends JFrame{

	private static final long serialVersionUID = 5762811609519082348L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;
	private JPanel pnlAds;
	private JLabel lblReclama;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAdauga;
	private JMenuItem mntmSterge;
	private JMenuItem mntmModifica;
	private JMenuItem mntmInregistrare;
	private JMenuItem mntmAbout;
	private JButton btnAdauga;
	private JButton btnSterge;
	private JButton btnModifica;
	private JRadioButton rdbtnNume;
	private JRadioButton rdbtnPrenume;
	private JRadioButton rdbtndn;
	private JRadioButton rdbtnTelefon;
	private static DefaultTableModel model;



	@SuppressWarnings("serial")
	public MainView() {
		setTitle("Phonebook v1.2 [Unregistered version!]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('f');
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.setMnemonic('o');
		mntmOpen.setEnabled(false);
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.setMnemonic('s');
		mntmSave.setEnabled(false);
		mnFile.add(mntmSave);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		mntmExit = new JMenuItem("Iesire");
		mntmExit.setMnemonic('i');
		mnFile.add(mntmExit);
		
		JMenu mnAbonati = new JMenu("Abonati");
		mnAbonati.setMnemonic('a');
		menuBar.add(mnAbonati);
		
		mntmAdauga = new JMenuItem("Adauga");
		mntmAdauga.setMnemonic('a');
		mnAbonati.add(mntmAdauga);
		
		mntmSterge = new JMenuItem("Sterge");
		mntmSterge.setMnemonic('s');
		mnAbonati.add(mntmSterge);
		
		mntmModifica = new JMenuItem("Modifica");
		mntmModifica.setMnemonic('m');
		mnAbonati.add(mntmModifica);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('h');
		menuBar.add(mnHelp);
		
		mntmInregistrare = new JMenuItem("Inregistrare");
		mntmInregistrare.setMnemonic('i');
		mnHelp.add(mntmInregistrare);
		
		JSeparator separator_1 = new JSeparator();
		mnHelp.add(separator_1);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.setMnemonic('a');
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnlAds = new JPanel();
		pnlAds.setPreferredSize(new Dimension(10, 100));
		pnlAds.setMinimumSize(new Dimension(10, 1));
		pnlAds.setBackground(Color.LIGHT_GRAY);
		contentPane.add(pnlAds, BorderLayout.SOUTH);
		pnlAds.setLayout(new BorderLayout(0, 0));
		
		lblReclama = new JLabel();
		lblReclama.setForeground(Color.GREEN);
		lblReclama.setHorizontalAlignment(SwingConstants.CENTER);
		pnlAds.add(lblReclama, BorderLayout.CENTER);
		
		JPanel pnlFunctions = new JPanel();
		pnlFunctions.setBackground(Color.LIGHT_GRAY);
		pnlFunctions.setPreferredSize(new Dimension(100, 10));
		contentPane.add(pnlFunctions, BorderLayout.WEST);
		pnlFunctions.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		btnAdauga = new JButton("Adauga");
		btnAdauga.setToolTipText("Adauga un nou abonat in baza de date");
		btnAdauga.setPreferredSize(new Dimension(80, 30));
		pnlFunctions.add(btnAdauga, "2, 4");
				
		btnModifica = new JButton("Modifica");
		btnModifica.setPreferredSize(new Dimension(71, 30));
		btnModifica.setToolTipText("Modifica abonatul selectat");
		pnlFunctions.add(btnModifica, "2, 6");
		
               
                btnSterge = new JButton("Sterge");
		btnSterge.setPreferredSize(new Dimension(65, 30));
		btnSterge.setToolTipText("Sterge abonatul selectat");
		pnlFunctions.add(btnSterge, "2, 8");
                
		JScrollPane pnlAbonati = new JScrollPane();
		pnlAbonati.setBackground(Color.PINK);
		contentPane.add(pnlAbonati, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		model.addColumn("Nume");
		model.addColumn("Prenume");
		model.addColumn("Data nasterii");
		model.addColumn("Telefon");
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		table.setModel(model);
		pnlAbonati.setViewportView(table);
		

		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 40));
		panel.setBackground(Color.GREEN);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSearchOptions = new JPanel();
		pnlSearchOptions.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout = (FlowLayout) pnlSearchOptions.getLayout();
		flowLayout.setVgap(0);
		pnlSearchOptions.setPreferredSize(new Dimension(10, 20));
		panel.add(pnlSearchOptions, BorderLayout.NORTH);
		
		JLabel lblCriteriuCautare = new JLabel("Criteriu Cautare:");
		lblCriteriuCautare.setForeground(Color.BLACK);
		pnlSearchOptions.add(lblCriteriuCautare);
		
		rdbtnNume = new JRadioButton("Nume");
		rdbtnNume.setForeground(Color.BLACK);
		rdbtnNume.setOpaque(false);
		pnlSearchOptions.add(rdbtnNume);
		
		rdbtnPrenume = new JRadioButton("Prenume");
		rdbtnPrenume.setOpaque(false);
		rdbtnPrenume.setForeground(Color.BLACK);
		pnlSearchOptions.add(rdbtnPrenume);
		
		//rdbtndn = new JRadioButton("Data nasterii");
		//rdbtndn.setOpaque(false);
		//rdbtndn.setForeground(Color.BLACK);
		//pnlSearchOptions.add(rdbtndn);
		
		rdbtnTelefon = new JRadioButton("Telefon");
		rdbtnTelefon.setOpaque(false);
		rdbtnTelefon.setForeground(Color.BLACK);
		pnlSearchOptions.add(rdbtnTelefon);
		
		ButtonGroup searchGroup = new ButtonGroup();
		searchGroup.add(rdbtnNume);
		searchGroup.add(rdbtnPrenume);
		//searchGroup.add(rdbtndn);
		searchGroup.add(rdbtnTelefon);
		
		txtSearch = new JTextField();
		txtSearch.setForeground(Color.BLUE);
		txtSearch.setBackground(Color.WHITE);
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setText("Cautare...");
		panel.add(txtSearch, BorderLayout.CENTER);
		txtSearch.setColumns(10);
		
	}
	
	public void removeAds()
	{
		remove(pnlAds);
		revalidate();
	}

	public JMenuItem getMntmOpen() {
		return mntmOpen;
	}

	public JMenuItem getMntmSave() {
		return mntmSave;
	}

	public JMenuItem getMntmExit() {
		return mntmExit;
	}

	public JMenuItem getMntmAdauga() {
		return mntmAdauga;
	}

	public JMenuItem getMntmSterge() {
		return mntmSterge;
	}

	public JMenuItem getMntmModifica() {
		return mntmModifica;
	}

	public JMenuItem getMntmInregistrare() {
		return mntmInregistrare;
	}

	public JMenuItem getMntmAbout() {
		return mntmAbout;
	}

	public JButton getBtnAdauga() {
		return btnAdauga;
	}

	public JButton getBtnSterge() {
		return btnSterge;
	}

	public JButton getBtnModifica() {
		return btnModifica;
	}

	public JRadioButton getRdbtnNume() {
		return rdbtnNume;
	}

	public JRadioButton getRdbtnPrenume() {
		return rdbtnPrenume;
	}

	//public JRadioButton getRdbtndn() {
	//	return rdbtndn;
	//}

	public JRadioButton getRdbtnTelefon() {
		return rdbtnTelefon;
	}

	public JLabel getLblReclama() {
		return lblReclama;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public static DefaultTableModel getModel() {
		return model;
	}

	public JTextField getTxtSearch() {
		return txtSearch;
	}


}
