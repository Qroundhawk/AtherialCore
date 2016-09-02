package me.TomAlex.Atherial.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import me.TomAlex.Atherial.SettingsManager;

public class GlobalMarketCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player p = (Player) sender;

		if (!p.hasPermission("globalmarket.command")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}

		Location l = p.getLocation();

		Villager v = (Villager) p.getWorld().spawnEntity(l, EntityType.VILLAGER);
		v.setCustomName(ChatColor.GREEN + "Global Market");
		v.setCustomNameVisible(true);
		v.setInvulnerable(true);
		v.setCollidable(false);

		return true;
	}

}