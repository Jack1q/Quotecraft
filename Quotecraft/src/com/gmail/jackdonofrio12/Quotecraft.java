package com.gmail.jackdonofrio12;

/*
 * I'm a firm believer in learning by doing. So instead of just reading more about the 
 * Spigot API without using anything I've learned along the way, I've decided to 
 * get my feet wet with this little project. The main command is /quote. The different
 * arguments represent the different categories of quotes
 */
import org.bukkit.plugin.java.JavaPlugin;

public class Quotecraft extends JavaPlugin
{

  @Override
  public void onEnable()
  {
    this.getCommand("quote").setExecutor(new QuoteCommand());
    this.getCommand("quotebook").setExecutor(new QuoteBookCommand());
    this.getCommand("quoteoftheday").setExecutor(new QOTDCommand());
  }

  @Override
  public void onDisable()
  {
  }
}