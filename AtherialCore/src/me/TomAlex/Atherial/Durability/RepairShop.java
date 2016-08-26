package me.TomAlex.Atherial.Durability;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RepairShop implements Listener 
{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) 
	{
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equals(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Repair Shop")) 
		{	
			ItemStack tier = null;
			String tiername = null;
			ItemStack repairstone = null;
			
			int amountX = 0;
			
			int clicked = e.getRawSlot();
			if(clicked == 0)
			{
				tier = new ItemStack(Material.COAL_ORE); 
				tiername = "COAL";
				
				repairstone =  new ItemStack(Material.LEATHER);
				ItemMeta stoneMeta = repairstone.getItemMeta();
				stoneMeta.setDisplayName(ChatColor.WHITE + ChatColor.BOLD.toString() + "Leather repair stone");
				stoneMeta.setLore(Arrays.asList(ChatColor.GRAY+ "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY+ "by clicking this item on your armor/weapon"));
				repairstone.setItemMeta(stoneMeta);
				
				amountX = 32;
			}
			if(clicked == 2)
			{
				tier = new ItemStack(Material.COAL_ORE); 
				tiername = "COAL";
				repairstone =  new ItemStack(Material.IRON_FENCE);
				ItemMeta stoneMeta = repairstone.getItemMeta();
				stoneMeta.setDisplayName(ChatColor.GRAY + ChatColor.BOLD.toString() + "Chain repair stone");
				stoneMeta.setLore(Arrays.asList(ChatColor.GRAY+ "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY+ "by clicking this item on your armor/weapon"));
				repairstone.setItemMeta(stoneMeta);
				amountX = 64;
			}
			if(clicked == 4)
			{
				tier = new ItemStack(Material.IRON_ORE); 
				tiername = "IRON";
				repairstone =  new ItemStack(Material.IRON_INGOT);
				ItemMeta stoneMeta = repairstone.getItemMeta();
				stoneMeta.setDisplayName(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Iron repair stone");
				stoneMeta.setLore(Arrays.asList(ChatColor.GRAY+ "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY+ "by clicking this item on your armor/weapon"));
				repairstone.setItemMeta(stoneMeta);
				amountX = 32;
			}
			if(clicked == 6)
			{
				tier = new ItemStack(Material.GOLD_ORE); 
				tiername = "GOLD";
				repairstone =  new ItemStack(Material.GOLD_INGOT);
				ItemMeta stoneMeta = repairstone.getItemMeta();
				stoneMeta.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Gold repair stone");
				stoneMeta.setLore(Arrays.asList(ChatColor.GRAY+ "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY+ "by clicking this item on your armor/weapon"));
				repairstone.setItemMeta(stoneMeta);
				amountX = 32;
			}
			if(clicked == 8)
			{
				tier = new ItemStack(Material.DIAMOND_ORE); 
				tiername = "DIAMOND";
				repairstone =  new ItemStack(Material.DIAMOND);
				ItemMeta stoneMeta = repairstone.getItemMeta();
				stoneMeta.setDisplayName(ChatColor.BLUE + ChatColor.BOLD.toString() + "Diamond repair stone");
				stoneMeta.setLore(Arrays.asList(ChatColor.GRAY+ "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY+ "by clicking this item on your armor/weapon"));
				repairstone.setItemMeta(stoneMeta);
				amountX = 32;
			}
			
			
			if(clicked == 0 || clicked == 2 || clicked == 4 || clicked == 6 || clicked == 8)
			{
				int i = 0;
				
				while(i <= 35)
				{
					if(p.getInventory().getItem(i) != null)
					{
						String invitem = p.getInventory().getItem(i).getType().toString();
						
						if(invitem.contains(tiername))
						{
							int amount = p.getInventory().getItem(i).getAmount();
							if(amount >= amountX)
							{
								int newamount = amount-amountX;
								if(newamount == 0)
								{
									p.getInventory().setItem(i, null);
								}else if(newamount != 0 )
								{
									tier.setAmount(newamount);
									p.getInventory().setItem(i, tier);
								}
								p.getInventory().addItem(repairstone);
								p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]>" +
										ChatColor.GREEN + "  You bought 1 " +  repairstone.getItemMeta().getDisplayName() +
										ChatColor.GREEN + " for " + amountX +" "+ tiername + " ORE");
								break;
								
							}
							
						}
						
					}
					if(i == 35)
					{
						p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]>" +
								ChatColor.GREEN + "  You do not have " + ChatColor.YELLOW + ChatColor.UNDERLINE.toString()
								+ amountX + " "+ tiername.toLowerCase() + " ore" + ChatColor.GREEN +" in your inventory!");
					}
					
					i++;
				}
				e.setCancelled(true);
			}else e.setCancelled(true);
		}
	}


}
