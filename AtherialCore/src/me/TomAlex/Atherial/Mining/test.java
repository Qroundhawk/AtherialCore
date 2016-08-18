package me.TomAlex.Atherial.Mining;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class test implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if (b.getType() == Material.COAL_ORE) {
			
			if (p.getItemInHand().getType() == Material.FEATHER) return;
			
			e.setCancelled(true);
			b.setType(Material.BEDROCK);
			return;
		}
		
	}

}
