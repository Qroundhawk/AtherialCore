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

public class OreBreakDiamond implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	LvlExp lvlexp = LvlExp.getInstance();
	public String smsg = ChatColor.DARK_GRAY +  "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "MINING > ";

	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if (b.getType() == Material.DIAMOND_ORE) {
			if (p.getItemInHand().getType() == Material.FEATHER) return;
		if (!(settings.getOreData().get("diamondore.") == null)) {
			for (String i : settings.getOreData().getConfigurationSection("diamondore.").getKeys(false)) {
				Location loc = (Location) settings.getOreData().get("diamondore." + i + ".loc");
				if (b.getLocation().equals(loc)) {
					e.setCancelled(true);
					if (p.getItemInHand().getType() == Material.WOOD_PICKAXE || p.getItemInHand().getType() == Material.STONE_PICKAXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.GOLD_PICKAXE) {
						p.sendMessage(smsg + ChatColor.RED + "Oops sorry, you can only mine Diamond Ore with an Diamond Pickaxe or higher!");
						return;
					}
					if (p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
						if (p.getItemInHand().hasItemMeta()) {
							b.setType(Material.BEDROCK);
							settings.Diamond.put(i, settings.DiamondRespawn);
							if (p.getInventory().firstEmpty() == -1) {
								p.sendMessage(ChatColor.RED + "Wacht out! Inventory Full!");
							}
							ItemStack diamondore = new ItemStack(Material.DIAMOND_ORE, 1);
							p.getInventory().addItem(diamondore);
							
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
							int plusser = settings.DiamondXPMax - settings.DiamondXPMin;
							int exprandom = (int) ((Math.random() *plusser) + settings.DiamondXPMin);
							exp = exp + exprandom;
							String greenstripes = "Error";
							String redstripes = "Error";
							
							p.sendMessage(smsg + ChatColor.YELLOW + "Your pixkaxe gaind " + ChatColor.LIGHT_PURPLE + exprandom + " exp" + ChatColor.YELLOW + " for mining an " + ChatColor.LIGHT_PURPLE + "Diamond Ore!");
							
							if (exp >= maxexp) {
								level = level + 1;
								exp = exp - maxexp;
								maxexp = lvlexp.lvlexp(level + 1);
								greenstripes = lvlexp.stripesgreen(exp, maxexp);
								redstripes = lvlexp.stripesred(exp, maxexp);
								
								p.sendMessage(smsg + ChatColor.YELLOW + "Your pickaxe leveld up! Your pickaxe level is now " + ChatColor.LIGHT_PURPLE + "level " + level + "!");
								
								if (level == 10) {
									if (p.getItemInHand().getType() == Material.STONE_PICKAXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
									}else{
										p.getItemInHand().setType(Material.STONE_PICKAXE);
										ItemMeta pickaxemeta = p.getItemInHand().getItemMeta();
								        pickaxemeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Stone Pickaxe");
								        p.getItemInHand().setItemMeta(pickaxemeta);
								        p.sendMessage(smsg + ChatColor.YELLOW + "Your pickaxe upgraded to a " + ChatColor.LIGHT_PURPLE + "Stone Pickaxe!");
									}
								}
								if (level == 20) {
									if (p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
									}else{
										p.getItemInHand().setType(Material.IRON_PICKAXE);
										ItemMeta pickaxemeta = p.getItemInHand().getItemMeta();
										pickaxemeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Iron Pickaxe");
										p.getItemInHand().setItemMeta(pickaxemeta);
										p.sendMessage(smsg + ChatColor.YELLOW + "Your pickaxe upgraded to a " + ChatColor.LIGHT_PURPLE + "Iron Pickaxe!");
									}
								}
								if (level == 30) {
									if (p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
									}else{
										p.getItemInHand().setType(Material.GOLD_PICKAXE);
										ItemMeta pickaxemeta = p.getItemInHand().getItemMeta();
										pickaxemeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Gold Pickaxe");
										p.getItemInHand().setItemMeta(pickaxemeta);
										p.sendMessage(smsg + ChatColor.YELLOW + "Your pickaxe upgraded to a " + ChatColor.LIGHT_PURPLE + "Gold Pickaxe!");
									}
								}
								if (level == 40) {
									if (p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
									}else{
										p.getItemInHand().setType(Material.DIAMOND_PICKAXE);
										ItemMeta pickaxemeta = p.getItemInHand().getItemMeta();
										pickaxemeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Diamond Pickaxe");
										p.getItemInHand().setItemMeta(pickaxemeta);
										p.sendMessage(smsg + ChatColor.YELLOW + "Your pickaxe upgraded to a " + ChatColor.LIGHT_PURPLE + "Diamond Pickaxe!");
									}
								}
								
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
