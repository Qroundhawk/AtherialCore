package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Legion.LegionMethods;

import org.bukkit.entity.Player;

public class LegionLeave {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionLeave() { }
	
	static LegionLeave instance = new LegionLeave();
	   
    public static LegionLeave getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("leave");
    	
    	return;
    }

}
