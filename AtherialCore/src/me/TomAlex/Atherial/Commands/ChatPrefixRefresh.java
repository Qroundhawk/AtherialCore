package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Chat.ChatPrefixes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class ChatPrefixRefresh implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();
	ChatPrefixes prefix = ChatPrefixes.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("chat.setchatprefix")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		for (Player i : Bukkit.getOnlinePlayers()) {
			if (!(settings.getPlayerData().getString(i.getUniqueId().toString() + ".prefix") == "default")) {
				settings.Prefix.put(i.getUniqueId().toString(), prefix.Prefix(settings.getPlayerData().getString(i.getUniqueId().toString() + ".prefix")));
			}else{
				settings.Prefix.put(i.getUniqueId().toString(), null);
			}
		}
		
		p.sendMessage(ChatColor.GREEN + "You refreshed all the prefixes!");
		
		return true;
	}

}
