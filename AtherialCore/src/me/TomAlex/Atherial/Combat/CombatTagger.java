package me.TomAlex.Atherial.Combat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

public class CombatTagger implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();

	@EventHandler
	public void CombatTag(EntityDamageByEntityEvent e) 
	{
		if(e.getDamager() instanceof Player)
		{
			Player Pdamager = (Player) e.getDamager();
			// -----------------------------------------CombatTagger----------------------------
			if (settings.Tagger.containsKey(Pdamager.getUniqueId())) 
			{
				Bukkit.getScheduler().cancelTask(settings.Tagger.get(Pdamager.getUniqueId()));
			} else
				Pdamager.sendMessage((ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
						+ "]>       " + ChatColor.RED + ChatColor.BOLD.toString() + "You are in combat!"));

			int id = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable() {

				public void run() {
					Pdamager.sendMessage((ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
							+ "]>       " + ChatColor.GREEN + ChatColor.BOLD.toString() + "You are out of combat!"));
					settings.Tagger.remove(Pdamager.getUniqueId());
				}
			}, 100);
			settings.Tagger.put(Pdamager.getUniqueId(), id);
			
		}else return;
	}

}
