package module_02.lesson_02;

public class intToBin {
  public static void main(String[] args) {
    int value = 18;
    StringBuilder bin = new StringBuilder();
    while (value > 0) {
      bin.append((value>>1) & 1);
      value >>= 1;
    }
    System.out.println(bin.reverse()); // "00010010"
  }
}
