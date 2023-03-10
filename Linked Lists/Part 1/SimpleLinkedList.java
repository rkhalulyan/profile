/*
 * Robert Khalulyan
 * Professor Maryam Jalal
 * Project 1 Part 1
 */
public class SimpleLinkedList {
    protected Node header;
    // Class Constructor
    public SimpleLinkedList() {
        header = null;
    }
    // Appends any given element into linked list
    public void add(Object x){
        if(header == null)
            header = new Node(x, null);
        else {
            Node curr = header;
            while (curr != null) {
                if (curr.next == null) {
                    curr.next = new Node(x, null);
                    break;
                }
                curr = curr.next;
            }
        }
    }
    //Methods:

    // A. Returns size of linked list (int)
    public int getSize() {
        Node curr = header;
        int size = 0;
        while(curr != null){
             size++;
             curr = curr.next;
        }
        return size;
    }

    // B. Prints out linked list
    public void printLinkedList() {
        Node curr = header;
        while(curr != null) {
            System.out.print(curr.data + ", ");
            curr = curr.next;
        }
    }

    // C. Returns true if object is in linked list, false if otherwise
    public boolean isContatined(Object x) {
        Node curr = header;
        while(curr != null) {
            if(curr.data == x) return true;
            curr = curr.next;
        }
        return false;
    }

    // D. Appends object if not contained in linked list, does not append if otherwise
    public void appendIfNotContained(Object x) {
        Node curr = header;
        boolean isContained = false;
        while(curr != null) {
            if(curr.data == x) {
                isContained = true;
                break;
            }
            curr = curr.next;
        }
        if(isContained == false) {
            Node temp = header;
            while(temp != null) {
                if(temp.next == null){
                    temp.next = new Node(x, null);
                    break;
                }
                temp = temp.next;
            }
        }
    }

    // E. Removes object if contained in linked list
    public void removeIfContained(Object x) {
        Node curr = header;
        boolean isContained = false;
        while(curr != null) {
            if(curr.data == x) {
                isContained = true;
                break;
            }
            curr = curr.next;
        }
        if(isContained == true){
            Node temp = header;
            while(temp != null){
                if(temp.data == x)
                    header = header.next;
                if(temp.next != null) {
                    if (temp.next.data == x && temp.next.next != null)
                        temp.next = temp.next.next;
                    else if (temp.next.next == null)
                        temp.next = null;
                }
                temp = temp.next;
            }
        }
    }

    // F. Reverses linked list
    public void reverse() {
        Node startingPos = header;
        Node curr = header.next;
        while(curr != null) {
            Node temp = new Node(curr.data, header);
            header = temp;
            curr = curr.next;
        }
        startingPos.next = null;
    }

    // G. Returns a linked list of intersecting objects shared among 2 other linked lists
    public Node getIntersection(Node l1, Node l2) {
        //if both lists are empty
        if(l1 == null || l1 == null)
            return null;

        SimpleLinkedList l3 = new SimpleLinkedList();
        Node l1_pointer = l1;
        Node last_pos = new Node();
        while(l1_pointer != null){
            Node l2_pointer = l2;
            while(l2_pointer != null) {
                if(l1_pointer.data == l2_pointer.data){
                    if(l3.header == null){
                       l3.header = new Node(l1_pointer.data, null);
                       last_pos = l3.header;
                    }
                    else{
                        last_pos.next = new Node(l1_pointer.data, null);
                        last_pos = last_pos.next;
                    }
                }
                l2_pointer = l2_pointer.next;

            }
            l1_pointer = l1_pointer.next;
        }
        return l3.header;

    }

}
