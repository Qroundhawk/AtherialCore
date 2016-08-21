package me.TomAlex.Atherial.Combat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

public class PlayerUpdater 
{

	SettingsManager settings = SettingsManager.getInstance();
	
	private PlayerUpdater() { }
	
	static PlayerUpdater instance = new PlayerUpdater();
	   
    public static PlayerUpdater getInstance() {
            return instance;
    }
	

	 public void UpdaterStart() 
	 {
	    	
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable () 
			{
				public void run() 
				{
		
					
				}
			}, 100, 600);	    	
	    }
}