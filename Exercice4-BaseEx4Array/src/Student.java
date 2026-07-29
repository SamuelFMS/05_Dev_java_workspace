import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private static ArrayList<Student> listStudent = new ArrayList<>();
    public String lastName;
    public String firstName;
    public ArrayList<Integer> grades;

    public Student() {
        listStudent.add(this);
    }

    /**
     * Return the minimum of my array of Integer
     *
     * @return
     */
    public Integer minMarks() {
        if (grades.size() > 0) {
            Integer min = grades.get(0);
            for (int i = 1; i < grades.size(); i++) {
                if (min > grades.get(i)) {
                    min = grades.get(i);
                }
            }
            return min;
        } else {
            return null;
        }
    }

    /**
     * Return the maximum of my array of Integer
     *
     * @return
     */
    public Integer maxMarks() {
        if (grades.size() > 0) {
            Integer max = grades.get(0);
            for (int i = 1; i < grades.size(); i++) {
                if (max < grades.get(i)) {
                    max = grades.get(i);
                }
            }
            return max;
        } else {
            return null;
        }
    }

    /**
     * Return the average of my array of Integer
     *
     * @return
     */
    public Double averageMarks() {
        if (grades.size() > 0) {
            Integer somme = grades.get(0);
            for (int i = 1; i < grades.size(); i++) {
                somme += grades.get(i);
            }
            return (double) somme / grades.size();
        } else {
            return null;
        }
    }

    /**
     * allows a new student to be registered
     *
     * @param scanner
     */
    public void registerUser(Scanner scanner) {
        System.out.println("Veuillez entrer le prénom ");
        firstName = scanner.next();
        System.out.println("Veuillez entrer le nom de famille ");
        lastName = scanner.next();
        inputGrades(scanner);
    }

    /**
     * allows grades to be registered
     *
     * @param scanner
     */
    public void inputGrades(Scanner scanner) {
        grades = new ArrayList<>();
        boolean isInputValid = true;
        while (isInputValid) {
            System.out.println("Veuillez entrer une note");
            try {
                Integer mark = Integer.valueOf(scanner.next());
                grades.add(mark);
            } catch (Exception e) {
                isInputValid = false;
            }
        }
    }

    /**
     * Return size of the list so the number of Students in total
     * @return
     */
    public static Integer nbStudents() {
        return listStudent.size();
    }

    /**
     * Default return toString
     * @return
     */
    public String toString() {
        Double avgMark = averageMarks();
        return "prénom: " + firstName + "\n" + "nom de famille: " + lastName + "\n" + "Moyenne des notes: " + (avgMark==null?"Aucune note disponnible": String.valueOf(avgMark));
    }

    /**
     * Find a Student from the list and returns it
     * @param firstName
     * @param lastName
     * @return
     */
    public static Student seachStudent(String firstName, String lastName){
        for(Student student: listStudent) {
            if(student.firstName.equals(firstName) && student.lastName.equals(lastName)){
                return student;
            }
        }
        return null;
    }

    /**
     * Order the lstStudent by first name
     */
    private static void OrderListByFirstName(){
        for(int x=0; x<listStudent.size(); x++){
            for(int y=1; y < (listStudent.size()-x); y++) {
                if(listStudent.get(y-1).firstName.compareToIgnoreCase(listStudent.get(y).firstName) > 0) {
                    Student temp = listStudent.get(y-1);
                    listStudent.set(y-1, listStudent.get(y));
                    listStudent.set(y, temp);
                }
            }
        }
    }

    /**
     * Display all the students first name and last name by first name
     */
    public static void DisplayAllStudentInOrder(){
        System.out.println("Voici la liste des éleves: ");
        OrderListByFirstName();
        for(Student student: listStudent){
            System.out.println(student.firstName + " " + student.lastName);
        }
    }
}
