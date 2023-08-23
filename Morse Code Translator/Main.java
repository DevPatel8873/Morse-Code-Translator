import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main 
{
  public static void main(String[] args) throws IOException, FileNotFoundException
  {
    String userMCode = "";
    
    //makes the scanner + initialize variables 
    Scanner secondBestGroup = new Scanner(System.in);
  
    Scanner file = new Scanner(new File("Messages.txt"));

    //change delimiter to new lines so the program can go through the text file line-by-line
    file.useDelimiter("\n");


    //--. --- / ...- .. -.- .. -. --. ... * -.. .- - .- / ... - .-. ..- -.-. - ..- .-. . ... *

    System.out.println("Please enter a series of . and - with spaces for letters and slashes for words so that we can translate the message for you:");
    userMCode = secondBestGroup.nextLine();
    

    String translateMorseLetter = "";

    //Creates and fills Binary tree with all letters in Morse order
    MorseTree translatorTree = new MorseTree();
    
    for(int i = 0; i < 26; i++)
    {
      translatorTree.InsertItem(file.next());
    }

    
    System.out.print("Translated Phrase: \n");

    //Iterates through the entered string checking for the valid strings neccesary for translation
    for(int i = 0; i < userMCode.length(); i++)
    {
      //If the character is a morse letter, it gets added to string containing the morse letter for one regular letter
      if(userMCode.substring(i, i+1).equals(".") || userMCode.substring(i, i+1).equals("-"))
      {
        translateMorseLetter = translateMorseLetter + userMCode.substring(i,i+1);
      }

      //If the character is a space, it translates and prints the morse letter into a regular letter, then reset the variable for the next 
      //letter
      if(userMCode.substring(i, i+1).equals(" ") && translateMorseLetter.length() > 0)
      {
        System.out.print(translatorTree.translate(translateMorseLetter));
        translateMorseLetter = "";
      }

      //Prints space inbetween words if character is a slash
      if(userMCode.substring(i, i+1).equals("/"))
      {
        System.out.print(" ");
      }
      
      //Prints next line inbetween lines if character is a *
      if(userMCode.substring(i, i+1).equals("*"))
      {
        System.out.print("\n");
      }
    }
  }
}