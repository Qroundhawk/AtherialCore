package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.entity.Player;

public class LegionInfo {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionInfo() { }
	
	static LegionInfo instance = new LegionInfo();
	   
    public static LegionInfo getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("info");
    	
    	return;
    }

}
