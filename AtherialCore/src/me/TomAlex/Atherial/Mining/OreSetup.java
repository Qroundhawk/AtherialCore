package me.TomAlex.Atherial.Mining;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OreSetup implements Listener {
	
	
	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if (!p.hasPermission("mining.oresetup")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return;
		}
		
		 return;
	}

}
