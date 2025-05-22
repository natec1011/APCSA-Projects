import org.code.theater.*;
import org.code.media.*;

public class ScenePlus extends Scene {
  /*
   * draws an image the full size of the theater
   */
  public void background(ImagePlus image) {
    drawImage(image, 0, 0, getWidth(), getHeight(), 0);
  }
}