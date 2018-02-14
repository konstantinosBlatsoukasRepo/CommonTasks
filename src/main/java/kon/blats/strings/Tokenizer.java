package kon.blats.strings;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * Created by k.blatsoukas on 1/25/2018.
 */
public class Tokenizer {

  @Test
  public void tokenizerExample() {
    StringTokenizer stringTokenizer = new StringTokenizer("(4, 5)",",");
    System.out.println(stringTokenizer.nextToken().substring(1));

    while(stringTokenizer.hasMoreTokens()) {
      String currentToken = stringTokenizer.nextToken();
      System.out.println("currentToken = " + currentToken.substring(0, currentToken.length() - 1));
    }

  }
}
