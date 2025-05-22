import org.code.theater.*;
import org.code.media.*;

public class LogDataScene extends DataScene {
  private double[] logPrices;
  
  public LogDataScene(int[] years, double[] prices) {
    super(years, prices);
    super.numScenes++;
    logPrices = logDoubleArray(prices);
  }

  /*
   * returns the given double array in log base 10
   */
  public double[] logDoubleArray(double[] array) {
    double[] result = new double[array.length];
    
    for(int i = 0; i < array.length; i++) {
      if(array[i] > 0.5) {
        result[i] = Math.log(array[i]) / Math.log(10);
      }
    }
    
    return result;
  }

  /*
   * draws the increments on the y axis
   */
  public void drawYIncrements() {
    setStrokeColor(new Color(200, 200, 200));
    setTextHeight(18);
    
    for(int j = 5; j >= 0; j--) {
      int yPlace = (int)(325 / 6 * -j + 325);

      if(j == 0) {
        drawText("0", 55, yPlace + 5);
        break;
      }
      else if(j > 3) {
        drawText(String.valueOf((int)Math.pow(10.0, j - 3)) + "k", 35, yPlace + 5);
      }
      else {
        drawText(String.valueOf((int)Math.pow(10.0, j)), 35, yPlace + 5);
      }
      
      drawLine(75, yPlace, 395, yPlace);
    }
    
    setStrokeColor("black");
    setTextHeight(20);
  }

  /*
   * draws the title of the graph
   */
  public void drawTitle() {
    setTextHeight(20);
    drawText("Log of Price of Bitcoin vs. Year", 90, 25);
    setTextHeight(18);
  }

  /*
   * plots the points on the graph
   */
  public void plotPoints() {
    for(int k = 0; k < logPrices.length; k++) {
      int yPlace = (int)(logPrices[k] / 5.0 * -269 + 321);
      int xPlace = (int)(325 / 17 * k + 90);

      playSound("bubble-sound-43207.wav");
      pause(0.4);
      
      drawEllipse(xPlace, yPlace, 7, 7);
    }
    setStrokeColor("black");
  }
}