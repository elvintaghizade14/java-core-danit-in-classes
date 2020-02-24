package lesson_09.warmup_02;

import lesson_09.warmup_01.Formatter;

public class Formatter3 extends Formatter{
  public String s;

  public Formatter3(String s) {
    this.s = s;
  }

  @Override
  public String format(String s) {
    s = s.toUpperCase();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < s.length()+4; j++) {
        if (i==0 || i == 2) sb.append('*');
        else {
          if(j == 0 || j == s.length()+3) sb.append('*');
          else if(j == 1 || j == s.length()+2) sb.append(' ');
          else sb.append(s.charAt(j - 2));
        }
      }
      sb.append('\n');
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return format(s);
  }
}
