package me.TomAlex.Atherial.Economy;

import me.TomAlex.Atherial.Economy.Methods;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerEvent extends Methods implements Listener {

	@EventHandler
	public void VillagerInteractClick(PlayerInteractEntityEvent e) {
		if (e.getRightClicked().getType() == EntityType.VILLAGER) {
			Villager v = (Villager) e.getRightClicked();
			Player p = e.getPlayer();
			
			e.setCancelled(true);
			
				if(v.getCustomName() == null) return;
				
			if (v.getCustomName().equals(ChatColor.DARK_GREEN + "Bank Merchant")) {
				
				openBank(p);
				p.sendMessage(smsg + ChatColor.GREEN + "Opend bank!");
				return;
			}
		}
		
		if (e.getRightClicked().getType() == EntityType.VILLAGER) {
			Villager v = (Villager) e.getRightClicked();
			Player p = e.getPlayer();
			
			e.setCancelled(true);
			
				if(v.getCustomName() == null) return;
				
			if (v.getCustomName().equals(ChatColor.DARK_GREEN + "Market Place")) {
				
				//openBank(p);
				p.sendMessage(smsg + ChatColor.GREEN + "Opend Market!");
				return;
			}
		}
	}
	
	@EventHandler
	public void VillagerHurt(EntityDamageByEntityEvent e) {
		if (e.getEntity().getType() == EntityType.VILLAGER) {
			if (e.getDamager().getType() == EntityType.PLAYER) {
				
					e.setCancelled(true);
			}
		}
	}
	
	
	
}
