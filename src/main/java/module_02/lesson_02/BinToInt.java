package module_02.lesson_02;

public class BinToInt {
  public static void main(String[] args) {
    String binary = "00010011";
    int value = 0;
    for (int i = 0; i < binary.length(); i++) {
      value += Integer.parseInt(String.valueOf(binary.charAt(i)))
              * Math.pow(2, binary.length()-i-1);

    }
    System.out.println(value);
  }
}
