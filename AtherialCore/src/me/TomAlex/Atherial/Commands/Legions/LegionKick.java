package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.entity.Player;

public class LegionKick {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionKick() { }
	
	static LegionKick instance = new LegionKick();
	   
    public static LegionKick getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("kick");
    	
    	return;
    }

}
