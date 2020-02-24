package lesson_09.warmup_01;

public class FormatterApp {
  public static void print(String s, Formatter f) {
    if (f instanceof Formatter1) System.out.println(s.toLowerCase());
    else if(f instanceof Formatter2) System.out.println(s.toUpperCase());
    else {
      s = s.toUpperCase();
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < s.length()+4; j++) {
          if (i==0 || i == 2) System.out.print('*');
          else {
            if(j == 0 || j == s.length()+3) System.out.print('*');
            else if(j == 1 || j == s.length()+2) System.out.print(' ');
            else System.out.print(s.charAt(j - 2));
          }
        }
        System.out.println();
      }
    }
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