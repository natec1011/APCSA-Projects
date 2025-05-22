import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {

    PlumberPainter altra = new PlumberPainter(); // spawns new PlumberPainter

    altra.setPaint(9999); // Gives PlumberPainter 9999 paint to paint with

    /*
     * Draws the plumbers Mario and Luigi forever
     */
    while(true) {
      altra.moveFor(2); // Moves into position and draws the plumber Mario
      altra.plumber("Mario");

      altra.returnToStart(); // Returns to the starting position then turns right 100 times as a means to wait between painting the next plumber
      for(int i = 0; i < 100; i++) {
        altra.turnRight();
      }
      
      altra.moveFor(2); // Moves into position and draws the plumber Luigi
      altra.plumber("Luigi");

      altra.returnToStart(); // Returns to the starting position then turn right 100 times as a means to wait between painting the next plumber
      for(int i = 0; i < 100; i++) {
        altra.turnRight();
      }
    }
  }
}