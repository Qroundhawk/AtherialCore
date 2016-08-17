package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Economy.Methods;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EcoAddMarketCommand extends Methods implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("economy.addmarket")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		Villager s = p.getWorld().spawn(p.getLocation(), Villager.class);
		s.setCustomNameVisible(true);
		s.setCustomName(ChatColor.DARK_GREEN + "Market Place");
		s.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9000000, 10000000));
		
		p.sendMessage(smsg + ChatColor.GREEN + "Spawned market place!");
		
		return true;
	}

}
