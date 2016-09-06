package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Legion.LegionMethods;

import org.bukkit.entity.Player;

public class LegionMembers {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionMembers() { }
	
	static LegionMembers instance = new LegionMembers();
	   
    public static LegionMembers getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("members");
    	
    	return;
    }

}
