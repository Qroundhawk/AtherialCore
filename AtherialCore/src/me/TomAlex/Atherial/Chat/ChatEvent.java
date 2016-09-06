package me.TomAlex.Atherial.Chat;

import me.TomAlex.Atherial.SettingsManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatEvent implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		
        e.setCancelled(true);
        
        //@Horse Renaming
		if(settings.pendingRename.containsKey(e.getPlayer())){
			ItemStack is = settings.pendingRename.get(e.getPlayer());
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(e.getMessage());
			is.setItemMeta(im);
			e.getPlayer().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "HORSES > " + ChatColor.GRAY + "Your horse has been renamed to: " + e.getMessage());
			settings.pendingRename.remove(e.getPlayer());
			return;
		}
        
        Player p = e.getPlayer();
        String msg = e.getMessage();
        String prefix = settings.Prefix.get(p.getUniqueId().toString());
        
        //@GlobalChat
        if (settings.GlobalChat == true) {
        	if (p.hasPermission("chat.staffcolor")) {
        		if (prefix == null) {
        			Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Global" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + p.getName() + ": " + ChatColor.WHITE + msg);
        		}else{
        			Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Global" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_GRAY + "[" + prefix + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + p.getName() + ": " + ChatColor.WHITE + msg);
        		}
        		return;
        	}
        	
        	if (prefix == null) {
        		Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Global" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + p.getName() + ": " + msg);
        	}else{
        		Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Global" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_GRAY + "[" + prefix + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + p.getName() + ": " + ChatColor.WHITE + msg);
        	}
        	return;
        }
        
        
        //@Shout System
        if (msg.startsWith("!")) {
        	if (settings.ShoutTimer.containsKey(p.getUniqueId().toString())) {
        		p.sendMessage(ChatColor.RED + "You can only shout every 10 seconds!");
        		return;
        	}
        	msg = msg.replaceFirst("!", "");
        	Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "Shout" + ChatColor.DARK_AQUA + "]> " + p.getName() + ": " + ChatColor.AQUA + msg);
        	settings.ShoutTimer.put(p.getUniqueId().toString(), 10);
        	return;
        }
        
        
        //@Normal LocalChat System
        //LocalChat Staff
        if (p.hasPermission("chat.staffcolor")) {
        	for (Entity i : p.getWorld().getNearbyEntities(p.getLocation(), 15, 15, 15)) {
        		if (prefix == null) {
        			i.sendMessage(ChatColor.DARK_RED + p.getName() + ": " + ChatColor.WHITE + msg);
        		}else{
        			i.sendMessage(ChatColor.DARK_GRAY + "[" + prefix + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + p.getName() + ": " + ChatColor.WHITE + msg);
        		}
        	}
        	return;
        }
        
      //LocalChat Player(Default)
        for (Entity i : p.getWorld().getNearbyEntities(p.getLocation(), 15, 15, 15)) {
        	if (prefix == null) {
        		i.sendMessage(ChatColor.GRAY + p.getName() + ": " + msg);
        	}else{
        		i.sendMessage(ChatColor.DARK_GRAY + "[" + prefix + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + p.getName() + ": " + ChatColor.WHITE + msg);
        	}
        }
        
        
        return;
	}

}
