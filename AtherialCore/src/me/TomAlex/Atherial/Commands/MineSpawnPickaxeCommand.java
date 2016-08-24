package me.TomAlex.Atherial.Commands;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.SettingsManager;
import me.TomAlex.Atherial.Mining.OreSetupRespawn;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MineSpawnPickaxeCommand implements CommandExecutor {

	SettingsManager settings = SettingsManager.getInstance();
	OreSetupRespawn mining = OreSetupRespawn.getInstance();
	
	public String smsg = ChatColor.DARK_GRAY +  "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "MINING > ";

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("mining.spawnpickaxe")) {
			p.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
			return true;
		}
		
		if (args.length == 0) {
			p.sendMessage(ChatColor.RED + "Please specify the command, /spawnpickaxe <level>");
			return true;
		}
		
		int level = 0;
		try {
			level = Integer.parseInt(args[0]);
		} catch(NumberFormatException ex) {
			p.sendMessage(ChatColor.RED + "Ow whoops there is an error!");
			return true;
		}
		
		if (level >= 40) {
			ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
	        ItemMeta pickaxemeta = pickaxe.getItemMeta();
	        pickaxemeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Diamond Pickaxe");
	        ItemMeta loremeta = p.getItemInHand().getItemMeta();
			List<String> lore = new ArrayList<String>();
	        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + level);
	        lore.add("");
	        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + "10" + " / " + "50");
	        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "||||||||||||||||||||" + ChatColor.WHITE + "]");
	        pickaxemeta.setLore(lore);
	        pickaxe.setItemMeta(pickaxemeta);
	        
	        p.getInventory().addItem(pickaxe);
			return true;
		}
		if (level >= 30) {
			ItemStack pickaxe = new ItemStack(Material.GOLD_PICKAXE, 1);
	        ItemMeta pickaxemeta = pickaxe.getItemMeta();
	        pickaxemeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Gold Pickaxe");
	        ItemMeta loremeta = p.getItemInHand().getItemMeta();
			List<String> lore = new ArrayList<String>();
	        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + level);
	        lore.add("");
	        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + "10" + " / " + "50");
	        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "||||||||||||||||||||" + ChatColor.WHITE + "]");
	        pickaxemeta.setLore(lore);
	        pickaxe.setItemMeta(pickaxemeta);
	        
	        p.getInventory().addItem(pickaxe);
			return true;
		}
		if (level >= 20) {
			ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE, 1);
	        ItemMeta pickaxemeta = pickaxe.getItemMeta();
	        pickaxemeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Iron Pickaxe");
	        ItemMeta loremeta = p.getItemInHand().getItemMeta();
			List<String> lore = new ArrayList<String>();
	        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + level);
	        lore.add("");
	        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + "10" + " / " + "50");
	        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "||||||||||||||||||||" + ChatColor.WHITE + "]");
	        pickaxemeta.setLore(lore);
	        pickaxe.setItemMeta(pickaxemeta);
	        
	        p.getInventory().addItem(pickaxe);
			return true;
		}
		if (level >= 10) {
			ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE, 1);
	        ItemMeta pickaxemeta = pickaxe.getItemMeta();
	        pickaxemeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Stone Pickaxe");
	        ItemMeta loremeta = p.getItemInHand().getItemMeta();
			List<String> lore = new ArrayList<String>();
	        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + level);
	        lore.add("");
	        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + "10" + " / " + "50");
	        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "||||||||||||||||||||" + ChatColor.WHITE + "]");
	        pickaxemeta.setLore(lore);
	        pickaxe.setItemMeta(pickaxemeta);
	        
	        p.getInventory().addItem(pickaxe);
			return true;
		}
		if (level >= 1) {
			ItemStack pickaxe = new ItemStack(Material.WOOD_PICKAXE, 1);
	        ItemMeta pickaxemeta = pickaxe.getItemMeta();
	        pickaxemeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Wooden Pickaxe");
	        ItemMeta loremeta = p.getItemInHand().getItemMeta();
			List<String> lore = new ArrayList<String>();
	        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + level);
	        lore.add("");
	        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + "10" + " / " + "50");
	        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "||||||||||||||||||||" + ChatColor.WHITE + "]");
	        pickaxemeta.setLore(lore);
	        pickaxe.setItemMeta(pickaxemeta);
	        
	        p.getInventory().addItem(pickaxe);
			return true;
		}
		
		p.sendMessage(ChatColor.RED + "Whoops, there is a error!");
		
		return true;
	}

}
