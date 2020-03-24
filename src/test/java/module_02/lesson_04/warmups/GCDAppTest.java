package module_02.lesson_04.warmups;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GCDAppTest {
  private GCDApp g;

  @BeforeEach
  void bef() {
    g = new GCDApp();
  }

  @Test
  void gcd1() {
    assertEquals(1, g.gcd(7,5));
  }

  @Test
  void gcd2() {
    assertEquals(5, g.gcd(20,5));
  }

  @Test
  void gcd3() {
    assertEquals(12, g.gcd(36, 24));
  }

  @Test
  void gcd4() {
    assertEquals(3, g.gcd(3, 9));
  }

}