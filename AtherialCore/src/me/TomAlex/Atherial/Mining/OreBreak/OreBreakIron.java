package me.TomAlex.Atherial.Mining.OreBreak;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OreBreakIron implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();

	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		Material material = Material.IRON_ORE;
		String ore = "ironore.";
		
		if (b.getType() == material) {
			if (p.getItemInHand().getType() == Material.FEATHER) {
				return;
			}
			
			if (!(settings.getOreData().get(ore) == null)) {
				for (String i : settings.getOreData().getConfigurationSection(ore).getKeys(false)) {
					Location loc = (Location) settings.getOreData().get(ore + i + ".loc");
					if (b.getLocation().equals(loc)) {
						e.setCancelled(true);
						b.setType(Material.BEDROCK);
						
						settings.Iron.put(i, settings.IronRespawn);
						return;
					}
				}
			}
			
			
		}
		
		
		
		
		
		
	}
	
}
