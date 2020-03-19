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
    char[] chars = origin.toCharArray();
    for (int i = 0; i < origin.length(); i++) {
      chars[i] = (char) (chars[i] ^ 32); // bit XOR operation
    }
    return new String(chars);
  }

  String toUpperCase(String origin) { // a -> A A -> A
    char[] chars = origin.toCharArray();
    for (int i = 0; i < origin.length(); i++) {
      chars[i] = (char) ((chars[i] & 32) ^ chars[i]);
    }
    return new String(chars);
  }

  String toLowerCase(String origin) {
    char[] chars = origin.toCharArray();
    for (int i = 0; i < origin.length(); i++) {
      chars[i] = (char) (chars[i] | 32);
    }
    return new String(chars);
  }


}
