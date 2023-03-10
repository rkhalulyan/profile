import java.io.Serializable;
public class Faculty extends Person 
{
    String[] courses;
    public Faculty(String firstName, String lastName, int monthBirth, int dayBirth, int yearBirth, String[] courses) 
    {
        super(firstName, lastName, monthBirth, dayBirth, yearBirth);
        this.courses = courses;
    }
    public Faculty(Person p) { super(p.firstName, p.lastName, p.monthBirth, p.dayBirth, p.yearBirth);  }
    public void assignCourses(String[] courses) { this.courses = courses; }

    



}
