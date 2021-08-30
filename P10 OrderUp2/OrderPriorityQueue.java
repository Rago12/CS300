//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Order Priority Queue
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
 * A max-heap implementation of a priority queue for Orders, where the Order with the LONGEST prep 
 * time is returned first instead of the strict first-in-first-out queue as in P08.
 *
 * PriorityQueueADT without error!
 */
public class OrderPriorityQueue implements PriorityQueueADT<Order>{

  // Data fields; do not modify
  private Order[] queueHeap;
  private int size;
  
  /**
   * Constructs a PriorityQueue for Orders with the given capacity
   * 
   * @param capacity the initial capacity for the queue
   * @throws IllegalArgumentException if the given capacity is 0 or negative
   */
  public OrderPriorityQueue(int capacity) {
    if(capacity <= 0){
      throw new IllegalArgumentException("The capacity was less than or equal to zero.");
    }
    queueHeap = new Order[capacity];
    size = 0;
  }
  
  /**
   * Inserts a new Order into the queue in the appropriate position using a heap's add logic.
   * 
   * @param newOrder the Order to be added to the queue
   */
  @Override
  public void insert(Order newOrder) {
    if(isEmpty()){
      queueHeap[0] = newOrder;
    }
    if(queueHeap.length == size){
      queueHeap = Arrays.copyOf(queueHeap, size*2);
    }
    queueHeap[size] = newOrder;
    percolateUp(queueHeap, size);
    size++;
  }
  
  /**
   * A utility method to percolate Order values UP through the heap; see figure 13.3.1 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated up
   */
  protected static void percolateUp(Order[] heap, int orderIndex) {
    int parentIndex;
    Order temp;

    while (orderIndex > 0){
      parentIndex = (orderIndex - 1) / 2;
      if(heap[orderIndex].compareTo(heap[parentIndex]) == -1){
        return;
      } else{
        temp = heap[orderIndex];
        heap[orderIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
        orderIndex = parentIndex;
      }
    }
  }
  
  /**
   * Return the Order with the longest prep time from the queue and adjust the queue accordingly
   * 
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order removeBest() {
    if(isEmpty()){
      throw new NoSuchElementException("The queue is empty!");
    }

    Order remove = queueHeap[0];
    queueHeap[0] = queueHeap[size - 1];
    percolateDown(queueHeap, 0, size);
    queueHeap[size - 1] = null;
    size--;
    return remove;
  }
  
  /**
   * A utility method to percolate Order values DOWN through the heap; see figure 13.3.2 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated down
   * @param size the number of initialized elements in the heap
   */
  protected static void percolateDown(Order[] heap, int orderIndex, int size) {
    int childIndex = 2 * orderIndex + 1;
    Order order = heap[orderIndex];

    while (childIndex < size){
      Order maxOrder = order;
      int maxIndex = -1;
      for (int i = 0; i < 2 && i + childIndex < size; i++){
        if (heap[i + childIndex].compareTo(maxOrder) > 0){
          maxOrder = heap[i + childIndex];
          maxIndex = i + childIndex;
        }
      }
      if(maxOrder == order){
        return;
      } else{
        Order temp = heap[orderIndex];
        heap[orderIndex] = heap[maxIndex];
        heap[maxIndex] = temp;
        orderIndex = maxIndex;
        childIndex = 2 * orderIndex + 1;
      }
    }
  }
  
  /**
   * Return the Order with the highest prep time from the queue without altering the queue
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order peekBest() {
    if(isEmpty()){
      throw new NoSuchElementException("The queue is empty.");
    }

    return queueHeap[0];
  }
  
  /**
   * Returns true if the queue contains no Orders, false otherwise
   * @return true if the queue contains no Orders, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if(size == 0){
      return true;
    }
    return false;
  }
  
  /**
   * Returns the number of elements currently in the queue
   * @return the number of elements currently in the queue
   */
  public int size() {
    return size;
  }
  
  /**
   * Creates a String representation of this PriorityQueue. Do not modify this implementation; this
   * is the version that will be used by all provided OrderPriorityQueue implementations that your
   * tester code will be run against.
   * 
   * @return the String representation of this PriorityQueue, primarily for testing purposes
   */
  public String toString() {
    String toReturn = "";
    for (int i=0; i < this.size; i++) {
      toReturn += queueHeap[i].getID()+"("+queueHeap[i].getPrepTime()+")";
      if (i < this.size-1) toReturn += ", ";
    }
    return toReturn;
  }
  
}
