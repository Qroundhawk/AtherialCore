package me.TomAlex.Atherial.PlayerMenu;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class PlayerMenuEvent implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	
	
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
		if (p.getItemInHand().getType().equals(Material.COMPASS) && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.ITALIC + "Player Info")) {
			e.setCancelled(true);
			return;
		}
		return;
	}
	
	@EventHandler
	public void Compassdrop(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR ) {
			if (p.getItemInHand().getType().equals(Material.COMPASS) && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.ITALIC + "Player Info")) {
				
					Inventory PlayerInfo = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "" + p.getName() + "'s Player Info.");
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					p.openInventory(PlayerInfo);
					
					return;
			}
		}
		return;
	}
	
	
	
	
	@EventHandler
	public void Compassdrop(PlayerDropItemEvent e) {
		
		if(e.getItemDrop().getItemStack().getType().equals(Material.COMPASS) && e.getItemDrop().getItemStack().hasItemMeta() && e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.ITALIC + "Player Info")) {
			e.setCancelled(true);
			return;
		}
		return;
	}
	
	
	
	
	
	
	
}
