package module_02.lesson_06.warmups;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

  boolean check(int n) {
    List<Integer> digits = new ArrayList<>();
    while (n  > 0) {
      digits.add(n % 10);
      n /= 10;
    }
    for (int i = 0; i < digits.size()/2; i++) {
      if (!digits.get(i).equals(digits.get(digits.size() - i - 1))) return  false;
    }
    return true;
  }
}