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
	public final Logger log = Logger.getLogger("Minecraft-Server");
	  public static Craftedbans plugin;
	  public static final String VERSION = ("1.1.2");
	  public static final String NOPE_YOU_CANT = (ChatColor.RED + "No permissions!");
	  public static final String Not_Found = (ChatColor.GOLD + "Player not found!");
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
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args, boolean SenderisConsole) {
	    Player player = (Player) sender;
	     if(commandLabel.equalsIgnoreCase("ban")) {
	    	if(sender.hasPermission("craftedbans.ban"))
	    	if (args.length == 0)
	    		sender.sendMessage(ChatColor.RED + "Usage: /ban <player> <reason>");
	    	else if (args.length == 1) {
	    		if (player.getServer().getPlayer(args[0]) != null) {
			          Player targetPlayer = player.getServer().getPlayer(args[0]);
			          String reason = "You have been banned!";
			          if (args.length >= 2)
			          {
			              reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
			          }
			            Bukkit.broadcastMessage(ChatColor.GRAY + targetPlayer.getName() + " Has been banned by " + sender.getName() + " For: " + reason); 
                        targetPlayer.kickPlayer(ChatColor.GOLD + "Banned by " + sender.getName() + " For: " + reason);
		    	        targetPlayer.setBanned(true);
	    		}else{
	    			OfflinePlayer offlinep = getServer().getOfflinePlayer(args[0]);
	    			offlinep.setBanned(true);
	    			Bukkit.broadcastMessage(ChatColor.GRAY + offlinep.getName() + " Has been banned by " + sender.getName());
	    		}
	    	}
	     }
	        if(commandLabel.equalsIgnoreCase("kick")) {
	    	if(sender.hasPermission("craftedbans.kick"))
	    	if (args.length == 0)
	    		sender.sendMessage(ChatColor.RED + "Usage: /kick <player>");
	    	else if (args.length == 1) {
	    		if (player.getServer().getPlayer(args[0]) != null) {
			          Player targetPlayer = player.getServer().getPlayer(args[0]);
			          String reason = "You have been kicked!";
			          if (args.length >= 2)
			          {
			              reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
			          } 
			          Bukkit.broadcastMessage(ChatColor.GRAY + targetPlayer.getName() + " Has been kicked by " + sender.getName() + " For: " + reason); 
                        targetPlayer.kickPlayer(ChatColor.GOLD + "Kicked by " + sender.getName() + " For: " + reason);
	    		}else{
	    			sender.sendMessage(Not_Found);
	    		}
	      if(cmd.getName().equalsIgnoreCase("unban"))
	      {
	    	 OfflinePlayer offlinep = getServer().getOfflinePlayer(args[0]);
	    	 if(offlinep.isBanned());
	    	 Bukkit.broadcastMessage(ChatColor.GRAY + offlinep.getName() +" has been unbanned by: " + sender.getName());
	      }else{
	    	  sender.sendMessage(ChatColor.RED + "[CraftedBans]: That player is not banned!");
	     if(cmd.getName().equalsIgnoreCase("warn"))
	     {
		    	if(sender.hasPermission("craftedbans.warn"))
			    	if (args.length == 0)
			    		sender.sendMessage(ChatColor.RED + "CraftedSmart command- Warn a player Usage: /warn <player> <reason>");
			    	else if (args.length == 1) {
			    		if (player.getServer().getPlayer(args[0]) != null) {
					          Player targetPlayer = player.getServer().getPlayer(args[0]);
					          String reason = "You have been warned!";
					          if (args.length >= 2)
					          {
					              reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
					          } 
					         Bukkit.broadcastMessage("[CraftedSmart]: " + targetPlayer.getName() + " has been warned by: " + sender.getName() + " For: " + reason);
	     }
}
	    	}
	     {
		
	  }
}
			return SenderisConsole;
}
}
			return true;
	  }
}
