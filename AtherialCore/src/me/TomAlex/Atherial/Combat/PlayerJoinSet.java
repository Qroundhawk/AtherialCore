package me.TomAlex.Atherial.Combat;

import java.util.ArrayList;
import java.util.Arrays;
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

public class PlayerJoinSet implements Listener {

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
					swordLore1.add("");
					swordLore1.add(ChatColor.DARK_RED + "\u2694" + "+" + 16 + " Damage");
					swordLore1.add("");
					swordLore1.add(ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 10 + "% Strength");
					swordLore1.add(ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 10 + "% CritChance");
					swordLore1.add(ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 5 + "% LifeSteal");
					swordLore1.add("");
					swordLore1.add(ChatColor.RED + ChatColor.BOLD.toString() + "ATTRIBUTES:");
					swordLore1.add(ChatColor.RED + "\u27E1" + ChatColor.GRAY + " Red GemStone");
					swordLore1.add(ChatColor.GREEN + "\u27E1" + ChatColor.GRAY + " Green GemStone");
					swordLore1.add(ChatColor.GRAY + "_____________________");
					swordLore1.add(
							ChatColor.RED + ChatColor.BOLD.toString() + "RARITY:" + ChatColor.GREEN + " Common Item");
					swordLore1.add("");
					swordLore1.add(ChatColor.RED + ChatColor.BOLD.toString() + "DURABILITY");
					swordLore1.add(ChatColor.WHITE + ChatColor.BOLD.toString() + "[ " + 100 + " / 100 ]");
					swordMeta1.setLore(swordLore1);
					sword1.setItemMeta(swordMeta1);

