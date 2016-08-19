package me.TomAlex.Atherial.Combat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Stats implements Listener
{
	@EventHandler
	public void statsMenu(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();		
		if(!(e.getSlotType().toString() == "QUICKBAR"))
		{
			return;
		}
		if(e.getSlot() == 8)
		{
			p.sendMessage("You can't move this item");
			e.setCancelled(true);
		}else return;		
	}
	
	@EventHandler
	public void Compassdrop(PlayerDropItemEvent e)
	{
		if(e.getItemDrop().getItemStack().getType() == Material.COMPASS)
		{
			e.getPlayer().sendMessage(ChatColor.RED + "You can't drop this item");
			e.setCancelled(true);
		}
		
	}
}
