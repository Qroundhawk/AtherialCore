package me.TomAlex.Atherial.Combat;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.TomAlex.Atherial.SettingsManager;

public class PlayerRemoveSet implements Listener
{
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void RemoveFromHashMap(PlayerQuitEvent e)
	{
		UUID ud = e.getPlayer().getUniqueId();
		
		settings.Armor.remove(ud);
		settings.Regen.remove(ud);
		settings.Block.remove(ud);
		settings.Thorns.remove(ud);
		settings.Vit.remove(ud);
		settings.PvP.remove(ud);
		settings.PvE.remove(ud);		
	}
}
