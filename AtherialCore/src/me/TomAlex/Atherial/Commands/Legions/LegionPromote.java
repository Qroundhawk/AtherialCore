package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Legion.LegionMethods;

import org.bukkit.entity.Player;

public class LegionPromote {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionPromote() { }
	
	static LegionPromote instance = new LegionPromote();
	   
    public static LegionPromote getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("promote");
    	
    	return;
    }

}
