package me.TomAlex.Atherial.Durability;

import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class Infidura implements Listener 
{

	@EventHandler
	public void durability(PlayerItemDamageEvent event) 
	{
		event.setDamage(0);
		event.getPlayer().updateInventory();
		event.setCancelled(true);
		event.getPlayer().updateInventory();
		return;
	
	}
	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent event) 
	{
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onEntityCombust(EntityCombustEvent event)
	{
		if (event.getEntity() instanceof Skeleton) 
		{
			event.setCancelled(true);
		}
	}

}
