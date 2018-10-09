package phonebook.controller;

import java.util.Timer;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import phonebook.view.MainView;
import phonebook.view.SplashStart;

public class Application {
    
	public static boolean registered = false;
	public static final String regCode = "registerapp";
	private static MainView view;
	private static Timer timer;
        
        public static void main(String[] args) {
	
            try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
	    SplashStart splash = new SplashStart(2000);
	    view = new MainView();
	    
	    splash.showSplash();
	    
	    timer = new Timer();
	    AdsControl cycler = new AdsControl(view.getLblReclama());
	    timer.scheduleAtFixedRate(cycler, 0, 5000);
	    
		new MainController(view);

	}
	
	
	public static void makeFull(){
		Application.registered = true;
		view.getMntmOpen().setEnabled(true);
		view.getMntmSave().setEnabled(true);
		view.getMntmInregistrare().setEnabled(false);
		timer.cancel();
		view.removeAds();
		view.setTitle("Phonebook v1.2 [Registered version]");
	}

}
