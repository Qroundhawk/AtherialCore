package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Mining.OreSetupRespawn;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MineRespawnOreCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();
	OreSetupRespawn mining = OreSetupRespawn.getInstance();
	
	public String smsg = ChatColor.DARK_GRAY +  "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "MINING > ";

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("mining.respawnore")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		settings.Coal.clear();
		settings.Iron.clear();
		settings.Gold.clear();
		settings.Diamond.clear();
		settings.Lapis.clear();
		settings.Emerald.clear();
		
		mining.miningRespawn();
		
		p.sendMessage(smsg + ChatColor.GREEN + "All ore's will be respawned in 5 seconds!");
		
		return true;
	}

}
