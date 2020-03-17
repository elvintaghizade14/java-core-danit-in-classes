package module_01.lesson_10.warmup_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class warmup_01Test {
  final warmup_01 ref1 = new warmup_01();

  @Test
  void test1() {
    String expected = "HLL, WRLD!";
    String actual = ref1.filter("Hello, World!");
    assertEquals(expected, actual);
  }

  @Test
  void test2() {
    String expected = "";
    String actual = ref1.filter("aeiou");
    assertEquals(expected, actual);
  }

  @Test
  void test3() {
    String expected = "";
    String actual = ref1.filter("");
    assertEquals(expected, actual);
  }

  @Test
  void test4() {
    String expected = "";
    String actual = ref1.filter(null);
    assertEquals(expected, actual);
  }

}