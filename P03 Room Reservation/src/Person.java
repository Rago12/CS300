//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Person
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
 * This class allows the user to create a Person object that interacts with Rooms.
 */
public class Person {
  private String name; //The name of the person.
  private boolean isWaiting; //A boolean for if the person is waiting for a room.

  /**
   * This method initializes the instance variables.
   *
   * @param name The name of the person.
   */
  public Person(String name) {
    this.name = name;
    isWaiting = true;
  }

  /**
   * This method gets the name of the Person object.
   *
   * @return The name of the person.
   */
  public String getName() {
    return name;
  }

  /**
   * This method gets the waiting status of the Person object.
   *
   * @return The waiting status.
   */
  public boolean isWaiting() {
    return isWaiting;
  }

  /**
   * This method Sets isWaiting to true if it is currently false,
   * and to false if it is currently true.
   */
  public void toggleWaiting() {
    if (isWaiting == true) {
      isWaiting = false;
    } else if (isWaiting == false) {
      isWaiting = true;
    }
  }

  /**
   * This method compares the names of the object and then returns true if
   * the names are the same and false if they are not.
   *
   * @param o The object that is compared to the Person.
   * @return true if the objects names are the same, false otherwise.
   */
  public boolean equals(Object o) {
    if (o instanceof Person) {
      return this.name.equals(((Person) o).name);
    }
    return false;
  }
}
