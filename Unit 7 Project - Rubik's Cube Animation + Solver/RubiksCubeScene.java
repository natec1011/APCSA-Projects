import org.code.theater.*;
import org.code.media.*;

public class RubiksCubeScene extends Scene {
  public RubiksCubeScene() {
    drawBackground();
    drawOutline();
  }

  

  /*
   * draws the given cube at one of the two angles
   */
  public void drawCube(RubiksCube cube, int angle) {
    if(angle != 0 && angle != 1) {
      System.out.println("Wrong angle parameter!");
      return;
    }
    drawTopFace(cube, angle);
    drawLeftFace(cube, angle);
    drawRightFace(cube, angle);
  }

  

  /*
   * draws the background of the theater
   */
  private void drawBackground() {
    setFillColor("gray");
    drawRectangle(0, 0, 400, 400);
  }

  

  /*
   * outlines the cube
   */
  private void drawOutline() {
    setStrokeWidth(2);
    int[] points = {200, 0, 350, 100, 350, 300, 200, 400, 50, 300, 50, 100};
    drawShape(points, true);
    drawLine(200, 200, 350, 100);
    drawLine(200, 200, 50, 100);
    drawLine(200, 200, 200, 400);
  }

  

  /*
   * draws the top facing side
   */
  private void drawTopFace(RubiksCube cube, int angle) {
    switch(angle) {
      case 0:
        setFillColor(cube.getSide(4, 02, 02));
        int[] s1 = {200, 0, 250, 33, 200, 67, 150, 33};
        drawShape(s1, true);
    
        setFillColor(cube.getSide(4, 02, 01));
        int[] s2 = {250, 33, 300, 67, 250, 100, 200, 67};
        drawShape(s2, true);
        
        setFillColor(cube.getSide(4, 02, 0));
        int[] s3 = {300, 67, 350, 100, 300, 133, 250, 100};
        drawShape(s3, true);
        
        setFillColor(cube.getSide(4, 01, 02));
        int[] s4 = {150, 33, 200, 67, 150, 100, 100, 67};
        drawShape(s4, true);
        
        setFillColor(cube.getSide(4, 01, 01));
        int[] s5 = {200, 67, 250, 100, 200, 133, 150, 100};
        drawShape(s5, true);
        
        setFillColor(cube.getSide(4, 01, 0));
        int[] s6 = {250, 100, 300, 133, 250, 167, 200, 133};
        drawShape(s6, true);
        
        setFillColor(cube.getSide(4, 0, 02));
        int[] s7 = {100, 67, 150, 100, 100, 133, 50, 100};
        drawShape(s7, true);
        
        setFillColor(cube.getSide(4, 0, 01));
        int[] s8 = {150, 100, 200, 133, 150, 167, 100, 133};
        drawShape(s8, true);
        
        setFillColor(cube.getSide(4, 0, 0));
        int[] s9 = {200, 133, 250, 167, 200, 200, 150, 167};
        drawShape(s9, true);
        break;

        
      case 1:
        setFillColor(cube.getSide(5, 02, 0));
        int[] s11 = {200, 0, 250, 33, 200, 67, 150, 33};
        drawShape(s11, true);
    
        setFillColor(cube.getSide(5, 01, 0));
        int[] s21 = {250, 33, 300, 67, 250, 100, 200, 67};
        drawShape(s21, true);
        
        setFillColor(cube.getSide(5, 0, 0));
        int[] s31 = {300, 67, 350, 100, 300, 133, 250, 100};
        drawShape(s31, true);
        
        setFillColor(cube.getSide(5, 02, 01));
        int[] s41 = {150, 33, 200, 67, 150, 100, 100, 67};
        drawShape(s41, true);
        
        setFillColor(cube.getSide(5, 01, 01));
        int[] s51 = {200, 67, 250, 100, 200, 133, 150, 100};
        drawShape(s51, true);
        
        setFillColor(cube.getSide(5, 0, 01));
        int[] s61 = {250, 100, 300, 133, 250, 167, 200, 133};
        drawShape(s61, true);
        
        setFillColor(cube.getSide(5, 02, 02));
        int[] s71 = {100, 67, 150, 100, 100, 133, 50, 100};
        drawShape(s71, true);
        
        setFillColor(cube.getSide(5, 01, 02));
        int[] s81 = {150, 100, 200, 133, 150, 167, 100, 133};
        drawShape(s81, true);
        
        setFillColor(cube.getSide(5, 0, 02));
        int[] s91 = {200, 133, 250, 167, 200, 200, 150, 167};
        drawShape(s91, true);
        break;
    }
    
  }

  

