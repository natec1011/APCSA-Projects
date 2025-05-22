import org.code.neighborhood.*;

public class PlumberPainter extends MuralPainter {
  public void plumber(String plumber) {
    /*
     * Draws the specified plumber.
     */
    String color = ""; // Changes the plumber's hat and overalls color depending on which plumber.
    if(plumber == "Mario") {
      color = "red";
    }
    else if(plumber == "Luigi") {
      color = "green";
    }
    
    move(); // Moves into position to draw the hat and draws it
    move();
    drawHat(color);

    move(); // Moves into position to draw the head and draws it
    turnLeft();
    move();
    turnLeft();
    drawHead();

    move(); // Moves into position to draw the body and draws it
    turnLeft();
    moveFor(2);
    turnLeft();
    drawBody(color);

    turnAround(); // Moves into position to draw the shoes and draws them.
    moveFor(11);
    turnLeft();
    moveFor(2);
    turnLeft();
    drawShoes();
  }

  public void drawHat(String color) {
    /*
     * Draws the hat of the plumber in the specified color.
     */
    move(); // Draws the first row of the hat
    paintLine(color, 5);
    move();
    move();
    
    turnToWest(); // Draws the second row of the hat
    paintLine(color, 8);
  }

  public void drawHead() {
    /*
     * Draws the head of the plumber.
     */
    drawHeadSkin(); // Draws the skin of the plumber's head

    turnAround(); // Moves into position to draw the plumber's hair
    moveFor(8);
    turnRight();
    moveFor(4);
    turnRight();

    drawHeadHair(); // Draws the plumber's hair
  }

  public void drawHeadSkin() {
    /*
     * Draws the skin of the plumber's head.
     */
    String color = "#F6AD06"; // Sets the plumber's skin color
    
    moveFor(4); // Paints the first row of the plumber's head
    paintLine(color, 2);
    moveFor(2);
    paint(color);

    moveFor(2); // Paints the second row
    turnToWest();
    paintLine(color, 3);
    moveFor(2);
    paintLine(color, 3);
    moveFor(2);
    paint(color);

    turnToEast(); // Paints the third row
    paint(color);
    moveFor(3);
    paintLine(color, 3);
    moveFor(2);
    paintLine(color, 3);
  
    turnToWest(); // Paints the fourth row
    moveFor(5);
    paintLine(color, 4);

    turnToEast(); // Paints the fifth row
    paintLine(color, 7);
  }

  public void drawHeadHair() {
    /*
     * Draws the hair of the plumber's head.
     */
    String color = "#7E7E01"; // Sets the plumber's hair color

    move(); // Paints the first row
    paintLine(color, 3);
    moveFor(3);
    paint(color);

    turnToWest(); // Paints the second row
    paint(color);
    moveFor(4);
    paint(color);
    moveFor(2);
    paint(color);

    turnToEast(); // Paints the third row
    paint(color);
    moveFor(2);
    paintLine(color, 2);
    moveFor(4);
    paint(color);
    moveFor(2);

    turnToWest(); // Paints the fourth row
    paintLine(color, 4);
    moveFor(5);
    paintLine(color, 2);
  }

  public void drawBody(String color) {
    /*
     * Draws the body of the plumber.
     */
    drawShirt(); // Draws the plumber's shirt

    turnRight(); // Move into position to draw the plumber's overalls and draws them.
    moveFor(3);
    turnRight();
    drawOveralls(color);

    moveFor(2); // Moves into position to draw the plumber's hands and draws them.
    turnRight();
    moveFor(3);
    turnRight();
    drawHands();
  }

  public void drawShirt() {
    /*
     * Draws the shirt of the plumber.
     */
    String color = "#7E7E01"; // Sets the color of the plumber's shirt

    moveFor(2); // Draws the first row
    paintLine(color, 2);
    moveFor(2);
    paintLine(color, 3);
    moveFor(3);

    turnToWest(); // Draws the second row
    paintLine(color, 3);
    moveFor(2);
    paintLine(color, 2);
    moveFor(2);
    paintLine(color, 3);
    move();

    turnToEast(); // Draws the third row
    paintLine(color, 4);
    moveFor(5);
    paintLine(color, 4);

    turnToWest(); // Draws the fourth row
    moveFor(2);
    paint(color);
    moveFor(7);
    paint(color);
  }

  public void drawOveralls(String color) {
    /*
     * Draws the overalls of the plumber.
     */
    moveFor(2); // Draws the first row
    paint(color);
    turnRight();

    move(); // Draws the second row
    turnLeft();
    paint(color);
    moveFor(3);
    paint(color);

    turnToWest(); // Draws the third row
    paintLine(color, 4);
    move();

    turnToEast(); // Draws the fourth row
    paint(color);
    move();
    paint("#F7AF06");
    move();
    paintLine(color, 2);
    move();
    paint("#F7AF06");
    move();
    paint(color);

    turnToWest(); // Draws the fifth row
    paintLine(color, 6);
    move();

    turnToEast(); // Draws the sixth row
    paintLine(color, 3);
    moveFor(3);
    paintLine(color, 3);

    turnToWest(); // Draws the seventh row
    paintLine(color, 3);
    moveFor(3);
    paintLine(color, 3);
  }

  public void drawHands() {
    /*
     * Draws the hands of the plumber.
     */
    String color = "#F6AE02"; // Sets the plumber's hand color
    
    paintLine(color, 2); // Draws the first row
    moveFor(9);
    paintLine(color, 2);

    turnToWest(); // Draws the second row
    paintLine(color, 3);
    moveFor(7);
    paintLine(color, 3);

    turnToEast(); // Draws the third row
    paintLine(color, 2);
    moveFor(9);
    paintLine(color, 2);
  }

  public void drawShoes() {
    /*
     * Draws the shoes of the plumber.
     */
    String color = "#7E7E01"; // Sets the color of the plumber's shoes

    move(); // Draws the first row
    paintLine(color, 3);
    moveFor(5);
    paintLine(color, 3);
    move();

    turnToWest(); // Draws the second row
    paintLine(color, 4);
    moveFor(5);
    paintLine(color, 4);
  }
}