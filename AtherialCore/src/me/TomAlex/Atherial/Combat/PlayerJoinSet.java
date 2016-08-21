package me.TomAlex.Atherial.Combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.TomAlex.Atherial.Main;



public class PlayerJoinSet implements Listener
{

	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void PlayerJoin(PlayerLoginEvent event) {
		Player p = event.getPlayer();
		UUID ud = p.getUniqueId();
		
		new BukkitRunnable() {

			public void run() {
				if (!(event.getPlayer().hasPlayedBefore())) {
					event.getPlayer().setMaxHealth(100);
					event.getPlayer().setHealthScale(40);
					event.getPlayer().setHealth(event.getPlayer().getMaxHealth());
					event.getPlayer().sendMessage(org.bukkit.ChatColor.GREEN + "Welcome to the server!");
					Location spawn = new Location(event.getPlayer().getWorld(), -538, 25, -504);
					event.getPlayer().teleport(spawn);

					ItemStack sword1 = new ItemStack(Material.WOOD_SWORD);
					ItemMeta swordMeta1 = sword1.getItemMeta();
					List<String> swordLore1 = new ArrayList<String>();
					swordMeta1.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString()
							+ "Training Sword");
					swordLore1.add(ChatColor.GREEN + "UNCOMMON item T1");
					swordLore1
							.add(ChatColor.RED + "   ☼DAMAGE: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+16");
					swordLore1.add(ChatColor.RED + "____________________");
					swordLore1.add(ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE + ChatColor.BOLD.toString()
							+ "[ 100 / 100 ]");
					swordMeta1.setLore(swordLore1);
					sword1.setItemMeta(swordMeta1);

					ItemStack thelm = new ItemStack(Material.LEATHER_HELMET);
					ItemMeta thelmmeta = thelm.getItemMeta();
					List<String> thelmlore = new ArrayList<String>();
					thelmmeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString()
							+ "Training Helm");
					thelmlore.add(ChatColor.GREEN + "Common item T1");
					thelmlore.add(ChatColor.RED + "   ☼Armor: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+2");
					thelmlore.add(ChatColor.RED + "   ☼HEALTH: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+10");
					swordLore1.add(ChatColor.RED + "____________________");
					swordLore1.add(ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE + ChatColor.BOLD.toString()
							+ "[ 100 / 100 ]");
					thelmmeta.setLore(thelmlore);
					thelm.setItemMeta(thelmmeta);

					ItemStack tboots = new ItemStack(Material.LEATHER_BOOTS);
					ItemMeta tbootsmmeta = tboots.getItemMeta();
					List<String> tbootslore = new ArrayList<String>();
					tbootsmmeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString()
							+ "Training Boots");
					tbootslore.add(ChatColor.GREEN + "Common item T1");
					tbootslore.add(ChatColor.RED + "   ☼Armor: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+2");
					tbootslore
							.add(ChatColor.RED + "   ☼HEALTH: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+10");
					tbootslore.add(ChatColor.RED + "____________________");
					tbootslore.add(ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE + ChatColor.BOLD.toString()
							+ "[ 100 / 100 ]");
					tbootsmmeta.setLore(tbootslore);
					tboots.setItemMeta(tbootsmmeta);

					ItemStack tchest = new ItemStack(Material.LEATHER_CHESTPLATE);
					ItemMeta tchestmmeta1 = tchest.getItemMeta();
					List<String> tchestlore1 = new ArrayList<String>();
					tchestmmeta1.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString()
							+ ChatColor.ITALIC.toString() + "Training Chest");
					tchestlore1.add(ChatColor.GREEN + "Common item T1");
					tchestlore1.add(ChatColor.RED + "   ☼Armor: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+3");
					tchestlore1
							.add(ChatColor.RED + "   ☼HEALTH: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+15");
					tchestlore1.add(ChatColor.RED + "____________________");
					tchestlore1.add(ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE + ChatColor.BOLD.toString()
							+ "[ 100 / 100 ]");
					tchestmmeta1.setLore(tchestlore1);
					tchest.setItemMeta(tchestmmeta1);

