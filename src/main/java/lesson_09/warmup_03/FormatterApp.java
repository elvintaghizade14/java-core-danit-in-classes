package lesson_09.warmup_03;

public class FormatterApp {
  public static void main(String[] args) {
    System.out.println(new Formatter1("hello")); // hello
    System.out.println(new Formatter2(new Formatter1("hellllloooo")));
    System.out.println(new Formatter3("hello")); // hello
  }
}
