package me.TomAlex.Atherial.Commands;

import me.TomAlex.Atherial.SettingsManager;

import java.util.Collection;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();
	String messager = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA
			+ ChatColor.BOLD.toString() + "PARTY > " + ChatColor.GREEN;

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		String pn = p.getName();
		UUID ud = p.getUniqueId();
		
		if (args.length == 0 || args[0].equalsIgnoreCase("help")){
		     p.sendMessage(ChatColor.YELLOW + "---------" + ChatColor.GRAY + " Party Commands " + ChatColor.YELLOW + "---------");
		      p.sendMessage(" ");
		      p.sendMessage(ChatColor.DARK_GRAY + " - /party create");
		      p.sendMessage(ChatColor.DARK_GRAY + " - /party leave");
		      p.sendMessage(ChatColor.DARK_GRAY + " - /party invite <Player>");
		      p.sendMessage(ChatColor.DARK_GRAY + " - /party accept");
		      p.sendMessage(ChatColor.DARK_GRAY + " - /party info ");
		      p.sendMessage(ChatColor.DARK_GRAY + " - /party chat <message> ");
		      
		      p.sendMessage(" ");
		      p.sendMessage(ChatColor.YELLOW + "---------" + ChatColor.GRAY + " Party Commands " + ChatColor.YELLOW + "---------");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("create")) 
		{
			if(settings.partys.containsKey(pn))
			{
				p.sendMessage(messager + " You already have a party!");
				return true;
			}
			if(settings.partyPeople.contains(ud))
			{
				p.sendMessage(messager + " Already in party!");
				return true;
			}else
			{
				settings.partyPeople.add(ud);
				settings.partys.put(pn, pn);
				settings.partyLeaders.put(pn, pn);
				p.sendMessage(messager + " Party has been created!");
				return true;
			}
		}
		if (args[0].equalsIgnoreCase("invite")) 
		{
			if(args.length == 2)
			{
				Player invited = p.getServer().getPlayer(args[1]);
				if(!settings.partys.containsKey(pn))
				{
					p.sendMessage(messager +" You are not a party leader");
					return true;
				}
				if(invited == null)
				{
					p.sendMessage(messager + invited + " is not online");
					return true;
				}
				if(invited.getName() == pn)
				{
					p.sendMessage(messager + " Can not invite yourself silly!");
					return true;
				}
				
				invited.sendMessage(messager + " You have been invited to " + pn + " party");
				settings.partyInvites.put(invited.getName(), pn);
			}else 
			{
				p.sendMessage(messager + " use /party invite name!");
			}
			return true;
		}
		if (args[0].equalsIgnoreCase("accept")) 
		{
			if(settings.partyInvites.containsKey(pn))
			{
				if(settings.partyPeople.contains(p.getUniqueId()) || settings.partys.containsKey(pn))
				{
					p.sendMessage(messager + " Already in party!");
					return true;
				}
				
				p.sendMessage(messager + " You joined " + settings.partyInvites.get(pn) + " Party");
				Player leader = p.getServer().getPlayer(settings.partyInvites.get(pn));
				leader.sendMessage(messager + pn + " has joined your party!");
				settings.partys.put(settings.partyInvites.get(pn), pn);
				settings.partyLeaders.put(pn, settings.partyInvites.get(pn));
				settings.partyInvites.remove(pn);
				settings.partyPeople.add(ud);
				p.performCommand("Party info");
				leader.performCommand("Party info");
			}else
			{
				p.sendMessage(messager + " You do not have any invites");
			}
			
		}
		if (args[0].equalsIgnoreCase("leave")) 
		{
			if(!(settings.partyPeople.contains(ud)))
			{
				p.sendMessage(messager + " Not in a party!");
				return true;
			}
			if(settings.partyPeople.contains(p.getUniqueId()) && !settings.partys.containsKey(pn))
			{
				String leader = settings.partyLeaders.get(pn);
				settings.partys.remove(leader, pn);
				settings.partyLeaders.remove(pn);
				settings.partyPeople.remove(ud);
				p.sendMessage(messager + " Left the party");
				
			}else
			{
				Collection<String> members = settings.partys.get(pn);
				members.size();
				int partysize = members.size();
				int i = 0;
				p.sendMessage(messager + i);
				while (i < partysize) 
				{
					p.sendMessage(" "+ settings.partys.keys());

					i++;
				}

			}
			
		}
		if (args[0].equalsIgnoreCase("info")) 
		{
			if(!settings.partyPeople.contains(ud))
			{
				p.sendMessage(messager + " Not in party!");
				return true;
			}
			
			String leader = settings.partyLeaders.get(pn);
			Collection<String> members = settings.partys.get(leader);
			
			 p.sendMessage(ChatColor.YELLOW + "---------" + ChatColor.GRAY + " Party Information " + ChatColor.YELLOW + "---------");
		     p.sendMessage(" ");
		     p.sendMessage(ChatColor.WHITE + ChatColor.BOLD.toString() + "Leader: ");
		     p.sendMessage(ChatColor.GRAY + "" + leader);
		     p.sendMessage(" ");
		     p.sendMessage(ChatColor.WHITE + ChatColor.BOLD.toString() + "Members: ");
		     p.sendMessage("" + members);
		     p.sendMessage(ChatColor.YELLOW + "---------" + ChatColor.GRAY + " Party Information " + ChatColor.YELLOW + "---------");
			return true;
		}
		
		//party 0 1 2 3 4
		
		return true;
	}
	
}
