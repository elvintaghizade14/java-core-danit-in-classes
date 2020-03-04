package lesson_13.warmup_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class warmup_01 {
  public static void main(String[] args) throws FileNotFoundException {
    List<String> subj_cont = read("subj_verb_.txt");
    HashMap<String, List<String>> subj_verbs = mapper(subj_cont);

    List<String> obj_cont = read("verb_obj_.txt");
    HashMap<String, List<String>> obj_verbs = mapper(obj_cont);

    System.out.println(firstMethod(subj_verbs, obj_verbs));
    System.out.println("---------------");
    List<String> result = secondMethodWithStream(subj_verbs, obj_verbs);
    for (String line : result) {
      System.out.println(line);
    }
  }

  private static HashMap<String, List<String>> mapper(List<String> in_cont) {
    HashMap<String, List<String>> result = new HashMap<>();
    for (String line : in_cont) {
      String[] splited = line.split("[:]");
      String[] value = splited[1].split("[,]");
      ArrayList<String> values = new ArrayList<>();
      for (String el : value) {
        values.add(el.trim());
      }
      result.put(splited[0].trim(), values);
    }
    return result;
  }

  private static List<String> read(String filename) throws FileNotFoundException {
    File file = new File(filename);
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    return br.lines().collect(Collectors.toList());
  }

  private static StringBuilder firstMethod(HashMap<String, List<String>> subj_verbs, HashMap<String, List<String>> obj_verbs) {
    StringBuilder sb = new StringBuilder();
    for (String sub : subj_verbs.keySet()) {
      for (String verb : subj_verbs.get(sub)) {
        for (String obj : obj_verbs.get(verb)) {
          sb.append(String.format("%s %s %s\n", sub, verb, obj));
        }
      }
    }
    return sb;
  }

  private static List<String> secondMethodWithStream(HashMap<String, List<String>> subj_verbs, HashMap<String, List<String>> obj_verbs) {
    return subj_verbs.keySet().stream().flatMap(subj ->
            subj_verbs.get(subj).stream().flatMap(verb ->
                    obj_verbs.get(verb).stream().map(obj ->
                            String.format("%s %s %s", subj, verb, obj)))).collect(Collectors.toList());
  }
}
