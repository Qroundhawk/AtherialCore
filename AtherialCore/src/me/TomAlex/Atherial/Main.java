package me.TomAlex.Atherial;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Combat.ArmorEquipting;
import me.TomAlex.Atherial.ArmorEquipEvent.ArmorListener;
import me.TomAlex.Atherial.Combat.PlayerJoinSet;
import me.TomAlex.Atherial.Commands.TestCommand;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public static Economy econ = null;
	SettingsManager settings = SettingsManager.getInstance();

	public void onEnable() {
		JavaPlugin.getProvidingPlugin(Main.class);
		settings.setup(this);
		
		if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		
		
		//@Join Event
		//pm.registerEvents(new JoinEvent(), this);
		
		
		//@Combat Event
		pm.registerEvents(new PlayerJoinSet(), this);
		pm.registerEvents(new ArmorEquipting(), this);
		pm.registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
		
		
		getCommand("test").setExecutor(new TestCommand());
	}
	
	public void onDisable() {
		
	}
	
	public static Economy getEcon(){
        return econ;
    }
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
