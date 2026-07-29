import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
            if (Student.nbStudents() > 0) {
                System.out.println("2 - Afficher un eleve déja existant ");
            }
            if (Student.nbStudents() > 0) {
                System.out.println("3 - Afficher la liste d'eleve");
            }
            System.out.println("q - Quitter le programme ");

            // Input
            String inputUser = scanner.next();
            if (inputUser.equals("1")) {
                Student student = new Student();
                student.registerUser(scanner);
                System.out.println(student);
            }
            if (inputUser.equals("2") && Student.nbStudents() > 0) {
                System.out.println("Entrez un prenom: ");
                String firstName = scanner.next();
                System.out.println("Entrez un nom: ");
                String lastName = scanner.next();
                Student student = Student.seachStudent(firstName, lastName);
                if (student == null) {
                    System.out.println("Impossible de trouver cet éleve.");
                } else {
                    System.out.println(student);
                }
            }
            if (inputUser.equals("3") && Student.nbStudents() > 0) {
                Student.DisplayAllStudentInOrder();
            }
            if (inputUser.equals("q")) {
                break;
            }
        }
        scanner.close();
    }
}
