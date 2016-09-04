package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (args.length == 0 || args[0].equalsIgnoreCase("help")){
			//code
			return true;
		}
		
		if (args[0].equalsIgnoreCase("create")) {
			if(args.length == 2)
			{
				p.sendMessage("" + args[1]);
			}else
			{
				p.sendMessage("Use /party create name");
			}
			return true;
		}
		if (args[0].equalsIgnoreCase("invite")) 
		{
			//code
			return true;
		}
		if (args[0].equalsIgnoreCase("list")) {
			//code
			return true;
		}
		
		//party 0 1 2 3 4
		
		return true;
	}
	
}
