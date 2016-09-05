package me.TomAlex.Atherial.Dungeons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

public class PartyPlaceHolders {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	private PartyPlaceHolders() { }
	
	static PartyPlaceHolders instance = new PartyPlaceHolders();
	   
    public static PartyPlaceHolders getInstance() {
            return instance;
    }
	
	public void partyPlaceHolders() {
		
		if(Bukkit.getPluginManager().isPluginEnabled("MVdWPlaceholderAPI"))
		{
			//@PlaceHolder PartyLeader
			PlaceholderAPI.registerPlaceholder(JavaPlugin.getProvidingPlugin(Main.class), "partyleader",	new PlaceholderReplacer()
			{
				@Override
				public String onPlaceholderReplace(PlaceholderReplaceEvent e)
				{
					if(settings.partys.containsKey(e.getPlayer().getName()))
					{
						String re = ChatColor.GRAY + ChatColor.BOLD.toString() + "> " + e.getPlayer().getName();
						return re;
					}else
					{
						String re = ChatColor.GRAY + ChatColor.BOLD.toString() + "> " + "free spot";
						return re;
						
					}
					
				}
			});
			
			//@PlaceHolder MemberOfz
			PlaceholderAPI.registerPlaceholder(JavaPlugin.getProvidingPlugin(Main.class), "member1",	new PlaceholderReplacer()
			{
				@Override
				public String onPlaceholderReplace(PlaceholderReplaceEvent e)
				{
					if(settings.partys.containsKey(e.getPlayer().getName()))
					{
						String re = ChatColor.GRAY + ChatColor.BOLD.toString() + "> " + e.getPlayer().getName();
						return re;
					}else
					{
						String re = ChatColor.GRAY + ChatColor.BOLD.toString() + "> " + "free spot";
						return re;
						
					}
					
				}
			});
		}
		
		
	}
}
