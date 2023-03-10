/*
* Robert Khalulyan
* Professor Maryam Jalali
* Project 1 - Part 2
 */
import java.awt.*;
import java.util.Scanner;
public class DriverPart2 {
    public static void main(String[] args){
        // Allocated an ambigious amount of space so user can ideally input as many polynomials as they wish
        LinkedList[] polyArray = new LinkedList[100];
        Scanner scnr = new Scanner(System.in);

        while(true){
            char input = display(scnr);
            if(input == 'i')
            {
                System.out.println("input: enter the index number of polynomial and how many terms");
                int index = scnr.nextInt();
                int term = scnr.nextInt();
                polyArray[index] = new LinkedList();

                double coef;
                int exponent;
                for(int i = 0; i < term; i++) {
                    System.out.println("enter coef and exponent for term " + (i + 1));
                    coef = scnr.nextDouble();
                    exponent = scnr.nextInt();
                    polyArray[index].insertInOrder(coef, exponent);
                }
                polyArray[index].sort();
                polyArray[index].printPoly();
                System.out.println("\n");
            }
            else if(input == 'a')
            {
                System.out.println("add: enter the 2 indices you wish to add together");
                int index1 = scnr.nextInt();
                int index2 = scnr.nextInt();

                System.out.println("enter the index of the sum");
                int indexSum = scnr.nextInt();

                polyArray[indexSum] = new LinkedList();
                polyArray[indexSum].addPoly(polyArray[index1], polyArray[index2]);
                polyArray[indexSum].sort();
                polyArray[indexSum].printPoly();
                System.out.println();
            }
            else if(input == 's')
            {
                System.out.println("subtract: enter the 2 indices you wish to subtract together");
                int index1 = scnr.nextInt();
                int index2 = scnr.nextInt();

                System.out.println("enter the index of the difference");
                int indexDifference = scnr.nextInt();

                polyArray[indexDifference] = new LinkedList();
                polyArray[indexDifference].subtractPoly(polyArray[index1], polyArray[index2]);
                polyArray[indexDifference].sort();
                polyArray[indexDifference].printPoly();
                System.out.println();
            }
            else if(input == 'm')
            {
                System.out.println("multiply: enter the 2 indices you wish to multiply together");
                int index1 = scnr.nextInt();
                int index2 = scnr.nextInt();

                System.out.println("enter the index of the product");
                int indexProduct = scnr.nextInt();

                polyArray[indexProduct] = new LinkedList();
                polyArray[indexProduct].multPoly(polyArray[index1], polyArray[index2]);
                polyArray[indexProduct].sort();
                polyArray[indexProduct].printPoly();
                System.out.println();


            }
            else if(input == 'e')
            {
                System.out.println("evaluate: please enter a value");
                int value = scnr.nextInt();
                System.out.println("please enter the index of the polynomial you wish to use");
                int index = scnr.nextInt();
                double solution = polyArray[index].evalPoly(value);
                System.out.println(solution + "\n");

                }
            else if(input == 'p')
            {
                System.out.println("print: please enter the index of the polynomial you wish to print: ");
                int index = scnr.nextInt();
                polyArray[index].printPoly();
                System.out.println();
            }
            else if(input == 'q')
            {
                System.out.println("Bye-bye!");
                break;
            }
            else
            {
                System.out.println("\nYour input was invalid, please input from the options provided... \n");
            }

        }
    }

    // Display method used to display the menue and declutter main method
    public static char display(Scanner scnr){
        char input = ' ';

        System.out.println("Enter what you want: ");
        System.out.println("i for input ");
        System.out.println("a for add ");
        System.out.println("s for subtract ");
        System.out.println("m for multiply ");
        System.out.println("e for evaluate ");
        System.out.println("p for print ");
        System.out.println("q for quit ");

        return scnr.next().charAt(0);
    }
}
