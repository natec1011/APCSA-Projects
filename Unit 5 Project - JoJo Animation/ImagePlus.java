import org.code.theater.*;
import org.code.media.*;

public class ImagePlus extends Image {
  private Pixel[][] pixels;

  public ImagePlus(String fileName) {
    super(fileName);
    
    pixels = getPixelsFromImage();
  }

  public Pixel[][] getPixels() {
    return pixels;
  }

  /*
   * returns 2d array of the image's pixels
   */
  public Pixel[][] getPixelsFromImage() {
    Pixel[][] tempPixels = new Pixel[getHeight()][getWidth()];

    for(int i = 0; i < tempPixels.length; i++) {
      for(int j = 0; j < tempPixels[0].length; j++) {
        tempPixels[i][j] = getPixel(j, i);
      }
    }

    return tempPixels;
  }

  /*
   * sets every color to its max value except the color with the lowest value.
   */
  public void maxColors() {
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];
        int red = pixel.getRed();
        int blue = pixel.getBlue();
        int green = pixel.getGreen();

        if(red < blue && red < green) {
          pixel.setBlue(255);
          pixel.setGreen(255);
        }
        else if(blue < red && blue < green) {
          pixel.setRed(255);
          pixel.setGreen(255);
        }
        else if(green < red && green < blue) {
          pixel.setRed(255);
          pixel.setBlue(255);
        }
      }
    }
  }

  /*
   * randomly adds or removes 0-40 from each color value
   */
  public void noise() {
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];

        pixel.setRed(pixel.getRed() + (int)(Math.random() * 81 - 40));
        pixel.setBlue(pixel.getBlue() + (int)(Math.random() * 81 - 40));
        pixel.setGreen(pixel.getGreen() + (int)(Math.random() * 81 - 40));
      }
    }
  }

  /*
   * sets each color to its opposite value
   */
  public void invert() {
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];

        pixel.setRed(255 - pixel.getRed());
        pixel.setBlue(255 - pixel.getBlue());
        pixel.setGreen(255 - pixel.getGreen());
      }
    }
  }

  /*
   * changes every pixel to its average value
   */
  public void grayscale() {
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];
        int avg = (int)((pixel.getBlue() + pixel.getGreen() + pixel.getRed()) / 3);

        pixel.setRed(avg);
        pixel.setBlue(avg);
        pixel.setGreen(avg);
      }
    }
  }

  /*
   * increases the red value of every pixel
   */
  public void redTint() {
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];

        pixel.setRed(50 + pixel.getRed());
      }
    }
  }

  /*
   * increases the difference between the light and dark pixels
   */
  public void increaseContrast() {
    int factor = 25;
    int factor2 = 125;
    
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];
        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();
        
        if(red > factor2) {
          pixel.setRed(red + factor);
        }
        else {
          pixel.setRed(red - factor);
        }
        if(green > factor2) {
          pixel.setGreen(green + factor);
        }
        else {
          pixel.setGreen(green - factor);
        }
        if(blue > factor2) {
          pixel.setBlue(green + factor);
        }
        else {
          pixel.setBlue(green - factor);
        }
      }
    }
  }

  /*
   * sets the color with the lowest value to the given value
   */
  public void setLeastColorTo(int factor) {
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];
        int red = pixel.getRed();
        int blue = pixel.getBlue();
        int green = pixel.getGreen();

        if(red < blue && red < green) {
          pixel.setRed(factor);
        }
        else if(blue < red && blue < green) {
          pixel.setBlue(factor);
        }
        else if(green < red && green < blue) {
          pixel.setGreen(factor);
        }
      }
    }
  }

  /*
   * gives the image a purple tint
   */
  public void purpleTint() {
    double redBlueMulti = 1.5;
    double greenMulti = 0.9;
    
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];

        pixel.setRed((int)(pixel.getRed() * redBlueMulti));
        pixel.setBlue((int)(pixel.getBlue() * redBlueMulti));
        pixel.setGreen((int)(pixel.getGreen() * greenMulti));
      }
    }
  }

  /*
   * makes every color value closer to the average
   */
  public void muteColors() {
    int factor = 20;

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        Pixel pixel = pixels[i][j];
        int red = pixels[i][j].getRed();
        int green = pixels[i][j].getGreen();
        int blue = pixels[i][j].getBlue();
        int avg = (int)((red + green + blue) / 3);
        
        if(red < avg) {
          pixel.setRed(red + (avg / factor));
        }
        else {
          pixel.setRed(red - (avg / factor));
        }
        if(green < avg) {
          pixel.setGreen(green + (avg / factor));
        }
        else {
          pixel.setGreen(green - (avg / factor));
        }
        if(blue < avg) {
          pixel.setBlue(green + (avg / factor));
        }
        else {
          pixel.setBlue(green - (avg / factor));
        }
      }
    }
  }
}