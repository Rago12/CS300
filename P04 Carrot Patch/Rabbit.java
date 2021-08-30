//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Rabbit
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

/**
 * Creates the rabbit object and implements its behavior.
 */
public class Rabbit extends Animal {
  private static final String RABBIT = "images" + File.separator + "rabbit.png";
  private static final String TYPE = "R"; // A String that represents the rabbit type
  private static int hopStep = 70; // one hop step
  private static int scanRange = 175; // scan range to watch out for threats
  private static int nextID = 1; // class variable that represents the identifier
  // of the next rabbit to be created
  private final int ID; // positive number that represents the order of this rabbit

  /**
   * Creates a new rabbit object located at a random position of the display window
   */
  public Rabbit() {
    // Set rabbit drawing parameters
    super(RABBIT);
    // Set rabbit identification fields
    ID = nextID;
    this.label = TYPE + ID; // String that identifies the current rabbit
    nextID++;
  }

  /**
   * Getter of Rabbit.scanRange static field
   *
   * @return
   */
  public static int getScanRange() {
    return scanRange;
  }

  /**
   * Getter of Rabbit.hopStep static field
   *
   * @return
   */
  public static int getHopStep() {
    return hopStep;
  }

  /**
   * Gets the first carrot in the patch. If the carrot is in the Rabbit
   * hopStep range, the rabbit eats it. It sets its position to the (x,y)
   * position of the carrot and the carrot will be removed from the Carrot Patch.
   * Otherwise, the rabbit moves one hopStep towards that carrot. If no carrot
   * found (meaning Carrots.getFirstCarrot() returns false),
   * the rabbit does nothing.
   */
  public void hopTowardsCarrot() {
    // get the first carrot
    int[] carrot = Carrots.getFirstCarrot();
    if (carrot != null) {
      if (isClose(carrot[1], carrot[2], getHopStep())) {
        setX(carrot[1]);
        setY(carrot[2]);
        Carrots.remove(carrot[0]);
      } else {
        int newX;
        int newY;
        int dx = carrot[1] - getX();
        int dy = carrot[2] - getY();
        int d = (int) Math.sqrt((dx) * (dx) + (dy) * (dy));
        newX = getX() + (hopStep * (carrot[1] - getX()))/d;
        newY = getY() + (hopStep * (carrot[2] - getY()))/d;
        setY(newY);
        setX(newX);
      }
    }
  }

  @Override
  public void mousePressed() {
    super.mousePressed();
    hopTowardsCarrot();
  }

  /**
   * This method watches out for wolves. Checks if there is a wolf
   * in the Rabbit.scanRange of this Rabbit.
   *
   * @return true if the current rabbit is close to at least one wolf
   */
  public boolean watchOutForWolf() {
    for (int i = 0; i < processing.objects.size(); i++) {
      if (processing.objects.get(i) instanceof  Wolf) {
        if (isClose((Animal) processing.objects.get(i), Rabbit.getScanRange())) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Watches out for a wolf and display a Warning message "WOLF!"
   * if there is any wolf in its neighborhood.
   */
  @Override
  public void action() {
    if (watchOutForWolf()) {
      // this.setScaredImage();
      processing.fill(0); // specify font color: black
      processing.text("WOLF!", this.getX(), this.getY() - this.image.height / 2 - 6);
    } }


}
