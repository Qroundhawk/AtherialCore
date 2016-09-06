package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Legion.LegionMethods;

import org.bukkit.entity.Player;

public class LegionAccept {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionAccept() { }
	
	static LegionAccept instance = new LegionAccept();
	   
    public static LegionAccept getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("accept");
    	
    	return;
    }

}
