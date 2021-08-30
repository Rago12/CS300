//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Add Wolf Button
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
 * This class creates and adds the AddWolf button.
 *
 */
public class AddWolfButton extends Button{
  /**
   * Adds the Button in the specific location on the screen.
   *
   * @param x x-position of button
   * @param y y-position of button
   */
  public AddWolfButton(float x, float y) {
    super("Add Wolf", x, y);
  }


  /**
   * Implements the default behavior of this button when the mouse is pressed.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      Button.processing.objects.add(new Wolf());
    }

  }
}