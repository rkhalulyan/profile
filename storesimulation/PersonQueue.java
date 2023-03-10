
package storesimulation;

public class PersonQueue {

    int totalTime; //the sum of all processing times in this queue
    //can use any structure
    //because this is a queue, you will need enqueue(), dequeue(), isEmpty()
    Person [] persons;
    int size;
    int count;

    public PersonQueue() {
        count = 0;
        totalTime = 0;
    }

    public PersonQueue(int size) {
        this.size = size;
        persons = new Person[size];
        count = 0;
        totalTime = 0;
    }
    
    void enqueue(Person p){
        totalTime += p.processingTime;
        persons[count++] = p;
    }
    
    public Person dequeue(){
        return persons[--count];
    }
    
    public Person first(){
        return persons[count-1];
    }
    
    public boolean isEmpty(){
        return count == 0;
    }

    public int getTotalTime() {
        return totalTime;
    }
    
    public boolean isFull(){
        return count == size;
    }
    
    public int getSize(){
        return count;
    }
    
}
