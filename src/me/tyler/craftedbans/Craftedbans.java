package me.Tyler.craftedbans;

import org.bukkit.ChatColor;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
public class Craftedbans extends JavaPlugin{
	public final Logger log = Logger.getLogger("Minecraft-Server");
	  public static Craftedbans plugin;
	   public static final String COMMAND_PATH = "me.Tyler.craftedbans.Commands";
	   public static final String COMMAND_PREFIX = "Command_";
	  public static final String VERSION = ("1.1.2");
	  public static final String NOPE_YOU_CANT = (ChatColor.RED + "No permissions!");
	  public static final String Not_Found = (ChatColor.GOLD + "Player not found!");
	  public MySQLManager mysql = new MySQLManager(this);
	  public void onDisable()
	  {
		log.info("[CraftedSmart]: Has been Disabled!");
	    log.info("[CraftedBans]: Has Been Disabled!");
	  }
	  public void onEnable() 
	  {
	    log.info("[CraftedSmart]: V01 Has been enabled");
	    log.info("[CraftedBans]: Version " + VERSION +  " Has Been Enabled");
	  }

}
