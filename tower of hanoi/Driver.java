/*
Robert Khalulyan,
Dana Ramirez,
Angel Merchant,
and Daniel Tang.
*/

import java.util.Stack;
import java.lang.annotation.Target;
import java.util.Scanner;
public class Driver
{
  public static int counter = 0;
  public static Stack<Integer>[]  pillars = new Stack[4];
    
  public static void main(String[] args) 
  {
      //creating the pillars 
       pillars[1] = new Stack<Integer>();
       pillars[2] = new Stack<Integer>();
       pillars[3] = new Stack<Integer>();
      
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter the number of Disks: ");
       int numDisks = scan.nextInt();
       System.out.print("Enter the starting pillar: ");
       int startingPillar = scan.nextInt();
       System.out.print("Enter the target pillar: ");
       int targetPillar = scan.nextInt();
       towerOfHanoi(numDisks, startingPillar, targetPillar);
  }
  public static void towerOfHanoi(int numOfDisc, int startPillar, int targetPillar)
  {
    int helperPillar = 6 - startPillar - targetPillar;
    if (numOfDisc == 0) return;
    // populate the starting pillar
    for (int x = numOfDisc; x > 0; x -= 1)
      pillars[startPillar].push(x);
    display();
    move(numOfDisc-1, startPillar, helperPillar, targetPillar);
  }
  public static void move(int numOfDisc, int startingPillar, int helpingPillar, int targetPillar)
  {
        if (numOfDisc >= 0)
        {
            move(numOfDisc-1, startingPillar, targetPillar, helpingPillar);
            int temp = pillars[startingPillar].pop();
            pillars[targetPillar].push(temp);
            display();
            move(numOfDisc-1, helpingPillar, startingPillar, targetPillar);
        }
  }
  public static void display()
  {
    System.out.println("t" + counter + "Pillar 1: "  + pillars[1]);
    System.out.println("t" + counter + "Pillar 2: " + pillars[2]);
    System.out.println("t" + counter + "Pillar 3: " + pillars[3]);  
    counter += 1; 
  }
 
    
    
    
   
}