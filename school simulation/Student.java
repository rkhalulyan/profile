import java.io.Serializable;
public class Student extends Person 
{
    String major;
    public Student(String firstName, String lastName, int monthBirth, int dayBirth, int yearBirth, String major) 
    {
        super(firstName, lastName, monthBirth, dayBirth, yearBirth);
        this.major = major;
    }
    public Student(Person p) { super(p.firstName, p.lastName, p.monthBirth, p.dayBirth, p.yearBirth); }
    public String toString() { return this.firstName + " " + this.lastName; }
    public void setMajor(String major) { this.major = major; }

}
