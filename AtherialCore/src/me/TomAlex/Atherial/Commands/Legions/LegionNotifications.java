package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Legion.LegionMethods;

import org.bukkit.entity.Player;

public class LegionNotifications {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionNotifications() { }
	
	static LegionNotifications instance = new LegionNotifications();
	   
    public static LegionNotifications getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("notification");
    	
    	return;
    }

}
