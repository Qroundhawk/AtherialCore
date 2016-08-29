package me.TomAlex.Atherial.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

public class ChatStartup {

	SettingsManager settings = SettingsManager.getInstance();
	
	private ChatStartup() { }
	
	static ChatStartup instance = new ChatStartup();
	   
    public static ChatStartup getInstance() {
            return instance;
    }
    
    public void Startup() {
    	
		new BukkitRunnable() {
			public void run() {
				
				
				
				cancel();
			}
		}.runTaskLater(JavaPlugin.getProvidingPlugin(Main.class), 60);
    	
    	return;
    }
    
    
    
    
    
    
    
    
    public void Timer() {
    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable () {
			public void run() {
				
				if (settings.ShoutTimer.isEmpty() == false) {
					List<String> toRemove = new ArrayList<String>();
					for (Entry<String, Integer> i : settings.ShoutTimer.entrySet()) {
						i.setValue(i.getValue() - 2);
					}
					for (Entry<String, Integer> i : settings.ShoutTimer.entrySet()) {
						if (i.getValue() <= 0) {
							if (!toRemove.contains(i.getKey())) {
								toRemove.add(i.getKey());
							}
						}
					}
					for (String i : toRemove) {
						settings.ShoutTimer.remove(i);
					}
				}
				
			}
		}, 100, 40);
    	
    	
    	return;
    }
}
