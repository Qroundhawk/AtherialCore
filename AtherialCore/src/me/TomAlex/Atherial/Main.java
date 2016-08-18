package me.TomAlex.Atherial;

import me.TomAlex.Atherial.ArmorEquipEvent.ArmorListener;
import me.TomAlex.Atherial.Combat.ArmorEquipting;
import me.TomAlex.Atherial.Combat.PlayerJoinSet;
import me.TomAlex.Atherial.Commands.EcoAddBankCommand;
import me.TomAlex.Atherial.Commands.EcoAddMarketCommand;
import me.TomAlex.Atherial.Commands.EcoMoneyCommand;
import me.TomAlex.Atherial.Commands.EcoSetStorageCommand;
import me.TomAlex.Atherial.Commands.TestCommand;
import me.TomAlex.Atherial.Economy.MenuBankClickEvent;
import me.TomAlex.Atherial.Economy.MenuStorageClickEvent;
import me.TomAlex.Atherial.Economy.StorageCloseEvent;
import me.TomAlex.Atherial.Economy.VillagerEvent;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.event.EventHandler;
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
		
		/*@Event registers*/
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		
		//@Join Events
		pm.registerEvents(new JoinEvent(), this);
		
		//@Combat Events
		pm.registerEvents(new PlayerJoinSet(), this);
		pm.registerEvents(new ArmorEquipting(), this);
		pm.registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
		
		//@Economy Events
		pm.registerEvents(new JoinEvent(), this);
		pm.registerEvents(new VillagerEvent(), this);
		pm.registerEvents(new MenuBankClickEvent(), this);
		pm.registerEvents(new MenuStorageClickEvent(), this);
		pm.registerEvents(new StorageCloseEvent(), this);
		

		
		
		
		
		
		/*@Command registers*/
		
		//@Ecomony Commands
		getCommand("addbank").setExecutor(new EcoAddBankCommand());
		getCommand("addmarket").setExecutor(new EcoAddMarketCommand());
		getCommand("money").setExecutor(new EcoMoneyCommand());
		getCommand("setstorage").setExecutor(new EcoSetStorageCommand());
		
		
		
		
		
		//@Extra Comamnds
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
