package lesson_09.warmup_01;

public class FormatterApp {
  public static void print(String s, Formatter f) {

    if (f instanceof Formatter1) System.out.println(f.format(s));
    else if(f instanceof Formatter2) System.out.println(f.format(s));
    else System.out.println(f.format(s));
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