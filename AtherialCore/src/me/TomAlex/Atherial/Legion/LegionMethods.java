package me.TomAlex.Atherial.Legion;

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
    
    
    
    
    
    
    
    
    public void setPlayerLegion(Player p, String i) {
    	
    	if (settings.getLegionData().get(i) == null) {
    		System.out.println("Legion > Error! - setPlayerLegion");
    		return;
    	}
    	
    	settings.getPlayerData().set(p.getUniqueId() + ".legion", i);
    	
    	return;
    }

}
