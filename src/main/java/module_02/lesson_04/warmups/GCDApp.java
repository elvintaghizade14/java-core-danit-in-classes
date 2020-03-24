package module_02.lesson_04.warmups;

public class GCDApp {
  public static int gcd(int a, int b) {
    if (a == b) return a;
    else {
      int max = Math.max(a, b);
      if (a == max) return gcd(a-b, b);
      else return gcd(a, b-a);
    }
  }

  public static void main(String[] args) {
    System.out.println(gcd(24, 36));
  }
}
