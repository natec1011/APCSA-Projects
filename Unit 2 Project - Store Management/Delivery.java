public class Delivery extends Package {

  /*
   * Instance variables of the Delivery class.
   */
  private String destination;
  private boolean delivered;

  

  /*
   * No-argument constructor with default values.
   */
  public Delivery() {
    destination = "unknown";
    delivered = false;
  }

  /*
   * Constructor that sets the numItems while other variables are default.
   */
  public Delivery(int numItems) {
    super(numItems);
    destination = "unknown";
    delivered = false;
  }

  /*
   * Contructor that sets the numItems and orderName while other variables are default.
   */
  public Delivery(int numItems, String orderName) {
    super(numItems, orderName);
    destination = "unknown";
    delivered = false;
  }

  /*
   * Constructor that sets every variable except destination.
   */
  public Delivery(int numItems, String orderName, String destination) {
    super(numItems, orderName);
    this.destination = destination;
    delivered = false;
  }

  /*
   * Constructor that sets every variable of the object.
   */
  public Delivery(int numItems, String orderName, String destination, boolean delivered) {
    super(numItems, orderName);
    this.destination = destination;
    this.delivered = delivered;
  }

  

  /*
   * Accessor method to get the destination.
   */
  public String GetDestination() {
    return destination;
  }

  /*
   * Accessor method to get the delivered status.
   */
  public boolean GetDelivered() {
    return delivered;
  }
  
  /*
   * Mutator method to set the destination.
   */
  public void SetDestination(String destination) {
    this.destination = destination;
  }

    /*
   * Mutator method to set the delivered status.
   */
  public void SetDelivered(boolean delivered) {
    this.delivered = delivered;
  }

  

  /*
   * Returns the object's instance variables as a string.
   */
  public String toString() {
    return super.toString() + "\nDestination: " + destination + "\nDelivered: " + delivered;
  }

  

  /*
   * Sets the delivered status to true.
   */
  public void Deliver() {
    delivered = true;
  }
}