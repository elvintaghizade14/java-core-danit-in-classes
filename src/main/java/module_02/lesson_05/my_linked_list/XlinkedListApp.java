package module_02.lesson_05.my_linked_list;

import java.util.LinkedList;

public class XlinkedListApp {
  public static void main(String[] args) {
    XlinkedList xl = new XlinkedList();
    xl.prepend(1);
    xl.prepend(3);
    xl.prepend(10);
    xl.prepend(15);
    xl.append(12);

    System.out.println(xl.size());
    System.out.println(xl.sizeHR());
    System.out.println(xl.sizeTR());
    System.out.println(xl.representR());

    System.out.println(xl.contains(1));
    System.out.println(xl.contains(1000));
    System.out.println(xl.containsTR(1));
    System.out.println(xl.containsTR(1000));
    System.out.println(xl.containsAt(2, 12));
    System.out.println(xl.containsAt(3, 1));

    System.out.println("Here:");
    System.out.println(xl.representR());
    xl.reverseR();
    System.out.println(xl.representR());
    xl.deleteHead();
    System.out.println(xl.representR());
    xl.deleteTail();
    System.out.println(xl.representR());
    xl.append(124);
    System.out.println(xl.representR());
    xl.deleteAt(3);
    System.out.println(xl.representR());
    xl.deleteValue(124);
    System.out.println(xl.representR());
    xl.insertAfter(1, 111);
    System.out.println(xl.representR());
    xl.insertBefore(2, 222);
    System.out.println(xl.representR());
    xl.reverseR();
    System.out.println(xl.representR());
  }
}
