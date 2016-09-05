package me.TomAlex.Atherial.Dungeons;

import java.util.Arrays;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.TomAlex.Atherial.SettingsManager;

public class DungeonGolems implements Listener 
{
	SettingsManager settings = SettingsManager.getInstance();
	String messager = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD
			+ ChatColor.BOLD.toString() + "DUNGEON > " + ChatColor.GREEN;
	
	Location maw1 = new Location(Bukkit.getWorld("world"), -408, 70, -707);
	@EventHandler
	public void onPlayerInteract(PlayerInteractEntityEvent e)
	{
		Entity entity = e.getRightClicked();
		Player p = e.getPlayer();
		String pn = p.getName();
		UUID ud = p.getUniqueId();
		
		if (entity instanceof Golem) 
		{
			if(entity.getCustomName() == null){
				e.setCancelled(true);
				return;
			}
			if(entity.getCustomName().equalsIgnoreCase(ChatColor.GREEN + ChatColor.BOLD.toString() + "Maw of Souls"))
			{
				if(!settings.partyPeople.contains(ud))
				{
					p.sendMessage(messager + "You are not in a party! Create a party to join a Dungeon.");
					return;
				}
				String leader = settings.partyLeaders.get(pn);
				if(settings.Dungeonleaders.containsKey(leader))
				{
					p.sendMessage(messager + " Joined Maw of Souls Dungeon");
					p.teleport(maw1);
					return;
				}else if(!settings.partys.containsKey(pn))
				{
					p.sendMessage(messager + "Only the party leader can start a Dungeon.");
					return;
				}
				
				Inventory dungeon = Bukkit.createInventory(null, 27,
						ChatColor.GOLD+ ChatColor.BOLD.toString() + "Maw of Souls Dungeon");
				
				ItemStack yes = new ItemStack(Material.WOOL, 1, (byte) 5);
				ItemMeta yesMeta = yes.getItemMeta();	
				yesMeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString()+ "Yes join Maw of Souls Dungeon!");
				yesMeta.setLore(Arrays.asList("", ChatColor.YELLOW + "Recommended requiremts:"
				,ChatColor.DARK_RED +  "\u2764" + ChatColor.RED + "600+ Health"
				,ChatColor.RED + "3+ Players"));
				yes.setItemMeta(yesMeta);
				
				ItemStack no = new ItemStack(Material.WOOL, 1, (byte) 14);
				ItemMeta noMeta = no.getItemMeta();	
				noMeta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString()+ "No do not join this Dungeon");
				noMeta.setLore(Arrays.asList("", ChatColor.YELLOW + "Recommended requiremts:"
						,ChatColor.DARK_RED +  "\u2764" + ChatColor.RED + "600+ Health"
						,ChatColor.RED + "3+ Players"));
				no.setItemMeta(noMeta);
				
				dungeon.setItem(12, yes);
				dungeon.setItem(14, no);

				p.openInventory(dungeon);	
			}
			
			
		}else return;
	}
}
