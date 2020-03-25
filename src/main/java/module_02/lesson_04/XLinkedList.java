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

  private void attach_next(Node curr, StringJoiner sj) {
    if (curr == null) return;
    sj.add(String.valueOf(curr.value));
    attach_next(curr.next, sj);
  }

  public String represent3r() {
    StringJoiner sj = new StringJoiner(",", "LL:(", ")");
    attach_next(head, sj);
    return sj.toString();
  }

  // size via traditional way:
  int size() {
    int size = 0;
    Node curr = head;
    while (curr != null) {
      size++;
      curr = curr.next;
    }
    return size;
  }

  // size via head recursive (with runner recursive):
  int sizer(Node curr) {
    if (curr == null) return 0;
    return sizer(curr.next) + 1;
  }

  int sizer() {
    return sizer(head);
  }

  // size via tail recursive:
  int sizetr(Node curr, int size) {
    if (curr == null) return size;
    return sizetr(curr.next, size + 1);
  }

  int sizetr() {
    return sizetr(head, 0);
  }

  // contains via traditional way
  boolean contains(int element) {
    Node curr = head;
    while (curr != null) {
      if (curr.value == element) return true;
      curr = curr.next;
    }
    return false;
  }

  boolean containsr(int element) {
    throw new IllegalArgumentException("Not implemented yet...");
  }

  void reverse() {
  }

  void reverser() {
  }

  void merge(Node head2) {

  }

  boolean containsAt(int index, int element) {
    throw new IllegalArgumentException("containsAt:Should be implemented t home");
  }

  void deleteHead() {
  }

  void deleteTail() {
  }

  void deleteAt(int index) {
  }

  void deleteValue(int value) {
  }

  void insertAfter(int index, int value) {
  }

  void insertBefore(int index, int value) {
  }

}
