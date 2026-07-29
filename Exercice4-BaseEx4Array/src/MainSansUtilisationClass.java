import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainSansUtilisationClass {
    /**
     * Contain a map of String firstName and lastName and the grades
     *
     */
    static Map<String, ArrayList<Integer>> grades = new TreeMap<>(
            (a, b) -> {
                return a.compareTo(b);
            }
    );

    /**
     * Display a Student
     *
     * @param s
     */
    public static void DisplayStudent(String s) {
        System.out.println("Prenom et Nom: " + s + ", Note moyenne: " + averageMarks(grades.get(s)));
    }

    /**
     * Display all the students first name and last name by first name
     */
    public static void DisplayAllStudentInOrder() {
        System.out.println("Voici la liste des éleves: ");
        for (String student : grades.keySet()) {
            System.out.println(student);
        }
    }

    /**
     * Return the average of my array of Integer
     *
     * @return
     */
    public static Double averageMarks(ArrayList<Integer> grades) {
        if (grades.size() > 0) {
            Integer somme = 0;
            for (int score : grades) {
                somme += score;
            }
            return (double) somme / grades.size();
        } else {
            return null;
        }
    }

    /**
     * Allows the creation of a Student and adding it to the map.
     *
     * @param scanner
     */
    public static void createStudent(Scanner scanner) {
        System.out.println("Entrez un prenom: ");
        String firstName = scanner.next();
        System.out.println("Entrez un nom: ");
        String lastName = scanner.next();
        ArrayList<Integer> inputGrades = new ArrayList<>();
        while (true) {
            System.out.println("Veuillez entrer une note");
            try {
                Integer mark = Integer.valueOf(scanner.next());
                inputGrades.add(mark);
            } catch (Exception e) {
                break;
            }
        }
        grades.put(firstName + " " + lastName, inputGrades);
        DisplayStudent(firstName + " " + lastName);
    }

    /**
     * Main program for entering a student's details or displaying a student along with their average.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display
            System.out.println("Que souhaitez vous faire: ");
            System.out.println("1 - Creer un nouveau eleve ");
            if (grades.size() > 0) {
                System.out.println("2 - Afficher un eleve déja existant ");
            }
            if (grades.size() > 0) {
                System.out.println("3 - Afficher la liste d'eleve");
            }
            System.out.println("q - Quitter le programme ");

            // Input
            String inputUser = scanner.next();
            if (inputUser.equals("1")) {
                createStudent(scanner);
            }
            if (inputUser.equals("2") && grades.size() > 0) {
                System.out.println("Entrez un prenom: ");
                String firstName = scanner.next();
                System.out.println("Entrez un nom: ");
                String lastName = scanner.next();
                if (grades.containsKey(firstName + " " + lastName)) {
                    DisplayStudent(firstName + " " + lastName);
                } else {
                    System.out.println("Nous n'avons pas trouvé " + firstName + " " + lastName);
                }
            }
            if (inputUser.equals("3") && grades.size() > 0) {
                DisplayAllStudentInOrder();
            }
            if (inputUser.equals("q")) {
                break;
            }
        }
        scanner.close();
    }
}
