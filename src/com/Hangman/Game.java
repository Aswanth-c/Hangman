package com.Hangman;
import static com.Hangman.Status.printstatus;

import java.util.HashMap;
import java.util.Scanner;

public class Game {

  public static void main(String[] args) {
   WordGenerator wordGenerator =new WordGenerator();
    StringBuilder word= new StringBuilder(wordGenerator.Getword());
    System.out.println(word);
    StringBuilder Inputword =new StringBuilder(); //  The status of word user trying to finish
    for(int i=0;i<word.length();i++) {
      Inputword.append('*');
    }
    boolean found=false; // to know whether we found element or not
    int count=6;
    int lettercount=0; // To get how many times the letter has entered
    int guesscount =0; //match time to see how many time we choose a correct word
    HashMap <Character,Integer> Alreadyguessedcharacters = new HashMap<>();
    while(count>0) {
      @SuppressWarnings("resource")
      Scanner input= new Scanner(System.in);
      String charinput=input.next();
      //checking the given word contains  that character
      for(int i=0;i<word.length();i++) {
        // solving edge case if user try to input that character again
        if(Alreadyguessedcharacters.containsKey(charinput.charAt(0)) && lettercount<=0){
          System.out.println("The character is already entered please enter other character");
          found=true;
          break;

        }
        if(charinput.charAt(0)==word.charAt(i)) {

          if (lettercount == 0) {
            Alreadyguessedcharacters.put(word.charAt(i), i);
          }

          found = true;
          Inputword.setCharAt(i, charinput.charAt(0));//replaces the character with *
          lettercount++;
          guesscount++;
        }
      }

      if(found==true){

         if(guesscount >=word.length()) {
          System.out.println("Congratulations!!!! ");
           System.out.println("You Won word was:" +word);
          System.exit(0);
        }
        else{
          System.out.println(Inputword);
        System.out.println("correct character keep guessing");


      }}



      if(found==false) {
        count--;

        System.out.println(Inputword);
        printstatus(count);
      }

      found=false;
      lettercount=0;

    }
    System.out.println("Nice Try the word was:" +word);
  }


}
