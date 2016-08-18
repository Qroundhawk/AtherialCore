package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
	
	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("test.command")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
			//String chatcolor = ""+ ChatColor.RED;
			//p.sendMessage(chatcolor+ "Loresize: "  + p.getItemInHand().getItemMeta().getLore().size());
			//String loreThorns = p.getItemInHand().getItemMeta().getLore().get(7);
			//p.sendMessage("" + loreThorns.indexOf(1));
			
			p.sendMessage("" + settings.getOreData().getDouble("coalore.coal1.loc"));
		
		
		
		return true;
	}

}
