package module_03.lesson_32.web;

import java.util.function.BiFunction;

public class Calculator {

  public String doOperation(String xs, String ys, String ops) {
    String ans;
    try {
      int x = toInt(xs);
      int y = toInt(ys);
      int res = doParse(x, y, ops);
      ans = String.valueOf(res);
    } catch (NumberFormatException ex) {
      ans = "The number is in wrong format!";
    } catch (IllegalArgumentException ex) {
      ans = ex.getMessage();
    } catch (ArithmeticException ex) {
      ans = "Division by zero not allowed";
    } catch (Exception ex) {
      ans = String.format("Smth went wrong: %s", ex.getMessage());
    }
    return ans;
  }

  private int doParse(int x, int y, String ops) {
    switch (ops) {
      case "add":
        return doCore(x, y, Integer::sum);
      case "sub":
        return doCore(x, y, (a, b) -> a - b);
      case "mul":
        return doCore(x, y, (a, b) -> a * b);
      case "div":
        return doCore(x, y, (a, b) -> a / b);
      default:
        throw new IllegalArgumentException("Wrong Operation!");
    }
  }

  private int doCore(int x, int y, BiFunction<Integer, Integer, Integer> func) {
    return func.apply(x, y);
  }

  private int toInt(String origin) {
    return Integer.parseInt(origin);
  }
}
