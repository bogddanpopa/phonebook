package phonebook.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import phonebook.model.Abonat;
import phonebook.model.CarteDeTelefon;
import phonebook.view.AboutView;
import phonebook.view.MainView;

public class MainController implements ActionListener, ListSelectionListener, MouseListener, KeyListener, WindowListener, FocusListener {
	
	enum SearchState{
		Nume, 
		Prenume,
		dn, 
		Telefon
	}
	
	private MainView mview;
	Abonat ab1;
	Abonat ab2;
	private CarteDeTelefon carte;
	private String seldn;
	private int selRow;
	private String path = "error";
	SearchState searchState;
	
	
	public MainController(MainView mview){
		this.mview = mview;
		seldn = "";
		selRow = -1;
		mview.setVisible(true);
		setActionListeners();
		
		carte = new CarteDeTelefon();
		
		
		if (Application.registered) {
			Timer timer = new Timer();
			AutoSave autosaver = new AutoSave(carte, path);
			timer.scheduleAtFixedRate(autosaver, 5*60*1000, 5*60*1000);
		}
		
		mview.getRdbtnNume().setSelected(true);
		searchState = SearchState.Nume;
		    
		
	}
	
	private void setActionListeners(){
		mview.getMntmOpen().setActionCommand("Open");
		mview.getMntmOpen().addActionListener(this);
		mview.getMntmSave().setActionCommand("Save");
		mview.getMntmSave().addActionListener(this);
		mview.getMntmExit().setActionCommand("Exit");
		mview.getMntmExit().addActionListener(this);
		
		mview.getMntmAdauga().setActionCommand("Adauga");
		mview.getMntmAdauga().addActionListener(this);
		mview.getMntmSterge().setActionCommand("Sterge");
		mview.getMntmSterge().addActionListener(this);
		mview.getMntmModifica().setActionCommand("Modifica");
		mview.getMntmModifica().addActionListener(this);
		
		mview.getMntmInregistrare().setActionCommand("Inregistrare");
		mview.getMntmInregistrare().addActionListener(this);
		mview.getMntmAbout().setActionCommand("About");
		mview.getMntmAbout().addActionListener(this);
		
		mview.getBtnAdauga().addActionListener(this);
		mview.getBtnSterge().addActionListener(this);
		mview.getBtnModifica().addActionListener(this);
		
		mview.getRdbtnNume().addActionListener(this);
		mview.getRdbtnPrenume().addActionListener(this);
		mview.getRdbtnTelefon().addActionListener(this);
		
		mview.getTable().getSelectionModel().addListSelectionListener(this);
		mview.getTable().addMouseListener(this);
		mview.getTable().addKeyListener(this);
		
		mview.getTxtSearch().addFocusListener(this);
		mview.getTxtSearch().addKeyListener(this);
		
		mview.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Open")) {
			JFileChooser fc;
			fc = new JFileChooser();
			fc.setFileFilter(new FileNameExtensionFilter("Phonebook files","phb"));
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				path = fc.getSelectedFile().getPath();
				carte = carte.importDB(path);
                        }
			carte.populateTableModel(MainView.getModel());
		}else if (e.getActionCommand().equals("Save")) {
			JFileChooser fc;
			fc = new JFileChooser();
			fc.setFileFilter(new FileNameExtensionFilter("Phonebook files","phb"));
			int returnVal = fc.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				path  = fc.getSelectedFile().getPath();
				if (!path.endsWith(".phb")) {
					path += ".phb";
				}
				carte.exportDB(path);
				//Autosave.setPath(path);
			}
		}else if (e.getActionCommand().equals("Exit")) {
			if (Application.registered && !path.equals("error")) {
				carte.exportDB(path);
			}
			System.exit(0);
			
		}else if (e.getActionCommand().equals("Adauga")) {
			new ManageAbonatController(carte);
			
		}else if (e.getActionCommand().equals("Sterge")) {
			if (selRow != -1) {
				Abonat toDelete = carte.getAbonat(seldn);
				carte.deleteAbonat(toDelete, selRow, MainView.getModel());
				selRow = -1;
			}
			
		}else if (e.getActionCommand().equals("Modifica")) {
			if (selRow != -1) {
				new ManageAbonatController(carte, seldn, selRow);
			}
			selRow = -1;
			
		}else if (e.getActionCommand().equals("Inregistrare")) {
			new RegisterController();
			
		}else if (e.getActionCommand().equals("About")) {
			new AboutView();
			
		}else if (e.getSource().equals(mview.getRdbtnNume())) {
			searchState = SearchState.Nume;
		}else if (e.getSource().equals(mview.getRdbtnPrenume())) {
			searchState = SearchState.Prenume;
		}else if (e.getSource().equals(mview.getRdbtnTelefon())) {
			searchState = SearchState.Telefon;
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting()) // mouse button not released yet
			return;

		if (mview.getTable().getSelectedRow() != -1) {
			selRow = mview.getTable().getSelectedRow();
			seldn = (String) mview.getTable().getValueAt(selRow, 2);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			JTable clickedTable = (JTable) e.getSource();
			selRow = clickedTable.getSelectedRow();
			seldn = (String) mview.getTable().getValueAt(selRow, 2);
			
			new ManageAbonatController(carte, seldn, selRow);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stubz
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().equals(mview.getTable())) {
			if (e.getKeyCode() ==  KeyEvent.VK_ENTER) {
				JTable clickedTable = (JTable) e.getSource();
				selRow = clickedTable.getSelectedRow();
				seldn = (String) mview.getTable().getValueAt(selRow, 2);
				
				new ManageAbonatController(carte, seldn, selRow);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(mview.getTxtSearch())) {
			if (searchState == SearchState.Nume){
				carte.populateTableModel(mview.getTxtSearch().getText(), "nume", MainView.getModel());
			}else if (searchState == SearchState.Prenume) {
				carte.populateTableModel(mview.getTxtSearch().getText(), "prenume", MainView.getModel());
			}else if (searchState == SearchState.dn) {
				carte.populateTableModel(mview.getTxtSearch().getText(), "data nasterii", MainView.getModel());
			}else if (searchState == SearchState.Telefon) {
				carte.populateTableModel(mview.getTxtSearch().getText(), "telefon", MainView.getModel());
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (Application.registered && !path.equals("error")) {
			carte.exportDB(path);
		}
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(mview.getTxtSearch())) {
			if (mview.getTxtSearch().getText().equals("Cautare...")) {
				mview.getTxtSearch().setText("");
				mview.getTxtSearch().setBackground(Color.WHITE);
				mview.getTxtSearch().setForeground(Color.BLACK);
			}
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(mview.getTxtSearch())) {
			if (mview.getTxtSearch().getText().equals("")) {
				mview.getTxtSearch().setText("Cautare...");
				mview.getTxtSearch().setBackground(Color.WHITE);
				mview.getTxtSearch().setForeground(Color.BLACK);
			}
		}
	}
	
}
