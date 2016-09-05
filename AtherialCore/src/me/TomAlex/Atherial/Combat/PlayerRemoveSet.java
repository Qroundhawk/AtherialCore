package me.TomAlex.Atherial.Combat;

import java.util.Collection;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.TomAlex.Atherial.SettingsManager;

public class PlayerRemoveSet implements Listener
{
	SettingsManager settings = SettingsManager.getInstance();
	
	String messager = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA
			+ ChatColor.BOLD.toString() + "PARTY > " + ChatColor.GREEN;
	
	@EventHandler
	public void RemoveFromHashMap(PlayerQuitEvent e)
	{
		UUID ud = e.getPlayer().getUniqueId();
		String pn = e.getPlayer().getName();
		Player p = e.getPlayer();
		
		//remove stats
		settings.Armor.remove(ud);
		settings.Regen.remove(ud);
		settings.Block.remove(ud);
		settings.Thorns.remove(ud);
		settings.Vit.remove(ud);
		settings.PvP.remove(ud);
		settings.PvE.remove(ud);
		
		//remove party
		
		if(!(settings.partyPeople.contains(ud)))
		{
			return;
		}
		if(settings.partyPeople.contains(p.getUniqueId()) && !settings.partys.containsKey(pn))
		{
			String leader = settings.partyLeaders.get(pn);
			settings.partys.remove(leader, pn);
			settings.partyLeaders.remove(pn);
			settings.partyPeople.remove(ud);
			
			Collection<String> members = settings.partys.get(leader);
			for(String i : members)
			{
				Player member = Bukkit.getServer().getPlayer(i);
				member.sendMessage(messager + pn + " left the party!");
			}
			
		}else
		{
			Collection<String> members = settings.partys.get(pn);
			for(String i : members)
			{
				Player member = Bukkit.getServer().getPlayer(i);
				settings.partyLeaders.remove(i);
				settings.partyPeople.remove(member.getUniqueId());
				member.sendMessage(messager + " Party disbanded");
			}
			settings.partys.removeAll(pn);

		}
		
		
		
	}
}
