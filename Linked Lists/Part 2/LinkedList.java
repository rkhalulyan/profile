/*
 * Robert Khalulyan
 * Professor Maryam Jalali
 * Project 1 - Part 2
 */
import java.awt.font.TextMeasurer;
import java.util.Scanner;

public class LinkedList {
    protected Node header;
    protected Scanner scnr = new Scanner(System.in);

    // Constructor
    public LinkedList() { header = null;}

    // Function adds polynomials in order it was inputted then sent to a sort function to order the poly
    public void insertInOrder(double coef, int exponent){
        Node curr = header;
        if (header == null) {
            header = new Node(coef, exponent, null);
            curr = header;
            return;
        }
        while(curr != null) {
            if(curr.next == null){
                curr.next = new Node(coef, exponent, null);
                return;
            }
            curr = curr.next;
        }
    }

    /*
    * Sets polynomial in order from highest exponenet to lowest exponent
    * For add/subtract methods, adds/subtracts terms with equal exponents
    */
    public void sort(){
        Node curr = header, indx = null;
        double tempCoef;
        int tempExp;
        if(header == null)
            return;
        else{
            while(curr != null){
                indx = curr.next;
                while(indx != null){
                    if(curr.data.getExponent() < indx.data.getExponent()){
                        tempCoef = curr.data.getCoef();
                        tempExp = curr.data.getExponent();
                        curr.data.setPolyTerm(indx.data.getCoef(), indx.data.getExponent());
                        indx.data.setPolyTerm(tempCoef, tempExp);
                    }else if(curr.data.getExponent() == indx.data.getExponent()){
                        curr.data.setPolyTerm(curr.data.getCoef()+indx.data.getCoef(), curr.data.getExponent());
                    }
                    indx = indx.next;
                }
                curr = curr.next;
            }
            curr = header;
            while (curr != null && curr.next != null) {
                if(curr.data.getExponent() == curr.next.data.getExponent()){
                    curr.next = curr.next.next;
                }
                curr = curr.next;
            }
        }
    }

    /*
     *  Method adds terms into list, in no order. Sort is then used to order
     *  and add terms with equal exponents
     */
    public void addPoly(LinkedList l1, LinkedList l2) {
        Node curr1 = l1.header;
        while(curr1 != null){
            this.insertInOrder(curr1.data.getCoef(), curr1.data.getExponent());
            curr1 = curr1.next;
        }

        Node curr2 = l2.header;
        while(curr2 != null){
            this.insertInOrder(curr2.data.getCoef(), curr2.data.getExponent());
            curr2 = curr2. next;
        }
    }

    /* Method subtracts terms into list, in no order. Sort is then used to order the list
    *  and subtract terms with equal exponents
    */
    public void subtractPoly(LinkedList l1, LinkedList l2) {
        Node curr = l1.header;
        while(curr != null){
            this.insertInOrder(curr.data.getCoef(), curr.data.getExponent());
            curr = curr.next;
        }

       Node curr2 = l2.header;
        while(curr2 != null){
            double coefFlipped = -1*curr2.data.getCoef();
            this.insertInOrder(coefFlipped, curr2.data.getExponent());
            curr2 = curr2. next;
        }
    }

    // Method uses "FOIL" algorithm using nested loops to multiply 2 lists together
    public void multPoly(LinkedList l1, LinkedList l2){
        Node curr = l1.header, indx = null;
            while(curr != null){
                indx = l2.header;
                while(indx != null){
                    this.insertInOrder( curr.data.getCoef()*indx.data.getCoef(), curr.data.getExponent()+indx.data.getExponent());
                    indx = indx.next;
                }
                curr = curr.next;
              }
    }

    // Method takes a value and takes "x's" place in poly to evaluate the product
    public double evalPoly(int value){
        Node curr = header;
        double solution = 0;
        while(curr!=null){
            solution += curr.data.getCoef()*Math.pow(value, curr.data.getExponent());
            curr = curr.next;
        }
        return solution;
    }

    public void printPoly(){
        Node curr = header;
        while(curr != null){
            if(curr.next == null)
                System.out.print(curr.data.toString());
            else
                System.out.print(curr.data.toString() + " + ");
            curr = curr.next;
        }
    }

}
