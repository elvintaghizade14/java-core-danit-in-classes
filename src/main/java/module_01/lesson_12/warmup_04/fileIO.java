package module_01.lesson_12.warmup_04;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class fileIO {
  public static void main(String[] args) throws IOException {

    List<Pair> pairs = generate100(100, -30, 30);
    List<String> randomsStr = Util.convertIntToStr(pairs);
    write(randomsStr, "file1.txt");
    List<String> randoms2Str = read("file1.txt");
    List<Integer> randoms2Int = Util.convertStrToInt(randoms2Str);
    List<Integer> sorted_randomsInt = sort(randoms2Int);
//    List<String> sorted_randomsStr = Util.convertIntToStr(sorted_randomsInt);
//    write(sorted_randomsStr, "file2.txt");
  }

  private static ArrayList<Pair> generate100(int count, int min, int max) {
    ArrayList<Pair> result = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      Pair pairs = new Pair((int) (Math.random() * (max - min + 1) + min), (int) (Math.random() * (max - min + 1) + min));
      result.add(pairs);
    }
    return result;
  }

  private static List<String> read(String name) throws IOException {
    File ifile = new File(name);
    FileReader fr = new FileReader(ifile);
    BufferedReader br = new BufferedReader(fr);
    List<String> lines = br.lines().collect(Collectors.toList());
    br.close();
    return lines;
  }

  private static List<Integer> sort(List<Integer> data) {
    return data.stream().sorted().collect(Collectors.toList());
  }

  private static void write(List<String> processedL, String fileName) throws IOException {
    File ofile = new File(fileName);
    BufferedWriter bw = new BufferedWriter(new FileWriter(ofile));
    for (String line : processedL) {
      bw.write(line);
      bw.write("\n");
    }
    bw.close();
  }

}
