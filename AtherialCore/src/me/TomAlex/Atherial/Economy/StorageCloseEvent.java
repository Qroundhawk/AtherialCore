package me.TomAlex.Atherial.Economy;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class StorageCloseEvent extends Methods implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
    public void InventoryCloseEvent(InventoryCloseEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		if (e.getInventory().getName().equals(ChatColor.DARK_GRAY + "" + p.getName() + "'s Storage.")) {
			
			int a = getStorageRows(p.getName()) * 9;
			
			int counter = 0;
			while (counter < a) {
				if (e.getInventory().getItem(counter) == null) {
					saveStorageSlot(p.getName(), counter, null);
				}else{
					saveStorageSlot(p.getName(), counter, e.getInventory().getItem(counter));
				}
				counter++;
			}
			
			return;
		}
		return;
	}

}
