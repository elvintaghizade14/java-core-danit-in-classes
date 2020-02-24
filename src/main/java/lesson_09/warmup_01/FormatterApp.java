package lesson_09.warmup_01;

public class FormatterApp {
  public static void print(String s, Formatter f) {
    String formatted = f.format(s);
    System.out.println(formatted);
  }

  public static void main(String[] args) {
    Formatter fmt1 = new Formatter1();
    Formatter fmt2 = new Formatter2();
    Formatter fmt3 = new Formatter3();
    print("hello", fmt1); // hello
    print("hello", fmt2); // HELLO
    print("hello", fmt3); // ***********
    // *  HELLO  *
    // ***********
  }
}
