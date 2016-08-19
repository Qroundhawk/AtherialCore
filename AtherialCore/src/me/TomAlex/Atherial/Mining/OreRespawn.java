package me.TomAlex.Atherial.Mining;

import java.util.Map.Entry;

import net.md_5.bungee.api.ChatColor;

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
    	
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable () {
			public void run() {
				
				//@Coal respawn
				/*if (settings.Coal.isEmpty() == false) {
					for (Entry<String, Integer> i : settings.Coal.entrySet()) {
						
						if (!(settings.getOreData().get("coalore." + i.getKey()) == null)) {
							
							Location loc = (Location) settings.getOreData().get("coalore." + i.getKey() + ".loc");
							
							
							settings.Coal.put(i.getKey(), i.getValue() - 5);
							
							
							if 	(i.getValue() <= 0) {
								if (!(loc.getWorld().getBlockAt(loc).getType() == Material.COAL_ORE)) {
									loc.getWorld().getBlockAt(loc).setType(Material.COAL_ORE);
								}
								settings.Coal.remove(i.getKey());
								
								
							}
						}else{
							settings.Coal.remove(i.getKey());
						}
					}
				}*/
				
				
				
				if (settings.Coal.isEmpty() == false) {
					for (Entry<String, Integer> i : settings.Coal.entrySet()) {
						Bukkit.getServer().broadcastMessage("" + i);
						if (!(settings.getOreData().get("coalore." + i.getKey()) == null)) {
							Location loc = (Location) settings.getOreData().get("coalore." + i.getKey() + ".loc");
							if (loc.getWorld().getBlockAt(loc).getType() == Material.COAL_ORE) {
								Bukkit.getServer().broadcastMessage("Removed ;)");
								settings.Coal.remove(i.getKey());
							}else{
								settings.Coal.put(i.getKey(), i.getValue() - 5);
								if 	(i.getValue() <= 0) {
									loc.getWorld().getBlockAt(loc).setType(Material.COAL_ORE);
									settings.Coal.remove(i.getKey());
								}
							}
						}else{
							settings.Coal.remove(i.getKey());
						}
					}
				}
				
				
				
				
				
			}
		}, 100, 100);
    	
    }

}
