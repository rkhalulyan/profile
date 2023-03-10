import java.io.Serializable;

public class Person implements Serializable {
    String firstName; //first Name
    String lastName; //last Name
    int monthBirth;//month of date of birth 
    int dayBirth; //day of date of birth
    int yearBirth; //year of date of birth

    //constructor
    public Person (String firstName, String lastName, int monthBirth, int dayBirth, int yearBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthBirth = monthBirth;
        this.dayBirth = dayBirth;
        this.yearBirth = yearBirth;
    }
    public String toString() { return this.firstName + " " + this.lastName + " " + this.monthBirth + " " + this.dayBirth +  " " + this.yearBirth; }

}
