package me.tehtafara0.magicarmor;
 
import java.util.Random;
 
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main extends JavaPlugin {
       
        public void onEnable() {
                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
                        private Random r = new Random();
                       
                        public void run() {
                                Color c = Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255));
                               
                                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                                        if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getType() == Material.LEATHER_HELMET) {
                                                p.getInventory().setHelmet(getColorArmor(Material.LEATHER_HELMET, c));
                                        }
                                       
                                        if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE) {
                                                p.getInventory().setChestplate(getColorArmor(Material.LEATHER_CHESTPLATE, c));
                                        }
                                       
                                        if (p.getInventory().getLeggings() != null && p.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS) {
                                                p.getInventory().setLeggings(getColorArmor(Material.LEATHER_LEGGINGS, c));
                                        }
                                       
                                        if (p.getInventory().getBoots() != null && p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) {
                                                p.getInventory().setBoots(getColorArmor(Material.LEATHER_BOOTS, c));
                                        }
                                }
                        }
                }, 0, 1);
        }
       
        private ItemStack getColorArmor(Material m, Color c) {
                ItemStack i = new ItemStack(m, 1);
                LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
                meta.setColor(c);
                i.setItemMeta(meta);
                return i;
        }
}