					ItemStack tlegs = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemMeta tlegsmeta = tlegs.getItemMeta();
					List<String> tlegslore1 = new ArrayList<String>();
					tlegsmeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString()
							+ "Training Legs");
					tlegslore1.add(ChatColor.GREEN + "Common item T1");
					tlegslore1.add(ChatColor.RED + "   ☼Armor: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+3");
					tlegslore1
							.add(ChatColor.RED + "   ☼HEALTH: " + ChatColor.WHITE + ChatColor.BOLD.toString() + "+13");
					tlegslore1.add(ChatColor.RED + "____________________");
					tlegslore1.add(ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE + ChatColor.BOLD.toString()
							+ "[ 100 / 100 ]");
					tlegsmeta.setLore(tlegslore1);
					tlegs.setItemMeta(tlegsmeta);

					ItemStack tapple = new ItemStack(Material.APPLE, 30);
					event.getPlayer().getInventory().addItem(sword1, thelm, tlegs, tchest, tboots, tapple);

				}else event.getPlayer().setHealthScale(40);
				
				p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16);
				
				ItemStack pmenu = new ItemStack(Material.COMPASS);
				ItemMeta pmenuMeta = pmenu.getItemMeta();
				List<String> pmenuLore = new ArrayList<String>();
				pmenuMeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString() + "Player Menu");
				pmenuLore.add(ChatColor.WHITE + "Right click to open Player Menu");
				pmenuMeta.setLore(pmenuLore);
				pmenu.setItemMeta(pmenuMeta);
				p.getInventory().setItem(8, pmenu);
				
				
				//---------------------------setting stats--------------------------
				settings.Armor.put(p.getUniqueId(), 0);
				settings.Regen.put(p.getUniqueId(), 0);
				settings.Block.put(p.getUniqueId(), 0);
				settings.Thorns.put(p.getUniqueId(), 0);
				settings.Vit.put(p.getUniqueId(), 0);
				settings.PvP.put(p.getUniqueId(), 0);
				settings.PvE.put(p.getUniqueId(), 0);
				
				int i = 1;
				ItemStack armor = null;
				while(i <= 4)
				{
					switch(i)
					{
					case 1: armor = p.getInventory().getHelmet();
					break;
					case 2: armor = p.getInventory().getChestplate();
					break;
					case 3: armor = p.getInventory().getLeggings();
					break;
					case 4: armor = p.getInventory().getBoots();
					break;
					}
		
					if(armor != null)
					{
						String loreArmor = armor.getItemMeta().getLore().get(3);
						Scanner in1 = new Scanner(loreArmor).useDelimiter("[^0-9]+");
						int a = in1.nextInt();
						int currentarmor = settings.Armor.get(p.getUniqueId());
						int newarmor =  currentarmor +a;
						settings.Armor.put(p.getUniqueId(), newarmor);
						
						//----------HealthRegen-----------------
						if(armor.getItemMeta().getLore().size() >= 14)
						{
							String loreRegen = armor.getItemMeta().getLore().get(4);
							Scanner in4 = new Scanner(loreRegen).useDelimiter("[^0-9]+");
							int regen = in4.nextInt();
							int currentregen = settings.Regen.get(ud);
							int newregen =  currentregen +regen;
							settings.Regen.put(ud, newregen);		
						}	
						//----------BlockChance-----------------
						if(armor.getItemMeta().getLore().size() >= 15)
						{
							String loreBlock = armor.getItemMeta().getLore().get(5);
							Scanner in5 = new Scanner(loreBlock).useDelimiter("[^0-9]+");
							int block = in5.nextInt();
							int currentblock = settings.Block.get(ud);
							int newblock =  currentblock + block ;
							settings.Block.put(ud, newblock);
							
						}		
						//----------Thorns----------------------
						if(armor.getItemMeta().getLore().size() >= 16)
						{
							String loreThorns = armor.getItemMeta().getLore().get(6);
							Scanner in6 = new Scanner(loreThorns).useDelimiter("[^0-9]+");
							int Thorns = in6.nextInt();
							int currentThorns = settings.Thorns.get(ud);
							int newThorns =  currentThorns +Thorns ;
							settings.Thorns.put(ud, newThorns);				
						}


						//----------Vit-------------------------
						if(armor.getItemMeta().getLore().size() >= 17)
						{
							String loreVit = armor.getItemMeta().getLore().get(7);
							Scanner in7 = new Scanner(loreVit).useDelimiter("[^0-9]+");
							int Vit = in7.nextInt();
							int currentVit = settings.Vit.get(ud);
							int newVit =  currentVit +Vit ;
							settings.Vit.put(ud, newVit);				
						}
						
						
				
						//----------PvP Or PvE restistance------
						if(armor.getItemMeta().getLore().size() >= 18)
						{
							String lorePvP = armor.getItemMeta().getLore().get(8);
							
							if (lorePvP.indexOf("PvP") != -1) 
							{
								Scanner in8 = new Scanner(lorePvP).useDelimiter("[^0-9]+");
								int PvP = in8.nextInt();
								int currentPvP = settings.PvP.get(p.getUniqueId());
								int newPvP =  currentPvP + PvP ;
								settings.PvP.put(p.getUniqueId(), newPvP);	
								
							}else if(lorePvP.indexOf("PvE") != -1){
								Scanner in8 = new Scanner(lorePvP).useDelimiter("[^0-9]+");
								int PvP = in8.nextInt();
								int currentPvP = settings.PvE.get(p.getUniqueId());
								int newPvP =  currentPvP + PvP ;
								settings.PvE.put(p.getUniqueId(), newPvP);
							}							
						}
					}
					i++;
				}
				
				
				
				cancel();
			}
		}.runTaskLater(JavaPlugin.getProvidingPlugin(Main.class), 20);

	}

}
