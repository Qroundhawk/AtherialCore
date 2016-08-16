package me.TomAlex.AtherialRunes;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener 
{
	public static Logger log = Bukkit.getLogger();

	public static void out(String s) 
	{
		log.info("Test" + s);
	}

	public void onEnable() {
		out("Plugin enabled");
		saveDefaultConfig();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
	
	String test = "Test";
}
