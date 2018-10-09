package phonebook.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Date;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

import phonebook.exceptions.AbonatException;
import phonebook.model.Abonat;
import phonebook.model.CarteDeTelefon;
import phonebook.model.NumarTelefon;
import phonebook.view.MainView;
import phonebook.view.ManageAbonatView;

public class ManageAbonatController extends ManageAbonatView implements ActionListener {
	
	private static final long serialVersionUID = 2760628656137609687L;
	private static final String MODE_ADD = "add";
	private static final String MODE_UPDATE = "update";
	private String olddn;
	private int selRow;
	private CarteDeTelefon carte;
	private String mode;
        private LocalDate datacurenta;
        private String datacurentaformat;
        private String substringdn;
        
	public ManageAbonatController(CarteDeTelefon carte) {
		this.carte = carte;
		mode = MODE_ADD;
		setListeners();
		
	}
  
        public boolean DataCurenta(String dn){
            datacurenta= LocalDate.now();
            datacurentaformat=datacurenta.format(DateTimeFormatter.ofPattern("dd.MM"));
            substringdn=dn.substring(0,5);
            if (substringdn.equals(datacurentaformat)){
                return true;
                  }
            else {return false;
          }

        }
	public ManageAbonatController(CarteDeTelefon carte, String olddn, int selRow) {
		this.carte = carte;
		this.olddn = olddn;
		this.selRow = selRow;
		mode = MODE_UPDATE;
		setListeners();
		
		Abonat toEdit = carte.getAbonat(olddn);
		getTxtNume().setText(toEdit.getNume());
		getTxtPrenume().setText(toEdit.getPrenume());
		getTxtdn().setText(toEdit.getDn());
		getTxtTelefon().setText(toEdit.getTelefon().getNumar());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getBtnAdauga())) {
			String nume = getTxtNume().getText();
			String prenume = getTxtPrenume().getText();
			String dn = getTxtdn().getText();
			String telefon = getTxtTelefon().getText();
			
			NumarTelefon numar = null;
			Abonat abonat = null;
                
                if (DataCurenta(dn)) {
                    JOptionPane.showMessageDialog(null, "Ne bucuram ca sunteti alaturi de noi in aceasta zi speciala.\n"
                            + "\n\rVa uram un sincer si calduros LA MULTI ANI!!!","Sarbatorit!", JOptionPane.INFORMATION_MESSAGE);
                                   
                    }
                     try {
				numar = new NumarTelefon(telefon);
				abonat = new Abonat(nume, prenume, dn, numar);
				if (mode.equals(MODE_ADD)) {
					carte.addAbonat(abonat, MainView.getModel()); 
						dispose();
					}
					
				else { 
                                        if (mode.equals(MODE_UPDATE)) {
					carte.updateAbonat(abonat, olddn, selRow, MainView.getModel());
						dispose();
					}
                                     }
			    }
				
			  catch (AbonatException e1) {
				JOptionPane.showMessageDialog(null, "Datele introduse nu sunt valide.\n\n " + "Cauza: \n" +e1.toString() +
						"\n\nVa rugam sa introduceti un set de date valide.", "Date incorecte", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}else if (e.getSource().equals(getBtnRenunta())) {
			dispose();
		}
	}
	
	private void setListeners(){
		getBtnAdauga().addActionListener(this);
		getBtnRenunta().addActionListener(this);
	}

}
