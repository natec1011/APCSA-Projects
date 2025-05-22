import org.code.theater.*;
import org.code.media.*;
import java.util.Scanner;

public class TheaterRunner {
  public static void main(String[] args) {
    ScenePlus scene = new ScenePlus();
    String[][] imageFiles = {{"stairs2.jpg", "polnareff.jpg", "jotaro.jpg"}, 
                             {"jotaroworld.jpg", "cricket.jpg", "diotimestopjpg.jpg"}, 
                             {"the-world-time-stop.jpg", "dio2.jpg", "castle-interior.jpg"}};
    int[] index = new int[2];
    String chosenImage = "stairs2.jpg";

    outerloop:
    for(int i = 0; i < imageFiles.length; i++) { // only here because I genuinely don't know how someone can work string methods into this project
      for(int j = 0; j < imageFiles[0].length; j++) {
        if(imageFiles[i][j].equals(chosenImage)) {
          index[0] = i;
          index[1] = j;
          break outerloop;
        }
      }
    }

    System.out.println("Turn on audio!\n");

    // scanner for user input to workaround said problem
    System.out.println("Sooo I coded all of this then found out there's a memory limit AND video length limit.\nSo you'll need to run this three times.\nEnter into the console these in order, 'first', 'second', 'third'.");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    // instantiates all the necessary images
    ImagePlus stairs = new ImagePlus(imageFiles[index[imageFiles[index[0]][index[1]].indexOf(chosenImage)]][index[1]]); // second string method!
    ImagePlus stairsStopping = new ImagePlus(imageFiles[index[0]][index[1]]);
    stairsStopping.invert();
    ImagePlus stairsMuted = new ImagePlus(imageFiles[index[0]][index[1]]);
    stairsMuted.muteColors();

    ImagePlus polnareff = new ImagePlus("polnareff.jpg");
    ImagePlus polnareffStopping = new ImagePlus("polnareff.jpg");
    polnareffStopping.invert();
    ImagePlus polnareffMuted = new ImagePlus("polnareff.jpg");
    polnareffMuted.muteColors();

    ImagePlus dio = new ImagePlus("dio2.jpg");
    ImagePlus dioStopping = new ImagePlus("dio.jpg");
    dioStopping.invert();
    ImagePlus dioMuted = new ImagePlus("dio2.jpg");
    dioMuted.muteColors();
    ImagePlus dioTimeStop = new ImagePlus("dio2.jpg");
    dioTimeStop.invert();
    dioTimeStop.purpleTint();

    ImagePlus jotaro = new ImagePlus("jotaro.jpg");
    ImagePlus jotaroStopping = new ImagePlus("jotaro.jpg");
    jotaroStopping.invert();
    ImagePlus jotaroMuted = new ImagePlus("jotaro.jpg");
    jotaroMuted.muteColors();

    ImagePlus jotaroOH = new ImagePlus("jotaroworld.jpg");
    ImagePlus jotaroOHTimeStop = new ImagePlus("jotaroworld.jpg");
    jotaroOHTimeStop.invert();
    jotaroOHTimeStop.purpleTint();

    ImagePlus requiem = new ImagePlus("requiem.jpg"); // this translates to "This is reqiuem" and if you dont believe me you can copy/paste here: これがレクイエム

    ImagePlus beatdown = new ImagePlus("image_2025-01-13_180739484.png");

    // sets the text
    scene.setTextStyle(Font.SANS, FontStyle.BOLD);
    scene.setTextColor("yellow");
    scene.setFillColor("black");


    // the animation
    if(input.equals("first")) {
      // draws the first frame
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.playSound("untitled.wav");
      scene.pause(3.5);
  
      // pans dio
      for(int i = -400; i < -200; i += 5) {
        scene.drawImage(dio, 0, i, scene.getWidth());
        scene.pause(0.1);
      }
  
      // zooms in on dio's face
      scene.drawImage(dio, -530, 0, 1400);
      scene.pause(5);
  
      // cuts to polnareff
      scene.drawImage(polnareff, 0, 0, 400);
      scene.pause(0.5);
      scene.drawRectangle(40, 355, 270, 25);
      scene.drawText("At last you show yourself,", 50, 375);
      
      scene.pause(2.5);
      scene.drawImage(polnareff, 0, 0, 400);
      scene.drawRectangle(140, 355, 50, 25);
      scene.drawText("Dio!", 150, 375);
  
      // cuts to dio
      scene.pause(2.5);
      scene.drawImage(dio, -530, 0, 1400);
      scene.pause(1);
      scene.drawRectangle(100, 330, 175, 25);
      scene.drawText("Bravo, Polnareff.", 110, 350);
      scene.drawRectangle(20, 355, 350, 25);
      scene.drawText("You managed to avenge your sister", 30, 375);
      
      scene.pause(5);
      scene.drawImage(dio, -530, 0, 1400);
      scene.drawRectangle(30, 330, 265, 25);
      scene.drawText("while traveling all the way", 40, 350);
      scene.drawRectangle(80, 355, 190, 25);
      scene.drawText("from the Far East.", 90, 375);
  
      // cuts to polnareff
      scene.pause(4);
      scene.drawImage(polnareff, 0, 0, 400);
      scene.pause(1);
      scene.drawRectangle(30, 330, 255, 25);
      scene.drawText("To celebrate I shall gladly", 40, 350);
      scene.drawRectangle(90, 355, 160, 25);
      scene.drawText("take your life.", 100, 375);
  
      // cuts to dio
      scene.pause(8);
      scene.drawImage(dio, -530, 0, 1400);
      scene.pause(1.5);
      scene.drawRectangle(30, 355, 240, 25);
      scene.drawText("I'll give you one chance.", 40, 375);
  
      // cuts to the staircase
      scene.pause(3.5);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.drawRectangle(30, 355, 280, 25);
      scene.drawText("Descend two steps and live.", 40, 375);
      
      scene.pause(3.5);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.drawRectangle(10, 355, 310, 25);
      scene.drawText("I'll let you be my servant again.", 20, 375);
  
      // cuts to dio
      scene.pause(3);
      scene.drawImage(dio, -630, 0, 1400);
      scene.drawRectangle(80, 330, 220, 25);
      scene.drawText("If you choose death,", 90, 350);
      scene.drawRectangle(100, 355, 170, 25);
      scene.drawText("rise forth to me.", 110, 375);
  
      // cuts to polnareff
      scene.pause(5.5);
      scene.clear("white");
      scene.drawImage(polnareff, 0, -400, 400);
      scene.drawRectangle(70, 330, 230, 25);
      scene.drawText("At our first encounter,", 80, 350);
      scene.drawRectangle(40, 355, 290, 25);
      scene.drawText("fear overcame me like a curse.", 50, 375);
      scene.pause(1);
  
      // pans up
      for(int i = -380; i <= 20; i += 6) { // 14s
        scene.drawImage(polnareff, 0, i, 400);
        
        if(i < -245) {
          scene.drawRectangle(70, 330, 230, 25);
          scene.drawText("At our first encounter,", 80, 350);
          scene.drawRectangle(40, 355, 290, 25);
          scene.drawText("fear overcame me like a curse.", 50, 375);
        }
        else if(i < -200) {
          scene.drawRectangle(30, 355, 300, 25);
          scene.drawText("I let myself submit to your evil.", 40, 375);
        }
        else if(i < -56) {
          scene.drawRectangle(90, 330, 200, 25);
          scene.drawText("It was the beginning", 100, 350);
          scene.drawRectangle(90, 355, 200, 25);
          scene.drawText("of a futile existence.", 100, 375);
        }
        else {
          scene.drawRectangle(60, 330, 300, 25);
          scene.drawText("An existence more horrifying", 70, 350);
          scene.drawRectangle(100, 355, 180, 25);
          scene.drawText("than death itself.", 110, 375);
        }
        
        scene.pause(0.2);
      }
  
      // cuts to dio
      scene.pause(0.5);
      scene.drawImage(dio, -430, 0, 1400);
      scene.drawRectangle(30, 330, 340, 25);
      scene.drawText("A life consumed by the sole desire", 40, 350);
      scene.drawRectangle(100, 355, 200, 25);
      scene.drawText("to do your bidding.", 110, 375);
  
      // cuts to polnareff
      scene.pause(5);
      scene.drawImage(polnareff, 0, 0, 400);
      scene.drawRectangle(90, 355, 210, 25);
      scene.drawText("But that fear is gone.", 100, 375);
      
      scene.pause(4);
      scene.drawImage(polnareff, 0, 0, 400);
      scene.drawRectangle(30, 330, 370, 25);
      scene.drawText("The only thing that consumes me now", 40, 350);
      scene.drawRectangle(60, 355, 240, 25);
      scene.drawText("is a burning will to fight.", 70, 375);
      
      scene.pause(3);
      scene.drawImage(polnareff, 0, 0, 400);
      scene.drawRectangle(30, 330, 300, 25);
      scene.drawText("In the 45 days since I first met", 40, 350);
      scene.drawRectangle(40, 355, 270, 25);
      scene.drawText("Mr. Joestar and the others,", 50, 375);
      
      scene.pause(3);
      scene.drawImage(polnareff, 0, 0, 400);
      scene.drawRectangle(30, 330, 360, 25);
      scene.drawText("I've traveled the globe and watched", 40, 350);
      scene.drawRectangle(40, 355, 250, 25);
      scene.drawText("my friends die at my feet.", 50, 375);
      
      scene.pause(2);
      scene.drawImage(polnareff, 0, 0, 400);
      scene.drawRectangle(40, 355, 330, 25);
      scene.drawText("I'll never be scared of you again.", 50, 375);
  
      // cuts to dio
      scene.pause(2);
      scene.drawImage(dio, -530, 0, 1400);
  
      // cuts to stairs
      scene.pause(2.5);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.drawRectangle(50, 355, 250, 25);
      scene.drawText("Are you sure about that?", 60, 375);
  
      scene.pause(3.5);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.drawRectangle(50, 355, 240, 25);
      scene.drawText("Then climb these stairs.", 60, 375);

      scene.drawText("Restart the program", 0, 20);
    }
    else if(input.equals("second")) {
      // screen shakes and plays the banging noise
      boolean next = true;
      for(int i = 0; i < 3; i++) {
        scene.playSound("bang.wav");
        
        for(int j = 0; j < 16; j++) {
          if(next) {
            scene.drawImage(stairs, -5, 0, 410, 400, 0);
            scene.drawImage(dio, 195, 0, 100);
            scene.drawImage(polnareff, 35, 160, 125);
            scene.pause(0.2);
            next = false;
          }
          else {
            scene.drawImage(stairs, -10, 0, 410, 400, 0);
            scene.drawImage(dio, 190, 0, 100);
            scene.drawImage(polnareff, 30, 160, 125);
            scene.pause(0.2);
            next = true;
          }
        }
      }
      
      // jotaro appears
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaro, 200, 150, 200);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.playSound("bang.wav");
  
      // polnareff speaks
      scene.pause(1);
      scene.drawRectangle(30, 355, 200, 25);
      scene.drawText("Jotaro! You're okay!", 40, 375);
  
      // jotaro speaks
      scene.pause(1);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaro, 200, 150, 200);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.drawRectangle(320, 355, 70, 25);
      scene.drawText("Yeah.", 330, 375);
  
