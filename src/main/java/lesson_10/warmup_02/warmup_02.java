package lesson_10.warmup_02;

import java.util.*;

public class warmup_02 {
  public List<Integer> mergeLists(List<Integer> f, List<Integer> s) {
    if(f == null && s == null) throw new IllegalArgumentException("Null argument is not valid!");
    HashSet<Integer> merged = new HashSet<>();
    merged.addAll(Objects.requireNonNull(f));
    merged.addAll(s);
    return new ArrayList<>(merged);
  }
}
