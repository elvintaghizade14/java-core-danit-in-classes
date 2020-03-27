package module_02.lesson_06;

public class Result {
  boolean found;
  int index;
  int operations;

  public Result(boolean found, int index, int operations) {
    this.found = found;
    this.index = index;
    this.operations = operations;
  }

  public Result(boolean found) {
    this.found = found;
  }

  public String represent() {
    return String.format("[found=%s, index=%d, operations=%d]", found, index, operations);
  }
}
