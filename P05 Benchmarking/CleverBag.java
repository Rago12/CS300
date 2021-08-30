//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Clever Bag
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
import java.util.Scanner;

/**
 * Creates the Clever Bag object and houses the Clever Bag methods.(Extended from SimpleBag)
 */
public class CleverBag extends SimpleBag {

  private Integer size;

  /**
   * The constructor for the CleverBag object.
   *
   * @param seed the integer used for the Random object.
   */
  public CleverBag(int seed) {
    super(seed);
    this.size = 0;
  }

  /**
   * Reads the text from the provided file, inserting each new word into the
   * end of the array. If exception is thrown, then just return.
   *
   * Complexity: O(N)
   *
   * @param f the file that is read by the method.
   */
  @Override
  public void loadData(File f) {
    Scanner scan = null;
    try {
      scan = new Scanner(f);
      scan.next();
      while(scan.hasNext()) {
        String word = scan.next();
        data[size] = word;
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
   * Then Removes and returns the string at that index. Fills the gaps with
   * the last String.
   *
   * Complexity: O(1)
   *
   * @return the String at the index generated from the random number.
   */
  @Override
  public String removeRandom() {
    if(size == 0){
      return null;
    }

      int index = 0;
      String wordRemove = "";
      index = random.nextInt(size);
      wordRemove = data[index];
      data[index] = null;

      data[index] = data[size - 1];
      data[size - 1] = null;
      size--;

      return wordRemove;
  }
}


