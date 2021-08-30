//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Order Priority Queue Tester
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

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * OrderPriorityQueue.
 * <p>
 * You MAY add additional public static boolean methods to this class if you like, and any private
 * static helper methods you need.
 */
public class OrderPriorityQueueTester {

  /**
   * Checks the correctness of the isEmpty method of OrderPriorityQueue.
   * <p>
   * You should, at least:
   * (1) create a new OrderPriorityQueue and verify that it is empty
   * (2) add a new Order to the queue and verify that it is NOT empty
   * (3) remove that Order from the queue and verify that it is empty again
   *
   * @return true if and only if ALL tests pass
   */
  public static boolean testIsEmpty() {
    Order.resetIDGenerator();

    //(1)
    OrderPriorityQueue orderQueue = new OrderPriorityQueue(5);
    if (!orderQueue.isEmpty()) {
      System.out.println("The method returned false when it should have returned true.");
      return false;
    }

    //(2)
    orderQueue.insert(new Order("Pasta", 20));
    if (orderQueue.isEmpty()) {
      System.out.println("The method returned true when it should have returned false.");
      return false;
    }

    //(3)
    orderQueue.removeBest();
    if (!orderQueue.isEmpty()) {
      System.out.println("The method returned false when it should have returned true");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * <p>
   * You should, at least:
   * (1) create a new OrderPriorityQueue and add a single order with a large prepTime to it
   * (2) use the OrderPriorityQueue toString method to verify that the queue's internal structure
   * is a valid heap
   * (3) add at least three more orders with DECREASING prepTimes to the queue and repeat step 2.
   *
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertBasic() {
    Order.resetIDGenerator();

    OrderPriorityQueue orderPriorityQueue = new OrderPriorityQueue(10);
    orderPriorityQueue.insert(new Order("Soup", 60));
    if (!orderPriorityQueue.toString().equals("1001(60)")) {
      System.out.println("The insert method did not add the order correctly.");
      return false;
    }

    orderPriorityQueue.insert(new Order("Pizza", 30));
    orderPriorityQueue.insert(new Order("Ice Cream", 10));
    if (!orderPriorityQueue.toString().equals("1001(60), 1002(30), 1003(10)")) {
      System.out.println("The insert method did not add the order correctly.");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * <p>
   * You should, at least:
   * (1) create an array of at least four Orders that represents a valid heap
   * (2) add a fifth order at the next available index that is NOT in a valid heap position
   * (3) pass this array to OrderPriorityQueue.percolateUp()
   * (4) verify that the resulting array is a valid heap
   *
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateUp() {
    Order.resetIDGenerator();

    Order[] orders = new Order[]{new Order("Steak", 90),
            new Order("Pizza", 60), new Order("Soup", 70),
            new Order("Pasta", 30), new Order("Fish", 65)};

    OrderPriorityQueue.percolateUp(orders, 4);

    if (orders[0].compareTo(new Order("Steak", 90)) != 0 ||
            orders[1].compareTo(new Order("Fish", 65)) != 0 ||
            orders[2].compareTo(new Order("Soup", 70)) != 0 ||
            orders[3].compareTo(new Order("Pasta", 30)) != 0 ||
            orders[4].compareTo(new Order("Pizza", 60)) != 0) {
      System.out.println("The percolateUp() method did not work correctly.");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * <p>
   * You should, at least:
   * (1) create a new OrderPriorityQueue with at least 6 orders of varying prepTimes, adding them
   * to the queue OUT of order
   * (2) use the OrderPriorityQueue toString method to verify that the queue's internal structure
   * is a valid heap
   *
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertAdvanced() {
    Order.resetIDGenerator();

    OrderPriorityQueue orderPriorityQueue = new OrderPriorityQueue(8);
    orderPriorityQueue.insert(new Order("Chicken", 30));
    orderPriorityQueue.insert(new Order("Pasta", 70));
    orderPriorityQueue.insert(new Order("Fish", 45));
    orderPriorityQueue.insert(new Order("Steak", 60));
    orderPriorityQueue.insert(new Order("Bread", 90));
    orderPriorityQueue.insert(new Order("Beans", 15));

    if (!orderPriorityQueue.toString().equals("1005(90), 1002(70), 1003(45), 1001(30), 1004(60), 1006(15)")) {
      System.out.println("The insert method was not properly adding the orders.");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * <p>
   * You should, at least:
   * (1) create an array of at least five Orders where the Order at index 0 is NOT in valid heap
   * position
   * (2) pass this array to OrderPriorityQueue.percolateDown()
   * (3) verify that the resulting array is a valid heap
   *
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateDown() {
    Order.resetIDGenerator();

    Order[] orders = new Order[]{new Order("Steak", 10),
            new Order("Pizza", 80), new Order("Soup", 70),
            new Order("Pasta", 30), new Order("Fish", 50)};

    OrderPriorityQueue.percolateDown(orders, 0, orders.length);

    if (orders[4].compareTo(new Order("Steak", 10)) != 0 ||
            orders[1].compareTo(new Order("Fish", 50)) != 0 ||
            orders[2].compareTo(new Order("Soup", 70)) != 0 ||
            orders[3].compareTo(new Order("Pasta", 30)) != 0 ||
            orders[0].compareTo(new Order("Pizza", 80)) != 0) {
      System.out.println("The percolateUp() method did not work correctly.");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the removeBest and peekBest methods of OrderPriorityQueue.
   * <p>
   * You should, at least:
   * (1) create a new OrderPriorityQueue with at least 6 orders of varying prepTimes, adding them
   * to the queue in whatever order you like
   * (2) remove all but one of the orders, verifying that each order has a SHORTER prepTime than
   * the previously-removed order
   * (3) peek to see that the only order left is the one with the SHORTEST prepTime
   * (4) check isEmpty to verify that the queue has NOT been emptied
   * (5) remove the last order and check isEmpty to verify that the queue HAS been emptied
   *
   * @return true if and only if ALL tests pass
   */
  public static boolean testPeekRemove() {
    try {
      Order.resetIDGenerator();

      OrderPriorityQueue orderPriorityQueue = new OrderPriorityQueue(8);
      orderPriorityQueue.insert(new Order("Chicken", 30));
      orderPriorityQueue.insert(new Order("Pasta", 70));
      orderPriorityQueue.insert(new Order("Fish", 45));
      orderPriorityQueue.insert(new Order("Steak", 60));
      orderPriorityQueue.insert(new Order("Bread", 90));
      Order order = new Order("Beans", 15);
      orderPriorityQueue.insert(order);

      if(orderPriorityQueue.removeBest().compareTo(orderPriorityQueue.peekBest()) < 0){
        System.out.println("The removeBest() method has something wrong as the the first order removed " +
                "should be greater.");
        return false;
      }

      if(orderPriorityQueue.removeBest().compareTo(orderPriorityQueue.peekBest()) < 0){
        System.out.println("The removeBest() method has something wrong as the the first order removed " +
                "should be greater.");
        return false;
      }

      if(orderPriorityQueue.removeBest().compareTo(orderPriorityQueue.peekBest()) < 0){
        System.out.println("The removeBest() method has something wrong as the the first order removed " +
                "should be greater.");
        return false;
      }

      if(orderPriorityQueue.removeBest().compareTo(orderPriorityQueue.peekBest()) < 0){
        System.out.println("The removeBest() method has something wrong as the the first order removed " +
                "should be greater.");
        return false;
      }

      if(orderPriorityQueue.removeBest().compareTo(orderPriorityQueue.peekBest()) < 0){
        System.out.println("The removeBest() method has something wrong as the the first order removed " +
                "should be greater.");
        return false;
      }

      if (orderPriorityQueue.peekBest().compareTo(order) != 0) {
        System.out.println("The peek method is not working correctly as it " +
                "returned to the wrong order.");
        return false;
      }

      if (orderPriorityQueue.isEmpty()) {
        System.out.println("There should be one item left and the method should return false");
        return false;
      }

      orderPriorityQueue.removeBest();

      if (!orderPriorityQueue.isEmpty()) {
        System.out.println("The queue is empty and the method should return true");
        return false;
      }
      
    } catch (Exception e){
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the removeBest and peekBest methods, as well as the constructor of
   * the OrderPriorityQueue class for erroneous inputs and/or states
   * <p>
   * You should, at least:
   * (1) create a new OrderPriorityQueue with an invalid capacity argument, and verify that the
   * correct exception is thrown
   * (2) call peekBest() on an OrderPriorityQueue with an invalid state for peeking, and verify that
   * the correct exception is thrown
   * (3) call removeBest() on an OrderPriorityQueue with an invalid state for removing, and verify
   * that the correct exception is thrown
   *
   * @return true if and only if ALL tests pass
   */
  public static boolean testErrors() {
    try {
      Order.resetIDGenerator();

      try {
        OrderPriorityQueue orderPriorityQueue = new OrderPriorityQueue(-1);
      } catch (IllegalArgumentException e) {
        System.out.println("Exception was caught for creating a queue with invalid argument.");
      }

      try {
        OrderPriorityQueue orderPriorityQueue = new OrderPriorityQueue(10);
        orderPriorityQueue.peekBest();
      } catch (NoSuchElementException e) {
        System.out.println("The Exception for peekBest was caught.");
      }


      try {
        OrderPriorityQueue orderPriorityQueue = new OrderPriorityQueue(10);
        orderPriorityQueue.removeBest();
      } catch (NoSuchElementException e) {
        System.out.println("The Exception for removeBest was caught.");
      }
    } catch (Exception e){
      return false;
    }

    return true;
  }

  /**
   * Calls the test methods individually and displays their output
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("isEmpty: " + testIsEmpty());
    System.out.println("insert basic: " + testInsertBasic());
    System.out.println("percolate UP: " + testPercolateUp());
    System.out.println("insert advanced: " + testInsertAdvanced());
    System.out.println("percolate DOWN: " + testPercolateDown());
    System.out.println("peek/remove valid: " + testPeekRemove());
    System.out.println("error: " + testErrors());
  }

}
