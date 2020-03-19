package module_02.lesson_02;

/**
 * http://www.asciitable.com/index/asciifull.gif
 * https://cdn.cs50.net/2016/x/psets/0/pset0/bulbs.html
 * http://sticksandstones.kstrom.com/appen.html
 */


public class warmup_01_v2 {
  public static void main(String[] args) {
    warmup_01_v2 ref = new warmup_01_v2();
    System.out.println(ref.invertCase("AbCdE"));
    System.out.println(ref.toUpperCase("AbCdE"));
    System.out.println(ref.toLowerCase("AbCdE"));
  }

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


}
