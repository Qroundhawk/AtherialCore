package me.TomAlex.Atherial.Commands.Legions;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class LegionCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();
	
	LegionMethods legion = LegionMethods.getInstance();
	LegionHelp legionhelp = LegionHelp.getInstance();
	LegionCreate legioncreate = LegionCreate.getInstance();
	LegionMembers legionmembers = LegionMembers.getInstance();
	LegionPromote legionpromote = LegionPromote.getInstance();
	LegionDemote legiondemote = LegionDemote.getInstance();
	LegionInvite legioninvite = LegionInvite.getInstance();
	LegionAccept legionaccept = LegionAccept.getInstance();
	LegionKick legionkick = LegionKick.getInstance();
	LegionLeave legionleave = LegionLeave.getInstance();
	LegionMotd legionmotd = LegionMotd.getInstance();
	LegionInfo legioninfo = LegionInfo.getInstance();
	LegionNotifications legionnotifications = LegionNotifications.getInstance();
	

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("legions.use")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
			legionhelp.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("create")) {
			legioncreate.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("members")) {
			legionmembers.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("promote")) {
			legionpromote.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("demote")) {
			legiondemote.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("invite")) {
			legioninvite.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("accept")) {
			legionaccept.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("kick")) {
			legionkick.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("leave")) {
			legionleave.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("motd")) {
			legionmotd.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("info")) {
			legioninfo.command(p);
			return true;
		}
		if (args[0].equalsIgnoreCase("notifications")) {
			legionnotifications.command(p);
			return true;
		}
		
		p.sendMessage(legion.smsg + ChatColor.RED + "Unvailid command, try /legion help!");
		
		return true;
	}

}
