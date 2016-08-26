package me.TomAlex.Atherial.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import me.TomAlex.Atherial.SettingsManager;

public class RepairSmithCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player p = (Player) sender;

		if (!p.hasPermission("repairsmith.command")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}

		Location l = p.getLocation();
		String name = p.getName();

		Villager v = (Villager) p.getWorld().spawnEntity(l, EntityType.VILLAGER);
		v.setCustomName(ChatColor.GREEN + "Item Repair Smith");
		v.setCustomNameVisible(true);
		v.setInvulnerable(true);
		v.setCollidable(false);

		ArmorStand a1 = (ArmorStand) p.getWorld().spawnEntity(l.add(0, -10, 0), EntityType.ARMOR_STAND);
		a1.setInvulnerable(true);
		a1.setPassenger(v);
		
		p.sendMessage("Yo");

		return true;
	}

}