package me.TomAlex.Atherial.PlayerMenu;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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
	MenuItemStacks is = MenuItemStacks.getInstance();
	
	
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
		if (e.getCurrentItem() == null) return;
    	if (e.getCurrentItem().getItemMeta() == null) return;
    	if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		if (e.getCurrentItem().getType().equals(Material.COMPASS) && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.ITALIC + "Player Info")) {
			if (p.getGameMode().equals(GameMode.CREATIVE)) return;
			e.setCancelled(true);
			return;
		}
		return;
	}
	
	@EventHandler
	public void Compassdrop(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		String pn = p.getName();
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().getType().equals(Material.COMPASS) && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.ITALIC + "Player Info")) {
				
					Inventory PlayerMenu = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "" + p.getName() + "'s Player Info.");
					
					
					PlayerMenu.setItem(13, is.togglePvPOff(pn));
					PlayerMenu.setItem(22, is.serverInfo());
					PlayerMenu.setItem(4, is.playerInfo(pn));
					
					p.openInventory(PlayerMenu);
					
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
