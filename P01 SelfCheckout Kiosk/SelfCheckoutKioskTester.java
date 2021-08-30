///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:            Self Checkout Kiosk Tester
// Course:           CS 300, Spring 2021
//
// Authors:          Rago Senthilkumar
// Email:            rsenthilkuma@wisc.edu
// Lecturer's Name:  Hobbes LeGault
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Hobbes LeGault; Provided instructions that helped construct the test cases.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////////////////////////

public class SelfCheckoutKioskTester {
  /**
   * Checks whether SelfCheckoutKisok.getItemName() and SelfCheckoutKisok.getItemPrice()
   * method work as expected.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testItemNameAndPriceGetterMethods() {
    for (int i = 0; i < SelfCheckoutKiosk.GROCERY_ITEMS.length; i++) {
      if (!SelfCheckoutKiosk.getItemName(i).equals(SelfCheckoutKiosk.GROCERY_ITEMS[i][0])) {
        System.out.println("Problem detected: Called your getItemName() method with "
                + "input value " + i + ". But it did not return the expected output.");
        return false;
      }
      double expectedPriceOutput =
              Double.valueOf(SelfCheckoutKiosk.GROCERY_ITEMS[i][1].substring(1).trim());
      if (Math.abs((SelfCheckoutKiosk.getItemPrice(i) - expectedPriceOutput)) > 0.001) {
        System.out.println("Problem detected: Called your getItemPrice() method with "
                + "input value " + i + ". But it did not return the expected output.");
        return false;
      }
    }
    return true;
  }


  /**
   * Checks the correctness of SelfCheckoutKiosk.addItemToBaggingArea() method
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToBaggingArea() {
    String[] items = new String[10];
    int size = 0;

    // (1) Add one item to an empty bagging area
    size = SelfCheckoutKiosk.addItemToBaggingArea(0, items, size);
    if (size != 1) {
      System.out.println("Problem detected: Tried to add one item to an empty, "
              + "bagging area. The returned size must be 1. But your addItemToBaggingArea "
              + "method returned a different output.");

      return false;
    }
    if (!items[0].equals(SelfCheckoutKiosk.getItemName(0))) {
      // notice here the importance of checking for the correctness of your getItemName()
      // method before calling it above
      System.out.println("Problem detected: Tried to add only one item to an empty, "
              + "bagging area. But that item was not appropriately added to the contents "
              + "of the items array.");
    }

    // (2) Consider a non-empty bagging area
    items = new String[]{"Milk", "Chocolate", "Onion", null, null, null, null};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(10, items, size);
    if (size != 4) {
      System.out.println("Problem detected: Tried to add only one item to an non-empty, "
              + "bagging area. The size must be incremented after the method returns. But "
              + "it was not the case");
      return false;
    }
    if (!items[3].equals(SelfCheckoutKiosk.getItemName(10))) {
      System.out.println("Problem detected: Tried to add one item to an non-empty, "
              + "bagging area. But that item was not appropriately added to the contents "
              + "of the items array.");
    }

    // (3) Consider adding an item to a full bagging are
    items = new String[]{"Pizza", "Eggs", "Apples"};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(2, items, size);
    if (size != 3) {
      System.out.println("Problem detected: Tried to add a new item to a full bagging area."
              + " The size must stay the same. But "
              + " it was not the case");
      return false;
    }
    if (!items[0].equals("Pizza") || !items[1].equals("Eggs") || !items[2].equals("Apples")) {
      System.out.println("Problem detected: Tried to add a new item to a full bagging area."
              + " The contents in the bag should have stayed the same. But "
              + " it was not the case");
    }

    return true;
  }

  /**
   * Checks the correctness of the SelfCheckoutKiosk.count() method
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCount() {
    String[] items = new String[10];
    int size = 0;
    int count = 0;
    String item = "";

    //(1) A bagging area which contains 0 occurrences of the item
    items = new String[]{"Milk", "Eggs", "Onion", null, null, null};
    size = 3;
    item = "Apples";
    count = SelfCheckoutKiosk.count(item, items, size);
    if (count != 0) {
      System.out.println("Problem detected: A bagging area which contains 0" +
              " occurrences of the item.There should be no occurrences of the item. But "
              + " it was not the case");
      return false;
    }

    //(2) A bagging area which contains at least 4 items and only one occurrence
    items = new String[]{"Milk", "Eggs", "Onion", "Apples", null, null};
    size = 4;
    item = "Apples";
    count = SelfCheckoutKiosk.count(item, items, size);
    if (count != 1) {
      System.out.println("Problem detected:A bagging area which contains at least " +
              "4 items and only one occurrence occurrences of the item.There should be " +
              "1 occurrence of the item. But it was not the case");
      return false;
    }

    //(3) A bagging area which contains at least 5 items and 2 occurrences of the item to count.
    items = new String[]{"Milk", "Eggs", "Onion", "Apples", "Apples", null};
    size = 5;
    item = "Apples";
    count = SelfCheckoutKiosk.count(item, items, size);
    if (count != 2) {
      System.out.println("Problem detected:A bagging area which contains at least" +
              " 5 items and 2 occurrences of the item to count. There should be 2 " +
              "occurrences. But it was not the case");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the SelfCheckoutKiosk.indexOf() method
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIndexOf() {
    String items[] = new String[10];
    int size = 0;
    String item = "";
    int index = 0;

    //(1) The item is stored int he array and the expected output is 2
    items = new String[]{"Milk", "Eggs", "Onion", "Apples", null, null};
    size = 4;
    item = "Onion";
    index = SelfCheckoutKiosk.indexOf(item, items, size);
    if (index != 2) {
      System.out.println("Problem detected: The items array contains at least one match" +
              " with the item to find. It is located at index 2. But it was not the case.");
      return false;

    }

    //(2) The item was not stored in the array and the expected output is -1
    items = new String[]{"Milk", "Eggs", "Onion", "Apples", null, null};
    size = 4;
    item = "Grape";
    index = SelfCheckoutKiosk.indexOf(item, items, size);
    if (index != -1) {
      System.out.println("Problem detected: The items array contains no matches" +
              " and should return -1. But it was not the case.");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the SelfCheckoutKiosk.remove() method
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemove() {
    String items[] = new String[10];
    int beforesize = 0;
    int afterSize = 0;
    String removeItem = "";

    //(1) Attempt is made to remove an item that is not in the bagging are
    items = new String[]{"Milk", "Eggs", "Onion", "Apples", null, null};
    removeItem = "Chicken";
    beforesize = 4;
    afterSize = SelfCheckoutKiosk.remove(removeItem, items, beforesize);
    if (afterSize != 4) {
      System.out.println("Problem detected: The items array contains " +
              "no matches for the item being removed" +
              " and should return 4 the original size of the array. " +
              "But it was not the case.");
      return false;
    }
    if (!items[0].equals("Milk") || !items[1].equals("Eggs") || !items[2].equals("Onion") ||
            !items[3].equals("Apples")) {
      System.out.println("Problem detected: The items array contains no matches for the " +
              "item being removed" +
              " and the contents in the array should stay the same. " +
              "But it was not the case.");
      return false;
    }

    //(2) An attempt is made to remove an item from an empty bagging area
    items = new String[]{null, null};
    removeItem = "Chicken";
    beforesize = 0;
    afterSize = SelfCheckoutKiosk.remove(removeItem, items, beforesize);
    if (afterSize != 0) {
      System.out.println("Problem detected: The items array contains no contents" +
              " and should return 0, the original size of the array." +
              " But it was not the case.");
      return false;
    }

    //(3) An attempt is made to remove an item that has one occurrence in the bagging area
    items = new String[]{"Milk", "Chicken", "Apples", null, null};
    removeItem = "Chicken";
    beforesize = 3;
    afterSize = SelfCheckoutKiosk.remove(removeItem, items, beforesize);
    if (afterSize != 2) {
      System.out.println("Problem detected: The items array contains " +
              "1 occurrence of Chicken and should return 2 as the size after " +
              "the method is complete. But it was not the case.");
      return false;
    }
    if (!items[0].equals("Milk") || !items[1].equals("Apples")) {
      System.out.println("Problem detected: The items array contains 1 " +
              "occurrence of Chicken and should only contain 2 contents Milk and " +
              "Apples. But it was not the case.");
      return false;
    }

    //(4) An attempt is made to remove an item that has multiple occurrences in the bagging area
    items = new String[]{"Milk", "Chicken", "Apples", "Chicken", "Eggs", null};
    removeItem = "Chicken";
    beforesize = 5;
    afterSize = SelfCheckoutKiosk.remove(removeItem, items, beforesize);
    if (afterSize != 4) {
      System.out.println("Problem detected: The items array contains multiple occurrence of " +
              "Chicken and should return 4 as the size after the method is complete" +
              ". But it was not the case." + afterSize);
      return false;
    }
    if (!items[0].equals("Milk") || !items[1].equals("Eggs") || !items[2].equals("Apples")
            || !items[3].equals("Chicken")) {
      System.out.println("Problem detected: The items array contains 2 occurrence of " +
              "Chicken and should only contain 3 contents Milk, Apples, Chicken " +
              "and Eggs after the method. But it was not the case.");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the SelfCheckoutKiosk.getSubTotalPrice() method
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetSubTotalPrice() {
    String items[] = new String[10];
    int size = 0;
    double total = 0;

    //(1) Finding the subtotal for one item
    items = new String[]{"Beef", null};
    size = 1;
    total = SelfCheckoutKiosk.getSubTotalPrice(items, size);
    if (total != 3.79) {
      System.out.println("Problem detected: There is only one item in the array " +
              "and should return a value of 3.79. But this was not the case.");
      return false;
    }

    //(2) Finding subtotal for multiple items
    items = new String[]{"Beef", "Eggs", "Apple", null, null};
    size = 3;
    total = SelfCheckoutKiosk.getSubTotalPrice(items, size);
    if (total != 8.47) {
      System.out.println("Problem detected: There are Beef, " +
              "Eggs and Apple in the item array and the " +
              "total should be 8.47. But that was not the case.");
      return false;
    }

    //(3) Finding the subtotal for zero items
    items = new String[]{null, null, null};
    size = 0;
    total = SelfCheckoutKiosk.getSubTotalPrice(items, size);
    if (total != 0) {
      System.out.println("Problem detected: There are zero items in the array and " +
              "the subtotal should be zero. But that was not the case.");
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the SelfCheckoutKiosk.getUniqueCheckedOutItems() method
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetUniqueCheckedOutItems() {
    String items[] = new String[10];
    int size = 0;
    String itemsSet[];
    int newSize = 0;

    //(1) There are no duplicate items in the bagging area
    items = new String[]{"Milk", "Chicken", "Apples", "Cheese", null};
    size = 4;
    itemsSet = new String[7];
    newSize = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, size, itemsSet);
    if (newSize != size) {
      System.out.println("Problem detected: There are no duplicates in the bagging " +
              "area,and so the size of the item set array should be the same as the " +
              "size of the items array. But that was not the case");
      return false;
    }
    if (!itemsSet[0].equals("Milk") || !itemsSet[1].equals("Chicken") ||
            !itemsSet[2].equals("Apples") || !items[3].equals("Cheese")) {
      System.out.println("Problem detected: There are no duplicates in the bagging area, " +
              "and so the contents of the array should stay the same. But that was not the " +
              "case");
      return false;
    }

    //(2) There is one set of duplicates present
    items = new String[]{"Milk", "Chicken", "Milk", "Apples", null};
    size = 4;
    itemsSet = new String[7];
    newSize = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, size, itemsSet);
    if (newSize != 3) {
      System.out.println("Problem detected: There is one set of duplicates present in the " +
              "bagging area, and so the size of the item set array should be 3" +
              ". But that was not the case");
      return false;
    }
    if (!itemsSet[0].equals("Milk") || !itemsSet[1].equals("Chicken") ||
            !itemsSet[2].equals("Apples")) {
      System.out.println("Problem detected: There is 1 set of duplicates " +
              "in the bagging area, and so the size should be 3 and the contents should " +
              "be Milk, Cheese and Apples. But that was not the case");
      return false;
    }

    //(3) There are multiple duplicates present
    items = new String[]{"Milk", "Chicken", "Milk", "Apples", "Butter", "Chicken", null};
    size = 6;
    itemsSet = new String[7];
    newSize = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, size, itemsSet);
    if (newSize != 4) {
      System.out.println("Problem detected: There are 2 sets of duplicates present " +
              "in the items array, and the new array size should be 4. But that" +
              " was not the case.");
      return false;

    }
    if (!itemsSet[0].equals("Milk") || !itemsSet[1].equals("Chicken") ||
            !itemsSet[2].equals("Apples") || !itemsSet[3].equals("Butter")) {
      System.out.println("Problem detected: There are 2 sets of duplicates in " +
              "the bagging area, and so the size should be 4 and the " +
              "contents should be Milk, Cheese, Apples and " +
              "Butter. But that was not the case");
      return false;
    }

    //(4) There are 3 of the same items
    items = new String[]{"Milk", "Chicken", "Milk", "Apples", "Butter", "Milk", null};
    size = 6;
    itemsSet = new String[7];
    newSize = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, size, itemsSet);
    if (newSize != 4) {
      System.out.println("Problem detected: There are 3 Milks present in the items array," +
              " and so the new array size should be 4. But that was not the case.");
      return false;

    }
    if (!itemsSet[0].equals("Milk") || !itemsSet[1].equals("Chicken") ||
            !itemsSet[2].equals("Apples") || !itemsSet[3].equals("Butter")) {
      System.out.println("Problem detected: There are 3 Milks in the bagging area, " +
              "and so the size should be 4 and the contents should be Milk, Cheese, Apples " +
              "and Butter. But that was not the case");
      return false;
    }

    return true;
  }

  /**
   * main method used to call the unit tests
   *
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("tesItemNameAndPriceGetterMethods(): " +
            testItemNameAndPriceGetterMethods());
    SelfCheckoutKiosk.printCatalog();
    System.out.println("testAddItemToBaggingArea():" + testAddItemToBaggingArea());
    System.out.println("testCount(): " + testCount());
    System.out.println("testIndexOf(): " + testIndexOf());
    System.out.println("testRemove(): " + testRemove());
    System.out.println("testGetSubTotalPrice(): " + testGetSubTotalPrice());
    System.out.println("testGetUniqueCheckedOutItems(): " + testGetUniqueCheckedOutItems());

  }

}

