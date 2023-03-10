import java.util.Scanner;
import java.io.ObjectOutputStream;
import javax.swing.plaf.synth.SynthColorChooserUI;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class UniversityDriver  {
    public static University north = new University("NORTH UNIVERSITY", "Emollit Mores Nec Sinit Esse Feros");
    public static Scanner scnr = new Scanner(System.in); 
    public static String firstName;
    public static String lastName;
    public static int monthDay;
    public static int monthBirth;
    public static int dayBirth;
    public static int yearBirth;
    
    public static void main(String[] args) 
    {
        System.out.println("\nWelcome To " + north.getUniversityName());
        System.out.println(north.getUniversityMotto() + "\n");
        boolean quit = false;
       
        System.out.println("Enter \"hire\" to hire a new faculty member.");
        System.out.println("Enter \"admit\" to admit a new student.");
        System.out.println("Enter \"find student\" to list information about a student.");
        System.out.println("Enter \"find faculty\" to list information about a faculty member.");
        System.out.println("Enter \"list students\" to list the names of all students.");
        System.out.println("Enter \"list faculty\" to list the names of faculty members.");
        System.out.println("Enter \"quit\" to end this program and save data. \n");
        
        while (quit == false) 
        {
            System.out.print(">");
            String command = scnr.nextLine();
            
            if (command.equals("hire"))
                hireFaculty();
            else if(command.equals("admit")) 
                 admitStudent();
            else if(command.equals("find student"))
                findingStudent();
            else if(command.equals("find faculty"))
                findingFaculty();
            else if(command.equals("list students")) 
                listOfStudents();
            else if (command.equals("list faculty")) 
                listOfFaculty();
            else if (command.equals("quit")) {
                quit = true;
                quitProgram();
            }   
            else 
                System.out.println("Not found!");
            System.out.println("");
        }
    }
    public static void findingStudent() {
        System.out.print("What is the student's first name? \n>");
        firstName = scnr.nextLine();
        System.out.print("What is the student's last name? \n>");
        lastName = scnr.nextLine();
        Student studentIsFound = north.findStudent(firstName, lastName);
        //null if student was not found
        if (studentIsFound == null) 
            System.out.println("Student not found.");
        else {
            System.out.println("\nStudent: " + studentIsFound.firstName + " " + studentIsFound.lastName +
                               "\nDOB: " + studentIsFound.monthBirth + "/" + studentIsFound.dayBirth + "/" + studentIsFound.yearBirth +
                               "\nMajor:" + studentIsFound.major + "\n");
        }
    }
    public static void findingFaculty() {
        System.out.print("What is the faculty's first name? \n>");
        firstName = scnr.nextLine();
        System.out.print("What is the faculty's last name? \n>");
        lastName = scnr.nextLine();
        Faculty facultyIsFound = north.findFaculty(firstName, lastName);
        //null if student was not found
        if (facultyIsFound == null) 
            System.out.println("Faculty not found.");
        else {
            System.out.println("\nFaculty: " + facultyIsFound.firstName + " " + facultyIsFound.lastName +
                               "\nDOB: " + facultyIsFound.monthBirth + "/" + facultyIsFound.dayBirth + "/" + facultyIsFound.yearBirth +
                               "\nCourses:");
            for (int i = 0; i < facultyIsFound.courses.length; i += 1) {
                if (facultyIsFound.courses[i] != null)
                    System.out.println(facultyIsFound.courses[i]);
            }
            System.out.println("");
        }        
    }
    public static void listOfStudents() {
        Person[] tempStudentArr = north.getStudents();
        for (int i = 0; i < tempStudentArr.length; i += 1) {
            if (tempStudentArr[i] != null)
                System.out.println(tempStudentArr[i]);
        }
    } 
    public static void listOfFaculty() {
        Person[] tempFacultyArr = north.getFaculty();
        for (int i = 0; i < tempFacultyArr.length; i += 1) {
            if (tempFacultyArr[i] != null) 
                System.out.println(tempFacultyArr[i]);
        }
    }
    public static void admitStudent() {
        String[] listOfMajors = north.getAllMajors();
        boolean studentsMajor = false;
        System.out.println("What is this person's major?\nThe majors offered are: ");
        for (int i = 0; i < listOfMajors.length; i += 1) System.out.println(listOfMajors[i]);
        System.out.println("");
        while (studentsMajor != true) {   
            System.out.print(">");
            String chosenMajor = scnr.nextLine();
            for (int i = 0; i < listOfMajors.length; i += 1) {
                if(chosenMajor.equals(listOfMajors[i])){
                    System.out.println("What is the person's first name?");
                    System.out.print(">");
                    firstName = scnr.nextLine();
                    
                    System.out.println("What is the persoxn's last name?");
                    System.out.print(">");
                    lastName = scnr.nextLine();
                    
                    System.out.println("What is the person's month of birth?");
                    System.out.println("Enter an integer representing the month of birth");
                    System.out.print(">");
                    monthBirth = Integer.parseInt(scnr.nextLine());
                    
                    System.out.println("What is the person's day of birth?");
                    System.out.println("Enter an integer representing the day of birth");
                    System.out.print(">");
                    dayBirth = Integer.parseInt(scnr.nextLine());

                    System.out.println("What is the person's year of birth?");
                    System.out.println("Enter an integer representing the year of birth");
                    System.out.print(">");
                    yearBirth = Integer.parseInt(scnr.nextLine());

                    Person admittingNewStudent = new Person(firstName, lastName, monthBirth, dayBirth, yearBirth);
                    Student student_new = north.admit(admittingNewStudent);
                    student_new.setMajor(chosenMajor);
                    studentsMajor = true;
                }
            }
            if (studentsMajor == false) {
                System.out.println("That is not a major offered.\nWhat is this person's major?");
            }
        }
    

    }
    public static void hireFaculty() {
        String[] tempCourses = new String[100];
        String[] listOfCourses = north.getAllCourses();
        int counter = 0;
        
        System.out.println("What is the person's first name?");
        System.out.print(">");
        firstName = scnr.nextLine();
        System.out.println("What is the person's last name?");
        System.out.print(">");
        lastName = scnr.nextLine();
        System.out.println("What is the person's month birth?");
        System.out.print(">");
        monthBirth = Integer.parseInt(scnr.nextLine());
        System.out.println("What is the person's day birth?");
        System.out.print(">");
        dayBirth = Integer.parseInt(scnr.nextLine());
        System.out.println("What is the person's year birth?");
        System.out.print(">");
        yearBirth = Integer.parseInt(scnr.nextLine());

        Person faculty_new = new Person(firstName, lastName, monthBirth, dayBirth, yearBirth);
        Faculty f = north.hire(faculty_new);
        System.out.println(">");
        System.out.print("Assign a course to this Faculty");
        System.out.print("Enter \"done\" if there are no other courses.");
        System.out.println("The courses offered are: ");
        System.out.println("");
        for (int i = 0; i < listOfCourses.length; i += 1) System.out.println(listOfCourses[i]);
        System.out.println("");

        
        boolean loopTrue, loopFinished = false;
        String userInput = "";
        while (loopFinished != true) {
            loopTrue = false;
            System.out.print(">");
            userInput = scnr.nextLine();
            if (userInput.equals("done")) {
                loopFinished = true;
                break;
            }
            for (int i = 0; i< listOfCourses.length; i+=1){
                if (userInput.equals(listOfCourses[i])) {
                    loopTrue = true;
                    counter += 1;
                    for (int k = 0; k < counter; k += 1) {
                        if (tempCourses[k] == null) tempCourses[k] = userInput;
                    }
                    System.out.println("Assign a course to this Faculty");
                    System.out.println("Enter \"done\" if there are no other courses.");
                    break;
                }
            }
            if (loopTrue == false) {
                System.out.println("That is not a course offered.");
                System.out.println("Assign a course to thie Faculty.");
                System.out.println("Enter \"done\" if there are no other courses.");
            }   
        }
        f.assignCourses(tempCourses);
    }
    public static void quitProgram() {
        Person[] createFile = north.getAllPersons();
        try {
            String universityPersons_par = "UniversityPersons.per";
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(universityPersons_par)); 
        for(int i = 0; i < createFile.length; i++){
        if(createFile[i] != null)
            oos.writeObject(createFile[i]);
        }
        oos.close();

    }
    catch(IOException ioe){
        ioe.printStackTrace();
    }
}
}