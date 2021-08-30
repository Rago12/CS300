//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Benchmark
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
import java.io.PrintWriter;

/**
 * This class is responsible for comparing the time of certain SimpleBag and CleverBag methods.
 */
public class Benchmark {
  /**
   * Computes the time elapsed for the loadData method in both the bag types
   * and returns a string of the results.
   *
   * @param f the file being used for the loadData method fo bag types.
   * @param s the Simple bag object used for loadData method.
   * @param c the Clever bag object used for loadData method.
   * @return a formatted String with the elapsed times for each of the bag types.
   */
  public static String compareLoadData(File f, SimpleBag s, CleverBag c) {
    long simpleBagLoadTime = 0;
    long cleverBagLoadTime = 0;

    long time1 = System.currentTimeMillis();
    s.loadData(f);
    long time2 = System.currentTimeMillis();
    simpleBagLoadTime = time2 - time1;


    long time3 = System.currentTimeMillis();
    c.loadData(f);
    long time4 = System.currentTimeMillis();
    cleverBagLoadTime = time4 - time3;

    return "load:\t" + simpleBagLoadTime + "\t" + cleverBagLoadTime + "\n";
  }

  /**
   * Computes the time elapsed for the removeRandom method in both the bag types
   * and returns a string of the results.
   *
   * @param n the number of words being removed.
   * @param s the Simple bag object used for removing the random word.
   * @param c the clever bag object used for removing the random word.
   * @return a formatted string with n and the elapsed times for each of the bag types.
   */

  public static String compareRemove(int n, SimpleBag s, CleverBag c) {
    long simpleBagRemoveTime = 0;
    long cleverBagRemoveTime = 0;

    long time1 = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      s.removeRandom();
    }
    long time2 = System.currentTimeMillis();
    simpleBagRemoveTime = time2 - time1;

    long time3 = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      c.removeRandom();
    }
    long time4 = System.currentTimeMillis();
    cleverBagRemoveTime = time4 - time3;

    return n + "\t" + simpleBagRemoveTime + "\t" + cleverBagRemoveTime + "\n";
  }

  /**
   * Creates one instance each of a SimpleBag and a CleverBag.Calls
   * compareLoadData to compare the two different data loads using
   * the in parameter. Calls compareRemove on each of the provided nValues
   * to compare the two different remove implementations. Then puts all the
   * results in a file.
   *
   * @param in      the input file used to compare between SimpleBag and CleverBag.
   * @param out     the file the results are witten to.
   * @param nValues different values that are used for the number of words being removed.
   */
  public static void createResultsFile(File in, File out, int[] nValues) {
    SimpleBag s = new SimpleBag(100);
    CleverBag c = new CleverBag(100);

    String loadStr = compareLoadData(in, s, c);

    String removeStr = "";
    for (int i = 0; i < nValues.length; i++) {
      removeStr = removeStr + compareRemove(nValues[i], s, c);
    }

    PrintWriter writer = null;
    try {
      writer = new PrintWriter(out);
      writer.print(loadStr + removeStr);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    } finally {
      if (writer != null)
        writer.close();
    }
  }

  /**
   * The main method is used to test the code.
   *
   * @param args unused
   */
  public static void main(String args[]) {
    File in = new File("Frank.txt");
    File out = new File("Out.txt");

    int[] nValues = new int[]{10, 100, 1000, 10000};

    createResultsFile(in, out, nValues);
  }
}
