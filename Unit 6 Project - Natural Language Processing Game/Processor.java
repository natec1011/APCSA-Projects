import java.util.HashMap;
import java.util.ArrayList;

/**
 * A class to process the sentiment of a given sentence.
 */
public class Processor {
  private String[] words;
  private double[] values;
  private String[] stopWords;
  private HashMap<String, Double> sentiments = new HashMap<String, Double>();
  private ArrayList<String> strings = new ArrayList<String>();
  private ArrayList<Double> doubles = new ArrayList<Double>();

  /**
   * Sets the instance variables of the object.
   *
   * @param words The String array of every word.
   * @param values The double array of each word's corresponding value.
   * @param stopWords The String array of every stop word.
   */
  public Processor(String[] words, double[] values, String[] stopWords) {
    this.words = words;
    this.values = values;
    this.stopWords = stopWords;

    toHashMap();
  }

  /**
   * Adds each word as the key to a HashMap and makes each word's corresponding sentiment value the value.
   */
  public void toHashMap() {
    for(int i = 0; i < words.length; i++) {
      sentiments.put(words[i], values[i]);
    }
  }

  /**
   * Adds the values to each Arraylist.
   */
  public void arrayListRequirement() {
    for(double dbl : values) {
      doubles.add(dbl);
    }
    for(String str : words) {
      strings.add(str);
    }
  }

  /**
   * Gets every value of the sentence and returns it all in one String.
   *
   * @paramtext The sentence to analyze.
   */
  public String inputResponse(String text) {
    double sentiment = Math.round(analyzeSentiment(text) * 100.0) / 100.0;
    String noNegatives = removedNegativeWords(text);
    double sentimentPositive = Math.round(analyzeSentiment(noNegatives) * 100.0) / 100.0;
    double percentNonStopWords = Math.round(percentNonStopWords(text) * 100.0) / 100.0;
    
    return "\nAverage Sentiment: " + sentiment + "\nAvg Sentiment Without Negative Words: " + sentimentPositive + "\nPercentage of Non-Stop Words: " + percentNonStopWords + "%";
  }

  /**
   * Gets the average sentiment value of the entire sentence.
   *
   * @param text The sentence to analyze.
   */
  public double analyzeSentiment(String text) {
    String[] splitText = text.split("[,\\.\\s\\?\\!]");
    double result = 0.0;
    int count = 0;

    for(String word : splitText) {
      Double senti = sentiments.get(word.toLowerCase());
      if(senti != null) {
        result += senti;
        count++;
      }
    }
    
    return result / count;
  }

  /**
   * Takes the given sentence and removes any negative words then returns it as a String.
   *
   * @param text The sentence to analyze.
   */
  public String removedNegativeWords(String text) {
    String[] splitText = text.split("[,\\.\\s\\?\\!]");
    String result = "";

    for(String word : splitText) {
      Double senti = sentiments.get(word.toLowerCase());
      if(senti == null) {
        result += word + " ";
        continue;
      }
      if(senti > 0.0) {
        result += word + " ";
      }
    }

    return result;
  }

  /**
   * Returns the percentage of words that are stop words.
   *
   * @param text The sentence to analyze.
   */
  public double percentStopWords(String text) {
    String[] splitText = text.split("[,\\.\\s\\?\\!]");
    int count = 0;

    for(String word : splitText) {
      for(String stopWord : stopWords) {
        if(word.equals(stopWord)) {
          count++;
        }
      }
    }
    
    return ((double)count / splitText.length) * 100;
  }

  /**
   * Returns the percentage of words that are not stop words.
   *
   * @param text The sentence to analyze.
   */
  public double percentNonStopWords(String text) {
    String[] splitText = text.split("[,\\.\\s\\?\\!]");
    int count = 0;

    for(String word : splitText) {
      for(String stopWord : stopWords) {
        if(word.equals(stopWord)) {
          count++;
        }
      }
    }
    
    return (1 - (double)count / splitText.length) * 100;
  }

  /**
   * Returns the sentiment value of a given word.
   *
   * @param word The word to get the sentiment value of.
   */
  public double getSentiment(String word) {
    return sentiments.get(word);
  }

  /**
   * Returns a String of every word in the word list.
   */
  public String getWords() {
    String list = "";
    for(String word : words) {
      list += word + "\n";
    }
    
    return list;
  }

  /** 
   * Returns a String of every sentiment value in the values list.
   */
  public String getValues() {
    String list = "";
    for(double value : values) {
      list += value + "\n";
    }
    
    return list;
  }

  /**
   * Returns a string of every stop word in a given sentence.
   *
   * @param text1 The sentence to analyze.
   */
  public String getStopWordsInSentence(String text1) {
    String[] splitText = text1.split("[,\\.\\s\\?\\!]");
    String text = "";

    for(String word : splitText) {
      for(String stopWord : stopWords) {
        if(word.equals(stopWord)) {
          text += word + "\n";
        }
      }
    }
    
    return text;
  }
}