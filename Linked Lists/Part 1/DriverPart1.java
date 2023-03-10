/*
* Robert Khalulyan
* Professor Maryam Jalal
* Project 1 Part 1
 */
public class DriverPart1 {
    public static void main(String[] args) {
        SimpleLinkedList sll = new SimpleLinkedList();
        sll.add(8);
        sll.add(12);
        sll.add(3);
        sll.add(14);
        sll.add(1);
        sll.add(2);
        sll.add(88);
        System.out.println("Linked List 1: ");
        // B. Printing Linked List 1
        sll.printLinkedList();
        System.out.println("");

        SimpleLinkedList sll2 = new SimpleLinkedList();
        sll2.add(1);
        sll2.add(18);
        sll2.add(3);
        sll2.add(88);
        sll2.add(3);
        // B. Printing Linked List 2
        System.out.println("Linked List 2: ");
        sll2.printLinkedList();
        System.out.println("\n");

        // A. Returning the size of linked list 1 and linked list 2
        System.out.println("Size of Linked List 1: " + sll.getSize());
        System.out.println("Size of Linked List 2: " + sll2.getSize());
        System.out.println("");

        // C. Testing to see if value 18 is Linked List 1 or 2
        System.out.println(sll.isContatined(18) + " --> should be false;");
        System.out.println(sll2.isContatined(18) + " --> should be true;");
        System.out.println("");

        // D. Adding x if x is not in the linked list
        System.out.print("Linked List 1 before: ");
        sll.printLinkedList();
        System.out.println("");
        System.out.println("...attempting to append 8 into linked list 1 (should not work)...");
        sll.appendIfNotContained(8);
        System.out.print("Linked List 1 after: ");
        sll.printLinkedList();
        System.out.println("\n");

        System.out.println("...attempting to append 15 into linked list 1 (should work)...");
        sll.appendIfNotContained(15);
        System.out.print("Linked List 1 after: ");
        sll.printLinkedList();
        System.out.println("\n");

        // E. Removing x if it is contained in the linked list
        System.out.println("...attempting to remove 15 from linked list 1 (should work)...");
        sll.removeIfContained(15);
        System.out.print("Linked List 1 after: ");
        sll.printLinkedList();
        System.out.println("\n");

        // F. Reversing linked lists
        System.out.println("Linked List 1 reversed: ");
        sll.reverse();
        sll.printLinkedList();
        System.out.println("\n");

        // G. Returning the intersection of Linked List 1 and Linked List 2
        System.out.println("Linked List 1: ");
        sll.printLinkedList();
        System.out.println("");

        System.out.println("Linked List 2: ");
        sll2.printLinkedList();
        System.out.println("");

        SimpleLinkedList sll3 = new SimpleLinkedList();
        sll3.header =  sll3.getIntersection(sll.header, sll2.header);
        System.out.println("Printing the intersection of linked list 1 and linked list 2: ");
        sll3.printLinkedList();
    }
}