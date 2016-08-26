package me.TomAlex.Atherial.Durability;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemDurabillity implements Listener 
{
	public HashMap<String, Integer> duraCounter =  new HashMap<>();
	public HashMap<String, Integer> armorCounter =  new HashMap<>();

	@EventHandler
	public void DurabiltyCombat(EntityDamageByEntityEvent e) 
	{
		

		Entity defender = e.getEntity();
		
		if(defender instanceof Player)
		{
			Player p = (Player) defender;
			if(e.getDamager() instanceof Player)
			{
				return;
			}
			if (armorCounter.get(p.getName()) == null) 
			{
				armorCounter.put(p.getName(), 0);
				p.sendMessage("Armor");
			}
			
			int counter = armorCounter.get(p.getName());
			counter++;

			if (counter >= 2) 
			{
				counter = 0;
				armorCounter.put(p.getName(), counter);
				
				if(p.getEquipment().getBoots() != null && p.getEquipment().getBoots().hasItemMeta())
				{
					ItemStack boots = p.getEquipment().getBoots();
					ItemMeta bootsMeta = boots.getItemMeta();
					List<String> bootsLore = bootsMeta.getLore();

					int loreSize = bootsMeta.getLore().size();
					int place = loreSize - 1;
					
					String duraLore = bootsMeta.getLore().get(place);
					Scanner in = new Scanner(duraLore).useDelimiter("[^0-9]+");
					int customDura = in.nextInt();
					
					int newcustomDura = (customDura -1);
					
					if(newcustomDura == 0)
					{
						Scanner in2 = new Scanner(bootsLore.get(2)).useDelimiter("[^0-9]+");
						double health = in2.nextDouble();
						p.setMaxHealth((p.getMaxHealth() - health));
						p.getEquipment().setBoots(null);;
					}else
					{
						bootsLore.set(place, (ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE+ChatColor.BOLD.toString() +
								"[ " + newcustomDura + " / 100 ]"));
						bootsMeta.setLore(bootsLore);
						boots.setItemMeta(bootsMeta);
						
						int maxDura = boots.getType().getMaxDurability();
						
						double perc = (newcustomDura * 1.0/100);
						boots.setDurability((short) (maxDura-(perc*maxDura)) );
						
					}
					
				}
				if(p.getEquipment().getLeggings() != null && p.getEquipment().getLeggings().hasItemMeta())
				{
					ItemStack boots = p.getEquipment().getLeggings();
					ItemMeta bootsMeta = boots.getItemMeta();
					List<String> bootsLore = bootsMeta.getLore();

					int loreSize = bootsMeta.getLore().size();
					int place = loreSize - 1;
					
					String duraLore = bootsMeta.getLore().get(place);
					Scanner in = new Scanner(duraLore).useDelimiter("[^0-9]+");
					int customDura = in.nextInt();
					
					int newcustomDura = (customDura -1);
					
					if(newcustomDura == 0)
					{
						Scanner in2 = new Scanner(bootsLore.get(2)).useDelimiter("[^0-9]+");
						double health = in2.nextDouble();
						p.setMaxHealth((p.getMaxHealth() - health));
						p.getEquipment().setLeggings(null);;
					
					}else
					{
						bootsLore.set(place, (ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE+ChatColor.BOLD.toString() +
								"[ " + newcustomDura + " / 100 ]"));
						bootsMeta.setLore(bootsLore);
						boots.setItemMeta(bootsMeta);
						
						int maxDura = boots.getType().getMaxDurability();
						
						double perc = (newcustomDura * 1.0/100);
						boots.setDurability((short) (maxDura-(perc*maxDura)) );
						
					}
					
					
				}if(p.getEquipment().getChestplate() != null && p.getEquipment().getChestplate().hasItemMeta())
				{
					ItemStack boots = p.getEquipment().getChestplate();
					ItemMeta bootsMeta = boots.getItemMeta();
					List<String> bootsLore = bootsMeta.getLore();

					int loreSize = bootsMeta.getLore().size();
					int place = loreSize - 1;
					
					String duraLore = bootsMeta.getLore().get(place);
					Scanner in = new Scanner(duraLore).useDelimiter("[^0-9]+");
					int customDura = in.nextInt();
					
					int newcustomDura = (customDura -1);
					
					if(newcustomDura == 0)
					{
						Scanner in2 = new Scanner(bootsLore.get(2)).useDelimiter("[^0-9]+");
						double health = in2.nextDouble();
						p.setMaxHealth((p.getMaxHealth() - health));
						p.getEquipment().setChestplate(null);;
			
					}else
					{
						bootsLore.set(place, (ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE+ChatColor.BOLD.toString() +
								"[ " + newcustomDura + " / 100 ]"));
						bootsMeta.setLore(bootsLore);
						boots.setItemMeta(bootsMeta);
						
						int maxDura = boots.getType().getMaxDurability();
						
						double perc = (newcustomDura * 1.0/100);
						boots.setDurability((short) (maxDura-(perc*maxDura)) );
					}
					
					
				}if(p.getEquipment().getHelmet() != null && p.getEquipment().getHelmet().hasItemMeta())
				{
					ItemStack boots = p.getEquipment().getHelmet();
					ItemMeta bootsMeta = boots.getItemMeta();
					List<String> bootsLore = bootsMeta.getLore();

					int loreSize = bootsMeta.getLore().size();
					int place = loreSize - 1;
					
					String duraLore = bootsMeta.getLore().get(place);
					Scanner in = new Scanner(duraLore).useDelimiter("[^0-9]+");
					int customDura = in.nextInt();
					
					int newcustomDura = (customDura -1);
					
					if(newcustomDura == 0)
					{
						Scanner in2 = new Scanner(bootsLore.get(2)).useDelimiter("[^0-9]+");
						double health = in2.nextDouble();
						p.setMaxHealth((p.getMaxHealth() - health));
						p.getEquipment().setHelmet(null);;
					}else
					{
						bootsLore.set(place, (ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE+ChatColor.BOLD.toString() +
								"[ " + newcustomDura + " / 100 ]"));
						bootsMeta.setLore(bootsLore);
						boots.setItemMeta(bootsMeta);
						
						int maxDura = boots.getType().getMaxDurability();
						
						double perc = (newcustomDura * 1.0/100);
						boots.setDurability((short) (maxDura-(perc*maxDura)) );
					}
					
				}				
			}else armorCounter.put(p.getName(), counter);
			
			
		}
		
		if (e.getDamager() instanceof Player) 
		{

			Player p = (Player) e.getDamager();
			

			if ((p.getItemInHand().getType().toString().toLowerCase().contains("sword"))
					|| p.getItemInHand().getType().toString().toLowerCase().contains("axe")) 
			{
				e.setCancelled(false);
			} else 
			{
				e.setCancelled(true);
				return;
			}
			

			if (duraCounter.get(p.getName()) == null) 
			{
				duraCounter.put(p.getName(), 0);
			}
		

			int counter = duraCounter.get(p.getName());
			counter++;

			if (counter >= 2) 
			{
				counter = 0;
				duraCounter.put(p.getName(), counter);
				
				ItemStack weapon = p.getItemInHand();
				
				ItemMeta weaponMeta = weapon.getItemMeta();
				List<String> weaponLore = weaponMeta.getLore();

				int loreSize = weaponMeta.getLore().size();
				int place = loreSize - 1;
				
				
				
				
				
				String duraLore = weaponMeta.getLore().get(place);
				Scanner in = new Scanner(duraLore).useDelimiter("[^0-9]+");
				int customDura = in.nextInt();
				
				int newcustomDura = (customDura -1);
				
				if(newcustomDura == 0)
				{
					p.getInventory().setItemInHand(null);
					return;
				}
				
				weaponLore.set(place, (ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE+ChatColor.BOLD.toString() +
						"[ " + newcustomDura + " / 100 ]"));
				weaponMeta.setLore(weaponLore);
				weapon.setItemMeta(weaponMeta);
				
				int maxDura = weapon.getType().getMaxDurability();
				
				double perc = (newcustomDura * 1.0/100);
				weapon.setDurability((short) (maxDura-(perc*maxDura)) );
				
			}else duraCounter.put(p.getName(), counter);
		}
	}
	
	@EventHandler
	public void repairStone(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();
		ItemStack stone = e.getCursor();
		ItemStack weapon = e.getCurrentItem();
		
		if(weapon == null)
		{
			return;
		}
		if(!(weapon.hasItemMeta()))
		{
			return;
		}
		if(!(p.getOpenInventory() instanceof PlayerInventory))
		{
			if(!(p.getOpenInventory().countSlots() == 46))
			{
				return;
			}
		}
		
		if(weapon.getType().toString().contains("SWORD") || weapon.getType().toString().contains("AXE") 
				|| weapon.getType().toString().contains("BOOTS") || weapon.getType().toString().contains("CHESTPLATE")
				|| weapon.getType().toString().contains("LEGGINGS") || weapon.getType().toString().contains("HELMET"))
		{
			int loreSize = weapon.getItemMeta().getLore().size();
			int place = loreSize - 1;
			
			ItemMeta weaponMeta = weapon.getItemMeta();
			List<String> weaponLore = weaponMeta.getLore();
			
			String tier = null;
			ItemStack repairstone = null;
			
			if(weapon.getType().toString().contains("WOOD") || weapon.getType().toString().contains("LEATHER"))
			{
				tier = "wood";
				repairstone = new ItemStack(Material.LEATHER);
			}if(weapon.getType().toString().contains("STONE") || weapon.getType().toString().contains("CHAIN"))
			{
				tier = "stone";
				repairstone = new ItemStack(Material.IRON_FENCE);
			}
			if(weapon.getType().toString().contains("IRON"))
			{
				tier = "iron";
				repairstone = new ItemStack(Material.IRON_INGOT);
			}
			if(weapon.getType().toString().contains("GOLD"))
			{
				tier = "gold";
				repairstone = new ItemStack(Material.GOLD_INGOT);
			}
			if(weapon.getType().toString().contains("DIAMOND"))
			{
				tier = "diamond";
				repairstone = new ItemStack(Material.DIAMOND);
			}
			

			if (tier == "wood" || tier == "stone" || tier == "gold" || tier == "iron" || tier == "diamond") 
			{
				if(e.getCursor().getType() == repairstone.getType())
				{

					weaponLore.set(place, (ChatColor.RED + "   ☼DURABILITY " + ChatColor.WHITE + ChatColor.BOLD.toString()
						+ "[ 100 / 100 ]"));
					weaponMeta.setLore(weaponLore);
					weapon.setItemMeta(weaponMeta);
					short maxdura = weapon.getType().getMaxDurability();
					weapon.setDurability((short) 1);
					
					int stoneAmount = e.getCursor().getAmount();

					if(stoneAmount > 1)
					{
						e.setCurrentItem(weapon);
						e.setCursor(new ItemStack(Material.AIR));
						e.setCancelled(true);
						stone.setAmount(stoneAmount- 1);
						p.getInventory().addItem(stone);
						p.closeInventory();
					
					}else 
					{
						e.setCurrentItem(weapon);
						e.setCursor(new ItemStack(Material.AIR));
						e.setCancelled(true);
						p.closeInventory();
						
					}
					

					
				}
				

				
			}
		}
	}

}
