package me.TomAlex.Atherial.Combat;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						
					}
					
					
				}
			}, 100, 600);	    	
	    }
}