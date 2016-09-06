package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.entity.Player;

public class LegionHelp {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionHelp() { }
	
	static LegionHelp instance = new LegionHelp();
	   
    public static LegionHelp getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("help");
    	
    	return;
    }

}
