package me.TomAlex.Atherial.Economy;

import me.TomAlex.Atherial.Economy.Methods;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuStorageClickEvent extends Methods implements Listener {

	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
            if (e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_GRAY + "" + p.getName() + "'s Storage.")) {
            	
            	if (e.getCurrentItem() == null) return;
            	if (e.getCurrentItem().getItemMeta() == null) return;
            	if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            	
            	if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u2600")) {

                		e.setCancelled(true);
                        return;
                }
            	
            	if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "\u22C4Buy Extra Row\u22C4")) {
            		p.closeInventory();
            		openBuyStorage(p);
            		e.setCancelled(true);
                    return;
            	}
            	
            	if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "\u22C4To Bank\u2192")) {

                		e.setCancelled(true);
                		
                		p.sendMessage(smsg + ChatColor.GREEN + "Opend bank!");
                        p.closeInventory();
                        openBank(p);
                        return;
                }
            	return;
            }
            
            if (e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_GRAY + "Buy New Storage!")) {
            	
            	if (e.getCurrentItem().getItemMeta() == null) return;
            	if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            	
            	e.setCancelled(true);
            	
            	if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Accept")) {
            		
            		if (getStorageRows(p.getName()) < 3) {
            			if (hasEnough(p.getName(), 1) == false) {
            				
            				p.closeInventory();
            				openStorage(p);
            				return;
            			}
            			removeMoney(p.getName(), 1);
            			setStorage(p.getName(), 3);
            			
            			p.sendMessage(smsg + ChatColor.GREEN + "You have bought an new Storage Row!");
            			
            			p.closeInventory();
            			openStorage(p);
            			return;
            		}
            		
            		if (getStorageRows(p.getName()) < 4) {
            			if (hasEnough(p.getName(), 2) == false) {
            				
            				p.closeInventory();
            				openStorage(p);
            				return;
            			}
            			removeMoney(p.getName(), 2);
            			setStorage(p.getName(), 4);
            			
            			
            			p.closeInventory();
            			openStorage(p);
            			return;
            		}
            		
            		if (getStorageRows(p.getName()) < 5) {
            			if (hasEnough(p.getName(), 3) == false) {
            				
            				p.closeInventory();
            				openStorage(p);
            				return;
            			}
            			removeMoney(p.getName(), 3);
            			setStorage(p.getName(), 5);
            			
            			p.closeInventory();
            			openStorage(p);
            			return;
            		}
            		
            		if (getStorageRows(p.getName()) < 6) {
            			if (hasEnough(p.getName(), 4) == false) {
            				
            				p.closeInventory();
            				openStorage(p);
            				return;
            			}
            			removeMoney(p.getName(), 4);
            			setStorage(p.getName(), 6);
            			
            			p.closeInventory();
            			openStorage(p);
            			return;
            		}
            		
                    return;
            	}
            	
            	if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Cancel")) {
            		
            		p.sendMessage(smsg + ChatColor.GREEN + "You have canceld purchase!");
            		
            		p.closeInventory();
                    return;
            	}
            	
            	
            	return;
            }
            	
            	
	}
	
}
