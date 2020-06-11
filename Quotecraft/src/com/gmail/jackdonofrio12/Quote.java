package com.gmail.jackdonofrio12;

import org.bukkit.ChatColor;

public class Quote
{
  private String content;
  private String speaker;

  public Quote(String content, String speaker)
  {
    this.content = content;
    this.speaker = speaker;
  }

  public String getContent()
  {
    return content;
  }

  public String getAuthor()
  {
    return speaker;
  }

  @Override
  public String toString()
  {
    return (ChatColor.BLUE + (ChatColor.ITALIC + content)) + " - "
      + (ChatColor.GOLD + speaker);
  }

}