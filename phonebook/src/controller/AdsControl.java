package phonebook.controller;

import java.util.Random;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AdsControl extends TimerTask {

	private JLabel ad;
	private ImageIcon[] ads;
	private int currentAd;
	
	public AdsControl(JLabel ad) {
		this.ad = ad;
		currentAd = 1;
		ads = new ImageIcon[5];
		
		
                ads[0] = new ImageIcon(getClass().getResource("/img/ads/recl1.jpg"));
		ads[1] = new ImageIcon(getClass().getResource("/img/ads/recl2.jpg"));
		ads[2] = new ImageIcon(getClass().getResource("/img/ads/recl3.jpg"));
                ads[3] = new ImageIcon(getClass().getResource("/img/ads/recl4.jpg"));
                ads[4] = new ImageIcon(getClass().getResource("/img/ads/recl5.jpg"));
        }
	
	@Override
	public void run() {
		if (!Application.registered) {
			currentAd = getRandomAd(4);
			ad.setIcon(ads[currentAd]);
		}
		
	}
	
	private int getRandomAd(int maxVal){
		Random random = new Random();
		return random.nextInt(maxVal+1);
	}

}
