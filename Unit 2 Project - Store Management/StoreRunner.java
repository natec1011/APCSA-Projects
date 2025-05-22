import java.util.Scanner;

public class StoreRunner {
  public static void main(String[] args) {

    // Creates a Scanner object - feel free to delete if not using!
    Scanner input = new Scanner(System.in);
    
    // asks the user if it is for delivery or pickup
    System.out.println("Delivery or Pickup?");
    String userInput = input.nextLine();

    // the user places an order for delivery
    if(userInput.contains("delivery")) {
      System.out.println("\nEnter the number of items.");
      int itemNumber = input.nextInt();

      System.out.println("\nEnter the order name.");
      input.nextLine(); // for some reason the next time I called the nextLine() method it would be skipped so I put this here to get skipped to actually receive the order name
      String nameOnOrder = input.nextLine();

      System.out.println("\nEnter the address.");
      String address = input.nextLine();
      
      Delivery dinner = new Delivery(itemNumber, nameOnOrder, address);
      System.out.println("\n" + dinner);
    }

    // the user places an order for pickup
    else if(userInput.contains("pickup")) {
      System.out.println("\nEnter the number of items.");
      int itemNumber = input.nextInt();

      System.out.println("\nEnter the order name.");
      input.nextLine(); // same here (context on line 19)
      String nameOnOrder = input.nextLine();
      
      Pickup dinner = new Pickup(itemNumber, nameOnOrder);
      System.out.println("\n" + dinner);
    }

    // fallback in case the user enters something that doesn't fit the criteria
    else {
      System.out.println("\nInvalid response\nTry all lowercase");
    }

    // Closes the Scanner object
    input.close();
  }
}