package me.TomAlex.Atherial;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.Chat.ChatPrefixes;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinEvent implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	ChatPrefixes prefix = ChatPrefixes.getInstance();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(!settings.getPlayerData().contains(p.getUniqueId().toString())) {
			settings.getPlayerData().set(p.getUniqueId().toString(), p.getUniqueId().toString());
			settings.getPlayerData().set(p.getUniqueId().toString() + ".name", p.getName());
			settings.getPlayerData().set(p.getUniqueId().toString() + ".prefix", "default");
			settings.getPlayerData().set(p.getUniqueId().toString() + ".legion", "none");
			settings.getPlayerData().set(p.getUniqueId().toString() + ".storage.rows", 2);
			settings.savePlayerData();
		}
		
		if (!settings.getUuidData().contains(p.getName())) {
			settings.getUuidData().set(p.getName(), p.getUniqueId().toString());
			settings.saveUuidData();
		}
		
		if (!(settings.getPlayerData().getString(p.getUniqueId().toString() + ".prefix") == "default")) {
			settings.Prefix.put(p.getUniqueId().toString(), prefix.Prefix(settings.getPlayerData().getString(p.getUniqueId().toString() + ".prefix")));
		}else{
			settings.Prefix.put(p.getUniqueId().toString(), null);
		}
		
		ItemStack pmenu = new ItemStack(Material.COMPASS);
		ItemMeta pmenuMeta = pmenu.getItemMeta();
		List<String> pmenuLore = new ArrayList<String>();
		pmenuMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.ITALIC + "Player Info");
		pmenuLore.add(ChatColor.GREEN + "|" + ChatColor.GRAY + "Right Click" + ChatColor.GREEN + "| " + ChatColor.GRAY + "to see");
		pmenuLore.add(ChatColor.GRAY + "all your player info!");
		pmenuMeta.setLore(pmenuLore);
		pmenu.setItemMeta(pmenuMeta);
		p.getInventory().setItem(8, pmenu);
		
	}
}
