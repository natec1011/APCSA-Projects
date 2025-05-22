import java.util.ArrayList;

public class MineField {
  private int[][] mineField;
  private int[][] revealedSquares; // 0 = unrevealed, 1 = revealed, 2 = flagged
  private boolean alive = true;
  private int numMines;
  private int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
  private String saveCode;

  // constructor with pre-made fields
  public MineField(String difficulty) {
    if(difficulty.toLowerCase().equals("easy")) {
      mineField = new int[10][8];
      revealedSquares = new int[10][8];
      numMines = 10;
    }
    else if(difficulty.toLowerCase().equals("medium")) {
      mineField = new int[18][14];
      revealedSquares = new int[18][14];
      numMines = 40;
    }
    else if(difficulty.toLowerCase().equals("hard")) {
      mineField = new int[24][20];
      revealedSquares = new int[24][20];
      numMines = 99;
    }
    else {
      System.out.println("Invalid response. Please restart the program.");
    }

    setNewField();
  }

  // constructor for custom fields
  public MineField(int x, int y, int numMines) {
    mineField = new int[x][y];
    revealedSquares = new int[x][y];
    this.numMines = numMines;
    setNewField();
  }


  // randomly places mines onto the field
  private void setNewField() {
    int totalArea = mineField.length * mineField[0].length;
    for(int i = 0; i < numMines; i++) {
      int randomLocation = (int)(Math.random() * totalArea);
      int row = randomLocation / mineField[0].length;
      int col = randomLocation % mineField[0].length;

      if(mineField[row][col] != -1) {
        mineField[row][col] = -1;
      }
      else {
        i--;
      }
    }

    setBombCounts();
  }


  // sets each square's number of nearby bombs
  private void setBombCounts() {
    for(int i = 0; i < mineField.length; i++) {
      for(int j = 0; j < mineField[0].length; j++) {
        if(mineField[i][j] == -1) {
          continue;
        }
        mineField[i][j] = countSurroundingBombs(i, j);
      }
    }
  }


  // checks if a square is already revealed and if it is/isn't a bomb, then calls revealSafeSquares if the square is safe
  public void revealSquare(int col, int row) {
    col = mineField[0].length - col - 1;
    if(revealedSquares[row][col] == 1) {
      System.out.println("Already revealed!");
      return;
    }
    else if(mineField[row][col] == -1) {
      alive = false;
      revealedSquares[row][col] = 1;
    }
    else {
      revealSafeSquares(col, row);
    }
  }


  // reveals the given square and uses recursion to reveal more if there are no nearby bombs
  private void revealSafeSquares(int col, int row) {
    if(mineField[row][col] == 0 && revealedSquares[row][col] == 0) {
      revealedSquares[row][col] = 1;
      for(int[] direction : directions) {
        int newRow = row + direction[0];
        int newCol = col + direction[1];

        if(newRow >= 0 && newRow < mineField.length && newCol >= 0 && newCol < mineField[0].length) {
          revealSafeSquares(newCol, newRow);
        }
      }
    }
    else {
      revealedSquares[row][col] = 1;
    }
  }


  // flags a square
  public void flagSquare(int col, int row) {
    col = mineField[0].length - col - 1;
    if(revealedSquares[row][col] != 1) {
      revealedSquares[row][col] = 2;
    }
  }
  

  // counts the number of bombs surrounding a square
  private int countSurroundingBombs(int row, int col) {
    int count = 0;

    for(int[] direction : directions) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];

