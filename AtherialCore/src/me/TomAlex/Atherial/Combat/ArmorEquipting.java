package me.TomAlex.Atherial.Combat;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.ArmorEquipEvent.ArmorEquipEvent;

public class ArmorEquipting implements Listener
{
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void Equip(ArmorEquipEvent e) 
	{

		Player p = e.getPlayer();
		p.sendMessage("Works");
	
		
		//Checking if inventory is full
		if (p.getInventory().firstEmpty() == -1) 
		{
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "Inventory Full!");
			return;
		}
		
		
		if (e.getNewArmorPiece() != null && e.getNewArmorPiece().hasItemMeta()) 
		{
			//----------Setting Armor-----------------
			String loreArmor = e.getNewArmorPiece().getItemMeta().getLore().get(1);
			Scanner in1 = new Scanner(loreArmor).useDelimiter("[^0-9]+");
			int a = in1.nextInt();
			int currentarmor = settings.Armor.get(p.getUniqueId());
			int newarmor =  currentarmor +a;
			settings.Armor.put(p.getUniqueId(), newarmor);
			
			// ----------Setting Health----------
			String lorehealth = e.getNewArmorPiece().getItemMeta().getLore().get(2);
			Scanner in2 = new Scanner(lorehealth).useDelimiter("[^0-9]+");
			int h = in2.nextInt();
			double maxhealth = p.getMaxHealth();
			p.setMaxHealth(maxhealth + h);
			settings.Health.put(p.getUniqueId(), (int) (maxhealth + h));
			
			//----------HealthRegen-----------------
			if(e.getNewArmorPiece().getItemMeta().getLore().size() >= 8)
			{
				String loreRegen = e.getNewArmorPiece().getItemMeta().getLore().get(3);
				Scanner in3 = new Scanner(loreRegen).useDelimiter("[^0-9]+");
				int regen = in3.nextInt();
				int currentregen = settings.Regen.get(p.getUniqueId());
				int newregen =  currentregen +regen;
				settings.Regen.put(p.getUniqueId(), newregen);
				
			}else return;
			//----------BlockChance-----------------
			if(e.getNewArmorPiece().getItemMeta().getLore().size() >= 9)
			{
				String loreBlock = e.getNewArmorPiece().getItemMeta().getLore().get(4);
				Scanner in4 = new Scanner(loreBlock).useDelimiter("[^0-9]+");
				int block = in4.nextInt();
				int currentblock = settings.Block.get(p.getUniqueId());
				int newblock =  currentblock +block ;
				settings.Block.put(p.getUniqueId(), newblock);
				
			}else return;
			//----------Thorns----------------------
			if(e.getNewArmorPiece().getItemMeta().getLore().size() >= 10)
			{
				String loreThorns = e.getNewArmorPiece().getItemMeta().getLore().get(5);
				Scanner in5 = new Scanner(loreThorns).useDelimiter("[^0-9]+");
				int Thorns = in5.nextInt();
				int currentThorns = settings.Thorns.get(p.getUniqueId());
				int newThorns =  currentThorns +Thorns ;
				settings.Thorns.put(p.getUniqueId(), newThorns);				
			}else return;

			//----------Vit-------------------------
			if(e.getNewArmorPiece().getItemMeta().getLore().size() >= 11)
			{
				String loreVit = e.getNewArmorPiece().getItemMeta().getLore().get(6);
				Scanner in6 = new Scanner(loreVit).useDelimiter("[^0-9]+");
				int Vit = in6.nextInt();
				int currentVit = settings.Vit.get(p.getUniqueId());
				int newVit =  currentVit +Vit ;
				settings.Vit.put(p.getUniqueId(), newVit);				
			}else return;
			
			//----------PvP Or PvE restistance------
			if(e.getNewArmorPiece().getItemMeta().getLore().size() >= 12)
			{
				String loreThorns = e.getNewArmorPiece().getItemMeta().getLore().get(7);
				Scanner in5 = new Scanner(loreThorns).useDelimiter("[^0-9]+");
				int Thorns = in5.nextInt();
				int currentThorns = settings.Thorns.get(p.getUniqueId());
				int newThorns =  currentThorns +Thorns ;
				settings.Block.put(p.getUniqueId(), newThorns);		
			}
			
			
			
		
			
			
			
			
			
			//--------------Message-------------
			p.sendMessage("");
			p.sendMessage(ChatColor.DARK_PURPLE + "    ■You equipped: "
					+ e.getNewArmorPiece().getItemMeta().getDisplayName());
			p.sendMessage(ChatColor.DARK_PURPLE + "    ■" + ChatColor.WHITE + "MaxHealth is now: "
					+ ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + p.getMaxHealth() + "Health");
			p.sendMessage("");
		}

		if (e.getOldArmorPiece() != null && e.getOldArmorPiece().hasItemMeta()) {
			// ----------Setting Health----------
			String lorehealth = e.getOldArmorPiece().getItemMeta().getLore().get(2);
			Scanner in2 = new Scanner(lorehealth).useDelimiter("[^0-9]+");
			int h = in2.nextInt();
			double maxhealth = p.getMaxHealth();
			p.setMaxHealth(maxhealth - h);
			settings.Health.put(p.getUniqueId(), (int) (maxhealth - h));


			p.sendMessage("");
			p.sendMessage(ChatColor.DARK_PURPLE + "    ■You unequipped: "
					+ e.getOldArmorPiece().getItemMeta().getDisplayName());
			p.sendMessage(ChatColor.DARK_PURPLE + "    ■" + ChatColor.WHITE + "MaxHealth is now: "
					+ ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + p.getMaxHealth() + "Health");
			p.sendMessage("");
		}
	}
}
