package me.TomAlex.Atherial;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

	SettingsManager settings = SettingsManager.getInstance();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(!settings.getPlayerData().contains(p.getUniqueId().toString())) {
			settings.getPlayerData().set(p.getUniqueId().toString(), p.getUniqueId().toString());
			settings.getPlayerData().set(p.getUniqueId().toString() + ".name", p.getName());
			settings.getPlayerData().set(p.getUniqueId().toString() + ".storage.rows", 2);
			settings.savePlayerData();
		}
		
		if (!settings.getUuidData().contains(p.getName())) {
			settings.getUuidData().set(p.getName(), p.getUniqueId().toString());
			settings.saveUuidData();
		}
	}
}