      if(newRow >= 0 && newRow < mineField.length && newCol >= 0 && newCol < mineField[0].length) {
        if(mineField[newRow][newCol] == -1) {
          count++;
        }
      }
    }

    return count;
  }


  /*
    generates a code that saves the state of the game.
    
    add leading zeros to make everything 3 digits (except the revealedSquares part)
    first number = x-axis length
    second number = y-axis length
    third number = number of bombs
    numbers 4 to (# of bombs + 4) = number of squares from the start or last bomb to the next bomb (row-major)
    ends with the entire revealedSquares 2d array (row-major, no longer adding leading zeros to make each one three digits)
  */
  public String generateSaveCode() {
    saveCode = "";
    String x = String.format("%03d", mineField.length);
    String y = String.format("%03d", mineField[0].length);
    String mines = String.format("%03d", numMines);
    saveCode += x + y + mines;
    
    int lastCount = 0;
    int count = 0;
    String mineLocations = "";
    for(int i = 0; i < numMines; i++) {
      for(int j = lastCount; j < (mineField.length * mineField[0].length); j++) {
        count++;
        int col = j / mineField.length;
        int row = j % mineField.length;
        if(mineField[row][col] == -1) {
          mineLocations += String.format("%03d", count);
          lastCount = j + 1;
          break;
        }
        
      }
      count = 0;
    }

    saveCode += mineLocations;

    String revealed = "";
    for(int i = 0; i < (mineField.length * mineField[0].length); i++) {
      int col = i / mineField.length;
      int row = i % mineField.length;
      revealed += revealedSquares[row][col];
    }
    saveCode += revealed;
    
    return saveCode;
  }


  // interprets the given save code and adjusts values accordingly
  public void loadSave(String code) {
    ArrayList<Integer> codes = new ArrayList<Integer>();
    for(int i = 0; i < code.length() - 3; i += 3) {
      codes.add(Integer.parseInt(code.substring(i, i + 3)));
    }

    mineField = new int[codes.get(0)][codes.get(1)];
    revealedSquares = new int[codes.get(0)][codes.get(1)];
    numMines = codes.get(2);
    int count = -1;
    for(int i = 3; i < numMines + 3; i++) {
      count += codes.get(i);
      int col = count / mineField.length;
      int row = count % mineField.length;
      mineField[row][col] = -1;
    }
    setBombCounts();

    for(int i = ((codes.get(2) * 3) + 9); i < code.length(); i++) {
      count = i - ((codes.get(2) * 3) + 9);
      int col = count / mineField.length;
      int row = count % mineField.length;
      revealedSquares[row][col] = Integer.parseInt(code.substring(i, i + 1));
    }
  }


  // makes the entire field into one string and prints it
  // used for testing purposes
  public void printFullField() {
    String result = "*";

    for(int i = 0; i < mineField.length; i++) {
      result += "---*";
    }
    result += "\n";
    String stringRow = result;

    for(int i = 0; i < mineField[0].length; i++) {
      result += "|";
      for(int j = 0; j < mineField.length; j++) {
        int space = mineField[j][i];
        if(space == -1) {
          result += "   |";
        }
        else {
          result += " " + space + " |";
        }
      }
      result += "\n" + stringRow;
    } 
    
    System.out.println(result);
  }
  

  // makes the entire field into one string and prints it, hiding unrevealed squares
  public void printField() {
    String result = "  *";

    for(int i = 0; i < mineField.length; i++) {
      result += "---*";
    }
    result += "\n";
    String stringRow = "\n" + result;

    for(int i = 0; i < mineField[0].length; i++) {
      if((mineField[0].length - i) < 10) {
        result += (mineField[0].length - i) + " |";
      }
      else {
        result += (mineField[0].length - i) + "|";
      }
      for(int j = 0; j < mineField.length; j++) {
        int space = mineField[j][i];
        int revealed = revealedSquares[j][i];
        if(revealed == 0) {
          result += "   |";
        }
        else if(revealed == 2) {
          result += " X |";
        }
        else if(space == -1) {
          result += " # |";
        }
        else {
          result += " " + space + " |";
        }
      }
      result += stringRow;
    } 
    result += "  ";
    for(int i = 1; i < mineField.length + 1; i++) {
      if(i < 10) {
        result += "  " + i + " ";
      }
      else {
        result += "  " + i;
      }
    }
    
    System.out.println(result);
  }


  // checks if the player has revealed every non-bomb square
  public boolean hasWon() {
    int count = 0;
    for(int i = 0; i < mineField.length; i++) {
      for(int j = 0; j < mineField[0].length; j++) {
        if(revealedSquares[i][j] != 1) {
          count++;
        }
      }
    }

    if(count == numMines) {
      return true;
    }
    else {
      return false;
    }
  }


  // returns the player's alive state
  public boolean isAlive() {
    return alive;
  }

  // returns the index length of the x-axis
  public int getX() {
    return mineField.length - 1;
  }

  // returns the index length of the y-axis
  public int getY() {
    return mineField[0].length - 1;
  }
  

  // counts the total number of bombs on the field
  // used for testing purposes
  private void countBombs() {
    int count = 0;
    for(int i = 0; i < mineField.length; i++) {
      for(int j = 0; j < mineField[0].length; j++) {
        if(mineField[i][j] == -1) {
          count++;
        }
      }
    }
    System.out.println(count);
  }

  // counts the total number of squares with a certain number of bombs surrounding it
  // used for testing purposes
  private void countGivenNums(int num) {
    int count = 0;
    for(int i = 0; i < mineField.length; i++) {
      for(int j = 0; j < mineField[0].length; j++) {
        if(mineField[i][j] == num) {
          count++;
        }
      }
    }
    System.out.println(count);
  }

  // prints the field without any kind of formatting
  // used for testing purposes
  public void printFieldNoFormat() {
    for(int i = 0; i < (mineField.length * mineField[0].length); i++) {
      int row = i / mineField[0].length;
      int col = i % mineField[0].length;
      if(col == 0) {
        System.out.println("");
      }
      System.out.print(revealedSquares[row][col] + ", ");
    }
  }
}