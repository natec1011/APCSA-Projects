import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {

    boolean playing = false;
    Scanner input = new Scanner(System.in);
    String userInput;
    MineField mines = new MineField("easy");

    System.out.println("Welcome to Mine Sweeper!\n       New Game\n       Continue\n        Custom\n");
    // handles the main menu
    while(!playing) {
      userInput = input.nextLine().toLowerCase();
      switch(userInput) {
        case "new game":
          System.out.println("\nSelect a diffculty.\n       Easy\n      Medium\n       Hard\n");
          mines = new MineField(input.nextLine());
          mines.printField();
          playing = true;
          break;
          
        case "continue":
          System.out.print("\nPlease enter save code: ");
          userInput = input.nextLine();
          mines.loadSave(userInput);
          mines.printField(); 
          playing = true;
          break;
          
        case "custom":
          System.out.print("\nYou may need to zoom out if you make the grid too big.\nX Axis Length: ");
          int customX = input.nextInt();
          System.out.print("Y Axis Length: ");
          int customY = input.nextInt();
          System.out.print("Number of Mines: ");
          int customMines = input.nextInt();
          mines = new MineField(customX, customY, customMines);
          mines.printField();
          playing = true;
          break;
          
        default:
          System.out.println("\nInvalid response. Please try again.\n");
          break;
      }
    }


    // handles the player playing the game
    while(mines.isAlive() && playing) {
      System.out.println("Save Code: (Make sure program is not running to highlight and copy the code) " + mines.generateSaveCode());

      System.out.print("X Coordinate: ");
      int inputX = input.nextInt() - 1;
      if(inputX > mines.getX()) {
        System.out.println("\nInvalid input. Retying...\n");
        continue;
      }
      
      System.out.print("Y Coordinate: ");
      int inputY = input.nextInt() - 1;
      if(inputY > mines.getY()) {
        System.out.println("\nInvalid input. Retying...\n");
        continue;
      }

      System.out.print("Reveal, Flag, or Cancel?\n");
      userInput = input.next().toLowerCase();

      switch(userInput) {
        case "reveal":
          mines.revealSquare(inputY, inputX);
          break;
          
        case "flag":
          mines.flagSquare(inputY, inputX);
          break;
          
        case "cancel":
          System.out.println("\nCancelling...\n");
          continue;
          
        default:
          System.out.println("\nInvalid input. Retrying...\n");
          continue;
      }

      mines.printField();
      if(mines.hasWon()) {
        System.out.println("\nYou Won!");
        playing = false;
      }
      else if(!mines.isAlive()) {
        System.out.println("\n  Boom!\nYou Died!");
      }
    }
  }
}