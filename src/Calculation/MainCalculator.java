package Calculation;

public class MainCalculator {

  private static final char[] squareOfData = getArray();
  private static final int STEP = 5;

  public static String codeString(String text) {
    char[] textArray = text.toLowerCase().toCharArray();
    char[] codetArray = new char[textArray.length];
    for (int i = 0; i < textArray.length; i++) {
      char elementFromText = textArray[i];
      for (int j = 0; j < squareOfData.length; j++) {
        char elementFromSquare = squareOfData[j];
        if (elementFromSquare == elementFromText) {
          if (squareOfData.length > j + STEP) {
            codetArray[i] = squareOfData[j + STEP];
          } else {
            codetArray[i] = squareOfData[STEP - (squareOfData.length - j)];
          }
        }
      }
    }
    return String.copyValueOf(codetArray);
  }

  private static char[] getArray() {
    char[] m = new char[26];
    for (int i = 0; i < 26; i++) {
      m[i] = (char) ('a' + i);
    }
    return m;
  }

  public static String decodeString(String code) {
    char[] codeArray = code.toLowerCase().toCharArray();
    char[] textArray = new char[codeArray.length];
    for (int i = 0; i < codeArray.length; i++) {
      char elementFromCode = codeArray[i];
      for (int j = 0; j < squareOfData.length; j++) {
        char elementFromSquare = squareOfData[j];
        if (elementFromSquare == elementFromCode) {
          if (j - STEP >= 0) {
            textArray[i] = squareOfData[j - STEP];
          } else {
            textArray[i] = squareOfData[squareOfData.length - (STEP - j)];
          }
        }
      }
    }
    return String.copyValueOf(textArray);
  }

}
