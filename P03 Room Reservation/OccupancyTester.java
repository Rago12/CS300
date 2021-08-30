//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Occupancy Tester
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
 * This class tests both the Room and Person classes.
 */
public class OccupancyTester {

  /**
   * This method tests the Person object. The methods in the Person class tested are:
   * getName(), toggleWaiting(), equals(Object o) and isWaiting().
   *
   * @return true if all the tests have passed, false otherwise.
   */
  public static boolean testPerson() {
    boolean test = true;

    Person person1 = new Person("Raj");
    Person person2 = new Person("Dave");

    //Tests the getName()
    if (!(person1.getName().equals("Raj"))) {
      System.out.println("The name of peron one should be Raj," +
              " but returns: " + person1.getName());
      test = false;
    }
    if (!(person2.getName().equals("Dave"))) {
      System.out.println("The name of peron one should be Dave," +
              " but returns: " + person2.getName());
      test = false;
    }

    //Tests the toggleWaiting()
    person1.toggleWaiting();
    person2.toggleWaiting();
    if (person1.isWaiting() == true) {
      System.out.println("Person 1 Waiting status did not change to false");
      test = false;
    }
    if (person2.isWaiting() == true) {
      System.out.println("Person 2 Waiting status did not change to false");
      test = false;
    }
    person1.toggleWaiting();
    person2.toggleWaiting();
    if (person1.isWaiting() == false) {
      System.out.println("Person 1 Waiting status did not change back to true");
      test = false;
    }
    if (person2.isWaiting() == false) {
      System.out.println("Person 2 Waiting status did not change back to true");
      test = false;
    }

    //Tests the objects equality
    if (person1.equals(person2)) {
      System.out.println("Person 1 should not equal person 2 as they have different names");
      test = false;
    }

    Person person3 = new Person("Ryan");
    Person person4 = new Person("Ryan");

    if (!(person3.equals(person4))) {
      System.out.println("Person 3 should equal person 4 as they have the same names");
      test = false;
    }

    return test;
  }

  /**
   * This method tests the construction of the Room object.
   *
   * @return true if all the tests have passed, false otherwise.
   */

