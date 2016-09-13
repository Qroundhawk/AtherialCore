package me.TomAlex.Atherial;

import me.TomAlex.Atherial.ArmorEquipEvent.ArmorListener;
import me.TomAlex.Atherial.Chat.ChatEvent;
import me.TomAlex.Atherial.Chat.ChatStartup;
import me.TomAlex.Atherial.Chat.HorsesJUSTIN.HorseGUIClickEvent;
import me.TomAlex.Atherial.Combat.ArmorEquipting;
import me.TomAlex.Atherial.Combat.CombatTagger;
import me.TomAlex.Atherial.Combat.DeathEvent;
import me.TomAlex.Atherial.Combat.Hitting;
import me.TomAlex.Atherial.Combat.PlayerJoinSet;
import me.TomAlex.Atherial.Combat.PlayerMenu;
import me.TomAlex.Atherial.Combat.PlayerRemoveSet;
import me.TomAlex.Atherial.Combat.PlayerUpdater;
import me.TomAlex.Atherial.Commands.AddGolems;
import me.TomAlex.Atherial.Commands.ChatGlobalChat;
import me.TomAlex.Atherial.Commands.ChatPrefixRefresh;
import me.TomAlex.Atherial.Commands.ChatSetChatPrefix;
import me.TomAlex.Atherial.Commands.ChatStaffChat;
import me.TomAlex.Atherial.Commands.EcoAddBankCommand;
import me.TomAlex.Atherial.Commands.EcoAddMarketCommand;
import me.TomAlex.Atherial.Commands.EcoMoneyCommand;
import me.TomAlex.Atherial.Commands.EcoSetStorageCommand;
import me.TomAlex.Atherial.Commands.GlobalMarketCommand;
import me.TomAlex.Atherial.Commands.ItemDisenchanter;
import me.TomAlex.Atherial.Commands.MineRespawnOreCommand;
import me.TomAlex.Atherial.Commands.MineSpawnPickaxeCommand;
import me.TomAlex.Atherial.Commands.PartyCommand;
import me.TomAlex.Atherial.Commands.RepairSmithCommand;
import me.TomAlex.Atherial.Commands.TestCommand;
import me.TomAlex.Atherial.Commands.TestCommand2;
import me.TomAlex.Atherial.Commands.Legions.LegionCommand;
import me.TomAlex.Atherial.Dungeons.DungeonGolems;
import me.TomAlex.Atherial.Dungeons.MawDungeon;
import me.TomAlex.Atherial.Dungeons.PartyPlaceHolders;
import me.TomAlex.Atherial.Durability.DuraShops;
import me.TomAlex.Atherial.Durability.Infidura;
import me.TomAlex.Atherial.Durability.ItemDurabillity;
import me.TomAlex.Atherial.Durability.RepairShop;
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
import me.TomAlex.Atherial.PlayerMenu.PlayerMenuClickEvent;
import me.TomAlex.Atherial.PlayerMenu.PlayerMenuEvent;
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
	ChatStartup chatstartup = ChatStartup.getInstance();
	PartyPlaceHolders partyplaceholders = PartyPlaceHolders.getInstance();
	
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
		
		//@Dungeon Events
		pm.registerEvents(new DungeonGolems(), this);
		pm.registerEvents(new MawDungeon(), this);
		
		//@Join Events
		pm.registerEvents(new JoinEvent(), this);
		
		//@Combat Events
		pm.registerEvents(new PlayerJoinSet(), this);
		pm.registerEvents(new PlayerRemoveSet(), this);
		pm.registerEvents(new ArmorEquipting(), this);
		pm.registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
		pm.registerEvents(new Hitting(), this);
		pm.registerEvents(new PlayerMenu(), this);
		pm.registerEvents(new CombatTagger(), this);
		pm.registerEvents(new DeathEvent(), this);
		
		//@Dura Events
		pm.registerEvents(new Infidura(), this);
		pm.registerEvents(new DuraShops(), this);
		pm.registerEvents(new ItemDurabillity(), this);
		pm.registerEvents(new RepairShop(), this);
		
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
		
		//@Chat Events
		pm.registerEvents(new ChatEvent(), this);
		
		//@PlayerInfo Events
		pm.registerEvents(new PlayerMenuEvent(), this);
		pm.registerEvents(new PlayerMenuClickEvent(), this);
		
		//@HorseJUSTIN Events
		pm.registerEvents(new HorseGUIClickEvent(), this);
		
		
		
		

		/*@Command registers*/	
		
		
		//@DungeonsCommands;
		getCommand("party").setExecutor(new PartyCommand());
		getCommand("dungeon").setExecutor(new AddGolems());
		
		//@Ecomony Commands
		getCommand("addbank").setExecutor(new EcoAddBankCommand());
		getCommand("addmarket").setExecutor(new EcoAddMarketCommand());
		getCommand("money").setExecutor(new EcoMoneyCommand());
		getCommand("setstorage").setExecutor(new EcoSetStorageCommand());
		
		
		//@Mining Commands
		getCommand("respawnore").setExecutor(new MineRespawnOreCommand());
		getCommand("spawnpickaxe").setExecutor(new MineSpawnPickaxeCommand());
		
		//@Mining Shops
		getCommand("repairsmith").setExecutor(new RepairSmithCommand());
		getCommand("itemdisenchanter").setExecutor(new ItemDisenchanter());
		getCommand("globalmarket").setExecutor(new GlobalMarketCommand());
		
		//@Extra Comamnds
		getCommand("test").setExecutor(new TestCommand());
		getCommand("test2").setExecutor(new TestCommand2());
		
		//@Chat Comamnds
		getCommand("setchatprefix").setExecutor(new ChatSetChatPrefix());
		getCommand("prefixrefresh").setExecutor(new ChatPrefixRefresh());
		getCommand("globalchat").setExecutor(new ChatGlobalChat());
		getCommand("staffchat").setExecutor(new ChatStaffChat());
		
		//@Legions Commands
		getCommand("legion").setExecutor(new LegionCommand());
		
		
		mining.miningRespawn();
		miningore.miningStart();
		updater.UpdaterStart();
		updater.ExpHealth();
		chatstartup.Startup();
		chatstartup.Timer();
		chatstartup.Refresh();
		partyplaceholders.partyPlaceHolders();
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
