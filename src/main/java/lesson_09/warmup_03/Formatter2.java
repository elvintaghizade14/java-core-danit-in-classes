package lesson_09.warmup_03;

import lesson_09.warmup_01.Formatter;

public class Formatter2 extends Formatter {
  public String s;
  public Formatter f;

  public Formatter2(Formatter1 f) {
    this.s = f.s;
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
