package me.TomAlex.Atherial.Mining;

import java.util.ArrayList;
import java.util.List;
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
    
    //20 / xp nodig = uitkomts    --   nu xp / uitkomst = (rond nummer af) hoeveel streepjes.
    
    public void miningStart() {
    	
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable () {
			public void run() {
				
				//@Coal respawn
				if (settings.Coal.isEmpty() == false) {
					List<String> toRemove = new ArrayList<String>();
					for (Entry<String, Integer> i : settings.Coal.entrySet()) {
						i.setValue(i.getValue() - 5);
						if (!(settings.getOreData().get("coalore." + i.getKey()) == null)) {
							Location loc = (Location) settings.getOreData().get("coalore." + i.getKey() + ".loc");
							
							if (i.getValue() == 0) {
								if (!(loc.getWorld().getBlockAt(loc).getType() == Material.COAL_ORE)) {
									loc.getWorld().getBlockAt(loc).setType(Material.COAL_ORE);
								}
							}
						}else{
							toRemove.add(i.getKey());
						}
					}
					for (Entry<String, Integer> i : settings.Coal.entrySet()) {
						if (i.getValue() <= 0) {
							if (!toRemove.contains(i.getKey())) {
								toRemove.add(i.getKey());
							}
						}
					}
					for (String i : toRemove) {
						settings.Coal.remove(i);
					}
				}
				
				
				
				//@Iron respawn
				if (settings.Iron.isEmpty() == false) {
					List<String> toRemove = new ArrayList<String>();
					for (Entry<String, Integer> i : settings.Iron.entrySet()) {
						i.setValue(i.getValue() - 5);
						if (!(settings.getOreData().get("ironore." + i.getKey()) == null)) {
							Location loc = (Location) settings.getOreData().get("ironore." + i.getKey() + ".loc");
							
							if (i.getValue() == 0) {
								if (!(loc.getWorld().getBlockAt(loc).getType() == Material.IRON_ORE)) {
									loc.getWorld().getBlockAt(loc).setType(Material.IRON_ORE);
								}
							}
						}else{
							toRemove.add(i.getKey());
						}
					}
					for (Entry<String, Integer> i : settings.Iron.entrySet()) {
						if (i.getValue() <= 0) {
							if (!toRemove.contains(i.getKey())) {
								toRemove.add(i.getKey());
							}
						}
					}
					for (String i : toRemove) {
						settings.Iron.remove(i);
					}
				}
				
				
				
				//@Gold respawn
				if (settings.Gold.isEmpty() == false) {
					List<String> toRemove = new ArrayList<String>();
					for (Entry<String, Integer> i : settings.Gold.entrySet()) {
						i.setValue(i.getValue() - 5);
						if (!(settings.getOreData().get("goldore." + i.getKey()) == null)) {
							Location loc = (Location) settings.getOreData().get("goldore." + i.getKey() + ".loc");
							
							if (i.getValue() == 0) {
								if (!(loc.getWorld().getBlockAt(loc).getType() == Material.GOLD_ORE)) {
									loc.getWorld().getBlockAt(loc).setType(Material.GOLD_ORE);
								}
							}
						}else{
							toRemove.add(i.getKey());
						}
					}
					for (Entry<String, Integer> i : settings.Gold.entrySet()) {
						if (i.getValue() <= 0) {
							if (!toRemove.contains(i.getKey())) {
								toRemove.add(i.getKey());
							}
						}
					}
					for (String i : toRemove) {
						settings.Gold.remove(i);
					}
				}
				
				
				
				//@Diamond respawn
				if (settings.Diamond.isEmpty() == false) {
					List<String> toRemove = new ArrayList<String>();
					for (Entry<String, Integer> i : settings.Diamond.entrySet()) {
						i.setValue(i.getValue() - 5);
						if (!(settings.getOreData().get("diamondore." + i.getKey()) == null)) {
							Location loc = (Location) settings.getOreData().get("diamondore." + i.getKey() + ".loc");
							
							if (i.getValue() == 0) {
								if (!(loc.getWorld().getBlockAt(loc).getType() == Material.DIAMOND_ORE)) {
									loc.getWorld().getBlockAt(loc).setType(Material.DIAMOND_ORE);
								}
							}
						}else{
							toRemove.add(i.getKey());
						}
					}
					for (Entry<String, Integer> i : settings.Diamond.entrySet()) {
						if (i.getValue() <= 0) {
							if (!toRemove.contains(i.getKey())) {
								toRemove.add(i.getKey());
							}
						}
					}
					for (String i : toRemove) {
						settings.Diamond.remove(i);
					}
				}
				
				
				
				//@Lapis respawn
				if (settings.Lapis.isEmpty() == false) {
					List<String> toRemove = new ArrayList<String>();
					for (Entry<String, Integer> i : settings.Lapis.entrySet()) {
						i.setValue(i.getValue() - 5);
						if (!(settings.getOreData().get("lapisore." + i.getKey()) == null)) {
							Location loc = (Location) settings.getOreData().get("lapisore." + i.getKey() + ".loc");
							
							if (i.getValue() == 0) {
								if (!(loc.getWorld().getBlockAt(loc).getType() == Material.LAPIS_ORE)) {
									loc.getWorld().getBlockAt(loc).setType(Material.LAPIS_ORE);
								}
							}
						}else{
							toRemove.add(i.getKey());
						}
					}
					for (Entry<String, Integer> i : settings.Lapis.entrySet()) {
						if (i.getValue() <= 0) {
							if (!toRemove.contains(i.getKey())) {
								toRemove.add(i.getKey());
							}
						}
					}
					for (String i : toRemove) {
						settings.Lapis.remove(i);
					}
				}
				
				
				
				//@Emerald respawn
				if (settings.Emerald.isEmpty() == false) {
					List<String> toRemove = new ArrayList<String>();
					for (Entry<String, Integer> i : settings.Emerald.entrySet()) {
						i.setValue(i.getValue() - 5);
						if (!(settings.getOreData().get("emeraldore." + i.getKey()) == null)) {
							Location loc = (Location) settings.getOreData().get("emeraldore." + i.getKey() + ".loc");
							
							if (i.getValue() == 0) {
								if (!(loc.getWorld().getBlockAt(loc).getType() == Material.EMERALD_ORE)) {
									loc.getWorld().getBlockAt(loc).setType(Material.EMERALD_ORE);
								}
							}
						}else{
							toRemove.add(i.getKey());
						}
					}
					for (Entry<String, Integer> i : settings.Emerald.entrySet()) {
						if (i.getValue() <= 0) {
							if (!toRemove.contains(i.getKey())) {
								toRemove.add(i.getKey());
							}
						}
					}
					for (String i : toRemove) {
						settings.Emerald.remove(i);
					}
				}
				
				
				
				
				
			}
		}, 100, 100);
    	
    }

}
