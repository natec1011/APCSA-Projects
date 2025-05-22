import org.code.neighborhood.*;

public class PainterPlus extends Painter {
  public void turnRight() {
    /*
     * Turns the PainterPlus left three times.
     */
    turnLeft();
    turnLeft();
    turnLeft();
  }

  public void takeAllPaint() {
    /*
     * Takes every paint bucket the PainterPlus is currently standing on.
     */
    while(isOnBucket()) {
      takePaint();
    }
  }

  public void moveFast() {
    /*
     * Moves the PainterPlus forward until it is no longer able to.
     */
    while(canMove()) {
      move();
    }
  }

  public void paintToEmpty(String color) {
    /*
     * Paints a specified color and moves forward repeatedly until it runs out of paint.
     */
    while(hasPaint()) {
      paint(color);
      move();
    }
  }

  public void paintDonut(String color) {
    /*
     * Paints a donut in a specified color until it runs out of paint.
     */
    while(hasPaint()) {
      move();
      turnRight();
      paint(color);
      move();
      paint(color);
    }
  }

  public void turnAround() {
    /*
     * Makes the turn around 180 degrees.
     */
    turnLeft();
    turnLeft();
  }

  public void paintLine(String color, int size) {
    /*
     * Makes the painter paint in a straight line until it can no longer move
     */
    for(int i = 1; i < size; i++) {
      paint(color);
      move();
    }
    paint(color);
  }

  public void moveFor(int length) {
    /*
     * Moves the plumber for the given length.
     */
    for(int i = 0; i < length; i++) {
      move();
    }
  }

  public void returnToStart() {
    /*
     * Returns the painter to the starting location.
     */
    while(!isFacingWest()) {
      turnLeft();
    }
    moveFast();
    turnRight();
    moveFast();
    turnRight();
  }
}