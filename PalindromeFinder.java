/**
 * Gabriel Williams
 * 4/29/2026
 * CSC 331-001
 *
 * Purpose: This is taking words from wordList.txt and finding the palindromes within that file and
 * putting the palindromes in a file named palindromes.txt.
 */

import java.io.*; //Contains classes used for reading files, writing files, and handling file errors
import java.util.*; // Lets the code read text from a file, such as numbers, words, and lines

public class PalindromeFinder {
    public static void main(String[] args) {

        File wordFile = new File("wordList.txt"); //Create a variable for wordList file
        File palindromesFile = new File("palindromes.txt"); //Create a variable for palindromes file

        //Use a try catch to implement the writing and reading of each file.
        try {
            Scanner reader = new Scanner(wordFile); //Read the wordList file
            PrintWriter writer = new PrintWriter(palindromesFile); // Write into the palindromes file

            while (reader.hasNextLine()) {
                //This will read each line until the end of the file
                //Variable word because it gathers each line then you need ot trim and get the word
                String word = reader.nextLine().trim();

                if (isPalindrome(word)) {
                    //use isPalindrome to decide if the word is a palindrome and the print the word in the new file if it is a palindrome
                    writer.println(word);
                }
            }

            reader.close();//Close the file its reading
            writer.close();//Close the file its writing in

        } catch (FileNotFoundException e) {
            //Catch if there is no file to read
            System.out.println("File not found.");
        }
    }

    public static boolean isPalindrome(String word) {
        //Use recursion to determine if the word is a palindrome
        //turn all characters of the word lowercase for easier comparison
        word = word.toLowerCase();

        if (word.length() <= 1) {
            //Base case is if it is empty or one character it is a palindrome
            return true;
        }

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            //Next is if the first and last character of the word are not equal to each other it is not a palindrom
            return false;
        }

        //Apply recursion by taking the word and subtracting the first and last character and examining the middle characters
        return isPalindrome(word.substring(1, word.length() - 1));
    }
}
