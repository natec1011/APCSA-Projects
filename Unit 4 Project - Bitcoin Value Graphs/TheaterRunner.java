import org.code.theater.*;
import java.util.Scanner;

public class TheaterRunner {
  public static void main(String[] args) {
    
    // Gets the data from the datasets
    FileReader myFileReader = new FileReader();
    int[] years = myFileReader.toIntArray("year.txt");
    double[] prices = myFileReader.toDoubleArray("price.txt");

    // creates scanner object
    Scanner input = new Scanner(System.in);

    // creates DataScene object
    DataScene scene = new DataScene(years, prices);
    LogDataScene logScene = new LogDataScene(years, prices);

    // draws both graphs
    scene.drawScene();
    logScene.drawScene();

    // asks the user if they want to view the logarithmic graph or not
    System.out.println("Would you like to view the logarithmic graph? (yes or no)");
    String userInput = input.nextLine();
    boolean log;

    // saves the user's choice
    if(userInput.toLowerCase().contains("yes")) {
      log = true;
    }
    else if(userInput.toLowerCase().contains("no")) {
      log = false;
    }
    else {
      System.out.println("\nInvalid input\nPlease try again");
      while(9 + 10 != 21){} // prevents execution of later code
    }

    // asks the user to choose heads or tails
    System.out.println("\nIf you do not win this coin flip you will not view the graph you wish to view.\nHeads or Tails?");
    userInput = input.nextLine();

    // saves the user's choice
    boolean choseHeads;
    if(userInput.toLowerCase().contains("heads")) {
      choseHeads = true;
    }
    else if(userInput.toLowerCase().contains("tails")) {
      choseHeads = false;
    }
    else {
      System.out.println("\nInvalid input\nPlease try again");
      while(9 + 10 != 21){} // prevents execution of later code
    }
    
    // flips the coin
    System.out.println("\nFlipping...");
    String flipResult = DataScene.flipCoin();
    System.out.println(flipResult);

    // determines if the user won the coin flip
    boolean wonFlip = false;
    if(choseHeads && flipResult.contains("Heads")) {
      wonFlip = true;
    }
    else if(!choseHeads && flipResult.contains("Tails")) {
      wonFlip = true;
    }
    else {
      wonFlip = false;
    }

    // draws the graph corresponding with the user's choice and outcome of the coin flip
    if(log && wonFlip) {
      Theater.playScenes(logScene);
    }
    else if(!log && !wonFlip) {
      Theater.playScenes(logScene);
    }
    else {
      Theater.playScenes(scene);
    }
  }
}