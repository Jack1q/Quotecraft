package com.gmail.jackdonofrio12;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuoteCommand implements CommandExecutor
{

  public boolean onCommand(CommandSender sender, Command command, String label,
    String[] args)
  {
    if (sender instanceof Player)
    {
      try
      {
        Quote quote = new QuoteGenerator(args[0]).chooseRandomQuote();
        sender.sendMessage(quote.toString());
      }
      catch (Exception e)
      {
        sender.sendMessage(ChatColor.DARK_RED + "Proper usage: "
          + (ChatColor.RED + "/quote (genre)\n") + ChatColor.BLUE
          + "Genres include: " + (ChatColor.AQUA + "motivation, life"));
      }
    }
    return true;
  }

}
