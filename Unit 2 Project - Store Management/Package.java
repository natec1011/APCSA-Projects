public class Package {

  /*
   * Instance variables to the Package class.
   */
  private int numItems;
  private String orderName;

  /*
   * No-argument constructor with default values.
   */
  public Package() {
    numItems = 1;
    orderName = "unknown";
  }

  /*
   * Constructor that sets the numItems while orderName is default.
   */
  public Package(int numItems) {
    this.numItems = numItems;
    orderName = "unknown";
  }

  /*
   * Constructor that sets the numItems and orderName.
   */
  public Package(int numItems, String orderName) {
    this.numItems = numItems;
    this.orderName = orderName;
  }

  /*
   * Accessor method to get the number of items.
   */
  public int GetNumItems() {
    return numItems;
  }

  /*
   * Accessor method to get the order name.
   */
  public String GetOrderName() {
    return orderName;
  }

  /*
   * Mutator method to set the number of items.
   */
  public void SetNumItems(int numItems) {
    this.numItems = numItems;
  }

  /*
   * Mutator method to set the order name
   */
  public void SetOrderName(String orderName) {
    this.orderName = orderName;
  }

  /*
   * Returns the object's instance variables as a string.
   */
  public String toString() {
    return "Number of Items: " + numItems + "\nOrder Name: " + orderName;
  }
}