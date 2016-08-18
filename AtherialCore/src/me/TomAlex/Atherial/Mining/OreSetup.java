package me.TomAlex.Atherial.Mining;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class OreSetup {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	private OreSetup() { }
	
	static OreSetup instance = new OreSetup();
	   
    public static OreSetup getInstance() {
            return instance;
    }
	
	
	
	public void miningRespawn() {
		
		new BukkitRunnable() {

			public void run() {
				
				//@CoalOre respawn
				if (!(settings.getOreData().get("coalore") == null)) {
					for (String i : settings.getOreData().getConfigurationSection("coalore.").getKeys(false)) {
						Location loc = (Location) settings.getOreData().get("coalore." + i + ".loc");
						if (!(loc.getWorld().getBlockAt(loc).getType() == Material.COAL_ORE)) {
							loc.getWorld().getBlockAt(loc).setType(Material.COAL_ORE);
						}
					}
				}
				
				
				//@CoalOre respawn
				if (!(settings.getOreData().get("coalore") == null)) {
					for (String i : settings.getOreData().getConfigurationSection("coalore.").getKeys(false)) {
						Location loc = (Location) settings.getOreData().get("coalore." + i + ".loc");
						if (!(loc.getWorld().getBlockAt(loc).getType() == Material.COAL_ORE)) {
							loc.getWorld().getBlockAt(loc).setType(Material.COAL_ORE);
						}
					}
				}
				
				
				cancel();
			}
		}.runTaskLater(JavaPlugin.getProvidingPlugin(Main.class), 60);
		
		
		
		/*Bukkit.broadcastMessage("d");
		
		if (!(settings.getOreData().get("coalore") == null)) {
			for (String i : settings.getOreData().getConfigurationSection("coalore.").getKeys(false)) {
				String w = (String) settings.getOreData().get("coalore." + i + ".loc.world");
				Location loc = (Location) settings.getOreData().get("coalore." + i + ".loc");
				Bukkit.getWorld(w).getBlockAt(loc).setType(Material.COAL_ORE);;
			}
		}*/
		
		
		
		
		
		
		return;
	}
	

}
