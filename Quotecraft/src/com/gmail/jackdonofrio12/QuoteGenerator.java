package com.gmail.jackdonofrio12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuoteGenerator
{
  private String genre;
  private final String[] GENRES = {"life", "motivation"}; // add more
  private final int NUMBER_OF_LINES_IN_DOCUMENTS = 50;

  public QuoteGenerator(String genre)
  {
    this.genre = genre;
  }

  public Quote chooseRandomQuote()
  {
    if (genreIsValid())
    {
      int randomLineNumber =
        (int) (Math.random() * NUMBER_OF_LINES_IN_DOCUMENTS) + 1;
      InputStream in = getClass().getResourceAsStream(getFileName());
      try
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String currentLine;
        int currentLineNumber = 0;
        while ((currentLine = br.readLine()) != null
          && currentLineNumber < randomLineNumber)
        {
          currentLineNumber++;
        }
        return rawLineToQuote(currentLine);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return null;
  }

  public ArrayList<Quote> getAllQuotesFromGenre()
  {
    if (genreIsValid())
    {
      ArrayList<Quote> quotesFromGenre = new ArrayList<>();
      InputStream in = getClass().getResourceAsStream(getFileName());
      try
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int currentLineNumber = 0;
        String currentLine = br.readLine(); // first line is read so it will be
                                            // ignored
        while ((currentLine = br.readLine()) != null
          && currentLineNumber < NUMBER_OF_LINES_IN_DOCUMENTS)
        {
          quotesFromGenre.add(rawLineToQuote(currentLine));
          currentLineNumber++;
        }
        return quotesFromGenre;
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return null;
  }

  private boolean genreIsValid()
  {
    for (String g : GENRES)
    {
      if (genre.equals(g))
        return true;
    }
    return false;
  }

  private String getFileName()
  {
    return "quotes/" + genre + ".csv";
  }

  private Quote rawLineToQuote(String rawLineContent)
  {
    String[] rawContent = rawLineContent.split(",");
    String quote = "\"" + rawContent[0].trim() + "\"";
    String speaker = rawContent[1].trim();
    return new Quote(quote, speaker);
  }

}