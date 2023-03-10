import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class University implements School
{
    String universityName;
    String motto;
    Person[] people = new Person[50];
    String[] majors = 
    { 
      "Hardware Architecture", "Information Analytics", "Quantum Computing", "Undecided"
    };
    String[] courses = 
    { 
      "Computers", "Advanced Physics", "Quantum Entanglement", "Parallel Programming", 
      "Advance Algorithms", "FPGA Programming", "Hardware Design", "Embedded Systems", 
      "Signal Processing", "Artificial Intelligence", "Bayesian Logic", "Probability"
    };
    File createdFile = new File("UniversityPersons.per");
    boolean fileTrue = createdFile.exists();
    {
    if (!fileTrue) {
      String[] courses_Bruce = { "Bayesian Logic", "Artificial Intelligence", "Hardware Design" };
      String[] courses_Diana = { "Hardware Design", "FPGA Programming", "Embedded Systems" };
      String[] courses_Barbara = { "Probability", "Signal Processing", "Advance Algorithms" };
      String[] courses_Charles = { "Signal Processing", "Embedded Systems", "Parallel Programming" };
    
      people[0] = new Faculty("Bruce", "Wayne", 9, 27, 1995, courses_Bruce);
      people[1] = new Faculty("Diana","Prince", 11, 5, 2006, courses_Diana);
      people[2] = new Faculty("Barbara", "Gordon", 5, 23, 1980, courses_Barbara);
      people[3] = new Faculty("Charles","Xavier", 11, 5, 1966, courses_Charles);
      
      people[4] = new Student("Billy", "Baston", 7, 12, 1990, "Information Analytics");
      people[5] = new Student("Carol", "Danvers", 4, 9, 1992, "Quantum Computing");
      people[6] = new Student("Clark", "Kent", 5, 5, 1994 , "Hardware Architecture");
      people[7] = new Student("Kara", "Zorel", 4, 13, 1989, "Hardware Architecture");
      people[8] = new Student("Peter","Parker", 6, 25, 1997, "Quantum Computing");
      people[9] = new Student("Tony","Stark", 2, 2, 2004, "Hardware Architecture");
      people[10] = new Student("Stephen","Strange", 12, 15, 1976, "Quantum Computing");
      people[11] = new Student("Bruce", "Banner", 9, 9, 2000, "Undecided");
    }
    else{
      Boolean terminateProject = false;
      while(terminateProject != true)
      {
        try{
            String newFileName = "UniversityPersons.per";
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(newFileName))) {    
                  for(int i = 0; i < 100; i++) {
                      Person person_new = (Person)ois.readObject(); 
                      if(person_new != null)
                          people[i] = person_new;  
                  }
              }
          }
          catch(FileNotFoundException fnfe) {
                  fnfe.printStackTrace();
          }
          catch(IOException ioe) {
              terminateProject = true;    
                  break; 
          }
          catch(ClassNotFoundException cnfe) {
                  cnfe.printStackTrace();
              }  
       }
    }
  }
  
    //constructor
    public University(String universityName, String motto) 
    {
        this.universityName = universityName;
        this.motto = motto;
    }    
     
    public Student findStudent(String fn, String ln)
    {
        for (int i = 0; i < people.length; i += 1)
        {
          if (people[i] instanceof Student && people[i].firstName.equals(fn) && people[i].lastName.equals(ln)) 
            return (Student)people[i];
        }
        return null;
    }
    public Faculty findFaculty(String fn, String ln)
    {
        for (int i = 0; i < people.length; i += 1)
        {
          if (people[i] instanceof Faculty && people[i].firstName.equals(fn) && people[i].lastName.equals(ln))
            return (Faculty)people[i];
        }
        return null;
    }
    public Faculty hire(Person p)
    {
       Faculty newHire = new Faculty(p);
       boolean hired = false;
       for (int i = 0; i < people.length; i += 1) {
         if (people[i] instanceof Faculty == false) {
           if (people[i] == null) {
              hired = true;
              people[i] =  newHire;
           }
           if (hired != false) break;
         }
       }
       return newHire;
    }
    public Student admit(Person p)
    {
        boolean admitted = false;
        Student newStudent = new Student(p);
        for (int i = 0; i < people.length; i += 1) {
          if (people[i] instanceof Student == false) {
            if (people[i] == null){
              admitted = true;
              people[i] = newStudent;
            }
            if (admitted != false) break;
          }
        }
        return newStudent;
    }
    public Person [] getStudents()
    {
      Person[] tempStudentArr = new Person[50];
      for (int i = 0; i < people.length; i += 1)
      {
        if (people[i] instanceof Student && !(people[i] instanceof Faculty) )
        tempStudentArr[i] = people[i];
      }
      return tempStudentArr;
    }
    public Person [] getFaculty()
    {
      Person[] tempFacultyArr = new Person[50];
      for (int i = 0; i < people.length; i += 1)
      {
        if (people[i] instanceof Faculty && !(people[i] instanceof Student) )
        tempFacultyArr[i] = people[i];
      }
      return tempFacultyArr;
    }
    public Person [] getAllPersons() { return people; }
    public String [] getAllMajors() { return majors; }
    public String [] getAllCourses() { return courses; }
    public String getUniversityName() { return universityName; }
    public String getUniversityMotto() { return motto; }
    
    
}

