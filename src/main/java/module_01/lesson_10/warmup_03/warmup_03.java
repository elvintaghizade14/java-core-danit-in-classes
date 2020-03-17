package module_01.lesson_10.warmup_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class warmup_03 {

  public Map<Character, Integer> countOfEachLetter(String s) {
    HashMap<Character, Integer> listOfLetters = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      listOfLetters.put(s.charAt(i), getCount(s.charAt(i), s));
    }
    return listOfLetters;
  }

  private int getCount(char c, String s) {
    int counter = 0;
    for (int j = 0; j < s.length(); j++) {
      if (c == s.charAt(j)) counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();

    warmup_03 r = new warmup_03();
    System.out.println(r.countOfEachLetter(s));
  }
}
