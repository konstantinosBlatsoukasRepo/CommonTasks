package kon.blats.strings;

/**
 * Created by k.blatsoukas on 2/2/2018.
 */
public class BasicOperations {

  public static void main(String[] args) {
    //String concatenation
    String concatenationExampleOne = "This is a String " + "concatenation example";
    System.out.println("concatenationExampleOne = " + concatenationExampleOne);

    //String concatenation, with different data types
    //in this case and integer (a primitive)
    int age = 23;
    String myAge = "I am " + age + " years old.";
    System.out.println("myAge = " + myAge);

    //characters extraction
    String stringToBeExtracted = "abcdefg";
    char secondCharacter = stringToBeExtracted.charAt(1);
    System.out.println("secondCharacter (it should display b) = " + secondCharacter);

    //Characters extraction getChars()
    String testString = "This is a demo of the getChars method.";
    int start = 10;
    int end = 14;
    char buf[] = new char[end - start];
    testString.getChars(start, end, buf, 0);

    String demo = String.valueOf(buf);
    System.out.println("demo = " + demo + ", great success!!");

  }
}
