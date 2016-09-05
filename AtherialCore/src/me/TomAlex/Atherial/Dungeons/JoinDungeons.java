package me.TomAlex.Atherial.Dungeons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.TomAlex.Atherial.SettingsManager;

public class JoinDungeons implements Listener
{
	SettingsManager settings = SettingsManager.getInstance();
	String messager = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD
			+ ChatColor.BOLD.toString() + "COMBAT > " + ChatColor.GREEN;
	
	Location maw1 = new Location(Bukkit.getWorld("world"), -408, 70, -707);
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) 
	{
		//@@Maw of Souls Dungeon
		if (e.getInventory().getName().equals(ChatColor.GOLD+ ChatColor.BOLD.toString() + "Maw of Souls Dungeon")) 
		{
			Player p = (Player) e.getWhoClicked();
			String pn = p.getName();
			e.setCancelled(true);
			
			if (e.getCurrentItem() == null) return;
	    	if (e.getCurrentItem().getItemMeta() == null) return;
	    	if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
	    	if(e.getSlot() == 12)
	    	{
	    		if(!settings.Dungeons.containsKey("maw1"))
	    		{
	    			p.teleport(maw1);
		    		settings.Dungeons.put("maw1", pn);
		    		settings.Dungeonleaders.put(pn, "maw1");
	    		}else
	    		{
	    			p.sendMessage("Dungeons full");
	    			p.closeInventory();
	    		}
	    	}
	    	if(e.getSlot() == 14)
	    	{
	    		p.closeInventory();
	    	}
		}
	}
}
		
