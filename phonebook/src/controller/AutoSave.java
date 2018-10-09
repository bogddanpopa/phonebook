package phonebook.controller;

import java.util.TimerTask;

import phonebook.model.CarteDeTelefon;

public class AutoSave extends TimerTask {
	
	private CarteDeTelefon cartet;
	private static String path; 
	
	public AutoSave(CarteDeTelefon carte, String path) {
		this.cartet = carte;
		AutoSave.path = path;
	}

	@Override
	public void run() {
		if (!path.equals("error")) {
			cartet.exportDB(path);
		}
		
	}

	public String getPath() {
		return path;
	}

	public static void setPath(String path) {
		AutoSave.path = path;
	}

}
