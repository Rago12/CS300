

//Counts the number of Strings (i.e. non-null) valuesin the data array and generates arandom index between 0 and the number of Strings storedin this bag (exclusive)..
//○ Removes and returns the String at that index.
//○ Fills gaps by moving all following strings to theleftby one index. N -> N-1, etc.
//○If the bag contains no strings, this method returnsnull.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class TestLoadData {
  public static void main(String args[]) {
    File f = new File("test.txt");
    Scanner scan = null;
    try {
      scan = new Scanner(f);
      scan.next();

      String[] data = new String[50];
      int size = 0;

      while (scan.hasNext()) {
        String word = scan.next();
        data[size] = word;
        size++;
      }

      for(String s : data){
        System.out.println(s);
      }

    } catch (FileNotFoundException e) {
      System.out.println("File was not found");
      return;
    } finally {
      if (scan != null) {
        scan.close();
      }
    }
  }
}
