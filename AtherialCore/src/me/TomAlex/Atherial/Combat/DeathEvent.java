package me.TomAlex.Atherial.Combat;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;


public class DeathEvent implements Listener 
{
	SettingsManager settings = SettingsManager.getInstance();
	
	ItemStack boots = null;
	ItemStack legs = null;
	ItemStack chest = null;
	ItemStack helm = null;
	ItemStack sword = null;
	ItemStack pickaxe = null;

	@EventHandler
	public void itemsafer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		boots = p.getEquipment().getBoots();
		legs = p.getEquipment().getLeggings();
		chest = p.getEquipment().getChestplate();
		helm = p.getEquipment().getHelmet();
		sword = p.getInventory().getItem(0);

		e.getDrops().clear();

		int i = 1;
		while (i <= 35) {
			if (p.getInventory().getItem(i) != null) {
				if (p.getInventory().getItem(i).getType().toString().contains("PICKAXE")) {
					pickaxe = p.getInventory().getItem(i);
				} else {
					if (i != 8) {
						e.getDrops().add(p.getInventory().getItem(i));
					}
				}
			}
			i++;
		}

		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getProvidingPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				
					p.spigot().respawn();
					if (boots != null) {
						p.getInventory().addItem(boots);
					}
					if (legs != null) {
						p.getInventory().addItem(legs);
					}
					if (chest != null) {
						p.getInventory().addItem(chest);
					}
					if (helm != null) {
						p.getInventory().addItem(helm);
					}
					if (sword != null) {
						p.getInventory().addItem(sword);
					}
					if (pickaxe != null) {
						p.getInventory().addItem(pickaxe);
					}

					p.getInventory().setItem(8, new ItemStack(Material.COMPASS));
					if(settings.pvptoggle.contains(p.getUniqueId()))
					{
						settings.pvptoggle.remove(p.getUniqueId());
					}
			}
		}, 1);

	}

}
