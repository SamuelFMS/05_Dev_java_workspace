import java.util.Scanner;

public class Main {
    /**
     * Function main to test Java ask the first name and last Name
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Quel est votre prénom ? ");
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        System.out.println("Quel est votre nom ? ");
        String lastName = scan.next();
        System.out.println("Salut: " + firstName + " " + lastName);
        scan.close();
    }
}