package module_01.lesson_10;

public class isSortedApp {
  public boolean isSorted(int[] arr) {
    for (int indx = 0; indx < arr.length - 1; indx++) {
      if (arr[indx] > arr[indx + 1]) return false;
    }
    return true;
  }
}
