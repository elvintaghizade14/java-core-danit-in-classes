package lesson_10.warmup_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class warmup_01Test {

  @Test
  void test1() {
    String expected = "HLL, WRLD!";
    String actual = warmup_01.filter("Hello, World!");
    assertEquals(expected, actual);
  }

  @Test
  void test2() {
    String expected = "";
    String actual = warmup_01.filter("aeiou");
    assertEquals(expected, actual);
  }

}