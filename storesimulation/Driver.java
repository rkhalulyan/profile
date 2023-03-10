/*
Robert Khalulyan
Dana Ramirez
Daniel Tang
Angel Merchant
*/
package storesimulation;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        int queues, customersCount, minArrival, maxArrival, maxProcess, minProcess;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Job Simulator\n");
        System.out.println("How many queues do you want to simulate?");
        queues = input.nextInt();
        System.out.println("How many customers do you want to simulate?");
        customersCount = input.nextInt();
        System.out.println("What is the minimum time between job arrivals?");
        minArrival = input.nextInt();
        System.out.println("What is the maximum time between job arrivals?");
        maxArrival = input.nextInt();
        System.out.println("What is the minimum processing time for job?");
        minProcess = input.nextInt();
        System.out.println("What is the maximum processing time for job?");
        maxProcess = input.nextInt();

        Store store = new Store(queues, customersCount);
        Person[] customers = new Person[customersCount];
        Random rand = new Random();
        int prevArrival = 0;
        int procTime;
        for (int i = 0; i < customersCount; i++) {
            procTime = minProcess + rand.nextInt(maxProcess - minProcess) + 1;
            prevArrival = prevArrival +  minArrival + rand.nextInt(maxArrival - minArrival) + 1;
            Person customer;
            if (i == 0) {
                // first customer
                customer = new Person(i, procTime);
            } else {
                customer = new Person(prevArrival, procTime);
            }
            customers[i] = customer;
        }
        int customerJoined = 0;
        int currentTime = 0;
        Person newCustomer;
        while (customerJoined != customersCount || !store.customerEntertained()) {
            if (customerJoined < customersCount) {
                newCustomer = customers[customerJoined];
                if (newCustomer.getArrivalTime() <= currentTime) {
                    // customer can join
                    store.add(newCustomer, currentTime);
                    customerJoined++;
                }
            }
            // simulate queues if any customer can entertained at this time
            store.remove(currentTime);
            currentTime++;
        }
        store.printActivity();
    }

}
