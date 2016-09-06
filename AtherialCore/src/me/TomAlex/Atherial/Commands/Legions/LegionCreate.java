package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.entity.Player;

public class LegionCreate {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	
	private LegionCreate() { }
	
	static LegionCreate instance = new LegionCreate();
	   
    public static LegionCreate getInstance() {
            return instance;
    }
    
    
    public void command(Player p) {
    	p.sendMessage("create");
    	
    	return;
    }

}
