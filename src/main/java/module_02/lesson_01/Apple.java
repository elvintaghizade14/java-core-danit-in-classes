package module_02.lesson_01;

public class Apple {
  public int size;

  public Apple(int size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return String.format("A[%d]", size);
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