					ItemStack thelm = new ItemStack(Material.LEATHER_HELMET);
					ItemMeta thelmmeta = thelm.getItemMeta();
					thelmmeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString()
					+ "Training Helm");
					thelmmeta.setLore(Arrays.asList(
							""
							, ChatColor.DARK_RED + "\u2764" + "+" + 12 + " Health"
							, ""
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 4 + " Armor"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 6 + " Health Regen"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 4 + "% BlockChance"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 2 + "% Thorns"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 10 + " Vitality"
							,""
							, ChatColor.RED + ChatColor.BOLD.toString() + "ATTRIBUTES:"
							,ChatColor.RED + "\u27E1" + ChatColor.GRAY + " Red GemStone"
							,ChatColor.GREEN + "\u27E1" + ChatColor.GRAY + " Green GemStone"
							,ChatColor.GRAY + "_____________________"
							,ChatColor.RED + ChatColor.BOLD.toString() + "RARITY:" + ChatColor.GREEN + " Common Item"
							,""
							,ChatColor.RED + ChatColor.BOLD.toString() + "DURABILITY"
							,ChatColor.WHITE + ChatColor.BOLD.toString() + "[ " + 100 + " / 100 ]"));
					thelm.setItemMeta(thelmmeta);

			
			

					ItemStack tboots = new ItemStack(Material.LEATHER_BOOTS);
					ItemMeta tbootsmmeta = tboots.getItemMeta();
					tbootsmmeta.setLore(Arrays.asList(
							""
							, ChatColor.DARK_RED + "\u2764" + "+" + 12 + " Health"
							, ""
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 4 + " Armor"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 6 + " Health Regen"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 4 + "% BlockChance"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 2 + "% Thorns"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 10 + " Vitality"
							,""
							, ChatColor.RED + ChatColor.BOLD.toString() + "ATTRIBUTES:"
							,ChatColor.RED + "\u27E1" + ChatColor.GRAY + " Red GemStone"
							,ChatColor.GREEN + "\u27E1" + ChatColor.GRAY + " Green GemStone"
							,ChatColor.GRAY + "_____________________"
							,ChatColor.RED + ChatColor.BOLD.toString() + "RARITY:" + ChatColor.GREEN + " Common Item"
							,""
							,ChatColor.RED + ChatColor.BOLD.toString() + "DURABILITY"
							,ChatColor.WHITE + ChatColor.BOLD.toString() + "[ " + 100 + " / 100 ]"));
					tboots.setItemMeta(tbootsmmeta);

					ItemStack tchest = new ItemStack(Material.LEATHER_CHESTPLATE);
					ItemMeta tchestmeta = tchest.getItemMeta();
					tchestmeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString()
							+ ChatColor.ITALIC.toString() + "Training Chest");
					tchestmeta.setLore(Arrays.asList(
							""
							, ChatColor.DARK_RED + "\u2764" + "+" + 16 + " Health"
							, ""
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 7 + " Armor"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 8 + " Health Regen"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 6 + "% BlockChance"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 2 + "% Thorns"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 8 + " Vitality"
							,""
							, ChatColor.RED + ChatColor.BOLD.toString() + "ATTRIBUTES:"
							,ChatColor.RED + "\u27E1" + ChatColor.GRAY + " Red GemStone"
							,ChatColor.GREEN + "\u27E1" + ChatColor.GRAY + " Green GemStone"
							,ChatColor.GRAY + "_____________________"
							,ChatColor.RED + ChatColor.BOLD.toString() + "RARITY:" + ChatColor.GREEN + " Common Item"
							,""
							,ChatColor.RED + ChatColor.BOLD.toString() + "DURABILITY"
							,ChatColor.WHITE + ChatColor.BOLD.toString() + "[ " + 100 + " / 100 ]"));
					tchest.setItemMeta(tchestmeta);
				
			

					ItemStack tlegs = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemMeta tlegsmeta = tlegs.getItemMeta();
					tlegsmeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString()
							+ "Training Legs");
					tlegsmeta .setLore(Arrays.asList(
							""
							, ChatColor.DARK_RED + "\u2764" + "+" + 16 + " Health"
							, ""
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 7 + " Armor"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 8 + " Health Regen"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 6 + "% BlockChance"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 2 + "% Thorns"
							,ChatColor.GREEN + "\u25BA" + ChatColor.YELLOW + " +" + 8 + " Vitality"
							,""
							, ChatColor.RED + ChatColor.BOLD.toString() + "ATTRIBUTES:"
							,ChatColor.RED + "\u27E1" + ChatColor.GRAY + " Red GemStone"
							,ChatColor.GREEN + "\u27E1" + ChatColor.GRAY + " Green GemStone"
							,ChatColor.GRAY + "_____________________"
							,ChatColor.RED + ChatColor.BOLD.toString() + "RARITY:" + ChatColor.GREEN + " Common Item"
							,""
							,ChatColor.RED + ChatColor.BOLD.toString() + "DURABILITY"
							,ChatColor.WHITE + ChatColor.BOLD.toString() + "[ " + 100 + " / 100 ]"));
					tlegs.setItemMeta(tlegsmeta );
			
					ItemStack pickaxe = new ItemStack(Material.WOOD_PICKAXE, 1);
			        ItemMeta pickaxemeta = pickaxe.getItemMeta();
			        pickaxemeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Wooden Pickaxe");
					List<String> lore = new ArrayList<String>();
			        lore.add(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "" + ChatColor.ITALIC + 1);
			        lore.add("");
			        lore.add(ChatColor.WHITE + "EXP: " + ChatColor.GRAY + "" + ChatColor.ITALIC + "10" + " / " + "50");
			        lore.add(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "||||||||||||||||||||" + ChatColor.WHITE + "]");
			        pickaxemeta.setLore(lore);
			        pickaxe.setItemMeta(pickaxemeta);

					ItemStack tapple = new ItemStack(Material.APPLE, 6);
					event.getPlayer().getInventory().addItem(sword1, thelm, tlegs, tchest, tboots, tapple, pickaxe);

				}
				
				event.getPlayer().setHealthScale(40);

				p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16);

				ItemStack pmenu = new ItemStack(Material.COMPASS);
				ItemMeta pmenuMeta = pmenu.getItemMeta();
				List<String> pmenuLore = new ArrayList<String>();
				pmenuMeta.setDisplayName(
						ChatColor.GREEN + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString() + "Player Menu");
				pmenuLore.add(ChatColor.WHITE + "Right click to open Player Menu");
				pmenuMeta.setLore(pmenuLore);
				pmenu.setItemMeta(pmenuMeta);
				p.getInventory().setItem(8, pmenu);

				// ---------------------------setting
				// stats--------------------------
				settings.Armor.put(p.getUniqueId(), 0);
				settings.Regen.put(p.getUniqueId(), 0);
				settings.Block.put(p.getUniqueId(), 0);
				settings.Thorns.put(p.getUniqueId(), 0);
				settings.Vit.put(p.getUniqueId(), 0);
				settings.PvP.put(p.getUniqueId(), 0);
				settings.PvE.put(p.getUniqueId(), 0);

				int i = 1;
				ItemStack armor = null;
				while (i <= 4) {
					switch (i) {
					case 1:
						armor = p.getInventory().getHelmet();
						break;
					case 2:
						armor = p.getInventory().getChestplate();
						break;
					case 3:
						armor = p.getInventory().getLeggings();
						break;
					case 4:
						armor = p.getInventory().getBoots();
						break;
					}

					if (armor != null) {
						String loreArmor = armor.getItemMeta().getLore().get(3);
						Scanner in1 = new Scanner(loreArmor).useDelimiter("[^0-9]+");
						int a = in1.nextInt();
						int currentarmor = settings.Armor.get(p.getUniqueId());
						int newarmor = currentarmor + a;
						settings.Armor.put(p.getUniqueId(), newarmor);

						// ----------HealthRegen-----------------
						if (armor.getItemMeta().getLore().size() >= 14) {
							String loreRegen = armor.getItemMeta().getLore().get(4);
							Scanner in4 = new Scanner(loreRegen).useDelimiter("[^0-9]+");
							int regen = in4.nextInt();
							int currentregen = settings.Regen.get(ud);
							int newregen = currentregen + regen;
							settings.Regen.put(ud, newregen);
						}
						// ----------BlockChance-----------------
						if (armor.getItemMeta().getLore().size() >= 15) {
							String loreBlock = armor.getItemMeta().getLore().get(5);
							Scanner in5 = new Scanner(loreBlock).useDelimiter("[^0-9]+");
							int block = in5.nextInt();
							int currentblock = settings.Block.get(ud);
							int newblock = currentblock + block;
							settings.Block.put(ud, newblock);

						}
						// ----------Thorns----------------------
						if (armor.getItemMeta().getLore().size() >= 16) {
							String loreThorns = armor.getItemMeta().getLore().get(6);
							Scanner in6 = new Scanner(loreThorns).useDelimiter("[^0-9]+");
							int Thorns = in6.nextInt();
							int currentThorns = settings.Thorns.get(ud);
							int newThorns = currentThorns + Thorns;
							settings.Thorns.put(ud, newThorns);
						}

						// ----------Vit-------------------------
						if (armor.getItemMeta().getLore().size() >= 17) {
							String loreVit = armor.getItemMeta().getLore().get(7);
							Scanner in7 = new Scanner(loreVit).useDelimiter("[^0-9]+");
							int Vit = in7.nextInt();
							int currentVit = settings.Vit.get(ud);
							int newVit = currentVit + Vit;
							settings.Vit.put(ud, newVit);
						}

						// ----------PvP Or PvE restistance------
						if (armor.getItemMeta().getLore().size() >= 18) {
							String lorePvP = armor.getItemMeta().getLore().get(8);

							if (lorePvP.indexOf("PvP") != -1) {
								Scanner in8 = new Scanner(lorePvP).useDelimiter("[^0-9]+");
								int PvP = in8.nextInt();
								int currentPvP = settings.PvP.get(p.getUniqueId());
								int newPvP = currentPvP + PvP;
								settings.PvP.put(p.getUniqueId(), newPvP);

							} else if (lorePvP.indexOf("PvE") != -1) {
								Scanner in8 = new Scanner(lorePvP).useDelimiter("[^0-9]+");
								int PvP = in8.nextInt();
								int currentPvP = settings.PvE.get(p.getUniqueId());
								int newPvP = currentPvP + PvP;
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
