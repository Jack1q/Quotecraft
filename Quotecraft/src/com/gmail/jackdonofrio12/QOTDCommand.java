package com.gmail.jackdonofrio12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.ZoneId;
import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class QOTDCommand implements CommandExecutor
{

  public boolean onCommand(CommandSender sender, Command command, String label,
    String[] args)
  {
    int dayValue =
      new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        .getDayOfMonth();

    int todaysLineValue = dayValue % 98 + 1;
    InputStream in = getClass().getResourceAsStream("quotes/any.csv");
    try
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      int currentLineNumber = 0;
      String currentLine = br.readLine();
      while ((currentLine = br.readLine()) != null
        && currentLineNumber < todaysLineValue)
      {
        currentLineNumber++;
      }
      String[] rawLineContent = currentLine.split(",");
      Quote quoteOfTheDay =
        new Quote("\"" + rawLineContent[0].trim() + "\"",
          rawLineContent[1].trim());
      sender.sendMessage(quoteOfTheDay.toString());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return true;
  }

}
