package lesson_12.warmup_03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class fileIO {
  public static void main(String[] args) throws IOException {
    List<Integer> randoms = generate100(100, -30, 30);
    write(randoms, "file1.txt");
    List<Integer> randoms2 = read("file1.txt");
    List<Integer> sorted_randoms = sort(randoms2);
    write(sorted_randoms, "file2.txt");
  }

  private static List<Integer> generate100(int count, int min, int max) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < count; i++) list.add((int) (Math.random() * (max - min + 1) + min));
    return list;
  }

  private static List<Integer> read(String name) throws IOException {
    File ifile = new File(name);
    FileReader fr = new FileReader(ifile);
    BufferedReader br = new BufferedReader(fr);
    List<String> lines = br.lines().collect(Collectors.toList());
    ArrayList<Integer> nums = new ArrayList<>();
    for (String el : lines) {
      nums.add(Integer.parseInt(el));
    }
    br.close();
    return nums;
  }

  private static List<Integer> sort(List<Integer> data) {
    return data.stream().sorted().collect(Collectors.toList());
  }

  private static void write(List<Integer> processed, String fileName) throws IOException {
    File ofile = new File(fileName);
    BufferedWriter bw = new BufferedWriter(new FileWriter(ofile));
    for (Integer line : processed) {
      bw.write(line.toString());
      bw.write("\n");
    }
    bw.close();
  }

}
