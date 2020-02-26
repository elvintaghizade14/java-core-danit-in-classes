package lesson_10.warmup_01;

public class warmup_01 {
  public String filter(String origin) {
    if (origin == null) throw new IllegalArgumentException("'null' is not a value!");
    else {
      final String VOWELS = "AEIOU";
      origin = origin.toUpperCase();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < origin.length(); i++) {
        if (!(VOWELS.contains(String.valueOf(origin.charAt(i))))) {
          sb.append(origin.charAt(i));
        }
      }
      return sb.toString();
    }
  }
}
