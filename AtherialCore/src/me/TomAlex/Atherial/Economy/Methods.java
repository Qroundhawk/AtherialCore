package me.TomAlex.Atherial.Economy;

import java.util.ArrayList;
import java.util.List;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Methods {
	
	public String smsg = ChatColor.DARK_GRAY +  "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]" + ChatColor.BOLD + "> ";
	
	Economy econ = Main.getEcon();
	SettingsManager settings = SettingsManager.getInstance();
	
	public boolean playerExists(String p) {
		if (settings.getUuidData().contains(p)) {
			return true;
		}
		if (!settings.getUuidData().contains(p)) {
			return false;
		}
		return false;
	}
	
	public boolean hasEnough(String p, int amount) {
		if (econ.has(p, amount)) {
			return true;
		}
		
		/*if (getMoney(p) < amount) {
			return false;
		}*/
	return false;
	}
	
	public ItemStack getStorageSlot(String p, int Amount) {
		if (settings.getStorageData().getItemStack(settings.getUuidData().getString(p) + ".storage.item" + Amount) == null) {
			ItemStack re = null;
			return re;
		}
		ItemStack re = new ItemStack(settings.getStorageData().getItemStack(settings.getUuidData().getString(p) + ".storage.item" + Amount));
		return re;
	}
	
	public void saveStorageSlot(String p, int Amount, ItemStack ItemS) {
		settings.getStorageData().set(settings.getUuidData().getString(p) + ".storage.item" + Amount, ItemS);
		settings.saveStorageData();
		return;
	}
	
	public double getMoney(String p) {
		double re = econ.getBalance(p);
		//int re = settings.getMoneyData().getInt(settings.getUuidData().getString(p) + ".money");
	return re;
	}
	
	public int getStorageRows(String p) {
		int re = settings.getPlayerData().getInt(settings.getUuidData().getString(p) + ".storage.rows");
	return re;
	}
	
	public void addMoney(String p, int amount) {
		 EconomyResponse r = econ.depositPlayer(p, amount);
		
		/*int amount2 = settings.getMoneyData().getInt(settings.getUuidData().get(p) + ".money") + amount;
		settings.getMoneyData().set(settings.getUuidData().getString(p) + ".money", amount2);
		settings.saveMoneyData();*/
		return;
	}
	
	public void setStorage(String p, int amount) {
		settings.getPlayerData().set(settings.getUuidData().getString(p) + ".storage.rows", amount);
		settings.savePlayerData();
		return;
	}
	
	public void removeMoney(String p, int amount) {
		EconomyResponse r = econ.withdrawPlayer(p, amount);
		
		
		/*if (getMoney(p) < amount) {
			settings.getMoneyData().set(settings.getUuidData().getString(p) + ".money", 0);
			return;
		}
		int amount2 = settings.getMoneyData().getInt(settings.getUuidData().get(p) + ".money") - amount;
		settings.getMoneyData().set(settings.getUuidData().getString(p) + ".money", amount2);
		settings.saveMoneyData();*/
		return;
	}
	
	public void setMoney(String p, int amount) {
		/*settings.getMoneyData().set(settings.getUuidData().getString(p) + ".money", amount);
		settings.saveMoneyData();*/
		return;
	}
	
	public static ItemStack addItemStack(Material m, String n, String l, int amount) {
		
		ItemStack ItemS = new ItemStack(m);
		ItemS.setAmount(amount);
		ItemMeta ItemSMeta = ItemS.getItemMeta();
		ItemSMeta.setDisplayName(n);
		List lore = new ArrayList();
        lore.add(l);
        ItemSMeta.setLore(lore);
		ItemS.setItemMeta(ItemSMeta);
		
		return ItemS;
	}
	
    public void openBank(Player p) {
    	
    	Inventory Bank = Bukkit.createInventory(null, 54,
			       ChatColor.DARK_GRAY + "" + p.getName() + "'s Bank Account.");
	Bank.clear();
	
	Bank.setItem(0, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(1, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(2, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(3, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(5, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(6, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(7, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(8, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(9, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(17, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(18, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(26, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(27, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(28, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(29, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(30, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(32, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(33, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(34, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(35, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(36, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(37, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(40, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(43, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(44, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(46, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(49, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	Bank.setItem(52, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	
	Bank.setItem(4, addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Your Gems: " + ChatColor.GRAY + getMoney(p.getName()), null, 1));
	Bank.setItem(31, addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Your Gems: " + ChatColor.GRAY + getMoney(p.getName()), null, 1));
	
	Bank.setItem(10, addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 1, "Withdraw 1 Gem.", 1));
	Bank.setItem(12, addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 8, "Withdraw 8 Gem.", 8));
	Bank.setItem(13, addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 16, "Withdraw 16 Gem.", 16));
	Bank.setItem(14, addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 32, "Withdraw 32 Gem.", 32));
	Bank.setItem(16, addItemStack(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 64, "Withdraw 64 Gem.", 64));
	
	Bank.setItem(19, addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 1, "Withdraw 1 Gem Block.", 1));
	Bank.setItem(21, addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 8, "Withdraw 8 Gem Block.", 8));
	Bank.setItem(22, addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 16, "Withdraw 16 Gem Block.", 16));
	Bank.setItem(23, addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 32, "Withdraw 32 Gem Block.", 32));
	Bank.setItem(25, addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Withdraw: " + ChatColor.GRAY + 64, "Withdraw 64 Gem Block.", 64));
	
	Bank.setItem(45, addItemStack(Material.CHEST, ChatColor.GRAY + "\u2190To Storage\u22C4", null, 1));
	Bank.setItem(53, addItemStack(Material.PAPER, ChatColor.GRAY + "" + ChatColor.MAGIC +  "\u22C4To BankNote\u2192", "Will come in a future Update!", 1));
	
	p.openInventory(Bank);
	
	return;
	
    	
    }
    
public void openStorage(Player p) {
    	
    	Inventory Storage = Bukkit.createInventory(null, 54,
    			ChatColor.DARK_GRAY + "" + p.getName() + "'s Storage.");
    
    int a = getStorageRows(p.getName()) * 9;
    
    int counter = 0;
	while (counter < a) {
		if (getStorageSlot(p.getName(), counter) == null) {
			Storage.setItem(counter, null);
		}else{
			Storage.setItem(counter, getStorageSlot(p.getName(), counter));
		}
		counter++;
	}
    
	Storage.setItem(53, addItemStack(Material.EMERALD, ChatColor.GRAY + "\u22C4To Bank\u2192", "Gems: " + getMoney(p.getName()), 1));
    
    if (getStorageRows(p.getName()) <= 2) {
    	Storage.setItem(18, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(19, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(20, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(21, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	
    	Storage.setItem(22, addItemStack(Material.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD + "\u22C4Buy Extra Row\u22C4", "Costs: 1", 1));
    	
    	Storage.setItem(23, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(24, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(25, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(26, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    }
    if (getStorageRows(p.getName()) <= 3) {
    	Storage.setItem(27, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(28, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(29, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(30, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	
    	if (getStorageRows(p.getName()) < 3) {
    		Storage.setItem(31, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	}else{
    		Storage.setItem(31, addItemStack(Material.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD + "\u22C4Buy Extra Row\u22C4", "Costs: 2", 1));
    	}
    	
    	Storage.setItem(32, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(33, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(34, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(35, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    }
    if (getStorageRows(p.getName()) <= 4) {
    	Storage.setItem(36, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(37, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(38, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(39, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	
    	if (getStorageRows(p.getName()) < 4) {
    		Storage.setItem(40, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	}else{
    		Storage.setItem(40, addItemStack(Material.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD + "\u22C4Buy Extra Row\u22C4", "Costs: 3", 1));
    	}
    	
    	Storage.setItem(41, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(42, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(43, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(44, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    }
    if (getStorageRows(p.getName()) <= 5) {
    	Storage.setItem(45, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(46, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(47, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(48, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	
    	if (getStorageRows(p.getName()) < 5) {
    		Storage.setItem(49, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	}else{
    		Storage.setItem(49, addItemStack(Material.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD + "\u22C4Buy Extra Row\u22C4", "Costs: 4", 1));
    	}
    	
    	Storage.setItem(50, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(51, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    	Storage.setItem(52, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
    }
    	
	p.openInventory(Storage);
	
	p.sendMessage(smsg + ChatColor.GREEN + "Opend storage!");
	
	return;
	
	
	}

	public void openBuyStorage(Player p) {
	
	Inventory StorageBuy = Bukkit.createInventory(null, 27,
			ChatColor.DARK_GRAY + "" + "Buy New Storage!");
	
	StorageBuy.setItem(0, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(1, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(2, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(3, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(4, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(5, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(6, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(7, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(8, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(9, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(10, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(11, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(13, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(15, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(16, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(17, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(18, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(19, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(20, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(21, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(22, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(23, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(24, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(25, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	StorageBuy.setItem(26, addItemStack(Material.STAINED_GLASS_PANE, "\u2600", null, 1));
	
	StorageBuy.setItem(12, addItemStack(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "Accept", "Click to buy a new Storage Row!", 1));
	StorageBuy.setItem(14, addItemStack(Material.REDSTONE_BLOCK, ChatColor.RED + "" + ChatColor.BOLD + "Cancel", "Click to cancel the purchase!", 1));
	
	p.openInventory(StorageBuy);
	return;
	}



	static Methods instance = new Methods();
	   
    public static Methods getInstance() {
            return instance;
    }
    
    
}
