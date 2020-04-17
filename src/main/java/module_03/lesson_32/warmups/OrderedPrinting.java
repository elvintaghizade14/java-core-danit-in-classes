package module_03.lesson_32.warmups;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderedPrinting {

  private static String dataOrdered(int R, int C, int[][] a) {
    return IntStream.range(0, R * C).map(idx -> {
      int row = idx / C;
      int delta = idx - row * C;
      int col = (row & 1) == 0 ? delta : C - 1 - delta;
      return a[row][col];
    })
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
  }

  public static void main(String[] args) {
    int[][] a =
            {
                    {1, 2, 3},
                    {5, 6, 7},
                    {9, 10, 11},
                    {13, 14, 15},
                    {17, 18, 19},
                    {21, 22, 23},
            };

    System.out.println(dataOrdered(a.length, a[0].length, a));
  }

}