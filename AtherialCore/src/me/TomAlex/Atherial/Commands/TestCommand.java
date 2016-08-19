package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;

import java.util.Scanner;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class TestCommand implements CommandExecutor {
	
	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("test.command")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		//FREE TO USE :)
		
		
		
		return true;
	}

}
