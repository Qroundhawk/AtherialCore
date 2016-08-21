package me.TomAlex.Atherial.Mining.OreBreak;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class OreBreakCoal implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	public String smsg = ChatColor.DARK_GRAY +  "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]" + ChatColor.BOLD + "> ";

	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		Material material = Material.COAL_ORE;
		String ore = "coalore.";
		
		if (b.getType() == material) {
			if (p.getItemInHand().getType() == Material.FEATHER) {
				return;
			}
			
			if (!(settings.getOreData().get(ore) == null)) {
				for (String i : settings.getOreData().getConfigurationSection(ore).getKeys(false)) {
					Location loc = (Location) settings.getOreData().get(ore + i + ".loc");
					if (b.getLocation().equals(loc)) {
						e.setCancelled(true);
						if (p.getItemInHand().getType() == Material.WOOD_PICKAXE || p.getItemInHand().getType() == Material.STONE_PICKAXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
							if (p.getItemInHand().hasItemMeta()) {
								b.setType(Material.BEDROCK);
								settings.Coal.put(i, settings.CoalRespawn);
								if (p.getInventory().firstEmpty() == -1) {
									p.sendMessage(ChatColor.RED + "Wacht out! Inventory Full!");
									return;
								}
								ItemStack coalore = new ItemStack(Material.COAL_ORE, 1);
								p.getInventory().addItem(coalore);
								
								String[] args1 = p.getItemInHand().getItemMeta().getLore().toString().split(" ");
								String level2 = ChatColor.stripColor(args1[1]);
								String exp2 = ChatColor.stripColor(args1[4]);
								String maxexp2 = ChatColor.stripColor(args1[6]);
								level2 = level2.replaceAll(",", "");
								exp2 = exp2.replaceAll(",", "");
								maxexp2 = maxexp2.replaceAll(",", "");
								
								int level = 0;
								int exp = 0;
								int maxexp = 0;
								try {
									level = Integer.parseInt(level2);
									exp = Integer.parseInt(exp2);
									maxexp = Integer.parseInt(maxexp2);
								} catch(NumberFormatException ex) {
									p.sendMessage(ChatColor.RED + "Ow whoops there is an error!");
									return;
								}
								
								return;
							}
						}
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						/*b.setType(Material.BEDROCK);
						
						settings.Coal.put(i, settings.CoalRespawn);*/
						return;
					}
				}
			}
			
			
		}
		
		
		
		
		
		
	}
	
}
