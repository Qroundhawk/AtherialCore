package me.TomAlex.Atherial.Mining.OreRegisteration;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OreRegistrationGold implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		Material material = Material.GOLD_ORE;
		String coalore = "goldore.";
		String coaloresave = "goldore.gold";
		
		if (p.getItemInHand().getType() == Material.FEATHER) {
			if (!p.hasPermission("mining.oresetup")) {
				return;
			}
			
			//@Coal ore setup
			if (b.getType() == material) {
				e.setCancelled(true);
				if (p.isSneaking())	 {
					if (!(settings.getOreData().get(coalore) == null)) {
						for (String i : settings.getOreData().getConfigurationSection(coalore).getKeys(false)) {
							if (settings.getOreData().get(coalore + i + ".loc").equals(b.getLocation())) {
								settings.getOreData().set(coalore + i, null);
								settings.saveOreData();
								
								p.sendMessage("Removed register");
								
								b.setType(Material.AIR);
								return;
							}
						}
					}
					
					b.setType(Material.AIR);
					p.sendMessage("shift");
					return;
				}else{
					if (!(settings.getOreData().get(coalore) == null)) {
						for (String i : settings.getOreData().getConfigurationSection(coalore).getKeys(false)) {
							if (settings.getOreData().get(coalore + i + ".loc").equals(b.getLocation())) {
								
								p.sendMessage("Already registerd");
								return;
							}
						}
					}
					
					int number = 1;
					
					int counter = 0;
					while (counter < 1) {
						if (settings.getOreData().get(coaloresave + number + ".loc") == null) {
							settings.getOreData().set(coaloresave + number + ".loc", b.getLocation());
							settings.saveOreData();
							
							p.sendMessage("New block");
							counter++;
						}else{
							number++;
						}
					}
					return;
				}
			}
		}
		
		 return;
	}

}
