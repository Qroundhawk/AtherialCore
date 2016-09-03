package me.TomAlex.Atherial.Durability;

import me.TomAlex.Atherial.Main;
import net.milkbowl.vault.economy.Economy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DuraShops implements Listener 
{
	Economy econ = Main.getEcon();

	@EventHandler
	public void onPlayerInteract(PlayerInteractEntityEvent e) {
		Entity entity = e.getRightClicked();
		Player p = e.getPlayer();
		if (entity instanceof Villager) {
			if (entity.getCustomName().equalsIgnoreCase(ChatColor.GREEN + "Item Disenchanter")) {
				Inventory invMerchant = Bukkit.createInventory(null, 18,
						ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Item Disenchanter");

				p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]>"
						+ ChatColor.GREEN + "       Opened item disenchanter");

				ItemStack slotA = new ItemStack(Material.WOOL, 1, (byte) 5);
				ItemMeta slotAMeta = slotA.getItemMeta();
				slotAMeta.setDisplayName(ChatColor.DARK_GREEN + "Accept to Disenchant");
				slotA.setItemMeta(slotAMeta);

				ItemStack slotI = new ItemStack(Material.BOOK, 1);
				ItemMeta slotIMeta = slotI.getItemMeta();
				slotIMeta.setDisplayName(ChatColor.GOLD + "What is this page?");
				slotIMeta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "Disenchant your items for dust",
						ChatColor.DARK_GREEN + "Place items in the inventory and click accept"));
				slotI.setItemMeta(slotIMeta);

				invMerchant.setItem(0, slotA);
				invMerchant.setItem(17, slotI);

				p.openInventory(invMerchant);
			}
			else if (entity.getCustomName().equalsIgnoreCase(ChatColor.GREEN + "Item Repair Smith")) {
				Inventory invMerchant = Bukkit.createInventory(null, 9,
						ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Repair Shop");
				p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]>"
						+ ChatColor.GREEN + "       Opened repair stone shop");

				ItemStack slot0 = new ItemStack(Material.LEATHER, 1);
				ItemMeta slot0Meta = slot0.getItemMeta();
				slot0Meta.setDisplayName(ChatColor.WHITE + ChatColor.BOLD.toString() + "Leather repair stone");
				slot0Meta.setLore(Arrays.asList(ChatColor.GRAY + "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY + "by clicking this item on your armor/weapon", "",
						ChatColor.WHITE + "-------------------", "",
						ChatColor.BLUE + "Price: " + ChatColor.YELLOW + "32 Coal ore",
						ChatColor.GREEN + "Click to purchase"));
				slot0.setItemMeta(slot0Meta);

				ItemStack slot2 = new ItemStack(Material.IRON_FENCE, 1);
				ItemMeta slot2Meta = slot2.getItemMeta();
				slot2Meta.setDisplayName(ChatColor.GRAY + ChatColor.BOLD.toString() + "Chain repair stone");
				slot2Meta.setLore(Arrays.asList(ChatColor.GRAY + "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY + "by clicking this item on your armor/weapon", "",
						ChatColor.WHITE + "-------------------", "",
						ChatColor.BLUE + "Price: " + ChatColor.YELLOW + "64 Coal ore",
						ChatColor.GREEN + "Click to purchase"));
				slot2.setItemMeta(slot2Meta);

				ItemStack slot4 = new ItemStack(Material.IRON_INGOT, 1);
				ItemMeta slot4Meta = slot4.getItemMeta();
				slot4Meta.setDisplayName(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Iron repair stone");
				slot4Meta.setLore(Arrays.asList(ChatColor.GRAY + "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY + "by clicking this item on your armor/weapon", "",
						ChatColor.WHITE + "-------------------", "",
						ChatColor.BLUE + "Price: " + ChatColor.YELLOW + "32 Iron ore",
						ChatColor.GREEN + "Click to purchase"));
				slot4.setItemMeta(slot4Meta);

				ItemStack slot6 = new ItemStack(Material.GOLD_INGOT, 1);
				ItemMeta slot6Meta = slot6.getItemMeta();
				slot6Meta.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Gold repair stone");
				slot6Meta.setLore(Arrays.asList(ChatColor.GRAY + "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY + "by clicking this item on your armor/weapon", "",
						ChatColor.WHITE + "-------------------", "",
						ChatColor.BLUE + "Price: " + ChatColor.YELLOW + "32 Gold ore",
						ChatColor.GREEN + "Click to purchase"));
				slot6.setItemMeta(slot6Meta);

				ItemStack slot8 = new ItemStack(Material.DIAMOND, 1);
				ItemMeta slot8Meta = slot8.getItemMeta();
				slot8Meta.setDisplayName(ChatColor.BLUE + ChatColor.BOLD.toString() + "Diamond repair stone");
				slot8Meta.setLore(Arrays.asList(ChatColor.GRAY + "Use this item to fully repair your armor/weapon",
						ChatColor.GRAY + "by clicking this item on your armor/weapon", "",
						ChatColor.WHITE + "-------------------", "",
						ChatColor.BLUE + "Price: " + ChatColor.YELLOW + "32 Diamond ore",
						ChatColor.GREEN + "Click to purchase"));
				slot8.setItemMeta(slot8Meta);

				ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 0);
				ItemMeta glassMeta = glass.getItemMeta();
				glassMeta.setDisplayName(ChatColor.WHITE + ChatColor.BOLD.toString() + "*");
				glass.setItemMeta(glassMeta);

				invMerchant.setItem(0, slot0);
				invMerchant.setItem(2, slot2);
				invMerchant.setItem(4, slot4);
				invMerchant.setItem(6, slot6);
				invMerchant.setItem(8, slot8);
				invMerchant.setItem(1, glass);
				invMerchant.setItem(3, glass);
				invMerchant.setItem(5, glass);
				invMerchant.setItem(7, glass);

				p.openInventory(invMerchant);

			}
			else if (entity.getCustomName().equalsIgnoreCase(ChatColor.GREEN + "GemStone Master")) {
				p.sendMessage(ChatColor.RED + "This is not implemented yet, will put in next update!");
			}
			else if(entity.getCustomName().equalsIgnoreCase(ChatColor.GREEN + "Global Market"))
			{
				p.performCommand("ah");
			}
		}

	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {

		if (e.getInventory().getName().equals(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Item Disenchanter")) {
			if (e.getCurrentItem() != null) {
				Player p = (Player) e.getWhoClicked();

				int slotclicked = e.getSlot();
				String item = e.getCurrentItem().getType().toString();
				Inventory inv = e.getInventory();

				if (slotclicked == 0 && e.getCurrentItem().getType() == Material.WOOL) {
					int i = 1;

					while (i <= 16) {
						if (inv.getItem(i) != null) {
							int redgreen = (int) ((Math.random() * 2));
							redgreen++;
							String namer = "nothing";
							if (redgreen == 1) {
								namer = "red";
							}
							if (redgreen == 2) {
								namer = "green";
							}

							ItemStack dis = new ItemStack(Material.INK_SACK, 1, (byte) redgreen);
							ItemMeta disMeta = dis.getItemMeta();

							String itemname = inv.getItem(i).getType().toString();

							if (itemname.contains("LEATHER") || itemname.contains("WOOD")) {
								disMeta.setDisplayName(
										ChatColor.WHITE + ChatColor.BOLD.toString() + "level 1 " + namer + " dust");
								disMeta.setLore(Arrays.asList(
										ChatColor.GRAY + "Trade 32 " + namer + " dust to the GemStone Master",
										ChatColor.GRAY + "for 1 GemStone which can be",
										ChatColor.GRAY + "used to boost weapons"));
								dis.setItemMeta(disMeta);
								p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
										+ "]>" + ChatColor.GREEN + "Received 1 " + dis.getItemMeta().getDisplayName()
										+ ChatColor.GREEN + " for disenchanting "
										+ inv.getItem(i).getItemMeta().getDisplayName());
								e.getInventory().setItem(i, null);
								p.getInventory().addItem(dis);
							}
							if (itemname.contains("CHAIN") || itemname.contains("STONE")) {

								disMeta.setDisplayName(
										ChatColor.GRAY + ChatColor.BOLD.toString() + "level 10 " + namer + " dust");
								disMeta.setLore(Arrays.asList(
										ChatColor.GRAY + "Trade 32 " + namer + " dust to the GemStone Master",
										ChatColor.GRAY + "for 1 GemStone which can be",
										ChatColor.GRAY + "used to boost weapons"));
								dis.setItemMeta(disMeta);
								p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
										+ "]>" + ChatColor.GREEN + "Received 1 " + dis.getItemMeta().getDisplayName()
										+ ChatColor.GREEN + " for disenchanting "
										+ inv.getItem(i).getItemMeta().getDisplayName());
								e.getInventory().setItem(i, null);
								p.getInventory().addItem(dis);
							}
							if (itemname.contains("IRON")) {

								disMeta.setDisplayName(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "level 20 "
										+ namer + " dust");
								disMeta.setLore(Arrays.asList(
										ChatColor.GRAY + "Trade 32 " + namer + " dust to the GemStone Master",
										ChatColor.GRAY + "for 1 GemStone which can be",
										ChatColor.GRAY + "used to boost weapons"));
								dis.setItemMeta(disMeta);
								p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
										+ "]>" + ChatColor.GREEN + "Received 1 " + dis.getItemMeta().getDisplayName()
										+ ChatColor.GREEN + " for disenchanting "
										+ inv.getItem(i).getItemMeta().getDisplayName());
								e.getInventory().setItem(i, null);
								p.getInventory().addItem(dis);
							}
							if (itemname.contains("GOLD")) {

								disMeta.setDisplayName(
										ChatColor.GOLD + ChatColor.BOLD.toString() + "level 30 " + namer + " dust");
								disMeta.setLore(Arrays.asList(
										ChatColor.GRAY + "Trade 32 " + namer + " dust to the GemStone Master",
										ChatColor.GRAY + "for 1 GemStone which can be",
										ChatColor.GRAY + "used to boost weapons"));
								dis.setItemMeta(disMeta);
								p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
										+ "]>" + ChatColor.GREEN + "Received 1 " + dis.getItemMeta().getDisplayName()
										+ ChatColor.GREEN + " for disenchanting "
										+ inv.getItem(i).getItemMeta().getDisplayName());
								e.getInventory().setItem(i, null);
								p.getInventory().addItem(dis);
							}
							if (itemname.contains("DIAMOND")) {

								disMeta.setDisplayName(
										ChatColor.BLUE + ChatColor.BOLD.toString() + "level 40 " + namer + " dust");
								disMeta.setLore(Arrays.asList(
										ChatColor.GRAY + "Trade 32 " + namer + " dust to the GemStone Master",
										ChatColor.GRAY + "for 1 GemStone which can be",
										ChatColor.GRAY + "used to boost weapons"));
								dis.setItemMeta(disMeta);
								p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
										+ "]>" + ChatColor.GREEN + "Received 1 " + dis.getItemMeta().getDisplayName()
										+ ChatColor.GREEN + " for disenchanting "
										+ inv.getItem(i).getItemMeta().getDisplayName());
								e.getInventory().setItem(i, null);
								p.getInventory().addItem(dis);
							}
						}
						i++;

					}

					e.setCancelled(true);
				}
				if (slotclicked == 17 && e.getCurrentItem().getType() == Material.BOOK) {
					e.setCancelled(true);
				}
				if (!(item.contains("AXE") || item.contains("SWORD") || item.contains("LEGGINGS")
						|| item.contains("BOOTS") || item.contains("CHEST") || item.contains("HELM")
						|| e.getCurrentItem().getType().getId() == 0 || e.getRawSlot() == 0 || e.getRawSlot() == 17
						|| e.getCurrentItem().hasItemMeta() == true)) {
					p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]>"
							+ ChatColor.GREEN + "You can not disenchant this item! Try weapons or armor!");
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void onCloseMerchant(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		Inventory inv = e.getInventory();
		if (e.getInventory().getName().equals(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Item Disenchanter")) {

			int i = 1;

			while (i <= 16) {
				if (inv.getItem(i) != null) {
					p.getInventory().addItem(inv.getItem(i));
				}
				i++;
			}
		}
	}

	@EventHandler
	public void Dura(PlayerInteractEvent e) {
		Action action = e.getAction();
		Player p = e.getPlayer();
		if (action.equals(action.RIGHT_CLICK_BLOCK)) {
			if (e.getClickedBlock().getType() == Material.ANVIL) {
				e.setCancelled(true);
				if (e.getItem() == null) {
					return;
				}

				if (e.getItem().hasItemMeta()) {
					String itemname = e.getItem().getType().toString();
					ItemStack repairItem = e.getItem();

					int loreSize = repairItem.getItemMeta().getLore().size();
					int place = loreSize - 1;

					ItemMeta repairMeta = repairItem.getItemMeta();
					List<String> repairLore = repairMeta.getLore();

					String duraLore = repairMeta.getLore().get(place);
					Scanner in = new Scanner(duraLore).useDelimiter("[^0-9]+");
					int customDura = in.nextInt();

					if (customDura == 100) {
						p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + "]>"
								+ ChatColor.RED + "   This item is already fully repaired!");
						return;
					}

					double cost = 0;

					if (itemname.contains("CHEST") || itemname.contains("LEGG") || itemname.contains("BOOTS")
							|| itemname.contains("HELMET") || itemname.contains("SWORD") || itemname.contains("AXE")) {
						if (itemname.contains("LEATHER") || itemname.contains("WOOD")) {
							cost = 0.5 * (100 - customDura);

						}
						if (itemname.contains("CHAIN") || itemname.contains("STONE")) {
							cost = 1 * (100 - customDura);
						}
						if (itemname.contains("IRON")) {
							cost = 3 * (100 - customDura);
						}
						if (itemname.contains("GOLD")) {
							cost = 6 * (100 - customDura);
						}
						if (itemname.contains("DIAMOND")) {
							cost = 10 * (100 - customDura);
						}

						if (econ.has(p, cost)) {
							econ.withdrawPlayer(p, cost);
							repairLore.set(place, (ChatColor.WHITE
									+ ChatColor.BOLD.toString() + "[ 100 / 100 ]"));
							repairMeta.setLore(repairLore);
							repairItem.setItemMeta(repairMeta);
							repairItem.setDurability((short) 1);
							p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
									+ "]>" + ChatColor.GREEN + "  You repaired this item: "
									+ repairItem.getItemMeta().getDisplayName() + ChatColor.GREEN + " for "
									+ ChatColor.YELLOW + ChatColor.UNDERLINE.toString() + cost + " Gems");
						} else
							p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY
									+ "]>" + ChatColor.RED + "  You do not have " + ChatColor.YELLOW
									+ ChatColor.UNDERLINE.toString() + cost + " Gems " + ChatColor.RED
									+ "to repair this item");

					}

				} else
					return;
			}
		}
	}

}
