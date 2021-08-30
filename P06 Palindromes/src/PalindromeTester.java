//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Palindrome Tester
// Course:   CS 300 Spring 2022
//
// Author:   Rago Senthilkumar
// Email:    rsenthilkuma@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Hobbes LeGault: Provided instructions to build program.
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class houses the codes to test the Palindrome class.
 * <p>
 * A: testMirrorA()
 * Z: testMirrorZ()
 * AS: testMirrorAStep()
 * ZS: testMirrorZStep()
 */
public class PalindromeTester {
  /**
   * This method tests the Palindrome method MirrorA().
   *
   * @return true if the method works, false otherwise.
   */
  public static boolean testMirrorA() {
    boolean test = true;

    //(1) Normal Scenario
    String mirror1 = Palindrome.mirrorA('E');

    if (!mirror1.equals("E D C B A B C D E")) {
      System.out.println("(A1) The method did not provide the right string, the method resulted in: " + mirror1);
      test = false;
    }

    //(2) 'A' is the provided letter
    String mirror2 = Palindrome.mirrorA('A');

    if (!mirror2.equals("A")) {
      System.out.println("(A2) The method did not provide the right string, the method resulted in: " + mirror2);
      test = false;
    }

    //(3) Non-capital letter
    try {
      String mirror3 = Palindrome.mirrorA('3');
    } catch (IllegalArgumentException e) {
      System.out.println("(A3) Exception was caught when the input was not a capital letter.");
    }

    return test;
  }

  /**
   * This method tests the Palindrome method MirrorA() with the step.
   *
   * @return true if the method works, false otherwise.
   */
  public static boolean testMirrorAStep() {
    boolean test = true;

    //(1) Normal scenario with 'A' is the middle character.
    String mirror1 = Palindrome.mirrorA('E', 2);

    if (!mirror1.equals("E C A C E")) {
      System.out.println("(AS1) The method did not provide the right string, the method resulted in:" + mirror1);
      test = false;
    }

    //(2) Normal scenario with 'A' not in the middle.
    String mirror2 = Palindrome.mirrorA('E', 3);

    if (!mirror2.equals("E B B E")) {
      System.out.println("(AS2) The method did not provide the right string, the method resulted in:" + mirror2);
      test = false;
    }

    //(3) Input is 'A'.
    String mirror3 = Palindrome.mirrorA('A', 3);

    if (!mirror3.equals("A")) {
      System.out.println("(AS3) The method did not provide the right string, the method resulted in:" + mirror3);
      test = false;
    }

    //(4) Step size is less than zero
    try {
      String mirror4 = Palindrome.mirrorA('A', -1);
    } catch (IllegalArgumentException e) {
      System.out.println("(AS4) Exception was caught for a step size less than or equal to zero.");
    }

    //(5) Non-capital letter
    try {
      String mirror5 = Palindrome.mirrorA('4', 3);
    } catch (IllegalArgumentException e) {
      System.out.println("(AS5) Exception was caught when the input was not a capital letter.");
    }

    return test;
  }

  /**
   * This method tests the Palindrome method MirrorZ().
   *
   * @return true if the method works, false otherwise.
   */
  public static boolean testMirrorZ() {
    boolean test = true;

    //(1) Normal Scenario
    String mirror1 = Palindrome.mirrorZ('V');

    if (!mirror1.equals("V W X Y Z Y X W V")) {
      System.out.println("(Z1) The method did not provide the right string, the method resulted in: " + mirror1);
      test = false;
    }

    //(2) 'Z' is the provided letter
    String mirror2 = Palindrome.mirrorZ('Z');

    if (!mirror2.equals("Z")) {
      System.out.println("(Z2) The method did not provide the right string, the method resulted in: " + mirror2);
      test = false;
    }

    //(3) Non-capital letter
    try {
      String mirror3 = Palindrome.mirrorZ('3');
    } catch (IllegalArgumentException e) {
      System.out.println("(Z3) Exception was caught when the input was not a capital letter.");
    }

    return test;
  }

  /**
   * This method tests the Palindrome method MirrorZ() with the step.
   *
   * @return true if the method works, false otherwise.
   */
  public static boolean testMirrorZStep() {
    boolean test = true;

    //(1) Normal scenario with 'Z' is the middle character.
    String mirror1 = Palindrome.mirrorZ('V', 2);

    if (!mirror1.equals("V X Z X V")) {
      System.out.println("(1) The method did not provide the right string, the method resulted in:" + mirror1);
      test = false;
    }

    //(2) Normal scenario with 'Z' not in the middle.
    String mirror2 = Palindrome.mirrorZ('V', 3);

    if (!mirror2.equals("V Y Y V")) {
      System.out.println("(2) The method did not provide the right string, the method resulted in:" + mirror2);
      test = false;
    }

    //(3) Input is 'Z'.
    String mirror3 = Palindrome.mirrorZ('Z', 3);

    if (!mirror3.equals("Z")) {
      System.out.println("(3) The method did not provide the right string, the method resulted in:" + mirror3);
      test = false;
    }

    //(4) Step size is less than zero
    try {
      String mirror4 = Palindrome.mirrorZ('A', -1);
    } catch (IllegalArgumentException e) {
      System.out.println("(ZS4) Exception was caught for a step size less than or equal to zero.");
    }

    //(5) Non-capital letter
    try {
      String mirror5 = Palindrome.mirrorZ('4', 3);
    } catch (IllegalArgumentException e) {
      System.out.println("(ZS5) Exception was caught when the input was not a capital letter.");
    }

    return test;
  }

  /**
   * Calls all the test methods.
   *
   * @return return true if and only if allmethods return true.
   */
  public static boolean runAllTests() {
    boolean test = true;
    if (!testMirrorA()) {
      test = false;
    }
    if (!testMirrorAStep()) {
      test = false;
    }
    if (!testMirrorZ()) {
      test = false;
    }
    if (!testMirrorZStep()) {
      test = false;
    }
    return test;
  }

  /**
   * Calls the runAllTests() method.
   *
   * @param Args unused
   */
  public static void main(String Args[]) {
    System.out.println("runAllTests(): " + runAllTests());
  }
}
