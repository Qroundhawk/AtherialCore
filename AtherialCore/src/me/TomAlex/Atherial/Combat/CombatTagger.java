package me.TomAlex.Atherial.Combat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

public class CombatTagger implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();

	String messager = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
			+ "] " + ChatColor.RED + ChatColor.BOLD.toString() + "COMBAT >";
	@EventHandler
	public void CombatTag(EntityDamageByEntityEvent e) 
	{
		Entity attacker = e.getDamager();
		Entity defender = e.getEntity();
		if(attacker instanceof Player)
		{
			Player p = (Player) attacker;
			
			if(defender instanceof Villager)
			{
				return;
			}
			
			if( !(p.getItemInHand().getType().toString().toLowerCase().contains("sword"))
					|| !(p.getItemInHand().getType().toString().toLowerCase().contains("axe")) ) 
			{
				return;
			}
			
			if(defender instanceof Player)
			{
				Player pdefender = (Player) defender;
				if(!(settings.pvptoggle.contains(p.getUniqueId())) || !(settings.pvptoggle.contains(pdefender.getUniqueId())))
				{
					return;
				}
			}

			if (settings.Tagger.containsKey(p.getUniqueId())) 
			{
				Bukkit.getScheduler().cancelTask(settings.Tagger.get(p.getUniqueId()));
			} else
				p.sendMessage(messager +"     You are in combat!");

			int id = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable() {

				public void run() {
					p.sendMessage(messager+ ChatColor.GREEN + "    You are out of combat!");
					settings.Tagger.remove(p.getUniqueId());
				}
			}, 100);
			settings.Tagger.put(p.getUniqueId(), id);
			
		}
		if(defender instanceof Player)
		{
			Player p = (Player) defender;
			
			if (settings.Tagger.containsKey(p.getUniqueId())) 
			{
				Bukkit.getScheduler().cancelTask(settings.Tagger.get(p.getUniqueId()));
			} else
				p.sendMessage(messager + "     You are in combat!");

			int id = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable() {

				public void run() {
					p.sendMessage(messager+ ChatColor.GREEN + ChatColor.BOLD.toString()+ "    You are out of combat!");
					settings.Tagger.remove(p.getUniqueId());
				}
			}, 200);
			settings.Tagger.put(p.getUniqueId(), id);
			
		}
	}

}
