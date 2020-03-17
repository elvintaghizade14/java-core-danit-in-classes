package module_01.lesson_09.warmup_02;

public class FormatterApp {
  public static void main(String[] args) {
    System.out.println(new Formatter1("hello")); // hello
    System.out.println(new Formatter2("helloooo")); // HELLO
    System.out.println(new Formatter3("hello dear")); // ***********
                                                    // *  HELLO  *
                                                    // ***********
  }
}