  /*
   * draws the left facing side
   */
  private void drawLeftFace(RubiksCube cube, int angle) {
    switch(angle) {
      case 0:
        setFillColor(cube.getSide(2, 0, 0));
        int[] s1 = {50, 100, 100, 133, 100, 200, 50, 167};
        drawShape(s1, true);
        
        setFillColor(cube.getSide(2, 0, 01));
        int[] s2 = {100, 133, 150, 167, 150, 233, 100, 200};
        drawShape(s2, true);
        
        setFillColor(cube.getSide(2, 0, 02));
        int[] s3 = {150, 167, 200, 200, 200, 267, 150, 233};
        drawShape(s3, true);
        
        setFillColor(cube.getSide(2, 01, 0));
        int[] s4 = {50, 167, 100, 200, 100, 267, 50, 233};
        drawShape(s4, true);
        
        setFillColor(cube.getSide(2, 01, 01));
        int[] s5 = {100, 200, 150, 233, 150, 300, 100, 266};
        drawShape(s5, true);
        
        setFillColor(cube.getSide(2, 01, 02));
        int[] s6 = {150, 233, 200, 267, 200, 333, 150, 300};
        drawShape(s6, true);
        
        setFillColor(cube.getSide(2, 02, 0));
        int[] s7 = {50, 233, 100, 267, 100, 333, 50, 300};
        drawShape(s7, true);
        
        setFillColor(cube.getSide(2, 02, 01));
        int[] s8 = {100, 267, 150, 300, 150, 367, 100, 333};
        drawShape(s8, true);
        
        setFillColor(cube.getSide(2, 02, 02));
        int[] s9 = {150, 300, 200, 333, 200, 400, 150, 367};
        drawShape(s9, true);
        break;


      case 1:
        setFillColor(cube.getSide(1, 02, 02));
        int[] s11 = {50, 100, 100, 133, 100, 200, 50, 167};
        drawShape(s11, true);
        
        setFillColor(cube.getSide(1, 02, 01));
        int[] s21 = {100, 133, 150, 167, 150, 233, 100, 200};
        drawShape(s21, true);
        
        setFillColor(cube.getSide(1, 02, 0));
        int[] s31 = {150, 167, 200, 200, 200, 267, 150, 233};
        drawShape(s31, true);
        
        setFillColor(cube.getSide(1, 01, 02));
        int[] s41 = {50, 167, 100, 200, 100, 267, 50, 233};
        drawShape(s41, true);
        
        setFillColor(cube.getSide(1, 01, 01));
        int[] s51 = {100, 200, 150, 233, 150, 300, 100, 266};
        drawShape(s51, true);
        
        setFillColor(cube.getSide(1, 01, 0));
        int[] s61 = {150, 233, 200, 267, 200, 333, 150, 300};
        drawShape(s61, true);
        
        setFillColor(cube.getSide(1, 0, 02));
        int[] s71 = {50, 233, 100, 267, 100, 333, 50, 300};
        drawShape(s71, true);
        
        setFillColor(cube.getSide(1, 0, 01));
        int[] s81 = {100, 267, 150, 300, 150, 367, 100, 333};
        drawShape(s81, true);
        
        setFillColor(cube.getSide(1, 0, 0));
        int[] s91 = {150, 300, 200, 333, 200, 400, 150, 367};
        drawShape(s91, true);
        break;
    }
    
  }

  

  /*
   * draws the right facing side
   */
  private void drawRightFace(RubiksCube cube, int angle) {
    switch(angle) {
      case 0:
        setFillColor(cube.getSide(3, 0, 0));
        int[] s1 = {250, 167, 250, 233, 200, 267, 200, 200};
        drawShape(s1, true);
        
        setFillColor(cube.getSide(3, 0, 01));
        int[] s2 = {300, 133, 300, 200, 250, 233, 250, 167};
        drawShape(s2, true);
        
        setFillColor(cube.getSide(3, 0, 02));
        int[] s3 = {350, 100, 350, 167, 300, 200, 300, 133};
        drawShape(s3, true);
        
        setFillColor(cube.getSide(3, 01, 0));
        int[] s4 = {250, 233, 250, 300, 200, 333, 200, 267};
        drawShape(s4, true);
        
        setFillColor(cube.getSide(3, 01, 01));
        int[] s5 = {300, 200, 300, 267, 250, 300, 250, 233};
        drawShape(s5, true);
        
        setFillColor(cube.getSide(3, 01, 02));
        int[] s6 = {350, 167, 350, 233, 300, 267, 300, 200};
        drawShape(s6, true);
        
        setFillColor(cube.getSide(3, 02, 0));
        int[] s7 = {250, 300, 250, 367, 200, 400, 200, 333};
        drawShape(s7, true);
        
        setFillColor(cube.getSide(3, 02, 01));
        int[] s8 = {300, 267, 300, 333, 250, 367, 250, 300};
        drawShape(s8, true);
        
        setFillColor(cube.getSide(3, 02, 02));
        int[] s9 = {350, 233, 350, 300, 300, 333, 300, 267};
        drawShape(s9, true);
        break;


      case 1:
        setFillColor(cube.getSide(0, 02, 02));
        int[] s11 = {250, 167, 250, 233, 200, 267, 200, 200};
        drawShape(s11, true);
        
        setFillColor(cube.getSide(0, 02, 01));
        int[] s21 = {300, 133, 300, 200, 250, 233, 250, 167};
        drawShape(s21, true);
        
        setFillColor(cube.getSide(0, 02, 0));
        int[] s31 = {350, 100, 350, 167, 300, 200, 300, 133};
        drawShape(s31, true);
        
        setFillColor(cube.getSide(0, 01, 02));
        int[] s41 = {250, 233, 250, 300, 200, 333, 200, 267};
        drawShape(s41, true);
        
        setFillColor(cube.getSide(0, 01, 01));
        int[] s51 = {300, 200, 300, 267, 250, 300, 250, 233};
        drawShape(s51, true);
        
        setFillColor(cube.getSide(0, 01, 0));
        int[] s61 = {350, 167, 350, 233, 300, 267, 300, 200};
        drawShape(s61, true);
        
        setFillColor(cube.getSide(0, 0, 02));
        int[] s71 = {250, 300, 250, 367, 200, 400, 200, 333};
        drawShape(s71, true);
        
        setFillColor(cube.getSide(0, 0, 01));
        int[] s81 = {300, 267, 300, 333, 250, 367, 250, 300};
        drawShape(s81, true);
        
        setFillColor(cube.getSide(0, 0, 0));
        int[] s91 = {350, 233, 350, 300, 300, 333, 300, 267};
        drawShape(s91, true);
        break;
    }
    
  }
}