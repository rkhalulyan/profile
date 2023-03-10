
package storesimulation;

//corresponds to either an arrival or departure
public class Event {
    //can be “arrival” or “departure”

    String type;
    //if “arrival”, this will be the arrival time of a job
    //if “departure”, //this will be the departure time of a job
    int time;
    int param;
    //if “arrival”, this will be the processing time of a job; if //
    //“departure”, this will be the checkout line that had a departure event
    int queue;

    public Event() {
    }

    public Event(String type, int time, int param, int queue) {
        this.type = type;
        this.time = time;
        this.param = param;
        this.queue = queue;
    }

    public int getParam() {
        return param;
    }

    public int getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public void setParam(int param) {
        this.param = param;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }
    
    
}
