//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Order Iterator
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

public class OrderIterator implements Iterator<Order> {

  private LinkedOrder current; //The LinkedOrder that it's currently using.

  /**
   * Initializes current to the provided starting LinkedOrder
   *
   * @param start the provided starting LinkedOrder.
   */
  public OrderIterator(LinkedOrder start){
    current = start;
  }

  /**
   * Checks if iteration has more orders
   *
   * @return true if and only if the iteration has more orders
   */
  public boolean hasNext(){
    if (current != null){
      return true;
    }
    return false;
  }

  /**
   * Finds the next order and updates the current field appropriately.
   *
   * @return the next order.
   * @throws NoSuchElementException the iteration does not have more orders to return.
   */
  public Order next() throws NoSuchElementException{
    if(!hasNext()){
      throw new NoSuchElementException("There are no more orders!");
    }
    LinkedOrder previous = current;
    current = current.getNext();

    return previous.getOrder();
  }
}
