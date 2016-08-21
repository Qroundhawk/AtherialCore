package me.TomAlex.Atherial.Mining.OreBreak;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Mining.LvlExp;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OreBreakCoal implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	LvlExp lvlexp = LvlExp.getInstance();
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
								
								
								int plusser = settings.CoalXPMax - settings.CoalXPMin;
								int expplus = (int) ((Math.random() *plusser) + settings.CoalXPMin);
								int newexp = exp + expplus;
								
								if (newexp >= maxexp) {
									int newlevel = level + 1;
									int newmaxexp = lvlexp.lvlexp(newlevel + 1);
									int newnewexp = newexp - maxexp;
									
									ItemMeta loremeta = p.getItemInHand().getItemMeta();
									List<String> lore = new ArrayList<String>();
							        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + newlevel);
							        lore.add("");
							        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + newnewexp + " / " + newmaxexp);
							        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "||||||||||||||||||||" + ChatColor.WHITE + "]");
							        
							        loremeta.setLore(lore);
							        p.getItemInHand().setItemMeta(loremeta);
									
									return;
								}
								
								
								
								
								
								
								
								
								
								
								
								//20 / xp nodig = uitkomts    --   nu xp / uitkomst = (rond nummer af) hoeveel streepjes.
								
								int stripes1 = maxexp / 20;
								int stripesg = newexp / stripes1;
								int stripesr = 20 - stripesg;
								
								List<String> stripesgreen = new ArrayList<String>();
								List<String> stripesred = new ArrayList<String>();
								
								int countergreen = 0;
								int countergreen2 = 0;
			        			while (countergreen < 1) {
			        				if (countergreen2 != stripesg) {
			        					stripesgreen.add("|");
			        					countergreen2++;
			        				}else{
			        					countergreen++;
			        				}
			        			}
			        			int counterred = 0;
								int counterred2 = 0;
			        			while (counterred < 1) {
			        				if (counterred2 != stripesr) {
			        					stripesred.add("|");
			        					counterred2++;
			        				}else{
			        					counterred++;
			        				}
			        			}
								
			        			String green = stripesgreen.toString().replaceAll(", ", "").replaceAll("[", "");
			        			String red = stripesred.toString().replaceAll(", ", "");
								
								
								ItemMeta loremeta = p.getItemInHand().getItemMeta();
								List<String> lore = new ArrayList<String>();
						        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + level);
						        lore.add("");
						        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + newexp + " / " + maxexp);
						        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + green + ChatColor.DARK_RED + "" + ChatColor.BOLD + red + ChatColor.WHITE + "]");
						        
						        loremeta.setLore(lore);
						        p.getItemInHand().setItemMeta(loremeta);
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
