package lesson_10.warmup_03;

import java.util.*;
import java.util.function.BiConsumer;

public class warmup_03_v2 {

  public HashMap<Character, List<Integer>> countOfEachLetter(String s) {
    HashMap<Character, List<Integer>> listOfLetters = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      listOfLetters.put(s.charAt(i), getCount(s.charAt(i), s));
    }
    return listOfLetters;
  }

  private List<Integer> getCount(char c, String s) {
    ArrayList<Integer> listOfIndex = new ArrayList<>();
    int counter = 0;
    for (int j = 0; j < s.length(); j++) {
      if (c == s.charAt(j)) listOfIndex.add(j);
    }
    return listOfIndex;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();

    warmup_03_v2 r = new warmup_03_v2();
    r.countOfEachLetter(s).forEach((c, is) -> System.out.printf("%s : %d : %s\n", c, is.size(), is));
  }
}
