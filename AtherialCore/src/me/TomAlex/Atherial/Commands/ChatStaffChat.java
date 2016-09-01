package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatStaffChat  implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("chat.staffchat")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		if (args.length == 0) {
			p.sendMessage(ChatColor.RED + "Please specify the command! /staffchat(/sc) <message>");
			return true;
		}
		
		String msg = "";
		for (String arg : args) {
			msg += arg + " ";
		}
		
		for (Player i : Bukkit.getOnlinePlayers()) {
			if (i.hasPermission("chat.staffchat")) {
				i.sendMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "Staff" + ChatColor.DARK_GREEN + "]> " + p.getName() + ": " + ChatColor.GREEN + msg);
			}
		}
		
		
		return true;
	}

}