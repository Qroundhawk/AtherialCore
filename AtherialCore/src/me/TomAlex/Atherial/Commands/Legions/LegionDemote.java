package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.entity.Player;

public class LegionDemote {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionDemote() { }
	
	static LegionDemote instance = new LegionDemote();
	   
    public static LegionDemote getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("demote");
    	
    	return;
    }

}