  public static boolean testRoomConstructor() {
    boolean test = false;
    //When there are 2 different rooms there should be no issues.
    Room room1 = new Room("CS 1345", 100);
    Room room2 = new Room("Bio 235", 250);
    //When there are two similar rooms there should be an exception thrown.
    try {
      Room room3 = new Room("Chem 109", 300);
      Room room4 = new Room("Chem 109", 300);
    } catch (IllegalArgumentException e) {
      System.out.println("Exception was caught for rooms with the same name.");
      test = true;
    }
    //When the capacity is less than zero there should be an exception thrown.
    try {
      Room room5 = new Room("Math 234", 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Exception was caught for rooms with 0 capacity.");
      test = true;
    }
    return test;
  }

  /**
   * This method tests the accessors of the Room object.
   *
   * @return true if all the tests have passed, false otherwise.
   */
  public static boolean testRoomAccessors() {
    Room.clearRooms();
    boolean test = false;
    //Testing the getNames() method for content and order.
    Room room1 = new Room("CS 1345", 100);
    Room room2 = new Room("Bio 235", 3);
    String[] roomNames = Room.getNames();
    if (roomNames[0].equals("CS 1345") && roomNames[1].equals("Bio 235")) {
      test = true;
    } else {
      System.out.println("The order and/or the content was wrong in the array.");
      test = false;
    }

    //Testing getName() method to see if it returns the name
    if (!(room1.getName().equals("CS 1345"))) {
      System.out.println("Room 1 has a name that corresponds to CS 1345");
      test = false;
    }
    if (!(room2.getName().equals("Bio 235"))) {
      System.out.println("Room 2 has a name that corresponds to CS Bio 235");
      test = false;
    }

    //Testing getOccupancy() and should initially return 0 fro both rooms.
    if (!(room1.getOccupancy() == 0) && !(room2.getOccupancy() == 0)) {
      System.out.println("Room 1 and 2 should have 0 occupants");
      test = false;
    }

    //Testing getCOVIDCapacity() and should be half the capacity.
    if (!(room1.getCOVIDCapacity() == 50)) {
      System.out.println("Room 1 should have a COVID capacity of 50");
      test = false;
    }

    if (!(room2.getCOVIDCapacity() == 2)) {
      System.out.println("Room 2 should have a COVID capacity of 2");
      test = false;
    }

    //Testing getCapacity() and should be the capacity of the room.
    if (!(room1.getCapacity() == 100)) {
      System.out.println("Room 1 should have a capacity of 100");
      test = false;
    }
    if (!(room2.getCapacity() == 3)) {
      System.out.println("Room 2 should have a capacity of 3");
      test = false;
    }

    //Testing the contains method to see if a person is already in the Room.
    //(1) Person is in the room and should return true.
    Person person5 = new Person("Ethan");
    room1.checkIn(person5);
    if (!(room1.contains(person5))) {
      System.out.println("Room did contain Ethan but returned false");
      test = false;
    }
    //(2) Person is not in the room and should return false.
    if (room2.contains(person5)) {
      System.out.println("Does not contain Ethan and should not return");
      test = false;
    }

    return test;
  }

  /**
   * This method tests the checkIn() method from the Room Class.
   *
   * @return true if all the tests have passed, false otherwise.
   */
  public static boolean testRoomCheckIn() {
    Room.clearRooms();
    boolean test = true;
    Person people1 = new Person("Ryan");
    Person people2 = new Person("Max");
    Person people3 = new Person("Brendan");
    Person people5 = new Person("Sam");
    Person people4 = null;
    Room room1 = new Room("CS 1345", 5);
    Room room2 = new Room("Bio 235", 250);

    //(1)The passed in person is null and should return and illegal exception.
    try {
      room1.checkIn(people4);
    } catch (IllegalArgumentException e) {
      System.out.println("Exception was caught for a null person being passed in.");
    }

    //(2)The passed in person needs to be checked in
    if(room1.checkIn(people1) != true){
      System.out.println("Did not return true when the person was added.");
      test = false;
    }
    if (people1.isWaiting() != false) {
      System.out.println("isWaiting was not toggled properly");
      test = false;
    }
    if (room1.getOccupancy() != 1) {
      System.out.println("The current occupancy should be 1");
      test = false;
    }
    if (!(room1.contains(people1))) {
      System.out.println("The person was not found in the room");
      test = false;
    }

    //(3)The passed in person is already checked into this room
    try {
      room1.checkIn(people2);
      room1.checkIn(people2);
    } catch (IllegalArgumentException e) {
      System.out.println("Exception for checking in the same person into " +
              "the same room.");
    }

    //(4)The passed in person is in a different room
    try {
      room1.checkIn(people3);
      room2.checkIn(people3);
    } catch (IllegalArgumentException e) {
      System.out.println("Exception for checking in a " +
              "person who has already been checked in");
    }

    //(5)The room capacity is full and should return false when adding a person.
    if (room1.checkIn(people5) != false) {
      System.out.println("Should not have been able to check in person");
      test = false;
    }

    return test;
  }

  /**
   * This method tests the checkOut method from the Room class.
   *
   * @return true if all the tests have passed, false otherwise.
   */
  public static boolean testRoomCheckOut() {
    Room.clearRooms();
    Room.clearRooms();
    boolean test = true;
    Person person2 = new Person("Adam");
    Person person1 = null;
    Room room1 = new Room("CS 1345", 5);
    Room room2 = new Room("Bio 235", 250);
    room2.checkIn(person2);
    //(1)The passed in person is null and should return and illegal exception.
    try {
      room1.checkOut(person1);
    } catch (IllegalArgumentException e) {
      System.out.println("The passed in person was null");
    }
    //(2)The person is checked out from the room.
    room2.checkOut(person2);
    if (room2.getOccupancy() != 0) {
      System.out.println("The occupancy of the room should be back to zero");
      test = false;
    }
    if (room2.contains(person2)) {
      System.out.println("The person was not sucesfully removed from the room");
      test = false;
    }
    if (person2.isWaiting() != true) {
      System.out.println("The persons waiting status was not toggled properly");
      test = false;
    }
    //(3)The person is not in the room but is being checked out.
    if (room1.checkOut(person2) != false) {
      System.out.println("The person being checked out is not in the room" +
              " and should return false");
      test = false;
    }

    return test;
  }

  /**
   * This method tests the toString() method in the Room class.
   *
   * @return true if all the tests have passed, false otherwise.
   */
  public static boolean testRoomToString() {
    Room.clearRooms();
    Room room1 = new Room("CS 300", 6);
    Person person1 = new Person("Jake");
    Person person2 = new Person("Moon");
    Person person3 = new Person("Star");
    room1.checkIn(person1);
    room1.checkIn(person2);
    room1.checkIn(person3);

    String classInfo = "CS 300" +
            "\n===\n" +
            "Jake\n" +
            "-\n" +
            "Moon\n" +
            "-\n" +
            "Star\n" +
            "-\n";
    if (room1.toString().equals(classInfo)) {
      return true;
    } else {
      System.out.println("The contents in the room " +
              "was not converted properly into a string.");
      return false;
    }
  }

  /**
   * The main method is used to call all the tests and prints the results.
   *
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("testPerson(): " + testPerson());
    System.out.println("testRoomConstructor(): " + testRoomConstructor());
    System.out.println("testRoomAccessors(): " + testRoomAccessors());
    System.out.println("testRoomCheckIn(): " + testRoomCheckIn());
    System.out.println("testRoomCheckOut(): " + testRoomCheckOut());
    System.out.println("testRoomToString(): " + testRoomToString());


  }
}
