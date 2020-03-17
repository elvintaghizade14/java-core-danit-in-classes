package module_01.lesson_14.warmup_01;

import java.util.Scanner;

public class warmup_01 {
  public int calc(String origin) {
    int count = 1;
    int max = 1;
    for (int i = 0; i < origin.length() - 1; i++) {
      if (origin.charAt(i) == '(') {
        count++;
        if (origin.charAt(i + 1) == ')') {
          count--;
          i++;
        }
      } else max = Math.max(max, count--);
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();

//    warmup_01 ref = new warmup_01();
//    System.out.println(ref.calc(line));

  }
}