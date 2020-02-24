package lesson_09.warmup_02.warmup_01;

import lesson_09.warmup_01.Formatter;

public class Formatter1 extends Formatter {
  public String s;
  public Formatter1(String s) {
    this.s = s;
  }

  @Override
  public String format(String s) {
    return s.toLowerCase();
  }

  @Override
  public String toString() {
    return format(s);
  }
}
