public class Pickup extends Package {

  /*
   * Instance variable of the Pickup class.
   */
  private boolean pickedUp;


  
  /*
   * No-argument constructor with default values.
   */
  public Pickup() {
    pickedUp = false;
  }

  /*
   * Constructor that sets the numItems while the other variable are default.
   */
  public Pickup(int numItems) {
    super(numItems);
    pickedUp = false;
  }

  /*
   * Constructor that set the numItems and orderName while pickedUp is default.
   */
  public Pickup(int numItems, String orderName) {
    super(numItems, orderName);
    pickedUp = false;
  }

  /*
   * Constructor that sets every variable of the object.
   */
  public Pickup(int numItems, String orderName, boolean pickedUp) {
    super(numItems, orderName);
    this.pickedUp = pickedUp;
  }


  
  /*
   * Accessor method that returns pickedUp.
   */
  public boolean GetPickedUp() {
    return pickedUp;
  }

  /*
   * Mutator method that sets the pickedUp variable.
   */
  public void SetPickedUp(boolean pickedUp) {
    this.pickedUp = pickedUp;
  }


  
  /*
   * Returns the object's instance variables as a string.
   */
  public String toString() {
    return super.toString() + "\nPicked Up: " + pickedUp;
  }


  
  /*
   * Changes the pickedUp variable to true.
   */
  public void PickUp() {
    pickedUp = true;
  }
}