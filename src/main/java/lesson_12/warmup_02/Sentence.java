package lesson_12.warmup_02;

public class Sentence {
  public final String subject;
  public final String verb;
  public final String object;

  public Sentence(String subject, String verb, String object) {
    this.subject = subject;
    this.verb = verb;
    this.object = object;
  }

  @Override
  public String toString() {
    return String.format("%s %s %s", subject, verb, object);
  }
}