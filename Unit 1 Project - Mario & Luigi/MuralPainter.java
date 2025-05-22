import org.code.neighborhood.*;

public class MuralPainter extends PainterPlus {
  public void turnToWest() {
    /*
     * Moves the painter down one row and faces west.
     */
    turnRight();
    move();
    turnRight();
  }

  public void turnToEast() {
    /*
     * Moves the painter down one row and faces east.
     */
    turnLeft();
    move();
    turnLeft();
  }
}