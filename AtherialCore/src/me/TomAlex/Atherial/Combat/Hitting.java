package me.TomAlex.Atherial.Combat;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.bukkit.inventory.ItemStack;

import me.TomAlex.Atherial.SettingsManager;

public class Hitting implements Listener

{
	SettingsManager settings = SettingsManager.getInstance();

	String messager = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.RED
			+ ChatColor.BOLD.toString() + "COMBAT >";
	
	public DecimalFormat f = new DecimalFormat("##.00");

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onHit(EntityDamageByEntityEvent e) 
	{
		Entity attacker = e.getDamager();
		Entity defender = e.getEntity();

		if (attacker instanceof Player) 
		{
			Player p = (Player) attacker;
			UUID udattacker = p.getUniqueId();

			//------------check for weapon---------------
			if ((p.getItemInHand().getType().toString().toLowerCase().contains("sword"))
					|| p.getItemInHand().getType().toString().toLowerCase().contains("axe")) {
				e.setCancelled(false);
			} else {
				p.sendMessage(messager + "  This is not a weapon!");
				e.setCancelled(true);
				return;
			}
			
			if(defender instanceof Player)
			{
				UUID ud = defender.getUniqueId(); 
				if(!(settings.pvptoggle.contains(udattacker)))
				{
					e.setCancelled(true);
					p.sendMessage(messager + ChatColor.GREEN + " You have PvP disabled, activate in Player Menu");
					return;
				}
				if(!(settings.pvptoggle.contains(ud)))
				{
					e.setCancelled(true);
					p.sendMessage(messager + ChatColor.GREEN + " This player has PvP disabled");
					return;
				}
			}
		
			
			

			if (p.getItemInHand().hasItemMeta()) 
			{
				int loresize = p.getInventory().getItemInMainHand().getItemMeta().getLore().size();
				ItemStack sword = new ItemStack(p.getItemInHand());
				
				// Get Damage
				String dmglore = sword.getItemMeta().getLore().get(1);
				Scanner in = new Scanner(dmglore).useDelimiter("[^0-9]+");
				double d = in.nextDouble();
				double damage = in.nextDouble();
				//Get strength
				if(loresize >=  13)
				{
					String strlore = sword.getItemMeta().getLore().get(3);
					Scanner in3 = new Scanner(strlore).useDelimiter("[^0-9]+");
					double str = in3.nextDouble();
					double strmulti = (100+str)/100;
					damage = damage * strmulti;
				}
	
				if(loresize >= 14)
				{
					String critlore = sword.getItemMeta().getLore().get(4);
					Scanner in4 = new Scanner(critlore).useDelimiter("[^0-9]+");
					double crit = in4.nextDouble();
					int critRNG = (int) ((Math.random() *100));
					if(critRNG <= crit)
					{
						damage = damage * 2;
						p.sendMessage(messager + ChatColor.YELLOW  + "   You crit, damage is doubled!");
					}
	
				}
				
				if(loresize >= 15)
				{
					String steallore = sword.getItemMeta().getLore().get(5);
					Scanner in5 = new Scanner(steallore).useDelimiter("[^0-9]+");
					double steal = in5.nextDouble();
					double lifesteal = (damage * (steal/100));
					if(!(lifesteal + p.getHealth() >= p.getMaxHealth()))
					{
						p.setHealth(lifesteal + p.getHealth());
						p.sendMessage(ChatColor.GREEN +  "LifeSteal +" + f.format(lifesteal)  );
					}
				}
				

				if (defender instanceof Skeleton) 
				{
				
					Skeleton s = (Skeleton) defender;
					e.setDamage(DamageModifier.ARMOR, 0);
					e.setDamage(DamageModifier.BASE, damage);
					p.sendMessage(ChatColor.RED + "PvE► "+ ChatColor.RED + ((int)damage) + " DAMAGE -> " + s.getName() + ChatColor.WHITE + "  [" 
					+ f.format(s.getHealth()- damage) + "/" + s.getMaxHealth() + "]");
				}
				else if(defender instanceof Player)
				{					
					Player pdefender = (Player) defender;
					UUID ud = pdefender.getUniqueId();
			
					
					double armor = settings.Armor.get(ud);
					double thorns = settings.Thorns.get(ud);
					int block = settings.Block.get(ud);
					double pvp = settings.PvP.get(ud);
					//-------------Armor reduce-----------
					double armordamage = ((damage - (armor/100)*damage));
					//-------------PvE reduce-------------
					double finaldamage = ((armordamage - (pvp/100*armordamage)));
					//-------------BlockChance------------
					int BlockRNG = (int) ((Math.random() *100));
					if(BlockRNG <= block)
					{
						p.sendMessage(messager + ChatColor.GREEN + "       Blocked this attack! "); 
						e.setCancelled(true);
						return;
					}
					
					int thornsdamage = (int) ((thorns/100)*finaldamage);
					p.damage(thornsdamage);
				
					e.setDamage(DamageModifier.ARMOR, 0);
					e.setDamage(DamageModifier.BASE, finaldamage);
					
					//message to attacker
					p.sendMessage(ChatColor.RED + "PvP► "+ ChatColor.RED + f.format(finaldamage) + " DAMAGE -> " + pdefender.getName() + ChatColor.WHITE + "  [" 
							+ (f.format(pdefender.getHealth()- damage) + "/" + pdefender.getMaxHealth() + "]"));
					//message to defender
					pdefender.sendMessage(ChatColor.RED + "PvP◄" + f.format(finaldamage) + " DAMAGE TAKEN  "
					+ ChatColor.WHITE + "[Armor% -" + f.format((armor/100)*damage) + " DMG]" 
							+ " [PvP% -" + f.format((pvp/100)*armordamage) + " DMG]");				
				}
			}else return;

		}else if(attacker instanceof Skeleton)
		{
			if(defender instanceof Player)
			{
				Skeleton s = (Skeleton) attacker;
				Player p = (Player) defender;
				UUID ud = p.getUniqueId();
				
				double damage = s.getMaxHealth()/10;
				
				double armor = settings.Armor.get(ud);
				double thorns = settings.Thorns.get(ud);
				int block = settings.Block.get(ud);
				double pve = settings.PvE.get(ud);
				//-------------Armor reduce-----------
				double armordamage = ((damage - (armor/100)*damage));
				//-------------PvE reduce-------------
				double finaldamage = ((armordamage - (pve/100*armordamage)));
				//-------------BlockChance------------
				int BlockRNG = (int) ((Math.random() *100));
				if(BlockRNG <= block)
				{
					p.sendMessage(messager + ChatColor.GREEN + "       Blocked this attack! "); 
					e.setCancelled(true);
					return;
				}
				
				int thornsdamage = (int) ((thorns/100)*finaldamage);
				p.sendMessage(""+ thornsdamage);
				s.damage(thornsdamage);
			
				e.setDamage(DamageModifier.ARMOR, 0);
				e.setDamage(DamageModifier.BASE, finaldamage);
				
				p.sendMessage(ChatColor.RED + "PvE◄" + f.format(finaldamage) + " DAMAGE TAKEN  "
				+ ChatColor.WHITE + "[Armor% -" + f.format((armor/100)*damage) + " DMG]" 
						+ " [PvE% -" + f.format((pve/100)*armordamage) + " DMG]");
				
				
				
			}
		}
		
	}

}
