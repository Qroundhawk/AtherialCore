package me.TomAlex.Atherial.Mining;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.SettingsManager;

public class LvlExp {
	
	private LvlExp() { }
	
	SettingsManager settings = SettingsManager.getInstance();
	static LvlExp instance = new LvlExp();
	   
    public static LvlExp getInstance() {
            return instance;
    }
	
    public int lvlexp(int a) {
    	
    	if (settings.getLevelExpData().get("" + a) == null) {
    		int b = settings.getLevelExpData().getInt("" + 60);
    		return b;
    	}
    	int b = settings.getLevelExpData().getInt("" + a);
    	
    	return b;
    }
    
    public String stripesgreen(int exp, int maxexp) {
    	int stripes1 = maxexp / 20;
		int stripesg = exp / stripes1;
		List<String> stripes = new ArrayList<String>();
		int counter = 0;
		int counter2 = 0;
		while (counter < 1) {
			if (counter2 != stripesg) {
				stripes.add("|");
				counter2++;
			}else{
				counter++;
			}
		}
		String green = stripes.toString().replaceAll(", ", "").replace("[", "").replace("]", "");
    	
    	return green;
    }
    
    public String stripesred(int exp, int maxexp) {
    	int stripes1 = maxexp / 20;
		int stripesg = exp / stripes1;
		int stripesr = 20 - stripesg;
		List<String> stripes = new ArrayList<String>();
		int counter = 0;
		int counter2 = 0;
		while (counter < 1) {
			if (counter2 != stripesr) {
				stripes.add("|");
				counter2++;
			}else{
				counter++;
			}
		}
		String red = stripes.toString().replaceAll(", ", "").replace("[", "").replace("]", "");
    	
    	return red;
    }
    
	/*public int Lvl1 = 0;
	public int Lvl2 = 50;
	public int Lvl3 = 150;
	public int Lvl4 = 300;
	public int Lvl5 = 350;
	public int Lvl6 = 400;
	public int Lvl7 = 450;
	public int Lvl8 = 500;
	public int Lvl9 = 750;
	public int Lvl10 = 1000;
	public int Lvl11 = 1250;
	public int Lvl12 = 1500;
	public int Lvl13 = 1500;
	public int Lvl14 = 1750;
	public int Lvl15 = 2000;
	public int Lvl16 = 2000;
	public int Lvl17 = 2500;
	public int Lvl18 = 3000;
	public int Lvl19 = 3500;
	public int Lvl20 = 5000;
	public int Lvl21 = 10000;
	public int Lvl22 = 15000;
	public int Lvl23 = 20000;
	public int Lvl24 = 25000;
	public int Lvl25 = 25000;
	public int Lvl26 = 30000;
	public int Lvl27 = 35000;
	public int Lvl28 = 40000;
	public int Lvl29 = 45000;
	public int Lvl30 = 50000;
	public int Lvl31 = 70000;
	public int Lvl32 = 80000;
	public int Lvl33 = 90000;
	public int Lvl34 = 100000;
	public int Lvl35 = 120000;
	public int Lvl36 = 140000;
	public int Lvl37 = 160000;
	public int Lvl38 = 180000;
	public int Lvl39 = 200000;
	public int Lvl40 = 250000;
	public int Lvl41 = 300000;
	public int Lvl42 = 350000;
	public int Lvl43 = 400000;
	public int Lvl44 = 450000;
	public int Lvl45 = 500000;
	public int Lvl46 = 600000;
	public int Lvl47 = 700000;
	public int Lvl48 = 800000;
	public int Lvl49 = 900000;
	public int Lvl50 = 1000000;
	public int Lvl51 = 1250000;
	public int Lvl52 = 1500000;
	public int Lvl53 = 1750000;
	public int Lvl54 = 2000000;
	public int Lvl55 = 2500000;
	public int Lvl56 = 3000000;
	public int Lvl57 = 3500000;
	public int Lvl58 = 4500000;
	public int Lvl59 = 5000000;
	public int Lvl60 = 10000000;*/
	
}
