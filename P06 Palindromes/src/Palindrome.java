//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Palindrome
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
 * This class is responsible for housing the code to create palindromes.
 */
public class Palindrome {
  /**
   * This method recursively create a simple alphabet pattern, starting at the provided character, moving
   * backward to the beginning of the alphabet, and then forward again to the provided
   * letter, separating each letter with a space.
   *
   * @param start the provided character to start from.
   * @return a string mirrored at 'A' from the given character.
   * @throws IllegalArgumentException when the argument is not a capital letter.
   */
  public static String mirrorA(char start) throws IllegalArgumentException {
    if (!(start >= 'A' && start <= 'Z')) {
      throw new IllegalArgumentException("Character was not a capital letter");
    }
    String mirror = "";
    if (start == 'A') {
      mirror = "A";
    } else {
      mirror = start + " " + mirrorA((char) (start - 1)) + " " + start;
    }
    return mirror;
  }

  /**
   * This method recursively create an alphabet pattern, starting at the provided character, and moving
   * back and forth to the beginning of the alphabet by steps of size step.
   *
   * @param start the provided character to start from.
   * @param step  the size of the step taken to reach the beginning of the alphabet.
   * @return a string mirrored at 'A' from the given character and given step size.
   * @throws IllegalArgumentException when the argument is not a capital letter
   *                                  or the step size is less than or equal to 0
   */
  public static String mirrorA(char start, int step) throws IllegalArgumentException {
    if (!Character.isUpperCase(start) || !(step > 0)) {
      throw new IllegalArgumentException("Character was not a capital letter and/or " +
              "step was less than or equal to zero");
    }

    String mirror = "";
    if (start == 'A') {
      mirror = mirror + "A";
    } else if (start - step < 'A') {
      mirror = start + " " + mirror + " " + start;
    } else {
      mirror = start + " " + mirrorA((char) (start - step), step) + " " + start;
      mirror = mirror.replace("  ", " ");
    }
    return mirror;
  }

  /**
   * This method recursively create a simple alphabet pattern, starting the provided character, and
   * moving forward to the end of the alphabet, and then backward again to the provided
   * letter, separating each letter with a space.
   *
   * @param start the provided character to start from.
   * @return a string mirrored at 'Z' from the given character.
   * @throws IllegalArgumentException
   */
  public static String mirrorZ(char start) throws IllegalArgumentException {
    if (!(start >= 'A' && start <= 'Z')) {
      throw new IllegalArgumentException("Character was not a capital letter");
    }
    String mirror = "";
    if (start == 'Z') {
      mirror = "Z";
    } else {
      mirror = start + " " + mirrorZ((char) (start + 1)) + " " + start;
    }

    return mirror;
  }

  /**
   * This method recursively create an alphabet pattern, starting at the provided character, and moving
   * back and forth to the end of the alphabet by steps of size step.
   *
   * @param start the provided character to start from.
   * @param step  the size of the step taken to reach the end of the alphabet.
   * @return a string mirrored at 'Z' from the given character and given step size.
   * @throws IllegalArgumentException when the argument is not a capital letter
   *                                  or the step size is less than or equal to 0
   */
  public static String mirrorZ(char start, int step) throws IllegalArgumentException {
    if (!Character.isUpperCase(start) || !(step > 0)) {
      throw new IllegalArgumentException("Character was not a capital letter and/or " +
              "the step was less than or equal to zero");
    }
    String mirror = "";
    if (start == 'Z') {
      mirror = "Z";
    } else if (start + step > 'Z') {
      mirror = start + " " + mirror + " " + start;
    } else {
      mirror = start + " " + mirrorZ((char) (start + step), step) + " " + start;
      mirror = mirror.replace("  ", " ");
    }
    return mirror;
  }

}