      // dio stops time
      scene.pause(1);
      scene.drawImage(dio, -530, 0, 1400);
      scene.pause(0.5);
      scene.playSound("diotheworld.wav");
      scene.drawRectangle(60, 355, 220, 25);
      scene.drawText("The World! Stop time!", 70, 375);
      scene.pause(1);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaro, 200, 150, 200);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.drawRectangle(60, 355, 220, 25);
      scene.drawText("The World! Stop time!", 70, 375);
      scene.pause(0.9);
      scene.background(stairsStopping);
      scene.drawImage(dioTimeStop, 200, 0, 100);
      scene.drawImage(jotaroStopping, 200, 150, 200);
      scene.drawImage(polnareffStopping, 40, 160, 125);
      scene.drawRectangle(60, 355, 220, 25);
      scene.drawText("The World! Stop time!", 70, 375);
      scene.pause(1.2);
      scene.background(stairsMuted);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaroMuted, 200, 150, 200);
      scene.drawImage(polnareffMuted, 40, 160, 125);

      // dio starts laughing
      scene.background(stairsMuted);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaroMuted, 200, 150, 200);
      scene.drawImage(polnareffMuted, 40, 160, 125);
      scene.playSound("diolaugh.wav");
  
      // jotaro's hand twitches
      scene.pause(9);
      scene.drawImage(jotaroMuted, -900, -200, 1800);
      scene.pause(1);
      scene.playSound("jd1.wav");
      scene.drawRectangle(70, 355, 250, 25);
      scene.drawText("(Jotaro's hand twitches)", 80, 375);
  
      // dio suspicious
      scene.pause(1);
      scene.drawImage(dio, -430, 0, 1400);
      scene.pause(8);
      scene.drawImage(jotaroMuted, -900, -200, 1800);
      scene.drawRectangle(70, 355, 250, 25);
      scene.drawText("(Jotaro's hand twitches)", 80, 375);
  
      // dio shock
      scene.pause(1);
      scene.drawImage(dio, -500, 0, 1400);
      scene.drawRectangle(130, 355, 90, 25);
      scene.drawText("What?!", 140, 375);
      scene.pause(2);
      scene.drawRectangle(90, 355, 170, 25);
      scene.drawText("He just moved!", 100, 375);
      scene.pause(2);
      scene.drawRectangle(80, 355, 180, 25);
      scene.drawText("He... Impossible!", 90, 375);
      scene.pause(1);
      scene.playSound("jd2.wav");
      scene.pause(1);
      scene.drawRectangle(70, 355, 220, 25);
      scene.drawText("His finger just moved!", 80, 375);
      scene.pause(2.5);
      scene.drawImage(dio, -500, 0, 1400);
      scene.pause(2);
      scene.drawRectangle(100, 355, 130, 25);
      scene.drawText("Could it be?", 110, 375);
      scene.pause(7.5);
      scene.drawImage(dio, -500, 0, 1400);
      scene.pause(1);
  
      // cuts to jotaro
      scene.drawImage(jotaroMuted, -1500, -500, 3400);
      scene.pause(1);
      scene.playSound("jd3.wav");
      scene.drawImage(jotaroMuted, -1500, -500, 3400);
      scene.pause(4);
      scene.drawImage(dio, -500, 0, 1400);
      scene.pause(0.5);
      scene.drawRectangle(70, 355, 240, 25);
      scene.drawText("Jotaro, can you see me?", 80, 375);
      scene.pause(3.5);
      scene.drawImage(dio, -500, 0, 1400);
      scene.drawRectangle(60, 330, 210, 25);
      scene.drawText("Or are you moving", 70, 350);
      scene.drawRectangle(70, 355, 270, 25);
      scene.drawText("your hand unconsciously?", 80, 375);
      scene.pause(3);
  
      // cuts to stairs
      scene.background(stairsMuted);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaroMuted, 200, 150, 200);
      scene.drawImage(polnareffMuted, 40, 160, 125);
      scene.pause(2);
      scene.drawRectangle(90, 355, 120, 25);
      scene.drawText("Time's up.", 100, 375);
      scene.pause(2.5);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaro, 200, 150, 200);
      scene.drawImage(polnareff, 40, 160, 125);

      scene.drawText("Restart the program", 0, 20);
    }
    else if(input.equals("third")) {
      // cuts to jotaro
      scene.drawImage(jotaro, -500, -150, 1600);
      scene.drawRectangle(20, 355, 370, 25);
      scene.drawText("So that's what stopped time feels like.", 30, 375);
  
      // jotaro goes overheaven
      scene.pause(2);
      scene.clear("white");
      scene.drawImage(jotaro, 0, 0, 400, 400, 0);
      scene.pause(3);
      scene.drawRectangle(40, 355, 350, 25);
      scene.drawText("OOORRRRRAAAAAAAAAAAAA!!!!!!!", 50, 375);
      scene.pause(2);
      scene.clear("white");
      scene.drawImage(jotaroOH, 0, 0, 400, 400, 0);
      scene.drawImage(requiem, 60, 355, 200); // this translates to "This is reqiuem" and if you dont believe me you can copy/paste here: これがレクイエム
  
      // cuts to dio
      scene.pause(3);
      scene.drawImage(dio, -500, 0, 1400);
      scene.drawRectangle(50, 355, 180, 25);
      scene.drawText("WHAAAATT?!?!?", 60, 375);
  
      // jotaro time stops
      scene.pause(2);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaroOH, 200, 150, 200);
      scene.drawImage(polnareff, 40, 160, 125);
      scene.pause(1);
      scene.drawRectangle(40, 355, 250, 25);
      scene.drawText("ああああああああああああああああああああ", 50, 375);
      scene.pause(0.9);
      scene.playSound("tsstart.wav");
      scene.background(stairsStopping);
      scene.drawImage(dioStopping, 200, 0, 100);
      scene.drawImage(jotaroOHTimeStop, 200, 150, 200);
      scene.drawImage(polnareffStopping, 40, 160, 125);
      scene.drawRectangle(40, 355, 250, 25);
      scene.drawText("ああああああああああああああああああああ", 50, 375);
      scene.pause(1.2);
      scene.background(stairsMuted);
      scene.drawImage(dioMuted, 200, 0, 100);
      scene.drawImage(jotaroOH, 200, 150, 200);
      scene.drawImage(polnareffMuted, 40, 160, 125);
  
      // jotaro's monologue
      scene.pause(1);
      scene.drawRectangle(40, 355, 170, 25);
      scene.drawText("Dio, ああああああああああああ", 50, 375);
      scene.pause(2);
      scene.drawRectangle(40, 355, 310, 25);
      scene.drawText("ああああああああああPolnareffああああああああああああああ", 50, 375);
      scene.pause(2);
      scene.drawRectangle(40, 355, 310, 25);
      scene.drawText("ああああああAvdolああああああIggyああああKakyoinああ", 50, 375);
      scene.pause(2);
      scene.drawRectangle(40, 355, 310, 25);
      scene.drawText("あああああああああああああああああああああああああああJosephああ", 50, 375);
      scene.pause(3);
      scene.background(stairsMuted);
      scene.drawImage(dioMuted, 200, 0, 100);
      scene.drawImage(jotaroOH, 200, 150, 200);
      scene.drawImage(polnareffMuted, 40, 160, 125);
      scene.drawRectangle(140, 355, 50, 25);
      scene.drawText("Dio,", 150, 375);
      scene.pause(2);
      scene.drawRectangle(140, 355, 50, 25);
      scene.drawText("あああ", 150, 375);
  
      // jotaro beats down dio
      scene.pause(2);
      scene.playSound("orebeatdown.wav");
      scene.background(stairsMuted);
      scene.drawImage(dioMuted, 200, 0, 100);
      scene.drawImage(jotaroOH, 200, 150, 200);
      scene.drawImage(polnareffMuted, 40, 160, 125);
      scene.drawImage(beatdown, 200, 150, 100, 100, 0);
  
      // ends the time stop
      scene.pause(23.9);
      scene.background(stairsMuted);
      scene.drawImage(dioMuted, 200, 0, 100);
      scene.drawImage(jotaroOH, 200, 150, 200);
      scene.drawImage(polnareffMuted, 40, 160, 125);
      scene.pause(0.5);
      scene.playSound("tsend.wav");
      scene.pause(1);
      scene.background(stairs);
      scene.drawImage(dio, 200, 0, 100);
      scene.drawImage(jotaroOH, 200, 150, 200);
      scene.drawImage(polnareff, 40, 160, 125);
  
      // dio kicks the proverbial bucket
      scene.playSound("diodeath.wav");
      for(int i = 0; i < 21; i++) {
        dio.noise();
        dio.redTint();
  
        if(i == 20) {
          dio.maxColors();
        }
        
        scene.drawImage(dio, 200, 0, 100);
        
        scene.pause(1);
        
      }
      stairs.setLeastColorTo(0);
      scene.background(stairs);
      scene.drawImage(jotaroOH, 200, 150, 200);
      scene.drawImage(polnareff, 40, 160, 125);

      scene.drawText("End", 0, 20);
    }
    else {
      scene.clear("black");
      scene.drawText("spell it correctly this time", 20, 234);
    }
    
    Theater.playScenes(scene);
  }
}