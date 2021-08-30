//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Room
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

import java.util.ArrayList;

/**
 * This class is responsible for creating the Room object,
 * which interacts with the Person object.
 */

public class Room {
  private static ArrayList<String> names = new ArrayList<>(); //A list of all the room names
  private String name; // The name of a room.
  private Person[] occupants; // An array of the people in a room.
  private int currentOccupancy; //The number of current occupants.

  /**
   * This method converts the list of room names as an Array of Strings.
   *
   * @return An array of Strings representing the current room names.
   */
  public static String[] getNames() {
    String[] roomNames = new String[names.size()];
    for (int i = 0; i < names.size(); i++) {
      roomNames[i] = names.get(i);
    }
    return roomNames;
  }

  /**
   * This method initializes the instance variables and adds the name of the
   * room to the list of all room names. It takes into account if the capacity is
   * less than or equal to zero, and if the name is already in the Arraylist.
   *
   * @param name     The name of the room.
   * @param capacity The amount of people the room can hold (NonCovid).
   */

  public Room(String name, int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity is less than or equal to 0!");
    }

    for (int i = 0; i < names.size(); i++) {
      if ((name).equals(names.get(i))) {
        throw new IllegalArgumentException("This name already exists");
      }
    }

    this.name = name;
    occupants = new Person[capacity];
    currentOccupancy = 0;

    names.add(name);
  }

  /**
   * This method gets the name of the room.
   *
   * @return The name of the room.
   */

  public String getName() {
    return this.name;
  }

  /**
   * This method gets the current number of people.
   *
   * @return The current number of people in the room.
   */
  public int getOccupancy() {
    return currentOccupancy;
  }

  /**
   * This method finds the number of people allowed in
   * a room under COVID protocol which is half the capacity.
   *
   * @return The number of people allowed under COVID protocol.
   */
  public int getCOVIDCapacity() {
    int covidCapacity;
    if (occupants.length % 2 == 0) {
      covidCapacity = (occupants.length) / 2;
      return covidCapacity;
    } else {
      covidCapacity = (occupants.length) / 2;
      return covidCapacity + 1;
    }
  }

  /**
   * This method gets the capacity of the room under non-COVID protocol.
   *
   * @return The number of people allowed under non-COVID protocol.
   */
  public int getCapacity() {
    int normCapacity;
    normCapacity = occupants.length;
    return normCapacity;
  }

  /**
   * This method checks whether a person is in the occupants of a specific room,
   *
   * @param p The person that is trying to be found.
   * @return true if the person is in the room, false otherwise.
   */
  public boolean contains(Person p) {
    for (int i = 0; i < occupants.length; i++) {
      if (p.equals(occupants[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method checks in a person into a room, by putting the
   * person into the occupants array for the room. It takes into account
   * if the person is already in the room or any other room. It also looks
   * at if the person passed in was null and if the room is full(COVID capacity).
   * Additionally, it updates the occupancy of the room and toggles the
   * waiting state for the person.
   *
   * @param in The person being checked in.
   * @return true if and only if the provided Person was
   *         successfully added to the room.
   */
  public boolean checkIn(Person in) {
    if (in == null) {
      throw new IllegalArgumentException("Person was null");
    }

    if (in.isWaiting() == false) {
      throw new IllegalArgumentException("Person is already in the room");
    }

    if (currentOccupancy == getCOVIDCapacity()) {
      return false;
    }

    for (int i = 0; i < occupants.length; i++) {
      if (i % 2 == 0 && occupants[i] == null) {
        occupants[i] = in;
        in.toggleWaiting();
        currentOccupancy++;
        return true;
      }
    }
    return false;
  }

  /**
   * This method checks out the person from the room by removing
   * the person from the array and setting that index to zero. It also looks
   * at if the person passed in is null and if the person is in the room.
   *
   * @param out The person being checked out.
   * @return true if and only if the provided Person was successfully
   * removed from the Room.
   */
  public boolean checkOut(Person out) {
    if (out == null) {
      throw new IllegalArgumentException("Person passed in was null.");
    }

    if (!contains(out)) {
      return false;
    }

    for (int i = 0; i < occupants.length; i++) {
      if (out.equals(occupants[i])) {
        out.toggleWaiting();
        currentOccupancy--;
        occupants[i] = null;
        return true;
      }
    }
    return false;
  }

  /**
   * This method creates String of the people in the room.
   *
   * @return String representation of this Room and its occupants.
   */
  public String toString() {
    String classInfo;

    classInfo = name + "\n===\n";
    for (int i = 0; i < occupants.length; i++) {
      if (occupants[i] == null) {
        classInfo += "-";
        classInfo += "\n";
      } else {
        classInfo += occupants[i].getName();
        classInfo += "\n";
      }
    }

    return classInfo;
  }

  /**
   * Clears the names in the Arraylist, is used to reset.
   */
  public static void clearRooms() {
    names.clear();
  }

}
