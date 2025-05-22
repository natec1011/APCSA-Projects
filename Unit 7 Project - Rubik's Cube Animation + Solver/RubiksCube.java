public class RubiksCube{
  private String[][] whiteSide = new String[3][3];
  private String[][] orangeSide = new String[3][3];
  private String[][] greenSide = new String[3][3];
  private String[][] redSide = new String[3][3];
  private String[][] blueSide = new String[3][3];
  private String[][] yellowSide = new String[3][3];
  private String[][][] allSides = new String[6][3][3];

  

  public RubiksCube() {
    setCube();
    custom();
  }

  

  public RubiksCube(boolean shuffled) {
    setCube();
    if(shuffled) {
      shuffle();
    }
  }

  

  /*
   * assigns all of the colors to the arrays
   */
  private void setCube() {
    for(int i = 0; i < 6; i++) {
      switch(i) {
        case 0:
          for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
              whiteSide[j][k] = "white";
            }
          }
          break;
        case 1:
          for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
              orangeSide[j][k] = "orange";
            }
          }
          break;
        case 2:
          for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
              greenSide[j][k] = "green";
            }
          }
          break;
        case 3:
          for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
              redSide[j][k] = "red";
            }
          }
          break;
        case 4:
          for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
              blueSide[j][k] = "blue";
            }
          }
          break;
        case 5:
          for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
              yellowSide[j][k] = "yellow";
            }
          }
          break;
      }
    }

    // puts all the sides into one array
    for(int i = 0; i < 6; i++) {
      switch(i) {
        case 0:
          allSides[i] = orangeSide;
          break;
        case 1:
          allSides[i] = greenSide;
          break;
        case 2:
          allSides[i] = redSide;
          break;
        case 3:
          allSides[i] = blueSide;
          break;
        case 4:
          allSides[i] = whiteSide;
          break;
        case 5:
          allSides[i] = yellowSide;
          break;
      }
    }
  }

  

  /*
   * turns a random side a random # of times, 30-50 times
   */
  public void shuffle() {
    for(int i = 0; i < (int)((Math.random() * 20) + 30); i++) {
      turnSide((int)(Math.random() * 6), (int)(Math.random() * 3 + 1));
    }
  }



  /*
   * returns one side in a string
   */
  public String getSide(String side) {
    String result = "";
    String[][] chosenSide = new String[3][3];
    
    switch(side) {
      case "white":
        chosenSide = allSides[4];
        break;
      case "orange":
        chosenSide = allSides[0];
        break;
      case "green":
        chosenSide = allSides[1];
        break;
      case "red":
        chosenSide = allSides[2];
        break;
      case "blue":
        chosenSide = allSides[3];
        break;
      case "yellow":
        chosenSide = allSides[5];
        break;
      default:
        return "Choose a side, moron!";
    }

    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        result += chosenSide[i][j] + ", ";
      }
      result += "\n";
    }

    return result;
  }


  /*
   * returns a specific row of any given side
   */
  public String getSide(int side, int row) {
    String result = "";
    String[][] chosenSide = allSides[side];

    for(int i = 0; i < 3; i++) {
      result += chosenSide[i][row] + ", ";
    }

    return result;
  }


  /*
   * returns a specific index from allSides
   */
  public String getSide(int side, int row, int column) {
    return allSides[side][row][column];
  }



  /*
   * returns a string of every side vertically
   */
  public String getAllSides() {
    String result = "";

    for(int i = 0; i < allSides.length; i++) {
      for(int j = 0; j < allSides[0].length; j++) {
        for(int k = 0; k < allSides[0][0].length; k++) {
          result += allSides[i][j][k] + ", ";
        }
        result += "\n";
      }
      result += "\n";
    }

    return result;
  }


  /*
   * prints every side of the cube in a formatted 2d rendering of the cube
   */
  public void printAllSides() {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        System.out.printf("%-8s", allSides[4][i][j]);
      }
      System.out.println();
    }

    System.out.print("------------------------\n");

    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 4; j++) {
        for(int k = 0; k < 3; k++) {
          System.out.printf("%-8s", allSides[j][i][k]);
        }
        System.out.print("| ");
      }
      System.out.println();
    }

    System.out.print("------------------------\n");
    
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        System.out.printf("%-8s", allSides[5][i][j]);
      }
      System.out.println();
    }
  }


  /*
  * turns a side a number of times
  
  * ---> I'll keep my notes here for you but I may have changed how it works compared to the notes <---
  
  change of plans
  each side has a number (3d array of the 2ds?)
  orange = 0
  green = 1
  red = 2
  blue = 3
  white = 4
  yellow = 5

  take an int param(x)
  if x < 4 then the left and right sides and (x +- 1) % 4 and always top side = 4, bottom side = 5
  when x >= 4, go cw 0-3 for the sides
  and check at the start if x is from 0 to 5

  IMPORTANT:
  implement turning of the non-front sides
  start at index 1 of sides
  save the relevant values of index 1
  copy values from the next index to the current index
  use saved values for last side
  */
  public void turnSide(int side, int turns) {
    // uses recursion to turn the same side multiple times
    int numTurns = turns % 4;
    if(numTurns >= 1) {
      numTurns--;
      turnSide(side, numTurns);
    }
    else {
      return;
    }
    
    // grabs an array of the sides to modify
    if(side < 4 && !(side < 1)) { // in hindsight, might be useless right now but everything works and I'm not changing anything
      int[] sides = {side, 5, (side + 1) % 4, 4, (side - 1) % 4};
    }

    else if(side == 0) { // also useless?
      int[] sides = {side, 5, 1, 4, 3};
    }
      
    else if(side == 4) { // in addition to above, rotates the front-facing side
      int[] sides = {side, 0, 1, 2, 3};
      String[] savedSide = new String[3];
      for(int i = 0; i < savedSide.length; i++) {
        savedSide[i] = allSides[sides[1]][0][i];
      }
      for(int i = 1; i < sides.length - 1; i++) {
        for(int j = 0; j < 3; j++) {
          allSides[sides[i]][0][j] = allSides[sides[i + 1]][0][j];
        }
      }
      for(int i = 0; i < savedSide.length; i++) {
        allSides[sides[sides.length - 1]][0][i] = savedSide[i];
      }
    }
      
    else if(side == 5) { // in addition to above, rotates the front-facing side
      int[] sides = {side, 2, 1, 0, 3}; 
      String[] savedSide = new String[3];
      for(int i = 0; i < savedSide.length; i++) {
        savedSide[i] = allSides[sides[1]][2][i];
      }
      for(int i = 1; i < sides.length - 1; i++) {
        for(int j = 0; j < 3; j++) {
          allSides[sides[i]][2][j] = allSides[sides[i + 1]][2][j];
        }
      }
      for(int i = 0; i < savedSide.length; i++) {
        allSides[sides[sides.length - 1]][2][i] = savedSide[i];
      }
    }
      
    else { // prevents an error later on
      int[] sides = new int[5];
      return;
    }

    // turns the front-facing/chosen side
    String[][] newFront = new String[3][3];
    for(int i = 0; i < 3; i++) {
      for(int j = 2; j >= 0; j--) {
        newFront[i][2 - j] = allSides[side][j][i];
      }
    }
    allSides[side] = newFront;

    // turns adjacent sides
    switch(side) {
      case 0:
        String[] savedSide = new String[3];
        for(int i = 0; i < savedSide.length; i++) {
          savedSide[i] = allSides[5][0][i];
        }
        for(int i = 0; i < 3; i++) {
          allSides[5][0][i] = allSides[1][2 - i][0];
        }
        for(int i = 0; i < 3; i++) {
          allSides[1][i][0] = allSides[4][2][i];
        }
        for(int i = 0; i < 3; i++) {
          allSides[4][2][i] = allSides[3][2 - i][2];
        }
        for(int i = 0; i < 3; i++) {
          allSides[3][i][2] = savedSide[i];
        }
        break;
        
      case 1:
        String[] savedSide1 = new String[3];
        for(int i = 0; i < savedSide1.length; i++) {
          savedSide1[i] = allSides[5][i][2];
        }
        for(int i = 0; i < 3; i++) {
          allSides[5][i][2] = allSides[2][2 - i][0];
        }
        for(int i = 0; i < 3; i++) {
          allSides[2][i][0] = allSides[4][2 - i][2];
        }
        for(int i = 0; i < 3; i++) {
          allSides[4][i][2] = allSides[0][i][2];
        }
        for(int i = 0; i < 3; i++) {
          allSides[0][i][2] = savedSide1[i];
        }
        break;
        
      case 2:
        String[] savedSide2 = new String[3];
        for(int i = 0; i < savedSide2.length; i++) {
          savedSide2[i] = allSides[5][2][2 - i];
        }
        for(int i = 0; i < 3; i++) {
          allSides[5][2][i] = allSides[3][i][0];
        }
        for(int i = 0; i < 3; i++) {
          allSides[3][i][0] = allSides[4][0][2 - i];
        }
        for(int i = 0; i < 3; i++) {
          allSides[4][0][i] = allSides[1][i][2];
        }
        for(int i = 0; i < 3; i++) {
          allSides[1][i][2] = savedSide2[i];
        }
        break;
        
      case 3:
        String[] savedSide3 = new String[3];
        for(int i = 0; i < savedSide3.length; i++) {
          savedSide3[i] = allSides[5][i][0];
        }
        for(int i = 0; i < 3; i++) {
          allSides[5][i][0] = allSides[0][i][0];
        }
        for(int i = 0; i < 3; i++) {
          allSides[0][i][0] = allSides[4][i][0];
        }
        for(int i = 0; i < 3; i++) {
          allSides[4][i][0] = allSides[2][2 - i][2];
        }
        for(int i = 0; i < 3; i++) {
          allSides[2][2 - i][2] = savedSide3[i];
        }
        break;
    }
  }



  /*
   * makes a set shuffle so the cube has the same starting point
   */
  private void custom() {
    turnSide(0, 1);
    turnSide(1, 2);
    turnSide(3, 1);
    turnSide(2, 1);
    turnSide(0, 1);
    turnSide(5, 3);
    turnSide(1, 1);
    turnSide(0, 1);
    turnSide(2, 1);
  }
}