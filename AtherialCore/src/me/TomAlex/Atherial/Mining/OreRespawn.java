package me.TomAlex.Atherial.Mining;

import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

public class OreRespawn {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	private OreRespawn() { }
	
	static OreRespawn instance = new OreRespawn();
	   
    public static OreRespawn getInstance() {
            return instance;
    }
    
    public void miningStart() {
    	
    	
    	settings.Coal.put("coal1", 20);
    	settings.Coal.put("coal2", 20);
    	
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable () {
			public void run() {
				
				//@Coal respawn
				if (!settings.Coal.isEmpty() == true) {
					for (Entry<String, Integer> i : settings.Coal.entrySet()) {
						
						settings.Coal.put(i.getKey(), i.getValue() - 5);
						
						if (i.getValue() <= 0) {
							Location loc = (Location) settings.getOreData().get("coalore." + i.getKey() + ".loc");
							loc.getWorld().getBlockAt(loc).setType(Material.COAL_ORE);
							settings.Coal.remove(i);
						}
						
						//Bukkit.broadcastMessage("" + i.getKey() + " - " + i.getValue());
					}
				}
				
			}
		}, 100, 100);
    	
    }

}
