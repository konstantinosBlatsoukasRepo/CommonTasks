package kon.blats.common.methods;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by k.blatsoukas on 2/6/2018.
 */
public final class PhoneNumber implements Cloneable {
  private final short areaCode, prefix, lineNum;

  public PhoneNumber(short areaCode, short prefix, short lineNum) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNum = lineNum;
  }

  @Override
  public PhoneNumber clone() {
    try {
      return (PhoneNumber) super.clone();
    } catch(CloneNotSupportedException exception) {
      throw new AssertionError();
    }
  }

  public static void main(String[] args) {


    Map<String, Double> cummulativeEnergies = new HashMap<>();

    Double k = cummulativeEnergies.get("a");
    if (k == null) {
      System.out.println("A null number fetched");
    }

    PhoneNumber firstPhoneNumber = new PhoneNumber((short)12, (short)13, (short)1);
    System.out.println(firstPhoneNumber.hashCode());

    PhoneNumber secondPhoneNumber = firstPhoneNumber.clone();
    System.out.println(secondPhoneNumber.hashCode());


  }

}
