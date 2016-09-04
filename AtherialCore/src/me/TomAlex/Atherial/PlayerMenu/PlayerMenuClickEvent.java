package me.TomAlex.Atherial.PlayerMenu;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerMenuClickEvent implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	MenuItemStacks is = MenuItemStacks.getInstance();
	
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		String pn = p.getName();
		
		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_GRAY + "" + p.getName() + "'s Player Info.")) {
			
			e.setCancelled(true);
			
			if (e.getCurrentItem() == null) return;
	    	if (e.getCurrentItem().getItemMeta() == null) return;
	    	if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
	    	
	    	if (e.getCurrentItem().equals(is.togglePvPOff(pn))) {
	    		e.getInventory().setItem(13, is.togglePvPOn(pn));
	    		return;
	    	}
	    	if (e.getCurrentItem().equals(is.togglePvPOn(pn))) {
	    		e.getInventory().setItem(13, is.togglePvPOff(pn));
	    		return;
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
			return;
		}
		return;
	}

}
