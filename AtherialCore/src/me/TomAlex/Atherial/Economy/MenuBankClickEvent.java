package me.TomAlex.Atherial.Economy;

import me.TomAlex.Atherial.Economy.Methods;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuBankClickEvent extends Methods implements Listener {
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
            if (e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_GRAY + "" + p.getName() + "'s Bank Account.")) {
            	
            	e.setCancelled(true);
            	
            	if (e.getCurrentItem() == null) return;
            	if (e.getCurrentItem().getItemMeta() == null) return;
            	if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            	
            	
            	if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Gems")) {
                	if (e.getCurrentItem().getType() == Material.EMERALD) {
                		
                		addMoney(p.getName(), e.getCurrentItem().getAmount());
                		p.sendMessage(smsg + ChatColor.GREEN + "You have stored " + ChatColor.RED + e.getCurrentItem().getAmount() + ChatColor.GREEN + " Gems to your bank account!");
                        e.setCurrentItem(null);
                        
                        //p.closeInventory();
                        
                        openBank(p);
                        return;
                	}
                }
            	
            	if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Gems Block")) {
                	if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                		
                		addMoney(p.getName(), e.getCurrentItem().getAmount() * 64);
                		p.sendMessage(smsg + ChatColor.GREEN + "You have stored " + ChatColor.RED + e.getCurrentItem().getAmount() + ChatColor.GREEN + " Gems Block to your bank account!");
                        e.setCurrentItem(null);
                        
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
            	
            	
            	
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 1)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD) {
                		
                		if (hasEnough(p.getName(), 1) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}
                		
                        p.getInventory().addItem(addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems", "Worth: 1 Gem", 1));
                        removeMoney(p.getName(), 1);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "1" + ChatColor.GREEN + " Gems from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 8)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD) {
                		
                		if (hasEnough(p.getName(), 8) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}
                		
                        p.getInventory().addItem(addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems", "Worth: 1 Gem", 8));
                        removeMoney(p.getName(), 8);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "8" + ChatColor.GREEN + " Gems from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 16)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD) {
                		
                		if (hasEnough(p.getName(), 16) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}
                		
                        p.getInventory().addItem(addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems", "Worth: 1 Gem", 16));
                        removeMoney(p.getName(), 16);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "16" + ChatColor.GREEN + " Gems from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 32)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD) {
                		
                		if (hasEnough(p.getName(), 32) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}
                		
                        p.getInventory().addItem(addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems", "Worth: 1 Gem", 32));
                        removeMoney(p.getName(), 32);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "32" + ChatColor.GREEN + " Gems from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 64)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD) {
                		
                		if (hasEnough(p.getName(), 64) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}            
                        p.getInventory().addItem(addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems", "Worth: 1 Gem", 64));
                        removeMoney(p.getName(), 64);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "64" + ChatColor.GREEN + " Gems from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                
                
                
                
                
                
                
                
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 1)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                		
                		if (hasEnough(p.getName(), 64) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}
                		
                        p.getInventory().addItem(addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems Block", "Worth: 64 Gem", 1));
                        removeMoney(p.getName(), 64);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "1" + ChatColor.GREEN + " Gems Block from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 8)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                		
                		if (hasEnough(p.getName(), 512) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}
                		
                        p.getInventory().addItem(addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems Block", "Worth: 64 Gem", 8));
                        removeMoney(p.getName(), 512);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "8" + ChatColor.GREEN + " Gems Block from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 16)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                		
                		if (hasEnough(p.getName(), 1024) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}
                		
                        p.getInventory().addItem(addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems Block", "Worth: 64 Gem", 16));
                        removeMoney(p.getName(), 1024);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "16" + ChatColor.GREEN + " Gems Block from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 32)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                		
                		if (hasEnough(p.getName(), 2048) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}
                		
                        p.getInventory().addItem(addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems Block", "Worth: 64 Gem", 32));
                        removeMoney(p.getName(), 2048);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "32" + ChatColor.GREEN + " Gems Block from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 64)) {
                	if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                		
                		if (hasEnough(p.getName(), 4096) == false) {
                			p.sendMessage(ChatColor.RED + "You dont have enough gems!");
                			return;
                		}            
                        p.getInventory().addItem(addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Gems Block", "Worth: 64 Gem", 64));
                        removeMoney(p.getName(), 4096);
                        p.sendMessage(smsg + ChatColor.GREEN + "You have withrawed " + ChatColor.RED + "64" + ChatColor.GREEN + " Gems Block from your bank account!");
                        //p.closeInventory();
                        openBank(p);
                        return;
                	}
                }
                
                
                
                
                
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "\u2190To Storage\u22C4")) {
                	if (e.getCurrentItem().getType() == Material.CHEST) {

                        //p.closeInventory();
                        openStorage(p);
                        return;
                	}
                }
                
                
                
                
                
                return;
            }
            
            
            
    }
	

}
