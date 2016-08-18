package me.TomAlex.Atherial.Mining.OreBreak;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OreBreakCoal implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();

	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		Material material = Material.COAL_ORE;
		String coalore = "coalore.";
		String coaloresave = "coalore.coal";
		
		if (b.getType() == material) {
			if (p.getItemInHand().getType() == Material.FEATHER) {
				return;
			}
			
			if (!(settings.getOreData().get(coalore) == null)) {
				for (String i : settings.getOreData().getConfigurationSection(coalore).getKeys(false)) {
					Location loc = (Location) settings.getOreData().get(coalore + i + ".loc");
					if (b.getLocation().equals(loc)) {
						e.setCancelled(true);
						b.setType(Material.BEDROCK);
						
						settings.Coal.put(i, 30);
						return;
					}
				}
			}
			
			
		}
		
		
		
		
		
		
	}
	
}
