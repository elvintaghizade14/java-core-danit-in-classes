package lesson_10.warmup_02;

import lesson_10.warmup_01.warmup_01;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class warmup_02Test {
  final warmup_02 ref = new warmup_02();

  @Test
  void test1() {
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
    ArrayList<Integer> actual = (ArrayList<Integer>) ref.mergeLists(Arrays.asList(1, 3, 5), Arrays.asList(3, 4, 5));
    assertEquals(expected, actual);
  }

  @Test
  void test2() {
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
    ArrayList<Integer> actual = (ArrayList<Integer>) ref.mergeLists(Arrays.asList(1, 3, 4, 5),
            Arrays.asList(3, 4, 5));
    assertEquals(expected, actual);
  }

  @Test
  void test3() {
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
    ArrayList<Integer> actual = (ArrayList<Integer>) ref.mergeLists(null, null);
    assertEquals(expected, actual);
  }
}