package me.TomAlex.Atherial.Mining;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockPlaceEvent implements Listener {
	
	
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		Action action = e.getAction();
		
		if (action.equals(action.RIGHT_CLICK_BLOCK)) { 
			if (e.getClickedBlock().getType() == Material.COAL_ORE) {
				 p.sendMessage("hey");
				 return;
			 }
		}
		 return;
	}

}
