/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesimulation;

//corresponds to a customer
public class Person {

    int arrivalTime;
    int departureTime;
    int processingTime;
    int joiningTime;

    public Person() {
    }

    public Person(int arrivalTime, int processingTime) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public void setJoiningTime(int joiningTime) {
        this.joiningTime = joiningTime;
    }

    public int getJoiningTime() {
        return joiningTime;
    }

}
