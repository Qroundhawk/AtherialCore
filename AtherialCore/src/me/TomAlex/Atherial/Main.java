package me.TomAlex.Atherial;

import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();

	public void onEnable() {
		settings.setup(this);
		
		
	}
	
	public void onDisable() {
		
	}
}
