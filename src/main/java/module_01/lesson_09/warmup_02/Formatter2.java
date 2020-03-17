package module_01.lesson_09.warmup_02;

import module_01.lesson_09.warmup_01.Formatter;

public class Formatter2 extends Formatter {
  public String s;

  public Formatter2(String s) {
    this.s = s;
  }

  @Override
  public String format(String s) {
    return s.toUpperCase();
  }

  @Override
  public String toString() {
    return format(s);
  }
}
