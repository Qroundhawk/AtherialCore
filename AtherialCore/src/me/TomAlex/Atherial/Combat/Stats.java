package me.TomAlex.Atherial.Combat;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Stats implements Listener
{
	@EventHandler
	public void statsMenu(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();	
		
		if (e.getInventory().getName().equals(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Player Menu")) 
		{	
			e.setCancelled(true);
		}
		
		if(!(e.getSlotType().toString() == "QUICKBAR"))
		{
			return;
		}
		if(e.getSlot() == 8)
		{
			p.sendMessage("You can't move this item");
			e.setCancelled(true);
		}else return;		
	}
	
	@EventHandler
	public void Compassdrop(PlayerDropItemEvent e)
	{
		if(e.getItemDrop().getItemStack().getType() == Material.COMPASS)
		{
			e.getPlayer().sendMessage(ChatColor.RED + "You can't drop this item");
			e.setCancelled(true);
		}		
	}
	@EventHandler
	public void Compassdrop(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		
		if(e.getItem().getType() == Material.COMPASS)
		{
			Inventory menu = Bukkit.createInventory(null, 18,
					ChatColor.DARK_GREEN+ ChatColor.BOLD.toString() + "Player Menu");
			

			ItemStack slotA = new ItemStack(Material.BOOK);
			ItemMeta slotAMeta = slotA.getItemMeta();
			slotAMeta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString()+ "STATS");
			slotAMeta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "", ChatColor.DARK_GREEN + ""));
			slotA.setItemMeta(slotAMeta);
	
			menu.setItem(0, slotA);

			p.openInventory(menu);
			
		}else return;
	}
}
