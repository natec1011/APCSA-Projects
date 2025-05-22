import java.util.Scanner;

public class DataRunner {
  public static void main(String[] args) {

    //turns text files into 1D arrays and creates a new file reader object
    FileRead myFileReader = new FileRead("locations.txt");
    String[] locations = myFileReader.getStringData(30);

    myFileReader.setFile("arenas.txt");
    String[] arenas = myFileReader.getStringData(30);

    myFileReader.setFile("capacities.txt");
    int[] capacities = myFileReader.getIntData(30);

    myFileReader.setFile("championships.txt");
    int[] championships = myFileReader.getIntData(30);

    myFileReader.setFile("teams.txt");
    String[] teams = myFileReader.getStringData(30);

    

    // creates userStory object with datasets
    UserStory myStory = new UserStory(arenas, capacities, championships, locations, teams);

    // creates scanner object for user input
    Scanner input = new Scanner(System.in);

    // gets user input
    System.out.println("Number of available arenas to advertise in: " + capacities.length);
    System.out.println("How many arenas do you want to advertise in.\n");
    int numArenas = input.nextInt();

    // prints the data the user requests
    System.out.println("\n" + myStory.BestArenas(numArenas));
  }
}