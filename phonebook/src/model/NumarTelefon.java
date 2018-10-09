package phonebook.model;

import java.io.Serializable;

import phonebook.exceptions.AbonatException;

@SuppressWarnings("serial")
public class NumarTelefon implements Serializable {
	
	private String numar;
	private String tip;
	
	public NumarTelefon(String numar) throws AbonatException {
		if (isValid(numar)) {
			this.numar = numar;
			setTip();
		}else {
			throw new AbonatException("Numar telefon eronat");
		}
	
	}
	
	
	public boolean isValid(String numar){
		if (numar == null || 
				((numar.length() < 10) || (numar.length() > 10)) ||
				!(numar.startsWith("02") || numar.startsWith("03") || numar.startsWith("07") ) ||
				!numar.matches("[0-9]+")) {
				
				return false;
			}
		return true;
	}
	
	public String getTip() {
		return tip;
	}

	private void setTip() {
		if (numar.startsWith("02") || numar.startsWith("03")) {
			this.tip = "fix";
		}else if (numar.startsWith("07")) {
			this.tip = "mobil";
		}
	}


	public String getNumar() {
		return numar;
	}


	public void setNumar(String numar) throws AbonatException {
		if (isValid(numar)) {
			this.numar = numar;
			setTip();
		}else {
			throw new AbonatException("Numar de telefon invalid");
		}
		
	}

}
