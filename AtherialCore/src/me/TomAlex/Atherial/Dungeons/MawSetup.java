package me.TomAlex.Atherial.Dungeons;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;

public class MawSetup 
{
	private MawSetup() {
	}

	static MawSetup instance = new MawSetup();

	public static MawSetup getInstance() {
		return instance;
	}
	
	Location maw1s1 = new Location(Bukkit.getWorld("world"), -408, 70, -707);
	Location loc = new Location(Bukkit.getWorld("world"), -408, 70, -707);
	public ArrayList<UUID> maw1mobs = new ArrayList<UUID>();
	
	public void maw1set()
	{
		Skeleton s = (Skeleton) Bukkit.getServer().getWorld("world").spawnEntity(maw1s1, EntityType.SKELETON);
		s.setCustomName( "Level 19:" + ChatColor.GRAY + ChatColor.BOLD.toString()+ "Maw Guard");
		s.setCustomNameVisible(true);
		s.setMaxHealth(100);
		s.getEquipment().setItemInHand(new ItemStack(Material.STICK));
		maw1mobs.add(s.getUniqueId());
		
	}
	
	public void maw1reset()
	{

		for (Entity i : loc.getWorld().getNearbyEntities(loc, 15, 15, 15)) 
		{
			if(i instanceof Skeleton)
			{
				((Skeleton) i).setHealth(0);
			}
		}
	}

}
