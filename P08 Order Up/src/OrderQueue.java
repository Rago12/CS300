//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Order Queue
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class houses the codes for the OrderQueue object and implements QueueADT
 */
public class OrderQueue implements QueueADT<Order>, Iterable<Order> {
  private LinkedOrder front; //A reference to the LinkedOrder at the front of the queue
  private LinkedOrder back; //A reference to the LinkedOrder ar the back of the queue
  private int size; //An integer variable tracking the number of Orders currently in the queue

  /**
   * Creates and returns a new OrderIterator beginning with the current value to front
   * @return a new Order iterator beginning with the current value to front.
   */
  @Override
  public Iterator<Order> iterator(){
    return new OrderIterator(front);
  }

  /**
   * Adds a new LinkedOrder containing newElement to the back of the queue, updating the
   * size variable and front/back references appropriately.
   */
  @Override
  public void enqueue(Order newElement){
    LinkedOrder newItem = new LinkedOrder(newElement);
    if(isEmpty()){
      front = newItem;
      back = newItem;
      size++;
    } else {
      back.setNext(newItem);
      back = newItem;
      back.setNext(null);
      size++;
    }
  }

  /**
   * Removes the next LinkedOrder from the front of the queue and returns its Order
   * updating the size variable and front/back references appropriately.
   *
   * @return the order held by the LinkedOrder
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order dequeue() throws NoSuchElementException {
    if(isEmpty()){
      throw new NoSuchElementException("The queue is empty!");
    }
    LinkedOrder order = front;
    if (size == 1){
      front = null;
      back = null;
      size--;
    } else {
      front = front.getNext();
      size--;
    }
    return order.getOrder();
  }


  /**
   * Returns the Order from the LinkedOrder at the front of the queue without
   * removing the LinkedOrder from the queue.
   *
   * @return the order from the LinkedOrder at the front of the queue.
   * @throws NoSuchElementException is the queue is empty.
   */
  @Override
  public Order peek() throws NoSuchElementException {
    if(isEmpty()){
      throw new NoSuchElementException("The queue is empty!");
    }
    return front.getOrder();
  }

  /**
   * Checks if the queue is empty.
   *
   * @return true if adn only of the queue is empty.
   */
  @Override
  public boolean isEmpty() {
    if(front == null){
      return true;
    }else {
      return false;
    }
  }

  /**
   * Creates and returns a String representation of this OrderQueue
   * using an enhanced-for loop. For example, a queue with three Orders
   * might look like this:
   *   1001: fries (2) -> 1002: shake (1) -> 1003: burger(3) -> END
   *
   * @return A String representation of the queue
   */
  @Override
  public String toString(){
    if (this.size == 0) return "";
    String qString="";
    for (Order o : this){
      qString += o.toString();
      qString += " -> ";
    }
    qString += "END";
    return qString;
  }

}
