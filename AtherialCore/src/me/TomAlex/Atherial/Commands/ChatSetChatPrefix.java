package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class ChatSetChatPrefix implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("chat.setchatprefix")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		if (args.length == 0 || args.length == 1) {
			p.sendMessage(ChatColor.RED + "Please specify the command! /setchatprefix <player> <prefix>");
			return true;
		}
		
		if (!settings.getUuidData().contains(args[0])) {
			p.sendMessage(ChatColor.RED + "Player has never joint the server!");
			return true;
		}
		
		
		settings.getPlayerData().set(settings.getUuidData().get(args[0]) + ".prefix", args[1]);
		settings.savePlayerData();
		
		p.sendMessage(ChatColor.GREEN + "You have set the prefix from " + args[0] + " to " + args[1] + "!");
		
		return true;
	}

}
