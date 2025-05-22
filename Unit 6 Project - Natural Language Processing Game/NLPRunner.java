import java.util.HashMap;
import java.util.Scanner;

public class NLPRunner {
  public static void main(String[] args) {
    // Initializations
    String[] words = FileReader.toStringArray("words.txt");
    double[] values = FileReader.toDoubleArray("values.txt");
    String[] stopWords = FileReader.toStringArray("stopwords.txt");
    Scanner input = new Scanner(System.in);
    Processor analyst = new Processor(words, values, stopWords);

    String userInput = "";
    boolean gameOver = false;
    int diff = 0;
    double target = 0.0;


    System.out.println("Type in a word or sentence within the given sentiment value.");

    // the game
    while(!gameOver) {
      target = Math.round((Math.random() * 6.72 - 3.9) * 100.0) / 100.0;
      switch(diff) {
        case 0:
          System.out.println("\nDifficulty: Easy\nSentiment Within: 2.0 of " + target);
          userInput = input.nextLine();
          System.out.println(analyst.inputResponse(userInput));
          if(target - 2.0 < analyst.analyzeSentiment(userInput) && analyst.analyzeSentiment(userInput) < target + 2.0) {
            System.out.println("\nCorrect!");
            diff++;
          }
          else {
            System.out.println("\nWrong! Try Again.");
          }
          break;
          
        case 1:
          System.out.println("\nDifficulty: Medium\nSentiment Within: 1.0 of " + target);
          userInput = input.nextLine();
          System.out.println(analyst.inputResponse(userInput));
          if(target - 1.0 < analyst.analyzeSentiment(userInput) && analyst.analyzeSentiment(userInput) < target + 1.0) {
            System.out.println("\nCorrect!");
            diff++;
          }
          else {
            System.out.println("\nWrong! Try Again.");
          }
          break;
          
        case 2:
          System.out.println("\nDifficulty: Hard\nSentiment Within: 0.5 of " + target);
          userInput = input.nextLine();
          System.out.println(analyst.inputResponse(userInput));
          if(target - 0.5 < analyst.analyzeSentiment(userInput) && analyst.analyzeSentiment(userInput) < target + 0.5) {
            System.out.println("\nCorrect!");
            diff++;
          }
          else {
            System.out.println("\nWrong! Try Again.");
          }
          break;
          
        case 3:
          System.out.println("\nDifficulty: Extreme\nSentiment Within: 0.1 of " + target);
          userInput = input.nextLine();
          System.out.println(analyst.inputResponse(userInput));
          if(target - 0.1 < analyst.analyzeSentiment(userInput) && analyst.analyzeSentiment(userInput) < target + 0.1) {
            System.out.println("\nCorrect!");
            diff++;
          }
          else {
            System.out.println("\nWrong! Try Again.");
          }
          break;
          
        case 4:
          System.out.println("\nDifficulty: IMPOSSIBLE\nExactly " + target);
          userInput = input.nextLine();
          System.out.println(analyst.inputResponse(userInput));
          if(analyst.analyzeSentiment(userInput) == target) {
            System.out.println("\nCorrect!\nYou Win!");
            gameOver = true;
          }
          else {
            System.out.println("\nWrong! Try Again.");
          }
          break;
      }
    }
  }
}