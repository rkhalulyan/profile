package storesimulation;


public class EventPQueue {
    private Event[] pQueue;
    private int index;
     
    public EventPQueue(int capacity){
        pQueue = new Event[capacity];
        index =0;
    }
     
    public void enqueue(Event item ){
        pQueue[index++] = item;
    }
     
    public Event dequeue(){
        if(index == 0){
            return null;
        }
        int maxIndex = 0;
        for (int i=1; i<index; i++) { 
            if (pQueue[i].time < pQueue[maxIndex].time) { 
                maxIndex = i; 
            } 
        } 
        Event result = pQueue[maxIndex]; 
        index--; 
        pQueue[maxIndex] = pQueue[index]; 
        return result;
    }
    
    public boolean isEmpty(){
        return index == 0;
    }
    
    public int getSize(){
        return index;
    }
}
