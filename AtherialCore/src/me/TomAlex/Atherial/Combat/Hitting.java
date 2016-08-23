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

			//------------check for weapon---------------
			if ((p.getItemInHand().getType().toString().toLowerCase().contains("sword"))
					|| p.getItemInHand().getType().toString().toLowerCase().contains("axe")) {
				e.setCancelled(false);
			} else {
				p.sendMessage(messager + "  This is not a weapon!");
				e.setCancelled(true);
				return;
			}
			
			

			if (p.getItemInHand().hasItemMeta()) 
			{
				int loresize = p.getInventory().getItemInMainHand().getItemMeta().getLore().size();
				ItemStack sword = new ItemStack(p.getItemInHand());
				// Get Damage
				String dmglore = sword.getItemMeta().getLore().get(1);
				Scanner in = new Scanner(dmglore).useDelimiter("[^0-9]+");
				int d = in.nextInt();
				int damage = in.nextInt();

				if (defender instanceof Skeleton) 
				{
					Skeleton s = (Skeleton) defender;
					e.setDamage(DamageModifier.ARMOR, 0);
					e.setDamage(DamageModifier.BASE, damage);
					p.sendMessage(ChatColor.RED + "PvE► "+ ChatColor.RED + f.format((double)damage) + " DAMAGE -> " + s.getName() + ChatColor.WHITE + "  [" 
					+ (s.getHealth()- damage) + "/" + s.getMaxHealth() + "]");
				}else if(defender instanceof Player)
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
					p.sendMessage(ChatColor.RED + "PvP► "+ ChatColor.RED + f.format(damage) + " DAMAGE -> " + pdefender.getName() + ChatColor.WHITE + "  [" 
							+ ((int) pdefender.getHealth()- damage) + "/" + pdefender.getMaxHealth() + "]");
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
