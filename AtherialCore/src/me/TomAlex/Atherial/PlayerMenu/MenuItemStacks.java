package me.TomAlex.Atherial.PlayerMenu;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class MenuItemStacks {
	
	Economy econ = Main.getEcon();
	SettingsManager settings = SettingsManager.getInstance();
	
	private MenuItemStacks() { }
	
	static MenuItemStacks instance = new MenuItemStacks();
	   
    public static MenuItemStacks getInstance() {
            return instance;
    }
	
	public ItemStack playerInfo(String pn) {
		
		ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta headmeta = (SkullMeta) head.getItemMeta();
        headmeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + pn + "'s PlayerInfo");
		List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.DARK_AQUA + "Rank: " + ChatColor.WHITE + "Default");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Gems: " + ChatColor.WHITE + econ.getBalance(pn));
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Level: " + ChatColor.WHITE + "1");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "OnlineTime: " + ChatColor.WHITE + "0D/0H/0M");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Achievments: " + ChatColor.WHITE + "0/100");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Quests: " + ChatColor.WHITE + "0/100");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Exp: " + ChatColor.WHITE + "0/500");
        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "||||||||||||||||||||" + ChatColor.WHITE + "]");
        lore.add("");
        lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "-=[ Play.LegionRealms.Net ]=-");
        headmeta.setLore(lore);
        headmeta.setOwner(pn);
        head.setItemMeta(headmeta);
        
		return head;
	}
	
	public ItemStack serverInfo() {
		
		ItemStack book = new ItemStack(Material.BOOK, 1);
		ItemMeta bookmeta = book.getItemMeta();
		bookmeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Server Info");
		List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.DARK_AQUA + "PlayerCount: " + ChatColor.WHITE + "" + ChatColor.ITALIC + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Website: " + ChatColor.WHITE + "LegionRealms.net");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Shop: " + ChatColor.WHITE + "shop.LegionRealms.net");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Forum: " + ChatColor.WHITE + "forum.LegionRealms.net");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Contact: " + ChatColor.WHITE + "server@LegionRealms.net");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Twitter: " + ChatColor.WHITE + "@LegionRealmsRPG");
        lore.add("");
        lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "-=[ Play.LegionRealms.Net ]=-");
        bookmeta.setLore(lore);
        book.setItemMeta(bookmeta);
        
		return book;
	}
	
	public ItemStack playerStats(Player p) {
		
		ItemStack book = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta bookmeta = book.getItemMeta();
		bookmeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + p.getName() + "'s Stats");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_RED + "\u2764 MaxHealth: " + ChatColor.WHITE + "" + ChatColor.ITALIC + settings.Health.get(p.getUniqueId()));
		lore.add("");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Armor: " + ChatColor.WHITE + settings.Armor.get(p.getUniqueId()));
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Thorns: " + ChatColor.WHITE + settings.Thorns.get(p.getUniqueId()));
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "BlockChance: " + ChatColor.WHITE + settings.Block.get(p.getUniqueId()));
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "Vitality: " + ChatColor.WHITE + settings.Vit.get(p.getUniqueId()));
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "HealthRegen: " + ChatColor.WHITE + settings.Regen.get(p.getUniqueId()));
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "PvE Resistance: " + ChatColor.WHITE + settings.PvE.get(p.getUniqueId()));
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "PvP Resistance: " + ChatColor.WHITE + settings.PvP.get(p.getUniqueId()));
        lore.add("");
        lore.add(ChatColor.GRAY + "These are your");
        lore.add(ChatColor.GRAY + "Real-Time player stats!");
        bookmeta.setLore(lore);
        book.setItemMeta(bookmeta);
        
		return book;
	}
	
	public ItemStack dailyBonus(Player p) {
		
		ItemStack book = new ItemStack(Material.CHEST, 1);
		ItemMeta bookmeta = book.getItemMeta();
		bookmeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Daily Bonus");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "" + ChatColor.BOLD + ">| " + ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + "Comming Soon!" + ChatColor.WHITE + "" + ChatColor.BOLD + " |<");
        //lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.DARK_AQUA + "Day: " + ChatColor.WHITE + "1");
        //lore.add("");
        //lore.add(ChatColor.GRAY + "Here you can claim");
        //lore.add(ChatColor.GRAY + "Your daily bonus!");
        bookmeta.setLore(lore);
        book.setItemMeta(bookmeta);
        
		return book;
	}
	
	
	public ItemStack togglePvPOff(String pn) {
		
		ItemStack dye = new ItemStack(Material.INK_SACK, 1, (byte) 8);
		ItemMeta dyemeta = dye.getItemMeta();
		dyemeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Toggle " + ChatColor.WHITE + "" + ChatColor.BOLD + "| " + ChatColor.RED + "" + ChatColor.BOLD + "PvP");
		List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "PvP: " + ChatColor.RED + "Disabled");
        lore.add("");
        lore.add(ChatColor.GRAY + "Toggles your PvP.");
        lore.add("");
        lore.add(ChatColor.GRAY + "If enabled other");
        lore.add(ChatColor.GRAY + "player can attack you!");
        dyemeta.setLore(lore);
        dye.setItemMeta(dyemeta);
        
		return dye;
	}
	public ItemStack togglePvPOn(String pn) {
		
		ItemStack dye = new ItemStack(Material.INK_SACK, 1, (byte) 10);
		ItemMeta dyemeta = dye.getItemMeta();
		dyemeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Toggle " + ChatColor.WHITE + "" + ChatColor.BOLD + "| " + ChatColor.RED + "" + ChatColor.BOLD + "PvP");
		List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_GRAY + "\u25BA" + ChatColor.GRAY + "PvP: " + ChatColor.GREEN + "Enabled");
        lore.add("");
        lore.add(ChatColor.GRAY + "Toggles your PvP.");
        lore.add("");
        lore.add(ChatColor.GRAY + "If enabled other");
        lore.add(ChatColor.GRAY + "player can attack you!");
        dyemeta.setLore(lore);
        dye.setItemMeta(dyemeta);
        
		return dye;
	}
}
