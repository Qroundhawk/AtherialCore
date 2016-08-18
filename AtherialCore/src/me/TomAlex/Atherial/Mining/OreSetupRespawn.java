package me.TomAlex.Atherial.Mining;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class OreSetupRespawn {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	private OreSetupRespawn() { }
	
	static OreSetupRespawn instance = new OreSetupRespawn();
	   
    public static OreSetupRespawn getInstance() {
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
				
				//@IronOre respawn
				if (!(settings.getOreData().get("ironore") == null)) {
					for (String i : settings.getOreData().getConfigurationSection("ironore.").getKeys(false)) {
						Location loc = (Location) settings.getOreData().get("ironore." + i + ".loc");
						if (!(loc.getWorld().getBlockAt(loc).getType() == Material.IRON_ORE)) {
							loc.getWorld().getBlockAt(loc).setType(Material.IRON_ORE);
						}
					}
				}
				
				//@GoldOre respawn
				if (!(settings.getOreData().get("goldore") == null)) {
					for (String i : settings.getOreData().getConfigurationSection("goldore.").getKeys(false)) {
						Location loc = (Location) settings.getOreData().get("goldore." + i + ".loc");
						if (!(loc.getWorld().getBlockAt(loc).getType() == Material.GOLD_ORE)) {
							loc.getWorld().getBlockAt(loc).setType(Material.GOLD_ORE);
						}
					}
				}
				
				//@DiamondOre respawn
				if (!(settings.getOreData().get("diamondore") == null)) {
					for (String i : settings.getOreData().getConfigurationSection("diamondore.").getKeys(false)) {
						Location loc = (Location) settings.getOreData().get("diamondore." + i + ".loc");
						if (!(loc.getWorld().getBlockAt(loc).getType() == Material.DIAMOND_ORE)) {
							loc.getWorld().getBlockAt(loc).setType(Material.DIAMOND_ORE);
						}
					}
				}
				
				//@LapisOre respawn
				if (!(settings.getOreData().get("lapisore") == null)) {
					for (String i : settings.getOreData().getConfigurationSection("lapisore.").getKeys(false)) {
						Location loc = (Location) settings.getOreData().get("lapisore." + i + ".loc");
						if (!(loc.getWorld().getBlockAt(loc).getType() == Material.LAPIS_ORE)) {
							loc.getWorld().getBlockAt(loc).setType(Material.LAPIS_ORE);
						}
					}
				}
				
				//@EmeraldOre respawn
				if (!(settings.getOreData().get("emeraldore") == null)) {
					for (String i : settings.getOreData().getConfigurationSection("emeraldore.").getKeys(false)) {
						Location loc = (Location) settings.getOreData().get("emeraldore." + i + ".loc");
						if (!(loc.getWorld().getBlockAt(loc).getType() == Material.EMERALD_ORE)) {
							loc.getWorld().getBlockAt(loc).setType(Material.EMERALD_ORE);
						}
					}
				}
				
				cancel();
			}
		}.runTaskLater(JavaPlugin.getProvidingPlugin(Main.class), 60);
		return;
	}
	

}
