package module_01.lesson_14.warmup_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class bracketsTest {
  private warmup_01 app;

  @BeforeEach
  public void setUp() {
    this.app =
            new warmup_01();
  }

  @Test
  public void calc1() {
    assertEquals(1, app.calc("()()()"));
  }

  @Test
  public void calc1a() {
    assertEquals(1, app.calc("()"));
  }

  @Test
  public void calc2() {
    assertEquals(2, app.calc("()(()())()"));
  }

  @Test
  public void calc3() {
    assertEquals(3, app.calc("()(()())((()()))(())()"));
  }
}