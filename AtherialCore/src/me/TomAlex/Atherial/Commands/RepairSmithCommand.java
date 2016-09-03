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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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


		Villager v = (Villager) p.getWorld().spawnEntity(l, EntityType.VILLAGER);
		ArmorStand as = (ArmorStand)p.getWorld().spawnEntity(l.add(0.0D, -1.5D, 0.0D), EntityType.ARMOR_STAND);
	    as.setVisible(false);
	    as.setGravity(false);
	    as.setPassenger(v);
		v.setCustomName(ChatColor.GREEN + "Item Repair Smith");
		v.setCustomNameVisible(true);
		v.setInvulnerable(true);
		v.setCollidable(false);
        v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000000, 100));
        v.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000000, -100));

		return true;
	}

}