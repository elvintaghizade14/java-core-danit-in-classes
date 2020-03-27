package module_02.lesson_05.my_linked_list;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class XlinkedList {
  static class Node {
    final int value;
    Node next;

    Node(int value) {
      this.value = value;
    }

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  Node head;

  /**
   * Add element to head of linked list
   *
   * @param value => int
   */
  public void prepend(int value) {
    head = new Node(value, head);
  }

  /**
   * Add element to end of linked list
   *
   * @param value => int
   */
  public void append(int value) {
    Node node = new Node(value);
    if (head == null) head = node;
    else {
      Node curr = head;
      while (curr.next != null) curr = curr.next;
      curr.next = node;
    }
  }

  /**
   * This is traditional way of representing linked list with using loop
   *
   * @return String
   */
  public String represent() {
    StringJoiner result = new StringJoiner(", ", "[", "]");
    for (Node curr = head; curr != null; curr = curr.next) {
      result.add(String.valueOf(curr.value));
    }
    return result.toString();
  }

  /**
   * This is recursive way of representation linked list
   *
   * @return String
   */
  public String representR() {
    StringJoiner result = new StringJoiner(", ", "[", "]");
    attach_next(head, result);
    return result.toString();
  }

  private void attach_next(Node curr, StringJoiner result) {
    if (curr == null) return;
    result.add(String.valueOf(curr.value));
    attach_next(curr.next, result);
  }

  /**
   * Traditional way of calculating size of linked list
   *
   * @return int
   */
  public int size() {
    int size = 0;
    for (Node curr = head; curr != null; curr = curr.next) size++;
    return size;
  }

  /**
   * Size of linked list via head recursion
   *
   * @return int
   */
  public int sizeHR() {
    return sizeHR(head);
  }

  private int sizeHR(Node curr) {
    if (curr == null) return 0;
    return sizeHR(curr.next) + 1;
  }

  /**
   * Size of linked list via tail recursion
   *
   * @return int
   */
  public int sizeTR() {
    return sizeTR(head, 0);
  }

  private int sizeTR(Node curr, int size) {
    if (curr == null) return size;
    return sizeTR(curr.next, size + 1);
  }

  /**
   * Traditional way of contains method
   * Returns true if linked list contains entered value
   *
   * @param element => int
   * @return boolean
   */
  public boolean contains(int element) {
    for (Node curr = head; curr != null; curr = curr.next) {
      if (curr.value == element) return true;
    }
    return false;
  }

  /**
   * Tail recursive way of contains method
   * Returns true if linked list contains entered value
   *
   * @param element => int
   * @return boolean
   */
  public boolean containsTR(int element) {
    return containsTR(head, element);
  }

  private boolean containsTR(Node curr, int element) {
    if (curr == null) return false;
    if (curr.value == element) return true;
    return containsTR(curr.next, element);
  }

  /**
   * Returns true if linked list contains entered value at exact index
   *
   * @param index   => int
   * @param element => int
   * @return boolean
   */
  public boolean containsAt(int index, int element) {
    int indx = 0;
    for (Node curr = head; curr != null; curr = curr.next, indx++) {
      if (index - 1 == indx && curr.value == element) return true;
    }
    return false;
  }

  /**
   * Delete the first element from linked list
   */
  public void deleteHead() {
    head = head.next;
  }

  /**
   * Delete the last node inside linked list
   */
  public void deleteTail() {
    Node curr = head;
    if (head.next == null) head = null;
    else {
      while (curr.next.next != null) curr = curr.next;
      curr.next = null;
    }
  }

  /**
   * Delete node at entered index
   *
   * @param index => int
   */
  public void deleteAt(int index) {
    int indx = 0;
    Node curr = head;
    Node prev;
    if (curr.next == null) {
      head = null;
    } else {
      while (curr.next != null && indx++ <= index - 1) {
        prev = curr;
        curr = curr.next;
        if (indx == index - 1) {
          prev.next = curr.next;
        }
      }
    }
  }

  /**
   * Delete node which value of node is equal to entered value
   *
   * @param value => int
   */
  public void deleteValue(int value) {
    Node curr = head;
    Node prev;
    while (curr.next != null) {
      prev = curr;
      curr = curr.next;
      if (curr.value == value) {
        prev.next = curr.next;
      }
    }
  }

  /**
   * Insert new node with entered value after entered index
   *
   * @param index => int
   * @param value => int
   */
  public void insertAfter(int index, int value) {
    Node curr = head;
    while (index-- > 1) curr = curr.next;
    Node newNode = new Node(value);
    newNode.next = curr.next;
    curr.next = newNode;
  }

  /**
   * Insert given value before given index
   *
   * @param index => int
   * @param value => int
   */
  public void insertBefore(int index, int value) {
    Node curr = head;
    Node prev = null;
    while (index-- > 1) {
      prev = curr;
      curr = curr.next;
    }
    Node newNode = new Node(value);
    newNode.next = curr;
    if (prev != null) prev.next = newNode;
  }

  /**
   * Insert given value before given index
   *
   * @param index => int
   * @param value => int
   */
  public void insertBefore2(int index, int value) {
    insertAfter(index - 1, value);
  }

  /**
   * Traditional way of reverse method of the linked list
   */
  public void reverse() {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
  }

  /**
   * Recursive way of reverse method of linked list
   */
  public void reverseR() {
    head = reverseR(head, null);
  }

  private Node reverseR(Node curr, Node prev) {
    if (curr == null) return prev;
    Node next = curr.next;
    curr.next = prev;
    return reverseR(next, curr);
  }

  public void merge(Node head2) {
    throw new IllegalArgumentException("Not implemented yet!");
  }
}