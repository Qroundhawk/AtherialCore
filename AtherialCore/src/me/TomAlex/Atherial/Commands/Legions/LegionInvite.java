package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.entity.Player;

public class LegionInvite {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionInvite() { }
	
	static LegionInvite instance = new LegionInvite();
	   
    public static LegionInvite getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("invite");
    	
    	return;
    }

}
