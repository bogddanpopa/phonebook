package phonebook.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



@SuppressWarnings("serial")
public class CarteDeTelefon implements Serializable{
	
       
	private Hashtable<String, Abonat> abonati;

	public CarteDeTelefon() {
		abonati = new Hashtable<String, Abonat>();
                
                 }
            
	public void populateTableModel(String filter, String mode, DefaultTableModel tableModel){
		
		if (tableModel.getRowCount() > 0) {
			 for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
				 tableModel.removeRow(i);
             }
		}
		
		Enumeration<String> e = abonati.keys();
		while (e.hasMoreElements()) {
			String currkey = (String) e.nextElement();
			Abonat toAdd = getAbonat(currkey);
			
			if (mode.equals("nume")) {
				if (toAdd.getNume().contains(filter)) {
					String numarString = toAdd.getTelefon().getNumar()+" ( "+ toAdd.getTelefon().getTip() + " )";
					tableModel.addRow(new Object[] {toAdd.getNume(), toAdd.getPrenume(), toAdd.getDn(), numarString});
				}
				
			}else if (mode.equals("prenume")) {
				if (toAdd.getPrenume().contains(filter)) {
					String numarString = toAdd.getTelefon().getNumar()+" ( "+ toAdd.getTelefon().getTip() + " )";
					tableModel.addRow(new Object[] {toAdd.getNume(), toAdd.getPrenume(), toAdd.getDn(), numarString});
				}
			}else if (mode.equals("dn")) {
				if (toAdd.getDn().contains(filter)) {
					String numarString = toAdd.getTelefon().getNumar()+" ( "+ toAdd.getTelefon().getTip() + " )";
					tableModel.addRow(new Object[] {toAdd.getNume(), toAdd.getPrenume(), toAdd.getDn(), numarString});
                                }
			}else if (mode.equals("telefon")) {
				if (toAdd.getTelefon().getNumar().contains(filter)) {
					String numarString = toAdd.getTelefon().getNumar()+" ( "+ toAdd.getTelefon().getTip() + " )";
					tableModel.addRow(new Object[] {toAdd.getNume(), toAdd.getPrenume(), toAdd.getDn(), numarString});
				}
			}else {
				String numarString  = toAdd.getTelefon().getNumar()+" ( "+ toAdd.getTelefon().getTip() + " )";
				tableModel.addRow(new Object[] {toAdd.getNume(), toAdd.getPrenume(), toAdd.getDn(), numarString});
			}
		}
	}
	
	public void populateTableModel(DefaultTableModel tableModel){
		populateTableModel("*", "", tableModel);
	}
	
	public boolean addAbonat(Abonat abonat,  DefaultTableModel tableModel){
		if (!abonati.containsKey(abonat.getDn())) {
			abonati.put(abonat.getDn(), abonat);
			
			String numarString = abonat.getTelefon().getNumar()+" ( "+ abonat.getTelefon().getTip() + " )";
			tableModel.addRow(new Object[] {abonat.getNume(), abonat.getPrenume(), abonat.getDn(), numarString});
			return true;
		}
		return false;
	}
	
	public void deleteAbonat(Abonat abonat, int selRow, DefaultTableModel tableModel){
             int dialogButton = JOptionPane.YES_NO_OPTION;
             int dialogResult=JOptionPane.showConfirmDialog (null, "Sunteti sigur ca doriti sa stergeti acest abonat?","Warning",dialogButton);
            
              if(dialogResult == JOptionPane.YES_OPTION){ abonati.remove(abonat.getDn());
		tableModel.removeRow(selRow);}
               	}
	
	public boolean updateAbonat(Abonat abonat, String olddn, int selRow, DefaultTableModel tableModel){
		if (!(abonati.containsKey(abonat.getDn())) || abonat.getDn().equals(olddn)) {
			Abonat toDelete = getAbonat(olddn);
			deleteAbonat(toDelete, selRow, tableModel);
			addAbonat(abonat, tableModel);
			return true;
		}
		return false;
	}
	
	public Abonat getAbonat(String dn){
		Abonat abonat = null;
		if (abonati.containsKey(dn)) {
			abonat = abonati.get(dn);
		}
		return abonat;
	}
	
	public CarteDeTelefon importDB(String filename) {
		ObjectInputStream inputStream = null;
		CarteDeTelefon temp;
                
		try {
                        inputStream = new ObjectInputStream(new FileInputStream(filename));
			temp = (CarteDeTelefon) inputStream.readObject();
    			inputStream.close();
                       // message(filename);
                        
                        return temp;
                           
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fisier inexistent.",
					"eroare", JOptionPane.ERROR_MESSAGE);
			return new CarteDeTelefon();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fisier corupt.",
					"eroare", JOptionPane.ERROR_MESSAGE);
			return new CarteDeTelefon();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fisier corupt.",
					"eroare", JOptionPane.ERROR_MESSAGE);
			return new CarteDeTelefon();
		}
                
	}
        /*public void message(String filename){
          try{
            String file=filename;
            BufferedReader br = new BufferedReader(new FileReader(filename)); 
            String st;
            while ((st = br.readLine()) != null) 
            System.out.println(st); 
          }
          catch (IOException e) {
		//JOptionPane.showMessageDialog(null, "Fisier inexistent.",
		//		"eroare", JOptionPane.ERROR_MESSAGE);
          }
}*/
	
	public void exportDB(String filename) {
		ObjectOutputStream outputStream;
		try {
			outputStream = new ObjectOutputStream(
					new FileOutputStream(filename));

			outputStream.writeObject(this);

			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Hashtable<String, Abonat> getAbonati() {
		return abonati;
	}

	public void setAbonati(Hashtable<String, Abonat> abonati) {
		this.abonati = abonati;
	}

}
