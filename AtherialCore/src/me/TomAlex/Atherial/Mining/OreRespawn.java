package me.TomAlex.Atherial.Mining;

import me.TomAlex.Atherial.SettingsManager;

public class OreRespawn {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	private OreRespawn() { }
	
	static OreRespawn instance = new OreRespawn();
	   
    public static OreRespawn getInstance() {
            return instance;
    }
    
    

}
