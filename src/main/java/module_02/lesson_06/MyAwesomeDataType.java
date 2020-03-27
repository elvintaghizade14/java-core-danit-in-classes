package module_02.lesson_06;

public class MyAwesomeDataType {
  boolean found;
  int index;
  int operations;

  public MyAwesomeDataType(boolean found, int index, int operations) {
    this.found = found;
    this.index = index;
    this.operations = operations;
  }

  public MyAwesomeDataType(boolean found) {
    this.found = found;
  }

  public String represent() {
    return String.format("MyAwesomeDataType[found=%s, index=%d, operations=%d]", found, index, operations);
  }
}
