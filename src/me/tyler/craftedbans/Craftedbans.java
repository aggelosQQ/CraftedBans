package me.Tyler.craftedbans;

import java.io.File;
import java.util.logging.Logger;
import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
public class Craftedbans extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	  public static Craftedbans plugin;
	  public static final String NOPE_YOU_CANT = (ChatColor.RED + "No permissions!");
	  public static final String Not_Found = (ChatColor.GOLD + "Player not found!");
	  public void onDisable()
	  {
	    PluginDescriptionFile pdfFile = getDescription();
	    logger.info(pdfFile.getName() + " Has Been Disabled!");
	  }
	  public void onEnable() 
	  {
	    PluginDescriptionFile pdfFile = getDescription();
	    logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled");
	  }
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	    Player player = (Player) sender;
	     if(commandLabel.equalsIgnoreCase("ban")) {
	    	if(sender.hasPermission("craftedbans.ban"))
	    	if (args.length == 0)
	    		sender.sendMessage(ChatColor.RED + "Usage: /ban <player> <any letter here unbans>");
	    	else if (args.length == 1) {
	    		if (player.getServer().getPlayer(args[0]) != null) {
			          Player targetPlayer = player.getServer().getPlayer(args[0]);
			            Bukkit.broadcastMessage(ChatColor.GRAY + targetPlayer.getName() + " Has been banned by " + sender.getName()); 
                        targetPlayer.kickPlayer(ChatColor.GOLD + "Banned by " + sender.getName());
		    	        targetPlayer.setBanned(true);
	    		}else{
	    			OfflinePlayer offlinep = getServer().getOfflinePlayer(args[0]);
	    			offlinep.setBanned(true);
	    			Bukkit.broadcastMessage(ChatColor.GRAY + offlinep.getName() + " Has been banned by " + sender.getName());
	    		}
	    	}
	    	    if (args.length == 2) {
	    	    	OfflinePlayer offlinep = getServer().getOfflinePlayer(args[0]);
	    	    	offlinep.setBanned(false);
	    	    	Bukkit.broadcastMessage(ChatColor.GRAY + offlinep.getName() + " Has been unbanned by " + sender.getName());
	    	    }
	    			
		    	     
}
		return true;
	    	}
	     {
		
	  }
}
