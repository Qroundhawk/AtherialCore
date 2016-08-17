package me.TomAlex.Atherial;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Combat.ArmorEquipting;
import me.TomAlex.Atherial.ArmorEquipEvent.ArmorListener;
import me.TomAlex.Atherial.Combat.PlayerJoinSet;
import me.TomAlex.Atherial.Commands.TestCommand;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
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
		
		
		//Join Event
		//pm.registerEvents(new JoinEvent(), this);
		
		
		//Combat Event
		pm.registerEvents(new PlayerJoinSet(), this);
		pm.registerEvents(new ArmorEquipting(), this);
		pm.registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
		
		
		getCommand("test").setExecutor(new TestCommand());
	}
	
	public void onDisable() {
		
	}
	
	
}
