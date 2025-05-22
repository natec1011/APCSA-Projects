import org.code.theater.*;
import org.code.media.*;

public class DataScene extends Scene {
  private int[] years;
  private double[] prices;
  public static int numScenes;

  public DataScene(int[] years, double[] prices) {
    this.years = years;
    this.prices = prices;
    numScenes++;
  }

  /*
   * draws the entire scene
   */
  public void drawScene() {
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    drawImage("bitcoin2.jpg", 5, 335, 60);
    drawGraph();
  }

  /*
   * draws the entire graph
   */ 
  public void drawGraph() {
    setStrokeWidth(2);
    drawXIncrements();
    drawYIncrements();
    
    drawAxes();
    drawTitle();

    drawText("Price ($)", 20, 200, 270);
    drawText("  Year", 200, 395);

    plotPoints();
  }

  /*
   * draws the increments on the y axis
   */
  public void drawYIncrements() {
    setStrokeColor(new Color(200, 200, 200));
    setTextHeight(18);
    
    for(int j = 10; j >= 0; j--) {
      int yPlace = (int)(325 / 11 * -j + 325);

      if(j == 0) {
        drawText("0", 55, yPlace + 5);
        break;
      }
      
      drawLine(75, yPlace, 395, yPlace);
      drawText(String.valueOf(10 * j) + "k", 35, yPlace + 5);
    }
    
    setStrokeColor("black");
    setTextHeight(20);
  }

  /*
   * draws the increments on the x axis
   */
  public void drawXIncrements() {
    setStrokeColor(new Color(200, 200, 200));
    setTextHeight(18);
    
    for(int i = 1; i <= years.length; i++) {
      int xPlace = (int)(325 / 17 * i + 75);
      
      drawLine(xPlace, 5, xPlace, 325);
      drawText(String.valueOf(years[i - 1]), xPlace + 5, 370, 270);
    }
    
    setStrokeColor("black");
    setTextHeight(20);
  }

  /*
   * draws the axes of the graph
   */
  public void drawAxes() {
    drawLine(75, 5, 75, 330);
    drawLine(70, 325, 395, 325);

    // y-axis arrow
    drawLine(75, 5, 65, 15);
    drawLine(75, 5, 85, 15);

    // x-axis arrow
    drawLine(395, 325, 385, 315);
    drawLine(395, 325, 385, 335);
  }

  /*
   * draws the title of the graph
   */
  public void drawTitle() {
    setTextHeight(20);
    drawText("Price of Bitcoin vs. Year", 90, 25);
    setTextHeight(18);
  }

  /*
   * plots the points on the graph
   */
  public void plotPoints() {
    for(int k = 0; k < years.length; k++) {
      int yPlace = (int)(prices[k] / 100000.0 * -290 + 321);
      int xPlace = (int)(325 / 17 * k + 90);

      playSound("bubble-sound-43207.wav");
      pause(0.4);
      if(prices[k] < 100) {
        drawEllipse(xPlace, 325 + 75, 7, 7);
      }

      drawEllipse(xPlace, yPlace, 7, 7);
    }
    setStrokeColor("black");
  }

  /*
   * flips a coin
   */
  public static String flipCoin() {
    double coin = Math.random();

    if(coin < 0.5) {
      return "Heads";
    }
    else {
      return "Tails";
    }
  }

  /*
   * returns the static variable numScenes
   */
  public static int getNumScenes() {
    return numScenes;
  }
}