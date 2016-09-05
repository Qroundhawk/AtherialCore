package me.TomAlex.Atherial.Dungeons;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Golem;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.TomAlex.Atherial.SettingsManager;

public class AddGolems implements CommandExecutor 
{
	SettingsManager settings = SettingsManager.getInstance();
	String messager = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA
			+ ChatColor.BOLD.toString() + "PARTY > " + ChatColor.GREEN;

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		String pn = p.getName();
		UUID ud = p.getUniqueId();
		
		if (args.length == 0 || args[0].equalsIgnoreCase("help"))
		{
			p.sendMessage("Works");
			return true;
		}
		if (args[0].equalsIgnoreCase("maw")) 
		{
			Location l = p.getLocation();

			IronGolem v = (IronGolem) p.getWorld().spawnEntity(l, EntityType.IRON_GOLEM);
			ArmorStand as = (ArmorStand)p.getWorld().spawnEntity(l.add(0.0D, -1.5D, 0.0D), EntityType.ARMOR_STAND);
		    as.setVisible(false);
		    as.setGravity(false);
		    as.setPassenger(v);
		    v.setCustomName(ChatColor.GREEN + ChatColor.BOLD.toString() + "Maw of Souls");
			v.setCustomNameVisible(true);
			v.setInvulnerable(true);
			v.setCollidable(false);
	        v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000000, 100));
	        v.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000000, -100));

		}
		return true;
	}

}
