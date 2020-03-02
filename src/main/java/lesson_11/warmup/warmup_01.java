package lesson_11.warmup;

import java.util.*;
import java.util.stream.IntStream;

public class warmup_01 {
  public static void main(String[] args) {
    String origin = "Hello World";
    HashMap<Character, List<Integer>> map = new HashMap<>();

    IntStream.range(0, origin.length()).forEach(i -> {
      char c = origin.charAt(i);
      List<Integer> positions = map.getOrDefault(c, new ArrayList<>());
      positions.add(i);
      map.put(c, positions);
    });

    ArrayList<Character> chars = new ArrayList<>(map.keySet());
    Collections.sort(chars);
    for (char item : chars) {
      map.forEach((c, n) -> {
        if (item == c) System.out.printf("Letter: '%c', Count: %d, Positions:%s\n", c, n.size(), n);
      });
    }
  }
}
