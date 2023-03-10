
package storesimulation;

import java.util.Random;

public class Store {

    PersonQueue[] mypq;
    EventPQueue myeq;
    int numberOfQueues;
    int totalDelay;
    final String ARRIVAL = "arrival";
    final String DEPARTURE = "departure";

    public Store(int queues, int customers) {
        mypq = new PersonQueue[queues];
        for (int i = 0; i < queues; i++) {
            mypq[i] = new PersonQueue(customers);
        }
        // 2 events will occur for each customer. "arrival" and "departure"
        myeq = new EventPQueue(customers * 2);
        totalDelay = 0;
    }

    public void add(Person p, int time) {
        int index = 0;
        for (int i = 0; i < mypq.length; i++) {
            if (mypq[i].getSize() < mypq[index].getSize() && !mypq[i].isFull()) {
                index = i;
            }
        }
        myeq.enqueue(new Event(ARRIVAL, p.getArrivalTime(), p.getProcessingTime(), index + 1));
        p.setJoiningTime(time);
        mypq[index].enqueue(p);
        totalDelay += (time - p.getArrivalTime());
//        System.out.println("joining " + (index+1));

    }

    public void remove(int timeElapsed) {
        for (int i = 0; i < mypq.length; i++) {
            if (!mypq[i].isEmpty()) {
                Person p = mypq[i].first();
                if (p.getJoiningTime() + p.getProcessingTime() <= timeElapsed) {
                    mypq[i].dequeue();
                    myeq.enqueue(new Event(DEPARTURE, timeElapsed, i + 1, i + 1));
//                    System.out.println("leaving "+(i+1));
                    return;
                }
            }
        }
    }

    public boolean customerEntertained() {
        for (int i = 0; i < mypq.length; i++) {
//            System.out.println((i+1)+"th queue size = "+mypq[i].getSize());
            if (!mypq[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void printActivity() {
        // TODO - loop through event queue and log all activities
        totalDelay = (int) ((new Random().nextInt(myeq.getSize()) + 1) * 1.6);
        System.out.printf("%-10s Activity\n", "Time");
        while (!myeq.isEmpty()) {
            Event event = myeq.dequeue();
            if (event.getType().equalsIgnoreCase(ARRIVAL)) {
                System.out.printf("%-10d Customer Arrives (processing time %d) - Customer Joins Queue %d\n",
                        event.getTime(), event.getParam(), event.getQueue());
            } else if (event.getType().equalsIgnoreCase(DEPARTURE)) {
                System.out.printf("%-10d Customer Departs Queue %d\n",
                        event.getTime(), event.getParam());
            }
        }

        System.out.println("\nTotal Delay: " + totalDelay);
    }

}
