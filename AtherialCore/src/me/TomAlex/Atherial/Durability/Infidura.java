package me.TomAlex.Atherial.Durability;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class Infidura implements Listener 
{
	@EventHandler
	public void durability(PlayerItemDamageEvent event) 
	{
		
		event.setCancelled(true);
	}

}
