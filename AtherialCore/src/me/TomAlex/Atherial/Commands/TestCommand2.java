package me.TomAlex.Atherial.Commands;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Mining.LvlExp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class TestCommand2 implements CommandExecutor {
	
	SettingsManager settings = SettingsManager.getInstance();
	LvlExp lvlexp = LvlExp.getInstance();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		PlayerInventory pi = p.getInventory();
		
		if (!p.hasPermission("test.command")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		/*if (p.getItemInHand().getType() == Material.WOOD_PICKAXE) {
			if (p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Wooden Pickaxe")) {
				String[] args1 = p.getItemInHand().getItemMeta().getLore().toString().split(" ");
				String level2 = ChatColor.stripColor(args1[1]);
				String exp2 = ChatColor.stripColor(args1[4]);
				String maxexp2 = ChatColor.stripColor(args1[6]);
				level2 = level2.replaceAll(",", "");
				exp2 = exp2.replaceAll(",", "");
				maxexp2 = maxexp2.replaceAll(",", "");
				
				int level = 0;
				int exp = 0;
				int maxexp = 0;
				try {
					level = Integer.parseInt(level2);
					exp = Integer.parseInt(exp2);
					maxexp = Integer.parseInt(maxexp2);
				} catch(NumberFormatException ex) {
					p.sendMessage(ChatColor.RED + "Please use a number. 'Example: 1'");
					return true;
				}
				
				p.sendMessage("Level: " + level);
				p.sendMessage("Exp: " + exp);
				p.sendMessage("MaxExp: " + maxexp);
				return true;
			}
			p.sendMessage("Nope2");
		}*/
		
		//int exp = (int) ((Math.random() *20) + 40);
		
		p.sendMessage("" + settings.Coal);
		p.sendMessage("" + settings.Iron);
		
		
		/*int level = 2;
		int exp = 10;
		int maxexp = 50;
		String greenstripes = "";
		String redstripes = "||||||||||||||||||||";
		
		
		ItemStack pickaxe = new ItemStack(Material.WOOD_PICKAXE, 1);
        ItemMeta pickaxemeta = pickaxe.getItemMeta();
        pickaxemeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Wooden Pickaxe");
        ItemMeta loremeta = p.getItemInHand().getItemMeta();
		List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + level);
        lore.add("");
        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + exp + " / " + maxexp);
        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + greenstripes + ChatColor.DARK_RED + "" + ChatColor.BOLD + redstripes + ChatColor.WHITE + "]");
        pickaxemeta.setLore(lore);
        pickaxe.setItemMeta(pickaxemeta);
        
        pi.addItem(pickaxe);*/
		
		return true;
	}

}
