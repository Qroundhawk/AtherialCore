package me.TomAlex.Atherial.Chat;

import net.md_5.bungee.api.ChatColor;
import me.TomAlex.Atherial.SettingsManager;

public class ChatPrefixes {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	private ChatPrefixes() { }
	
	static ChatPrefixes instance = new ChatPrefixes();
	   
    public static ChatPrefixes getInstance() {
            return instance;
    }
    
    public String Prefix(String a) {
    	
        switch(a) {
        case "owner":
        	String owner = ChatColor.DARK_RED + "" + ChatColor.BOLD + "Owner";
            return owner;
        case "admin":
        	String admin = ChatColor.RED + "" + ChatColor.BOLD + "Admin";
            return admin;
        case "headdev":
        	String headdev = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Head-Dev";
            return headdev;
        case "dev":
        	String dev = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Dev";
            return dev;
        case "eventmanager":
        	String eventmanager = ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "EventManager";
            return eventmanager;
        case "moderator":
        	String moderator = ChatColor.BLUE + "" + ChatColor.BOLD + "Moderator";
            return moderator;
        case "support":
        	String support = ChatColor.YELLOW + "" + ChatColor.BOLD + "Support";
            return support;
        default:
        	String def = null;
            return def;
        }
        
    }

}
