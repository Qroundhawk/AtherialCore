package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Economy.Methods;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoSetStorageCommand extends Methods implements CommandExecutor {
	
	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("economy.setstorage")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		if (args.length == 0) {
			p.sendMessage(ChatColor.RED + "Please specify your command. /Setstorage <Player> <Amount>");
			return true;
		}
		
		if (args.length == 1) {
			p.sendMessage(ChatColor.RED + "Please specify your command. /Setstorage <Player> <Amount>");
			return true;
		}
		
		if (playerExists(args[0]) == false) {
			p.sendMessage(ChatColor.RED + "Player does not exists or never joint te server.");
			return true;
		}
		
		int Amount = 0;
	    try {
	    	Amount = Integer.parseInt(args[1]);
	    } catch (NumberFormatException localNumberFormatException) {
	    }
	    
	    setStorage(args[0], Amount);
	    p.sendMessage(smsg +  ChatColor.GREEN + "You set " + ChatColor.RED + args[0] + "'s" + ChatColor.GREEN + " Storage Rows to " + ChatColor.RED + Amount + "!");
		return true;
	}

}
