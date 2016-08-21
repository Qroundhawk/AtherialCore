package me.TomAlex.Atherial.Mining.OreBreak;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Mining.LvlExp;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OreBreakCoal implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	LvlExp lvlexp = LvlExp.getInstance();
	public String smsg = ChatColor.DARK_GRAY +  "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]> " + ChatColor.GREEN;

	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		Material material = Material.COAL_ORE;
		String ore = "coalore.";
		
		
		if (b.getType() == material) {
			if (p.getItemInHand().getType() == Material.FEATHER) return;
			
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
							}
							ItemStack coalore = new ItemStack(Material.COAL_ORE, 1);
							p.getInventory().addItem(coalore);
							
							String[] args1 = p.getItemInHand().getItemMeta().getLore().toString().split(" ");
							String levelnowinttry = ChatColor.stripColor(args1[1]);
							String expnowinttry = ChatColor.stripColor(args1[4]);
							String maxexpnowinttry = ChatColor.stripColor(args1[6]);
							levelnowinttry = levelnowinttry.replaceAll(",", "");
							expnowinttry = expnowinttry.replaceAll(",", "");
							maxexpnowinttry = maxexpnowinttry.replaceAll(",", "");
							
							int level = 0;
							int exp = 0;
							int maxexp = 0;
							try {
								level = Integer.parseInt(levelnowinttry);
								exp = Integer.parseInt(expnowinttry);
								maxexp = Integer.parseInt(maxexpnowinttry);
							} catch(NumberFormatException ex) {
								p.sendMessage(ChatColor.RED + "Ow whoops there is an error!");
								return;
							}
							//Randomizer
							int plusser = settings.CoalXPMax - settings.CoalXPMin;
							int exprandom = (int) ((Math.random() *plusser) + settings.CoalXPMin);
							exp = exp + exprandom;
							String greenstripes = "Error";
							String redstripes = "Error";
							
							p.sendMessage(smsg + "Your pixkaxe gaind " + ChatColor.RED + exprandom + " exp" + ChatColor.GREEN + " for mining an " + ChatColor.RED + "Coal Ore!");
							p.sendMessage(smsg + "Your pixkaxe gaind " + ChatColor.YELLOW + exprandom + " exp" + ChatColor.GREEN + " for mining an " + ChatColor.YELLOW + "Coal Ore!");
							p.sendMessage(smsg + ChatColor.YELLOW + "Your pixkaxe gaind " + ChatColor.RED + exprandom + " exp" + ChatColor.YELLOW + " for mining an " + ChatColor.RED + "Coal Ore!");
							p.sendMessage(smsg + ChatColor.YELLOW + "Your pixkaxe gaind " + ChatColor.GREEN + exprandom + " exp" + ChatColor.YELLOW + " for mining an " + ChatColor.GREEN + "Coal Ore!");
							
							if (exp >= maxexp) {
								level = level + 1;
								exp = exp - maxexp;
								maxexp = lvlexp.lvlexp(level + 1);
								greenstripes = lvlexp.stripesgreen(exp, maxexp);
								redstripes = lvlexp.stripesred(exp, maxexp);
								
								p.sendMessage(smsg + "Your pickaxe leveld up! Your pickaxe level is now " + ChatColor.RED + "level " + level + "!");
							}else{
								greenstripes = lvlexp.stripesgreen(exp, maxexp);
								redstripes = lvlexp.stripesred(exp, maxexp);
								
								
							}
							
							ItemMeta loremeta = p.getItemInHand().getItemMeta();
							List<String> lore = new ArrayList<String>();
					        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + level);
					        lore.add("");
					        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + exp + " / " + maxexp);
					        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + greenstripes + ChatColor.DARK_RED + "" + ChatColor.BOLD + redstripes + ChatColor.WHITE + "]");
					        
					        loremeta.setLore(lore);
					        p.getItemInHand().setItemMeta(loremeta);
							
							return;
						}
					}
				}
			}
		}
		return;
		}
		return;
	}
}
