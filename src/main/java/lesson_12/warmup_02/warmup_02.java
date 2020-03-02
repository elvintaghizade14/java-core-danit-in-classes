package lesson_12.warmup_02;

import java.util.Arrays;
import java.util.List;

public class warmup_02 {
  public static void main(String[] args) {
    List<String> subjects = Arrays.asList("Noel", "The cat", "The dog");
    List<String> verbs = Arrays.asList("wrote", "chased", "slept on");
    List<String> objects = Arrays.asList("the book", "the ball", "the bed");

//    for (String subject : subjects)
//      for (String verb : verbs)
//        for (String object : objects)
//          System.out.printf("%s %s %s.\n", subject, verb, object);

    StringBuilder sb = new StringBuilder();
    subjects.forEach(s -> verbs.forEach(v -> objects.forEach(o ->
            sb.append(s).append(' ').append(v).append(' ').append(o).append('\n'))));
    System.out.println(sb.toString());
  }
}