package me.TomAlex.Atherial;

import java.io.File;
import java.io.IOException;

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
