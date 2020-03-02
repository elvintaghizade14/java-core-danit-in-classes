package lesson_12.warmup_02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class warmup_02 {
  public static void main(String[] args) {
    // 1. input
    List<String> subjects = Arrays.asList("Noel", "The cat", "The dog");
    List<String> verbs = Arrays.asList("wrote", "chased", "slept on");
    List<String> objects = Arrays.asList("the book", "the ball", "the bed");

    // 2. process
//    ----------1st solution----------
//    for (String subject : subjects)
//      for (String verb : verbs)
//        for (String object : objects)
//          System.out.printf("%s %s %s.\n", subject, verb, object);

//    ----------2nd solution----------
//    StringBuilder sb = new StringBuilder();
//    subjects.forEach(s -> verbs.forEach(v -> objects.forEach(o ->
//            sb.append(s).append(' ').append(v).append(' ').append(o).append('\n'))));
//    System.out.println(sb.toString());

//    ----------3rd solution----------
    List<Sentence> sentences = subjects.stream().flatMap(s ->
            verbs.stream().flatMap(v -> objects.stream().map(o -> new Sentence(s, v, o))))
            .collect(Collectors.toList());

    // 3. output
    for (Sentence s : sentences) System.out.println(s.toString());
  }
}