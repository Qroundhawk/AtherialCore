package me.TomAlex.Atherial;

import me.TomAlex.Atherial.ArmorEquipEvent.ArmorListener;
import me.TomAlex.Atherial.Combat.ArmorEquipting;
import me.TomAlex.Atherial.Combat.Hitting;
import me.TomAlex.Atherial.Combat.PlayerJoinSet;
import me.TomAlex.Atherial.Combat.PlayerMenu;
import me.TomAlex.Atherial.Combat.PlayerRemoveSet;
import me.TomAlex.Atherial.Combat.PlayerUpdater;
import me.TomAlex.Atherial.Commands.EcoAddBankCommand;
import me.TomAlex.Atherial.Commands.EcoAddMarketCommand;
import me.TomAlex.Atherial.Commands.EcoMoneyCommand;
import me.TomAlex.Atherial.Commands.EcoSetStorageCommand;
import me.TomAlex.Atherial.Commands.TestCommand;
import me.TomAlex.Atherial.Commands.TestCommand2;
import me.TomAlex.Atherial.Economy.MenuBankClickEvent;
import me.TomAlex.Atherial.Economy.MenuStorageClickEvent;
import me.TomAlex.Atherial.Economy.StorageCloseEvent;
import me.TomAlex.Atherial.Economy.VillagerEvent;
import me.TomAlex.Atherial.Mining.OreRespawn;
import me.TomAlex.Atherial.Mining.OreSetupRespawn;
import me.TomAlex.Atherial.Mining.OreBreak.OreBreakCoal;
import me.TomAlex.Atherial.Mining.OreBreak.OreBreakDiamond;
import me.TomAlex.Atherial.Mining.OreBreak.OreBreakEmerald;
import me.TomAlex.Atherial.Mining.OreBreak.OreBreakGold;
import me.TomAlex.Atherial.Mining.OreBreak.OreBreakIron;
import me.TomAlex.Atherial.Mining.OreBreak.OreBreakLapis;
import me.TomAlex.Atherial.Mining.OreRegisteration.OreRegistrationCoal;
import me.TomAlex.Atherial.Mining.OreRegisteration.OreRegistrationDiamond;
import me.TomAlex.Atherial.Mining.OreRegisteration.OreRegistrationEmerald;
import me.TomAlex.Atherial.Mining.OreRegisteration.OreRegistrationGold;
import me.TomAlex.Atherial.Mining.OreRegisteration.OreRegistrationIron;
import me.TomAlex.Atherial.Mining.OreRegisteration.OreRegistrationLapis;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public static Economy econ = null;
	SettingsManager settings = SettingsManager.getInstance();
	OreSetupRespawn mining = OreSetupRespawn.getInstance();
	OreRespawn miningore = OreRespawn.getInstance();
	PlayerUpdater updater = PlayerUpdater.getInstance();
	
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
		pm.registerEvents(new PlayerRemoveSet(), this);
		pm.registerEvents(new ArmorEquipting(), this);
		pm.registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
		pm.registerEvents(new Hitting(), this);
		pm.registerEvents(new PlayerMenu(), this);
		
		//@Economy Events
		pm.registerEvents(new JoinEvent(), this);
		pm.registerEvents(new VillagerEvent(), this);
		pm.registerEvents(new MenuBankClickEvent(), this);
		pm.registerEvents(new MenuStorageClickEvent(), this);
		pm.registerEvents(new StorageCloseEvent(), this);
		

		//@Mining Events
		pm.registerEvents(new OreRegistrationCoal(), this);
		pm.registerEvents(new OreRegistrationDiamond(), this);
		pm.registerEvents(new OreRegistrationEmerald(), this);
		pm.registerEvents(new OreRegistrationGold(), this);
		pm.registerEvents(new OreRegistrationIron(), this);
		pm.registerEvents(new OreRegistrationLapis(), this);
		
		pm.registerEvents(new OreBreakCoal(), this);
		pm.registerEvents(new OreBreakDiamond(), this);
		pm.registerEvents(new OreBreakEmerald(), this);
		pm.registerEvents(new OreBreakGold(), this);
		pm.registerEvents(new OreBreakIron(), this);
		pm.registerEvents(new OreBreakLapis(), this);
		
		

		/*@Command registers*/	
		
		//@Ecomony Commands
		getCommand("addbank").setExecutor(new EcoAddBankCommand());
		getCommand("addmarket").setExecutor(new EcoAddMarketCommand());
		getCommand("money").setExecutor(new EcoMoneyCommand());
		getCommand("setstorage").setExecutor(new EcoSetStorageCommand());
		
		
		
		
		
		//@Extra Comamnds
		getCommand("test").setExecutor(new TestCommand());
		getCommand("test2").setExecutor(new TestCommand2());
		
		
		
		mining.miningRespawn();
		miningore.miningStart();
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
