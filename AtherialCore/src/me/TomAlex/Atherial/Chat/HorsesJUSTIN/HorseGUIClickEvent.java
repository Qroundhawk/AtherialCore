package me.TomAlex.Atherial.Chat.HorsesJUSTIN;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class HorseGUIClickEvent implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	Economy econ = Main.getEcon();
	
	public String prefix = ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "HORSES > ";
	
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
			
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		int slot = e.getSlot();
		
		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.YELLOW + "" + ChatColor.BOLD + "Upgrade your Horse")) {
			
			e.setCancelled(true);
			
			if (e.getCurrentItem() == null) return;
	    	if (e.getCurrentItem().getItemMeta() == null) return;
	    	if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
	    	
			if(slot == 16){
				if(econ.has(p, 100)){
					ItemStack is = p.getItemInHand();
					
					p.closeInventory();
					Main.econ.withdrawPlayer(p, 100);
					settings.pendingRename.put(p, is);
					p.sendMessage(prefix + ChatColor.GREEN + " Type what you would like to rename your Horse.");
					return;

				}else{
					p.sendMessage(prefix + ChatColor.RED + (" You can not afford this upgrade"));
				}
			}
	    	
		return;
		}
	}
}
