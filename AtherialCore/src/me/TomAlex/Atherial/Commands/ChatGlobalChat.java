package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class ChatGlobalChat implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("chat.globalchat")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		if (settings.GlobalChat == false) {
			settings.GlobalChat = true;
		}else{
			settings.GlobalChat = false;
		}
		
		p.sendMessage(ChatColor.GREEN + "You toggled the globalchat to " + settings.GlobalChat);
		
		return true;
	}

}
