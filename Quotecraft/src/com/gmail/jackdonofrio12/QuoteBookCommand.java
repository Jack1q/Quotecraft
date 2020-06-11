package com.gmail.jackdonofrio12;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

/*
 * Gives the player a book containing all quotes in a given genre
 */
public class QuoteBookCommand implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String label,
    String[] args)
  {
    if (sender instanceof Player)
    {
      try
      {
        String genre = args[0];
        ArrayList<Quote> quotesFromGenre =
          new QuoteGenerator(genre).getAllQuotesFromGenre();

        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) book.getItemMeta();
        bookMeta.setAuthor("Quotecraft");
        bookMeta.setTitle(ChatColor.ITALIC
          + ((ChatColor.DARK_AQUA + "Quotes on ") + ChatColor.GREEN + genre));

        for (int i = 1; i < 49; i += 2)
        {
          bookMeta.addPage(quotesFromGenre.get(i).toString() + "\n"
            + quotesFromGenre.get(i + 1).toString());
        }
        book.setItemMeta(bookMeta);
        ((Player) sender).getInventory().addItem(book);
      }
      catch (Exception e)
      {
        e.printStackTrace();
        sender.sendMessage(ChatColor.DARK_RED + "Proper usage: "
          + (ChatColor.RED + "/quotebook (genre)\n") + ChatColor.BLUE
          + "Genres include: " + (ChatColor.AQUA + "motivation, life"));
      }
    }
    return true;
  }
}
