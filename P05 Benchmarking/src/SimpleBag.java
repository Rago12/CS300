//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Simple Bag
// Course:   CS 300 Spring 2021
//
// Author:   Rago Senthilkumar
// Email:    rsenthilkuma@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Hobbes LeGault: Provided instructions to create
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Creates the Simple Bag object and houses the Simple Bag methods.
 */
public class SimpleBag {

  protected String[] data;
  protected Random random;

  /**
   * This is the constructor for Simple Bag.
   *
   * @param seed the integer used for the seed in the Random object.
   */
  public SimpleBag(int seed) {
    this.data = new String[80000];
    random = new Random(seed);
  }

  /**
   * Reads the text from the provided file, inserting each new word into the
   * beginning of the array (backwards). If exception is thrown, then just return.
   *
   * Complexity: O(N^2)
   *
   * @param f the file that is read by the method.
   */
  public void loadData(File f) {
    Scanner scan = null;
    try {
      scan = new Scanner(f);
      scan.next();

      int size = 0;
      while (scan.hasNext()) {
        String word = scan.next();
        for (int i = size; i > 0; i--) {
          data[i] = data[i - 1];
        }
        data[0] = word;
        size++;
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

  /**
   * Generates a random number between 0 and the number of strings in the array.
   * Then Removes and returns the string at that index. Fills the gaps by moving all
   * the following strings to the left.
   *
   * Complexity: O(N)
   *
   * @return the String at the index generated from the random number.
   */
  public String removeRandom() {
      int count = 0;
      for (String s : data) {
        if (s != null) {
          count++;
        }
      }
      if(count == 0){
        return null;
      }

      int index = 0;
      String wordRemove = "";
      index = random.nextInt(count);
      wordRemove = data[index];
      data[index] = null;

      for (int i = index; i < count; i++) {
        data[i] = data[i + 1];
      }
      return wordRemove;
    }
  }

