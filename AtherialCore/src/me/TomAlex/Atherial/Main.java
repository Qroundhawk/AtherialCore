package me.TomAlex.Atherial;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Combat.PlayerJoinSet;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();

	public void onEnable() {
		JavaPlugin.getProvidingPlugin(Main.class);
		settings.setup(this);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new PlayerJoinSet(), this);
		
	}
	
	public void onDisable() {
		
	}
	
	public HashMap<UUID, Integer> Health = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> Armor = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> Damage = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> LifeSteal = new HashMap<UUID, Integer>();
	
	
}
