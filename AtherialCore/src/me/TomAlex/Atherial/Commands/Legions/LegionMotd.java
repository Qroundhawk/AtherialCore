package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Legion.LegionMethods;

import org.bukkit.entity.Player;

public class LegionMotd {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionMotd() { }
	
	static LegionMotd instance = new LegionMotd();
	   
    public static LegionMotd getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("motd");
    	
    	return;
    }

}
