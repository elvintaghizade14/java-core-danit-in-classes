package module_01.lesson_12.warmup_04;

import java.util.ArrayList;
import java.util.List;

public class Util {
  public static List<Integer> convertStrToInt(List<String> listStr) {
    ArrayList<Integer> result = new ArrayList<>();
    for (String item : listStr) {
      result.add(Integer.parseInt(item));
    }
    return result;
  }

  public static List<String> convertIntToStr(List<Pair> listPair) {
    ArrayList<String> result = new ArrayList<>();
    for (Pair item : listPair) {
      result.add(String.format("%s:%s", item.left, item.right));
    }
    return result;
  }
}
