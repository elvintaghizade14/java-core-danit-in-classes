package module_02.lesson_03;

public class FactorialApp {
  private static int fact(int n) {
    if(n == 1) return 1;
    return n * fact(n-1);
  }

  public static void main(String[] args) {
    int N = 5;
    int f5 = fact(N);
    System.out.printf("Factorial: %d\n", f5);
  }
}
