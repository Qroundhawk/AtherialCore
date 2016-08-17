package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Economy.Methods;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoMoneyCommand extends Methods implements CommandExecutor {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("economy.money")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		if (args.length == 0) {
			p.sendMessage(smsg +  ChatColor.GREEN + "You have " + ChatColor.RED + getMoney(p.getName()) + ChatColor.GREEN + " Gems!");
			return true;
		}
		
		if (args.length == 1) {
			if (!p.hasPermission("economy.money.other")) {
				p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
				return true;
			}
			
			if (playerExists(args[0]) == false) {
				p.sendMessage(ChatColor.RED + "Player does not exists or never joint te server.");
				return true;
			}
			
			p.sendMessage(smsg + ChatColor.RED + args[0] + ChatColor.GREEN + " has " + ChatColor.RED + getMoney(args[0]) + ChatColor.GREEN + " Gems!");
			return true;
		}
		
		return true;
	}

}