package module_02.lesson_02;

/**
 * http://www.asciitable.com/index/asciifull.gif
 * https://cdn.cs50.net/2016/x/psets/0/pset0/bulbs.html
 * http://sticksandstones.kstrom.com/appen.html
 */


public class warmup_01 {
  // abc -> ABC
  // aBc -> AbC
  // Abc -> aBC
  String invertCase(String origin) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < origin.length(); i++) {
      int c = origin.charAt(i);
      if (c > 96 && c < 123)
        result.append((char) (c - 32));
      else result.append((char) (c + 32));
    }
    return result.toString();
  }

  // abc -> ABC
  // aBc -> ABC
  // Abc -> ABC
  String toUpperCase(String origin) { // a -> A A -> A
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < origin.length(); i++) {
      int c = origin.charAt(i);
      if (c > 96 && c < 123)
        result.append((char) (c - 32));
      else result.append((char) c);
    }
    return result.toString();
  }

  // abc -> abc
  // aBc -> abc
  // Abc -> abc
  String toLowerCase(String origin) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < origin.length(); i++) {
      int c = origin.charAt(i);
      if (c > 64 && c < 91)
        result.append((char) (c + 32));
      else result.append((char) c);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    warmup_01 ref = new warmup_01();
    System.out.println(ref.invertCase("AbCdE"));
    System.out.println(ref.toUpperCase("AbCdE"));
    System.out.println(ref.toLowerCase("AbCdE"));
  }
}
