package com.Hangman;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class WordGenerator {
  // function return  a word for hangman
  public String Getword() {

    try {
      File f = new File("dictionary.txt");
      FileReader fileReader = new FileReader(f);
      BufferedReader br = new BufferedReader(fileReader);
      br.readLine();
      Random random = new Random();
      int number = random.nextInt(80368); // number of words in our dictionary
      String picker = Files.readAllLines(Paths.get("dictionary.txt"))
          .get(number); // getting random word
      return (picker);
    } catch (Exception e) {
      e.printStackTrace();
      return "null";
    }
  }
}
