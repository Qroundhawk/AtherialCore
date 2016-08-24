package me.TomAlex.Atherial.Mining.OreRegisteration;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OreRegistrationCoal implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	public String smsg = ChatColor.DARK_GRAY +  "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "MINING > ";
	
	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		Material material = Material.COAL_ORE;
		String coalore = "coalore.";
		String coaloresave = "coalore.coal";
		
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
								
								p.sendMessage(smsg + ChatColor.RED + "Your removed a registerd " + ChatColor.LIGHT_PURPLE + "Coal Ore!");
								
								b.setType(Material.AIR);
								return;
							}
						}
					}
					
					b.setType(Material.AIR);
					return;
				}else{
					if (!(settings.getOreData().get(coalore) == null)) {
						for (String i : settings.getOreData().getConfigurationSection(coalore).getKeys(false)) {
							if (settings.getOreData().get(coalore + i + ".loc").equals(b.getLocation())) {
								
								p.sendMessage(smsg + ChatColor.RED + "This " + ChatColor.LIGHT_PURPLE + "Coal Ore " + ChatColor.RED + "is already registerd!");
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
							
							p.sendMessage(smsg + ChatColor.GREEN + "You registerd a new " + ChatColor.LIGHT_PURPLE + "Coal Ore!");
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
