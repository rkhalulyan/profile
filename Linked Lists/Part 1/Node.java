/*
 * Robert Khalulyan
 * Professor Maryam Jalal
 * Project 1 Part 1
 */

// Node class provided through project instructions
class Node {
   protected Object data;
   protected Node next;
   public  Node(Object x, Node n) {
       data = x;
       next = n;
   }
   public Node() {
       data = null;
       next = null;
   }
}