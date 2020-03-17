package module_01.lesson_10.warmup_02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    ArrayList<Integer> expected = new ArrayList<>(Collections.singletonList(1));
    ArrayList<Integer> actual = (ArrayList<Integer>) ref.mergeLists(null, null);
    assertEquals(expected, actual);
  }

  @Test
  void test4() {
    ArrayList<Integer> expected = new ArrayList<>(Collections.singletonList(1));
    ArrayList<Integer> actual = (ArrayList<Integer>)
            ref.mergeLists(Collections.singletonList(1), Collections.emptyList());
    assertEquals(expected, actual);
  }

  @Test
  void test5() {
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-1, 1, 2, 3, 4, 5));
    ArrayList<Integer> actual = (ArrayList<Integer>)
            ref.mergeLists(Arrays.asList(1, 2, 2), Arrays.asList(1, 2, 3, 5, 4, -1));
    assertEquals(expected, actual);
  }
}