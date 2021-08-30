///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:            Self Checkout Kiosk
// Course:           CS 300, Spring 2021
//
// Authors:          Rago Senthilkumar
// Email:            rsenthilkuma@wisc.edu
// Lecturer's Name:  Hobbes LeGault
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Hobbes LeGault; Provided instructions that helps construct this program.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

public class SelfCheckoutKiosk {
  public static final double TAX_RATE = 0.05; // sales tax
  public static final String[][] GROCERY_ITEMS = new String[][]{{"Apple", "$1.59"},
          {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
          {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
          {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
          {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
          {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
          {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

  /**
   * This method determines the name of the grocery item given the unique identifier.
   *
   * @param index the unique identifier of a grocery item.
   * @return A string containing the name of the grocery item.
   */
  public static String getItemName(int index) {
    String itemName;
    itemName = GROCERY_ITEMS[index][0];
    return itemName;
  }

  /**
   * Determines the price of the grocery item given the unique identifier.
   *
   * @param index the unique identifier of a grocery item
   * @return A double value containing the price of a grocery item.
   */
  public static double getItemPrice(int index) {
    double itemPrice;
    itemPrice = Double.valueOf(SelfCheckoutKiosk.GROCERY_ITEMS[index][1].substring(1).trim());
    return itemPrice;
  }

  /**
   * Prints the Catalog of the grocery store (item identifiers, names, and prices)
   */
  public static void printCatalog() {
    // Complete the missing code /* */ in the following implementation
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Item id \tName \t Price");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    for (int i = 0; i < GROCERY_ITEMS.length; i++) {
      System.out.println(i + "\t\t" + GROCERY_ITEMS[i][0] +
              " \t " + GROCERY_ITEMS[i][1]);
    }
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
  }

  /**
   * Adds the name of a grocery item given its identifier at (the end of the bagging)
   * the oversize array defined by the items array and its size if the items array reaches its capacity,
   * "Error! No additional items cn be scanned. Please wait for assistance." The contents int the array
   * will remain the same.
   *
   * @param id    identifier if the items to be added to the bagging area
   * @param items array storing the names of the items checked out and
   *              placed in the bagging area
   * @param size  number of elements stored in items before trying to add
   *              a new item
   * @return The number of elements stored in bagging area after the
   * item with the provided identifier was added to the bagging area
   */
  public static int addItemToBaggingArea(int id, String[] items, int size) {
    if (size == items.length) {
      System.out.println("Error! No additional items can be scanned. Please wait for assistance.");
    } else {
      items[size] = GROCERY_ITEMS[id][0];
      size++;
    }
    return size;
  }

  /**
   * Returns the number of occurrences of a given item in an oversize array of
   * strings. The comparison to find the occurrences of item is case insensitive.
   *
   * @param item  item to count its occurrences
   * @param items a bag of string items
   * @param size  number of items stored in items
   * @return the number of occurrences of a given item in an oversize array of strings
   */
  public static int count(String item, String[] items, int size) {
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (items[i].equals(item)) {
        count = count + 1;
      }
    }
    return count;
  }

  /**
   * Finds the index of the first occurrence of item in items if found,
   * else returns -1 if the item is not found
   *
   * @param item  element to search for
   * @param items an array of string elements
   * @param size  number of elements stored in items
   * @return the index of the first occurrence of item in items if found,
   * and -1 if the item not found
   */
  public static int indexOf(String item, String[] items, int size) {
    int index = 0;
    for (int i = 0; i < size; i++) {
      if (items[i].equals(item)) {
        index = i;
        return index;
      }
    }
    return -1;
  }

  /**
   * Removes the first occurrence of itemToRemove from the bagging area
   * defined by the array items and its size. If no match with itemToRemove is found,
   * the method displays the following error message "WARNING: item not found." without
   * making any change to the items array. This method compacts the contents of the items
   * array after removing the itemToRemove so there are no empty spaces in the middle of
   * the array.
   *
   * @param itemToRemove item to remove from the bagging area
   * @param items        a bag of items
   * @param size         number of elements stored in the bag of items
   * @return the number of items present in the cart after the
   * itemToRemove is removed from the cart
   */
  public static int remove(String itemToRemove, String[] items, int size) {
    boolean itemNotFound = true;
    if (size == 0) {
      System.out.println("WARNING: item not found.");
      itemNotFound = false;
    } else {
      for (int i = 0; i < size; i++) {
        if (items[i].equals(itemToRemove)) {
          items[i] = items[size - 1];
          items[size - 1] = null;
          size = size - 1;
          itemNotFound = false;
          break;
        }
      }
      if (itemNotFound) {
        System.out.println("WARNING: item not found.");
      }
    }
    return size;
  }

  /**
   * Gets a copy of the items array without duplicates. Adds every unique item
   * stored within the items array to the itemsSet array.The itemsSet array is
   * initially empty. Recall that a set is a collection which does not contain
   * duplicate items).
   * On the other hand, this method does not make any change to the contents
   * of the items array.
   *
   * @param items    list of items added to the bagging area
   * @param size     number of elements stored in items
   * @param itemsSet reference to an empty array which is going to contain the set
   *                 of items checked out (it does not contain duplicates)
   * @return the number of elements in items without accounting duplicates.
   * In other words, this method returns the new size of the itemsSet array
   */
  public static int getUniqueCheckedOutItems(String[] items, int size, String[] itemsSet) {
    int newSize = 0;
    for (int i = 0; i < size; i++) {
      if (indexOf(items[i], itemsSet, newSize) == -1) {
        itemsSet[newSize] = items[i];
        newSize++;
      }
    }
    return newSize;
  }

  /**
   * This method calculates the total value of the scanned items
   * at checkout without tax in dollars
   *
   * @param items an array which stores the items checked out
   * @param size  number of elements stored in the items array
   * @return the total value (price) of the scanned items at checkout
   * without tax in $ (double)
   */
  public static double getSubTotalPrice(String[] items, int size) {
    double total = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < GROCERY_ITEMS.length; j++) {
        if (items[i].equals(GROCERY_ITEMS[j][0])) {
          total = total + getItemPrice(j);
          continue;
        }
      }

    }
    return total;
  }
}

