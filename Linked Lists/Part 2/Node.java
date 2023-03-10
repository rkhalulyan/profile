/*
 * Robert Khalulyan
 * Professor Maryam Jalali
 * Project 1 - Part 2
 */
public class Node {
    // Node's data is an object from our PolyTerm Class
    protected PolyTerm data;
    protected Node next;

    // constructor with no parameters
    public Node(){
        data = new PolyTerm();
        next = null;
    }

    // Constructor with only data parameters
    public Node(double coef, int exponent){
        if (data == null)
            data = new PolyTerm();
        data.setPolyTerm(coef, exponent);
        next = null;
    }

    //Constructor with all 3 parameters, data and next
    public Node(double coef, int exponent, Node y){
        if (data == null)
            data = new PolyTerm();
        data.setPolyTerm(coef, exponent);
        next = null;
    }

}
