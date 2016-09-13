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
	
	ArrayList<Location> spawners = new ArrayList<Location>();
	Location maw1s1 = new Location(Bukkit.getWorld("world"), -408, 70, -707);
	Location maw1s2 = new Location(Bukkit.getWorld("world"), -398, 70, -707);
	
	
	Location maw1center = new Location(Bukkit.getWorld("world"), -408, 70, -707);
	
	public void addspawners()
	{
		spawners.add(maw1s1);
		spawners.add(maw1s2);
	}
	
	public void maw1set()
	{
		addspawners();
		
		for(Location i : spawners)
		{
			Skeleton s = (Skeleton) Bukkit.getServer().getWorld("world").spawnEntity(i, EntityType.SKELETON);
			s.setCustomName( "Level 19:" + ChatColor.GRAY + ChatColor.BOLD.toString()+ "Maw Guard");
			s.setCustomNameVisible(true);
			s.setMaxHealth(100);
			s.getEquipment().setItemInHand(new ItemStack(Material.STICK));
			
		}
		spawners.clear();
		
	}
	
	public void maw1reset()
	{

		for (Entity i : maw1center.getWorld().getNearbyEntities(maw1center, 15, 15, 15)) 
		{
			if(i instanceof Skeleton)
			{
				((Skeleton) i).setHealth(0);
			}
		}
	}

}
