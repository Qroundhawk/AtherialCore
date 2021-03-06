package me.TomAlex.Atherial.Dungeons;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import me.TomAlex.Atherial.SettingsManager;

public class MawDungeon implements Listener
{
	SettingsManager settings = SettingsManager.getInstance();
	MawSetup dungeonsetup = MawSetup.getInstance();
	
	String messager = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD
			+ ChatColor.BOLD.toString() + "DUNGEON > " + ChatColor.GREEN;
	
	Location maw1Start = new Location(Bukkit.getWorld("world"), -408, 70, -707);
	
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
	    	if(e.getSlot() == 12 && e.getCurrentItem().getType() == Material.WOOL)
	    	{
	    		if(!settings.Dungeons.containsKey("maw1"))
	    		{
	    			p.teleport(maw1Start);
		    		settings.Dungeons.put("maw1", pn);
		    		settings.Dungeonleaders.put(pn, "maw1");
		    		settings.DungeonPeople.put(pn, "maw1");
		    		
		    	
					dungeonsetup.maw1reset();
					dungeonsetup.maw1set();
		    		
		    		//send message to notify players
		    		String leader = settings.partyLeaders.get(pn);
		    		Collection<String> members = settings.partys.get(leader);
					for(String i : members)
					{
						Player member = Bukkit.getServer().getPlayer(i);
						member.sendMessage(messager + " Dungeon " + ChatColor.GOLD + "Maw of Souls "
								+ ChatColor.GREEN + "has been started do /Dungeon join");
					}
	    		}else
	    		{
	    			p.sendMessage("No aviable dungeons open");
	    			p.closeInventory();
	    		}
	    	}
	    	if(e.getSlot() == 14 && e.getCurrentItem().getType() == Material.WOOL)
	    	{
	    		p.closeInventory();
	    	}
		}
	}
}
		
