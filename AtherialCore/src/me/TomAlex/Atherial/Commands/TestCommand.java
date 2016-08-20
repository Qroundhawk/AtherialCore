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
		p.sendMessage("Coal: " + settings.Coal);
		p.sendMessage("Iron: " + settings.Iron);
		p.sendMessage("Gold: " + settings.Gold);
		p.sendMessage("Diamond: " + settings.Diamond);
		p.sendMessage("Lapis: " + settings.Lapis);
		p.sendMessage("Emerald: " + settings.Emerald);
		
		
		return true;
	}

}
