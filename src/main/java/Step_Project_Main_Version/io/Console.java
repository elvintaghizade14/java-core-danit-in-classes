package Step_Project_Main_Version.io;

public interface Console {
  void print(String line);
  default void printLn(String line) {
    print(line);
    print("\n");
  }
  String readLn();
}
