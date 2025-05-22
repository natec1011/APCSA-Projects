import java.util.Scanner;

public class UserStory {

  /*
   * dataset variables
   */
  private String[] arenas;
  private String[] sortedArenas;
  private int[] capacities;
  private int[] championships;
  private String[] locations;
  private String[] teams;

  /*
   * no-argument constructor
   */
  public UserStory() {
    arenas = new String[1];
    sortedArenas = new String[1];
    capacities = new int[1];
    championships = new int[1];
    locations = new String[1];
    teams = new String[1];
  }

  /*
   * two-parameter constructor
   */
  public UserStory(String[] arenas, int[] capacities) {
    this.arenas = arenas;
    sortedArenas = arenas;
    this.capacities = capacities;
    championships = new int[1];
    locations = new String[1];
    teams = new String[1];
  }

  /*
   * all parameters constructor
   */
  public UserStory(String[] arenas, int[] capacities, int[] championships, String[] locations, String[] teams) {
    this.arenas = arenas;
    sortedArenas = arenas;
    this.capacities = capacities;
    this.championships = championships;
    this.locations = locations;
    this.teams = teams;
  }

  /*
   * finds the top x best arenas to advertise at and returns them as a string.
   */
  public String BestArenas(int topX) {
    String best = "";
    best = "The top " + topX + " best arenas to advertise in are:\n\n";

    // gets the arrays sorted
    int[] sortedArray = SortedIntArray();

    // forms the the list into one big string
    for(int i = 0; i < topX; i++) { //
      best += i + 1 + ". " + sortedArenas[i] + "\n   Capacity: " + sortedArray[i] + "\n\n";
    }

    return best;
  }

  /*
   * returns an int array of capacities sorted greatest to least.
   * also sorts arenas because I realized after that it'll be faster to weasel it in there instead of coding more.
   */
  public int[] SortedIntArray() {
    int[] sortedCapacities = capacities;

    outerloop: // label to break out of the outer loop from within the inner loop
    while(true) {
      for(int index = 0; index < capacities.length - 1; index++) {
        // compares if an index is less than the index after it then swaps the two
        if(sortedCapacities[index] < sortedCapacities[index + 1]) {
          // stores a copy of the first index
          int smaller = sortedCapacities[index];
          String arenaSwap = sortedArenas[index];

          // swaps the indices in capacities
          sortedCapacities[index] = sortedCapacities[index + 1];
          sortedCapacities[index + 1] = smaller;

          // swaps the indices in arenas
          sortedArenas[index] = sortedArenas[index + 1];
          sortedArenas[index + 1] = arenaSwap;
  
          break; // break (in case you didn't know)
        }
        // breaks out of the while loop
        if(index == capacities.length - 2) {
          break outerloop;
        }
      }
    }
    
    return sortedCapacities; // return (commented in case theres a smudge on your screen that blocks it the first time)
  }

  /*
   * your example didn't have a toString method and that was the only relevant data
 * as I understand it. so, sorry if it isn't as much as you wanted.
   */
  public String toString() {
    return "Number of available arenas: " + capacities.length;
  }
}