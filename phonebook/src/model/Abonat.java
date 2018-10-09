package phonebook.model;

import java.io.Serializable;
import java.time.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.*;

import phonebook.exceptions.AbonatException;

@SuppressWarnings("serial")
public class Abonat implements Serializable{
	
        private String nume;
	private String prenume;
	private String dn;
        private String dnastere1;
        private Date dnastere;
        private SimpleDateFormat df;
        private NumarTelefon telefon;
	public Date getDnastere() {return dnastere;};
        public Abonat(String nume, String prenume, String dn, NumarTelefon telefon) throws AbonatException {
	
		if (isNumeValid(nume)){
			
			this.nume = nume;

		}else {
			throw new AbonatException("Abonat Invalid - Nume gresit");
		}
		
		if (isPrenumeValid(prenume)) {
			this.prenume = prenume;
		}else {
			throw new AbonatException("Abonat invalid - Prenume gresit");
		}
		
		if (isDNValid(dn)) {
			this.dn = dnastere1;
		}else {
			throw new AbonatException("Abonat invalid - Data nasterii incorecta. Introduceti o data de forma dd.MM.yyy");
		}
                
		this.telefon = telefon;
		
	}
	
	private boolean isNumeValid(String nume){
		if (nume == null || 
				nume.equals("") ||
                                nume.length()<=2 ||
				!nume.matches("[a-zA-Z]+")) {
				
				return false;
			}
		return true;
	}
	
	private boolean isPrenumeValid(String prenume){
		if (prenume == null || 
				prenume.equals("") ||
                                prenume.length()<=2 ||
				!prenume.matches("[a-zA-Z]+")) {
				
				return false;
			}
		return true;
	}
	
	private boolean isDNValid(String dn){
            df = new SimpleDateFormat("dd.MM.yyyy");
            try{
            dnastere=df.parse(dn);
            dnastere1=df.format(dnastere);
            return true;
            }
            catch (ParseException e) {
                return false;
            }
        }      
		
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) throws AbonatException {
		if (isNumeValid(nume)) {
			this.nume = nume;
		}else {
			throw new AbonatException("Nume invalid");
		}
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) throws AbonatException {
		if (isPrenumeValid(prenume)) {
			this.prenume = prenume;
		}else {
			throw new AbonatException("Prenume invalid");
		}
	}

	public String getDn() {
		return dn;
	}

	public void setdn(String dn) throws AbonatException {
		if (isDNValid(dn)) {
			this.dn = dn;
		}else {
			throw new AbonatException("Data nastere invalida");
		}
	}

	public NumarTelefon getTelefon() {
		return telefon;
	}

	public void setTelefon(NumarTelefon telefon) {
		this.telefon = telefon;	
	}
 
}
