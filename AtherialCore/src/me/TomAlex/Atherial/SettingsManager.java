package me.TomAlex.Atherial;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {
	 
    private SettingsManager() { }
   
    static SettingsManager instance = new SettingsManager();
   
    public static SettingsManager getInstance() {
            return instance;
    }
   
    Plugin p;
   
    FileConfiguration config;
    File cfile;
   
    FileConfiguration playerdata;
    File pdfile;
    
    FileConfiguration uuiddata;
    File udfile;
    
    FileConfiguration storagedata;
    File stfile;
    
    FileConfiguration oredata;
    File orfile;
    
    FileConfiguration levelexpdata;
    File lefile;
    
    
    
    //@Combat HashMaps
    public HashMap<UUID, Integer> Health = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> Armor = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> Block = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> Thorns = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> PvP = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> PvE = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> Vit = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> Regen = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> Tagger = new HashMap<UUID, Integer>();
	
	//@Mining HashMaps
	public HashMap<String, Integer> Coal = new HashMap<String, Integer>();
	public HashMap<String, Integer> Emerald = new HashMap<String, Integer>();
	public HashMap<String, Integer> Iron = new HashMap<String, Integer>();
	public HashMap<String, Integer> Gold = new HashMap<String, Integer>();
	public HashMap<String, Integer> Diamond = new HashMap<String, Integer>();
	public HashMap<String, Integer> Lapis = new HashMap<String, Integer>();
	//@Mining respawnrate in seconds
	public int CoalRespawn = 10;
	public int EmeraldRespawn = 20;
	public int IronRespawn = 30;
	public int GoldRespawn = 40;
	public int DiamondRespawn = 50;
	public int LapisRespawn = 60;
	//@Mining OreXP in seconds
	public int CoalXPMin = 40;//40
	public int EmeraldXPMin = 40;
	public int IronXPMin = 100;
	public int GoldXPMin = 200;
	public int DiamondXPMin = 300;
	public int LapisXPMin = 400;
	
	public int CoalXPMax = 60;//60
	public int EmeraldXPMax = 60;
	public int IronXPMax = 150;
	public int GoldXPMax = 250;
	public int DiamondXPMax = 400;
	public int LapisXPMax = 500;
	
	
	
	
	
	
    
    public void setup(Plugin p) {
            cfile = new File(p.getDataFolder(), "config.yml");
            config = p.getConfig();
            //config.options().copyDefaults(true);
            //saveConfig();
           
            if (!p.getDataFolder().exists()) {
                    p.getDataFolder().mkdir();
            }
            
            
           
            pdfile = new File(p.getDataFolder(), "playerdata.yml");
            if (!pdfile.exists()) {
                    try {
                    	pdfile.createNewFile();
                    }
                    catch (IOException e) {
                            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create playerdata.yml!");
                    }
            }
            playerdata = YamlConfiguration.loadConfiguration(pdfile);
            
            
            
            udfile = new File(p.getDataFolder(), "uuiddata.yml");
            if (!udfile.exists()) {
                    try {
                    	udfile.createNewFile();
                    }
                    catch (IOException e) {
                            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create uuiddata.yml!");
                    }
            }
            uuiddata = YamlConfiguration.loadConfiguration(udfile);
            
            
            
            stfile = new File(p.getDataFolder(), "storagedata.yml");
            if (!stfile.exists()) {
                    try {
                    	stfile.createNewFile();
                    }
                    catch (IOException e) {
                            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create storagedata.yml!");
                    }
            }
            storagedata = YamlConfiguration.loadConfiguration(stfile);
            
            
            
            orfile = new File(p.getDataFolder(), "oredata.yml");
            if (!orfile.exists()) {
                    try {
                    	orfile.createNewFile();
                    }
                    catch (IOException e) {
                            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create oredata.yml!");
                    }
            }
            oredata = YamlConfiguration.loadConfiguration(orfile);
            
            
            
            lefile = new File(p.getDataFolder(), "levelexpdata.yml");
            if (!lefile.exists()) {
                    try {
                    	lefile.createNewFile();
                    }
                    catch (IOException e) {
                            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create levelexpdata.yml!");
                    }
            }
            levelexpdata = YamlConfiguration.loadConfiguration(lefile);


            
            
    } 
    //===========================================================
   
    
    
    
    
    
    
    
    
    public FileConfiguration getPlayerData() {
            return playerdata;
    }
   
    public void savePlayerData() {
            try {
            	playerdata.save(pdfile);
            }
            catch (IOException e) {
                    Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save playerdata.yml!");
            }
    }
   
    public void reloadPlayerData() {
    	playerdata = YamlConfiguration.loadConfiguration(pdfile);
    }
    
    
    
    
    public FileConfiguration getUuidData() {
        return uuiddata;
    }

    public void saveUuidData() {
        	try {
        		uuiddata.save(udfile);
        	}
        	catch (IOException e) {
                	Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save uuiddata.yml!");
        	}
    }

    public void reloadUuidData() {
    	uuiddata = YamlConfiguration.loadConfiguration(udfile);
    }
    
    
    
    
    public FileConfiguration getStorageData() {
        return storagedata;
    }

    public void saveStorageData() {
        	try {
        		storagedata.save(stfile);
        	}
        	catch (IOException e) {
                	Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save storagedata.yml!");
        	}
    }

    public void reloadStorageData() {
    	storagedata = YamlConfiguration.loadConfiguration(stfile);
    }
    
    
    
    
    public FileConfiguration getOreData() {
        return oredata;
    }

    public void saveOreData() {
        	try {
        		oredata.save(orfile);
        	}
        	catch (IOException e) {
                	Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save oredata.yml!");
        	}
    }

    public void reloadOreData() {
    	oredata = YamlConfiguration.loadConfiguration(orfile);
    }
    
    
    
    
    public FileConfiguration getLevelExpData() {
        return levelexpdata;
    }

    public void saveLevelExpData() {
        	try {
        		levelexpdata.save(lefile);
        	}
        	catch (IOException e) {
                	Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save levelexpdata.yml!");
        	}
    }

    public void reloadLevelExpData() {
    	levelexpdata = YamlConfiguration.loadConfiguration(lefile);
    }
    
    //===========================================================
    
    public FileConfiguration getConfig() {
            return config;
    }
    public void saveConfig() {
            try {
                    config.save(cfile);
            }
            catch (IOException e) {
                    Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
            }
    }
   
    public void reloadConfig() {
            config = YamlConfiguration.loadConfiguration(cfile);
    }
    
    
    
    
    
   
    public PluginDescriptionFile getDesc() {
            return p.getDescription();
    }


}
