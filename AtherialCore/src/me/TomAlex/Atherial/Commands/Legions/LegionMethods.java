package me.TomAlex.Atherial.Commands.Legions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.TomAlex.Atherial.SettingsManager;

public class LegionMethods {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	public String smsg = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + "" + ChatColor.BOLD + "Legion > ";
	
	private LegionMethods() { }
	
	static LegionMethods instance = new LegionMethods();
	   
    public static LegionMethods getInstance() {
            return instance;
    }
    
    
    
    
    public void heyMessage(Player p) {
    	p.sendMessage("hey");
    	return;
    }

}
