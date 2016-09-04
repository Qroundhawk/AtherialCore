package me.TomAlex.Atherial.Dungeons;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TomAlex.Atherial.SettingsManager;

public class PartyCommands implements CommandExecutor 
{

	SettingsManager settings = SettingsManager.getInstance();

	public boolean onCommand(CommandSender theSender, Command cmd, String commandLabel, String[] args) 
	{

		if (theSender instanceof Player) {
			Player p = (Player) theSender;

			if (commandLabel.equalsIgnoreCase("party create")) 
			{
				if (args.length == 0) {
					p.sendMessage("name party: /party create name");
				}else if(args.length == 1){
					String partyname = args[0];
					
					p.sendMessage(ChatColor.YELLOW + "Party created name: " + args[0]);
				}

			}
			if (commandLabel.equalsIgnoreCase("partylist")) {

			}
		}
		return true;
	}
}
