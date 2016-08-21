package me.TomAlex.Atherial.Combat;

import me.TomAlex.Atherial.Main;
import me.TomAlex.Atherial.SettingsManager;

import java.util.Scanner;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerUpdater {

	SettingsManager settings = SettingsManager.getInstance();

	private PlayerUpdater() {
	}

	static PlayerUpdater instance = new PlayerUpdater();

	public static PlayerUpdater getInstance() {
		return instance;
	}

	public void UpdaterStart() {

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getProvidingPlugin(Main.class),
				new Runnable() {
					public void run() {
						for (Player p : Bukkit.getServer().getOnlinePlayers()) 
						{
							UUID ud = p.getUniqueId();
							int maxhealth = (int) p.getMaxHealth();
							int armorhealth = 100;

							int i = 1;
							int i2 = 1;
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

								// -------------gettinghealth wat het zou moeten zijn--------------------
								if (armor != null) {
									String lorehealth = armor.getItemMeta().getLore().get(1);
									Scanner in2 = new Scanner(lorehealth).useDelimiter("[^0-9]+");
									int h = in2.nextInt();
									int h2 = in2.nextInt();
									armorhealth = armorhealth + h2;
								}

								i++;
							}

							//-----------------Dit doet die als health niet klopt en glitched is---------------
							if (armorhealth != maxhealth) {
								p.setMaxHealth(100);
								settings.Armor.put(p.getUniqueId(), 0);
								settings.Regen.put(p.getUniqueId(), 0);
								settings.Block.put(p.getUniqueId(), 0);
								settings.Thorns.put(p.getUniqueId(), 0);
								settings.Vit.put(p.getUniqueId(), 0);
								settings.PvP.put(p.getUniqueId(), 0);
								settings.PvE.put(p.getUniqueId(), 0);

								while (i2 <= 4) 
								{
									switch (i2) {
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
										// ----------Setting Health----------
										String lorehealth = armor.getItemMeta().getLore().get(1);
										Scanner in2 = new Scanner(lorehealth).useDelimiter("[^0-9]+");
										int h = in2.nextInt();
										int h2 = in2.nextInt();
										int maxhealth2 = (int) p.getMaxHealth();
										p.setMaxHealth((double) maxhealth2 + h2);

										// ----------Armor-----------------
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

										// ----------PvP Or PvE
										// restistance------
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
									i2++;
								}
							}					
						}
					}
				}, 100, 100);
	}
}