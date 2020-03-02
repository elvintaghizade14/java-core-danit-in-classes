package lesson_12.warmup_03;

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

  public static List<String> convertIntToStr(List<Integer> listInt) {
    ArrayList<String> result = new ArrayList<>();
    for (int item : listInt) {
      result.add(String.valueOf(item));
    }
    return result;
  }
}
