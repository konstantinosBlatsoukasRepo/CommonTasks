package kon.blats.strings;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * Created by k.blatsoukas on 1/25/2018.
 */
public class Tokenizer {

  @Test
  public void tokenizerExample() {
    StringTokenizer stringTokenizer = new StringTokenizer("Konstantinos::Mitsos","::");

    while(stringTokenizer.hasMoreTokens()) {
      String currentToken = stringTokenizer.nextToken();
      System.out.println("currentToken = " + currentToken);
    }

  }
}
