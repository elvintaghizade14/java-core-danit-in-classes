package module_02.lesson_04.warmups;

public class GCDApp {

  public int gcd(int a, int b) {
    if (a == b) return a;
    return a == Math.max(a, b) ? gcd(a-b, b) : gcd(a, b-a);
  }
}