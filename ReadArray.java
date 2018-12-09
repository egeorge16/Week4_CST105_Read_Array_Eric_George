package readarray;

import java.util.*;
import java.io.*;
 /**Program: ReadArray
 * File: ReadArray.java
 * Summary: Take text input from a text file
 * and convert it to a 20 x 45 char array then
 * output to console in column order. 
 * Author: Eric George
 * Date: November 25, 2018
 */
public class ReadArray {

  public static void main(String[] args) throws Exception {
      //Load in text file
      File file = new File("G:\\Programming stuff\\ReadArray\\src\\readarray\\textfile.txt");
      //Create scanner from file
      Scanner input = new Scanner(file);
      //Create 2D char array
      char[][] array = new char[20][45];
      //Create char array to read from file with dimensions of target array.
      char[] charsInFile = new char[20 * 45];
      int fileSize = 0;
      int index = 0;
      //Create loop for loading characters into char array
      while (input.hasNext()) {
          char[] word = input.nextLine().toCharArray();
          fileSize += word.length;
          if(fileSize <= charsInFile.length) {
              System.arraycopy(word, 0, charsInFile, 0, word.length);
          } else {
              System.arraycopy(word, 0, charsInFile, 0, word.length - (fileSize - charsInFile.length));
              break;
          }
      }
      //Create loop to change certain characters to the @ symbol
      if (!input.hasNext()) {
          for (int i = charsInFile.length-1; i >= fileSize; i--) {
              charsInFile[i] = '@';
          }
      }
      //Create loop for the 2D element
      for (char[] array1 : array) {
          for (int k = 0; k < array1.length; k++) {
              if (index < charsInFile.length) {
                  array1[k] = charsInFile[index];
                  index++;
              }
          }
      }
      //Create loop for output in different order
      String outputArray = "";
      for (int x = 0; x < 45; x++) {
          for (char[] array1 : array) {
              outputArray += array1[x];
          }
      }
      System.out.println(outputArray);
  }
}