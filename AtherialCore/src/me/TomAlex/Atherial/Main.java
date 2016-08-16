package me.TomAlex.Atherial;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Combat.PlayerJoinSet;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();

	public void onEnable() {
		settings.setup(this);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new PlayerJoinSet(), this);
		
	}
	
	public void onDisable() {
		
	}
}
