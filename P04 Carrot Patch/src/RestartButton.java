//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Restart Button
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

/**
 * This class creates a button for restarting a game.
 */
public class RestartButton extends Button{
  /**
   * Places the restart button int he specific coordinates.
   *
   * @param x x-position of button
   * @param y y-position of button
   */
  public RestartButton(float x, float y) {
    super("Restart", x, y);
  }

  /**
   * This method removes all the characters form the screen to start over.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      Button.processing.removeAll();

    }

  }
}
