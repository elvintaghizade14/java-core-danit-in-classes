package module_02.lesson_04;

import java.util.StringJoiner;

public class XLinkedList {

  static class Node {
    final int value;
    Node next;

    Node(int value) {
      this.value = value;
    }

    Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  Node head;

  void prepend(int value) {
    Node node = new Node(value);
    node.next = head;
    head = node;
  }

  void prepend2(int value) {
    head = new Node(value, head);
  }

  void prepend3(int value) {
    head = new Node(value, head);
  }

  void append(int value) {
    Node node = new Node(value);
    if (head == null) {
      head = node;
    } else {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = node;
    }
  }

  public String represent() {
    StringJoiner sj = new StringJoiner(",", "LL:(", ")");
    Node curr = head;
    while (curr != null) {
      sj.add(String.valueOf(curr.value));
      curr = curr.next;
    }
    return sj.toString();
  }

  public String represent2() {
    StringJoiner sj = new StringJoiner(",", "LL:(", ")");
    for (Node curr = head; curr != null; curr = curr.next) {
      sj.add(String.valueOf(curr.value));
    }
    return sj.toString();
  }

  public String represent3r() {
    StringJoiner sj = new StringJoiner(",", "LL:(", ")");
    represent3r(head, sj);
    return sj.toString();
  }

  private void represent3r(Node curr, StringJoiner sj) {
    if (sj == null) return;
    represent3r(curr.next, sj);
  }


}
