//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Order Queue Tester
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

import java.util.NoSuchElementException;

/**
 * This class tests the entirety of the program.
 */
public class OrderQueueTester {

  /**
   * Tests the orderIterator class.
   *
   * @return true if the class works properly, false otherwise.
   */
  public static boolean orderIteratorTests() {
    try {
      //Chain of linked orders
      LinkedOrder item1 = new LinkedOrder(new Order("Pasta", 45));
      LinkedOrder item2 = new LinkedOrder(new Order("Salad", 20));
      LinkedOrder item3 = new LinkedOrder(new Order("Avocado Toast", 25));
      item1.setNext(item2);
      item2.setNext(item3);

      //Creating an OrderIterator
      OrderIterator iterator = new OrderIterator(item1);

      //Checking the hasNext() method
      if (!iterator.hasNext()) {
        System.out.println("The hasNext() method in the OrderIterator class did not return true, " +
                "it returned: " + iterator.hasNext());
        return false;
      }

      //Checking the next() method
      Order store = iterator.next();
      if (!store.getDishName().equals("Pasta")) {
        System.out.println("The next method in the OrderIterator class did not equal Pasta, " +
                "it returned: " + store.getDishName());
        return false;
      }

      //Checking if the exception is thrown.
      iterator.next();
      iterator.next();
      try {
        iterator.next();
      } catch (NoSuchElementException e) {
        System.out.println("The exception was caught successfully for OrderIterator.next().");
      }

    } catch (Exception e) {
      return false;
      }
    return true;
  }


    /**
     * Tests the code in the enqueue method.
     *
     * @return true if the method works, false other wise.
     */
    public static boolean enqueueTests () {
      try {
        //Adding a new item to an empty list.
        OrderQueue list = new OrderQueue();
        Order order = new Order("Pizza", 10);
        list.enqueue(order);
        if (!list.peek().getDishName().equals("Pizza")) {
          System.out.println("When the new order was added to the empty list the " +
                  "first order was not Pizza it was, : " + list.peek().getDishName());
          return false;
        }


        //Adding a new item to a list.
        list.enqueue(new Order("Soup", 15));
        OrderIterator iterator = (OrderIterator) list.iterator();
        iterator.next();
        Order store = iterator.next();
        if (!store.getDishName().equals("Soup")) {
          System.out.println("The method did not add the order correctly to the end," +
                  "it added: " + store.getDishName());
          return false;
        }
      } catch (Exception e) {
        return false;
      }
      return true;
    }

    /**
     * Tests the code in the dequeue method.
     *
     * @return true if the method works, false otherwise.
     */
    public static boolean dequeueTests () {
      try {
        OrderQueue queue1 = new OrderQueue();
        queue1.enqueue(new Order("Sandwich", 12));
        queue1.enqueue(new Order("Bowl", 5));

        //Removing from a queue
        Order removeOrder = queue1.dequeue();
        if (!removeOrder.getDishName().equals("Sandwich")) {
          System.out.println("The method did not remove the order correctly, it removed: " +
                  removeOrder);
          return false;
        }
        //Removing  from a queue with 1
        removeOrder = queue1.dequeue();
        if (!removeOrder.getDishName().equals("Bowl") && !queue1.isEmpty()) {
          System.out.println("The method did not remove the order correctly, it removed: " +
                  removeOrder + " and/or the size was not updated properly");
          return false;
        }

        //Removing from an empty
        try {
          queue1.dequeue();
        } catch (NoSuchElementException e) {
          System.out.println("The exception was caught successfully for dequeue().");
        }
      } catch (Exception e) {
        return false;
      }
       return true;
    }

    /**
     * Tests the code for the peek() method.
     *
     * @return true if the peek method works, false otherwise.
     */
    public static boolean peekTests () {
      try {
        OrderQueue queue = new OrderQueue();
        queue.enqueue(new Order("Pasta", 45));
        //Checking to see if the peek method works.
        if (!queue.peek().getDishName().equals("Pasta")) {
          System.out.println("The peek method did not correctly get Pasta, it got: "
                  + queue.peek());
          return false;
        }

        queue.dequeue();
        //Checking to if the exception is thrown in an empty queue
        try {
          queue.peek();
        } catch (Exception e) {
          System.out.println("The exception was caught successfully for peek().");
        }
      } catch (Exception e) {
        return false;
      }
      return true;
    }

    /**
     * This method calls all the tests.
     *
     * @return true if and only if all test methods succeed; false otherwise.
     */
    public static boolean runAllTests () {
      boolean test = true;
      if (!orderIteratorTests()) {
        System.out.println("orderIteratorTests(): " + orderIteratorTests());
        test = false;
      }
      if (!enqueueTests()) {
        System.out.println("enqueueTests(): " + enqueueTests());
        test = false;
      }
      if (!dequeueTests()) {
        System.out.println("dequeueTests(): " + dequeueTests());
        test = false;
      }
      if (!peekTests()) {
        System.out.println("peekTests(): " + peekTests());
        test = false;
      }

      return test;
    }

    /**
     * Calls your runAllTests() method.
     *
     * @param args unused
     */
    public static void main (String[]args){
      System.out.println("runAllTests(): " + runAllTests());
    }
  }
